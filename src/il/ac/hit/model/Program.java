package il.ac.hit.model;

import java.util.Date;

/**
 * Created by michaelgorlik on 3/16/16.
 */
public class Program {
     public static void main(String[] args)
     {
         Task task = new Task("fsdafasdfasdf", "asdfadfadfasdfasdfdescription", new Date(), 1);
         Task secondTask = new Task("test2", "seconddescription", new Date(), 2);
         Task task3 = new Task("test3", "description3", new Date(), 3);
         ToDoListDAO toDoListDAO = ToDoListDAO.getInstance();
         try {
             // toDoListDAO.addTask(task3);
             toDoListDAO.deleteTask(task3);

         } catch (ToDoListException e) {
             e.printStackTrace();
         }

     }
}
