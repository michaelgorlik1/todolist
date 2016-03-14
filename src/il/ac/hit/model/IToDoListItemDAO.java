package il.ac.hit.model;

import il.ac.hit.model.Task;

/**
 * Created by artur on 07/03/2016.
 */
public interface IToDoListItemDAO
{
    public void addTask(Task task) throws ToDoListException;

    public void updateTask(Task task)throws ToDoListException;

    public void deleteTask(Task task)throws ToDoListException;


}
