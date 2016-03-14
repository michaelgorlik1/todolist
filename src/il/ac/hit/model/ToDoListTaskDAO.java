package il.ac.hit.model;

/**
 * Created by artur on 07/03/2016.
 */
public class ToDoListTaskDAO implements IToDoListTaskDAO
{
    private static ToDoListTaskDAO ourInstance = new ToDoListTaskDAO();

    public static ToDoListTaskDAO getInstance()
    {
        return ourInstance;
    }

    private ToDoListTaskDAO()
    {
    }

    @Override
    public void addTask(Task task)
    {

    }

    @Override
    public void updateTask(Task task)
    {

    }

    @Override
    public void deleteTask(Task task)
    {

    }
}
