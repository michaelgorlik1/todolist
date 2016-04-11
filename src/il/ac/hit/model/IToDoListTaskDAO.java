package il.ac.hit.model;

import java.util.List;

/**
 * Created by artur on 07/03/2016.
 */
public interface IToDoListTaskDAO
{
    public void addTask(Task task) throws ToDoListException;

    public void updateTask(Task task) throws ToDoListException;

    public Task getTask(int taskID) throws ToDoListException;

    public void deleteTask(Task task) throws ToDoListException;

    public List<Task> getTasksByUID(int userID) throws ToDoListException;

    // public List<Task> getTasksByUID(User user) throws ToDoListException;

}
