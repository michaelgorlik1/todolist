package il.ac.hit.model;

/**
 * Created by artur on 14/03/2016.
 */
public interface IToDoListUserDAO extends IToDoListDAO
{
    public void addUser(User user) throws ToDoListException;

    public void updateUser(User user)throws ToDoListException;

    public void deleteTask(User user)throws ToDoListException;

}
