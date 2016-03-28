package il.ac.hit.controller;

import il.ac.hit.model.IToDoListDAO;
import il.ac.hit.model.ToDoListDAO;
import il.ac.hit.model.ToDoListException;
import il.ac.hit.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                request.getRequestDispatcher("/register.jsp").forward(request, response);
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
                }
                catch (ToDoListException e)
                {
                    request.setAttribute("userMessage", e.getMessage());
                    dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
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
