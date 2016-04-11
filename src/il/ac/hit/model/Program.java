package il.ac.hit.model;

/**
 * Created by michaelgorlik on 3/16/16.
 */
public class Program
{
    //static Logger logger = Logger.getLogger("Program");
    public static void main(String[] args)
    {
        User user = new User("natan", "12");
        //Task task = new Task("test", "desc", new Date(), user.getId());

        IToDoListDAO toDoListDAO = ToDoListDAO.getInstance();
        try
        {
            //toDoListDAO.addUser(user3);
            //toDoListDAO.addUser(user3);
            //toDoListDAO.updateUser(user2);
            //toDoListDAO.addTask(task3);
            //toDoListDAO.updateTask(secondTask);
            //toDoListDAO.deleteUser(user2);

            //        toDoListDAO.addUser(user3);
            toDoListDAO.addUser(user);

        }
        catch (ToDoListException e)
        {
            e.printStackTrace();
        }

    }
}
