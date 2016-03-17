package il.ac.hit.model;

import java.util.Date;

/**
 * Created by michaelgorlik on 3/16/16.
 */
public class Program {
     public static void main(String[] args)
     {
         Task task = new Task("fsdafasdfasdf", "asdfadfadfasdfasdfdescription", new Date(), 1);
         Task secondTask = new Task("test22", "seconddescription234", new Date(), 2);
         Task task3 = new Task("test3", "description3", new Date(), 3);
         User user = new User("artur", "123456", 1);
         User user2 = new User("michaelg", "12546", 2);
         User user3 = new User("natan", "12", 3);


         ToDoListDAO toDoListDAO = ToDoListDAO.getInstance();
         try {
             //  toDoListDAO.addUser(user2);
             //toDoListDAO.addUser(user3);
             // toDoListDAO.updateUser(user2);
             // toDoListDAO.addTask(task3);
             // toDoListDAO.updateTask(secondTask);
             toDoListDAO.deleteUser(user2);

         } catch (ToDoListException e) {
             e.printStackTrace();
         }

     }
}
