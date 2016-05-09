package il.ac.hit.controller;

import il.ac.hit.model.*;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by artur on 17/03/2016.
 */

@WebServlet("/controller/*")
public class Controller extends HttpServlet
{
    /**
     * The Log4J instance.
     */
    static Logger logger = Logger.getLogger("Controller");
    /**
     * The DAO instance.
     */
    IToDoListDAO toDoListDAO = ToDoListDAO.getInstance();
    /** Current session user. */
    private User newUser;

    /**
     * Do post. All the logic of the Web-application is implemented here.
     * Every click in the application produces URI with which we handle the action.
     * Description for every URI can be found over his IF statement.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getServletContext().removeAttribute("userMessage");
        List<User> listUsers = toDoListDAO.getUsersList( );
        request.getServletContext( ).setAttribute("userList", toDoListDAO);
        String path = request.getPathInfo();
        RequestDispatcher dispatcher = null;
        newUser = null;
        List<Task> tasksList = null;
        switch (path)
        {
            case "/login":
            {
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                String rememberMe = request.getParameter("rememberMeCheckBox");
                newUser = new User(userName, password);

                logger.addAppender(new FileAppender(new SimpleLayout(), "log.txt"));
                logger.info("newUser created :" + newUser);

                try
                {
                    toDoListDAO.checkIfPasswordMatchToUser(newUser);
                    newUser = toDoListDAO.getUser(newUser.getId());
                    tasksList = toDoListDAO.getTasksByUID(newUser.getId());

                    if (rememberMe != null)
                    {
                        Cookie rememberMeCookie = new Cookie("userName", userName);
                        if (rememberMeCookie != null)
                        {
                            rememberMeCookie.setMaxAge(3600);
                            response.addCookie(rememberMeCookie);
                        }
                    }
                    request.getServletContext().setAttribute("userID", newUser.getId());
                    request.getServletContext().setAttribute("userName", newUser.getName());
                    request.getServletContext().setAttribute("tasksList", tasksList);

                    //request.getRequestDispatcher("/userToDoListItems.jsp").forward(request, response);
                    response.sendRedirect("/userToDoListItems.jsp");

                }
                catch (ToDoListException e)
                {
                    request.getServletContext().setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext( ).getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }

                break;
            }
            case "/register":
            {
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                newUser = new User(userName, password);

                try
                {
                    toDoListDAO.addUser(newUser);
                    request.getServletContext().setAttribute("userID", newUser.getId());
                    request.getServletContext().setAttribute("userName", newUser.getName());
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
                }
                catch (ToDoListException e)
                {
                    request.getServletContext().setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            }
            case "/addTask":
            {
                String taskText = request.getParameter("taskInput");
                int userID = Integer.parseInt(String.valueOf(request.getServletContext().getAttribute("userID")));
                Task task = new Task(taskText, userID);
                try
                {
                    toDoListDAO.addTask(task);
                    tasksList = toDoListDAO.getTasksByUID(userID);

                    request.getServletContext().setAttribute("tasksList", tasksList);
                    //dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    //dispatcher.forward(request, response);
                    response.sendRedirect("/userToDoListItems.jsp");
                }
                catch (ToDoListException e)
                {
                    e.printStackTrace();
                    request.getServletContext().setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);

                }
                break;
            }
            case "/logout":
            {
                request.getSession().invalidate();
                dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "/editTask": {
                String taskID = request.getParameter("taskID");

                String description = request.getParameter("Description");

                Task editableTask = null;
                try
                {
                    editableTask = toDoListDAO.getTask(Integer.parseInt(taskID));
                    editableTask.setDescription(description);
                    toDoListDAO.updateTask(editableTask);
                    tasksList = toDoListDAO.getTasksByUID(editableTask.getUserID());

                    request.getServletContext().setAttribute("tasksList", tasksList);


                    response.sendRedirect("/userToDoListItems.jsp");
                }
                catch (ToDoListException e)
                {
                    e.printStackTrace();
                    request.getServletContext().setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
                }

                break;
            }
            case "/removeTask":
            {
                String taskID = request.getParameter("taskID");
                Task deletedTask = null;
                try
                {
                    deletedTask = toDoListDAO.getTask(Integer.parseInt(taskID));
                    toDoListDAO.deleteTask(deletedTask);

                    tasksList = toDoListDAO.getTasksByUID(deletedTask.getUserID());

                    request.getServletContext().setAttribute("tasksList", tasksList);
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
                    //response.sendRedirect("/userToDoListItems.jsp");

                }
                catch (ToDoListException e)
                {
                    e.printStackTrace();
                    request.getServletContext().setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            }
            default:
                request.getRequestDispatcher("/404Error.jsp").forward(request, response);
                break;
        }
    }

    /**
     * Do get.
     * It used for the first time running the application from the controller.
     * reference to doPost
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
