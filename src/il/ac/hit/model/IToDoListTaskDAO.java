package il.ac.hit.model;

import java.util.List;

/**
 * Created by artur on 07/03/2016.
 */


/**
 * An interface representing a TODO list DAO task.
 */
public interface IToDoListTaskDAO
{
    /**
     * method addTask adds a new task to the DB.
     *
     * @param task the task of user
     * @throws ToDoListException the to do list dao exception
     */
    public void addTask(Task task) throws ToDoListException;

    /**
     * method updateTask updates the tasks with new data.
     *
     * @param task the task of user
     * @throws ToDoListException the to do list dao exception
     */
    public void updateTask(Task task) throws ToDoListException;

    /**
     * This method Gets the  ask from the DB with the id it receives.
     *
     * @param taskID the item id
     * @return the task
     * @throws ToDoListException the to do list dao exception
     */
    public Task getTask(int taskID) throws ToDoListException;

    /**
     * method DeleteItem deletes an item task from the DB .
     *
     * @param task the task of user
     * @throws ToDoListException the to do list dao exception
     */
    public void deleteTask(Task task) throws ToDoListException;

    /**
     * Gets Tasks to list by UID(User Id).
     *
     * @param userID
     * @return List of Tasks by user id
     * @throws ToDoListException
     */
    public List<Task> getTasksByUID(int userID) throws ToDoListException;

    // public List<Task> getTasksByUID(User user) throws ToDoListException;

}
