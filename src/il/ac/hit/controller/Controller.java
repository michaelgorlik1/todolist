package il.ac.hit.controller;

import il.ac.hit.model.ToDoListDAO;
import il.ac.hit.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artur on 17/03/2016.
 */
public class Controller extends HttpServlet
{
    ToDoListDAO toDoListDAO = ToDoListDAO.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String path = request.getPathInfo();
        RequestDispatcher dispatcher = null;
        User newUser = null;
        switch (path)
        {
            case "/login":
            {
                // try
                // {
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                newUser = new User(userName, password);
                if (toDoListDAO.checkIfUserExists(newUser))
                {

                }
                // }
                //  catch (ToDoListException e)
                // {
                //     request.setAttribute("userMessage",e.getMessage());
                //     dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                //     dispatcher.forward(request,response);
                //  }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
