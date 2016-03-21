package il.ac.hit.model;

/**
 * Created by artur on 14/03/2016.
 */
public interface IToDoListUserDAO
{
    public void addUser(User user) throws ToDoListException;

    public void updateUser(User user) throws ToDoListException;

    public void deleteUser(User user) throws ToDoListException;

    public boolean checkIfUserExists(User user) throws ToDoListException;

    public boolean checkIfUserExists(int userID) throws ToDoListException;

}
