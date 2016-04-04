package il.ac.hit.controller;

import il.ac.hit.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by artur on 17/03/2016.
 */
@WebServlet("/controller/*")
public class Controller extends HttpServlet
{
    IToDoListDAO toDoListDAO = ToDoListDAO.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String path = request.getPathInfo();
        RequestDispatcher dispatcher = null;
        User newUser = null;
        switch (path)
        {
            case "/login":
            {
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");

                newUser = new User(userName, password);
                try
                {
                    toDoListDAO.checkIfPasswordMatchToUser(newUser);
                    newUser = toDoListDAO.getUser(newUser.getId());
                    request.getSession().setAttribute("userID", newUser.getId());
                    request.getSession().setAttribute("userName", newUser.getName());

                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);

                }
                catch (ToDoListException e)
                {
                    request.setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
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
                    request.getSession().setAttribute("userID", newUser.getId());
                    request.getSession().setAttribute("userName", newUser.getName());
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
                }
                catch (ToDoListException e)
                {
                    request.setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            }
            case "/addTask":
            {
                String taskText = request.getParameter("taskText");
                int userID = (int) (request.getSession().getAttribute("userID"));
                Task task = new Task("title", taskText, new Date(), userID);
                try
                {
                    toDoListDAO.addTask(task);
                    dispatcher = getServletContext().getRequestDispatcher("/userToDoListItems.jsp");
                    dispatcher.forward(request, response);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
