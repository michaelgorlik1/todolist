package il.ac.hit.model;

import java.util.Date;

/**
 * Created by michaelgorlik on 3/16/16.
 */
public class Program {
     public static void main(String[] args)
     {
         Task task = new Task("fsdafasdfasdf", "asdfadfadfasdfasdfdescription", new Date(), 1);
         ToDoListDAO toDoListDAO = ToDoListDAO.getInstance();
         try {
             toDoListDAO.addTask(task);

         } catch (ToDoListException e) {
             e.printStackTrace();
         }

     }
}
