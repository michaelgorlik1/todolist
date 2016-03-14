package il.ac.hit.model;

/**
 * Created by artur on 07/03/2016.
 */
public class ToDoListItemDAO implements IToDoListItemDAO
{
    private static ToDoListItemDAO ourInstance = new ToDoListItemDAO();

    public static ToDoListItemDAO getInstance()
    {
        return ourInstance;
    }

    private ToDoListItemDAO()
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
