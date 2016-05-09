package il.ac.hit.model;

import java.util.List;

/**
 * Created by artur on 14/03/2016.
 */
public interface IToDoListUserDAO
{
    public void addUser(User user) throws ToDoListException;

    public void updateUser(User user) throws ToDoListException;

    public void deleteUser(User user) throws ToDoListException;

    public void checkIfUserExists(User user) throws ToDoListException;

    public void checkIfUserExists(int userID) throws ToDoListException;

    public void checkIfPasswordMatchToUser(int userID) throws ToDoListException;

    public void checkIfPasswordMatchToUser(User user) throws ToDoListException;

    public User getUser(int userID) throws ToDoListException;

    public List<User> getUsersList( );
}
