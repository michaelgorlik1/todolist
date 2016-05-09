package il.ac.hit.model;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by artur on 07/03/2016.
 */
public class ToDoListDAO implements IToDoListDAO
{
    private static ToDoListDAO ourInstance;

    private SessionFactory factory;

    private ToDoListDAO()
    {
        try
        {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized ToDoListDAO getInstance()
    {
        if (ourInstance == null)
        {
            ourInstance = new ToDoListDAO();
        }
        return ourInstance;
    }

    @Override
    public void addTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't add task to database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @GET
    @Path("/{user}")
    @Produces({"application/xml"})
    public Response get(@PathParam("user") String users)
    {
        List<User> usersList = getUsersList();
        return Response.ok(usersList).build();
    }



    @Override
    public void updateTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't update task on the database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public Task getTask(int taskID) throws ToDoListException
    {

        try
        {
            Session session = factory.openSession();
            session.beginTransaction();
            List<Task> items = session.createQuery("from Task where id=" + taskID).list();
            session.close();

            if (items.size() == 1)
            {
                return items.get(0);
            }
            return null;
        }
        catch (HibernateException e)
        {
            throw new HibernateException(e.getMessage());
        }


    }


    @Override
    public void deleteTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            String hql = "DELETE FROM Task WHERE id = :Id";
            Query query = session.createQuery(hql);
            query.setParameter("Id", task.getTaskID());
            int result = query.executeUpdate();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't delete task");
        }
        finally
        {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Task> getTasksByUID(int userID) throws ToDoListException
    {
        Session session = factory.openSession();
        List<Task> tasksList = null;
        try
        {
            String hql = "FROM Task WHERE userID =:userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userID);
            tasksList = query.list();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            throw new ToDoListException("Couldn't get tasks list from the database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
            return tasksList;
        }
    }

    @Override
    public void addUser(User user) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            String hql = "FROM User WHERE name= :name";
            Query query = session.createQuery(hql);
            query.setString("name", user.getName());
            if (!query.list().isEmpty())
            {
                throw new ToDoListException("User already exists");
            }
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            Transaction tx = session.getTransaction();
            if (tx.isActive())
            {
                tx.rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't add user to database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User user) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            String hql = "FROM User WHERE name= :name";
            Query query = session.createQuery(hql);
            query.setString("name", user.getName());
            if (!query.list().isEmpty())
                throw new ToDoListException("Username already exists in the database");
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't update task on the database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(User user) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            String hql = "DELETE FROM User WHERE name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", user.getName());
            int result = query.executeUpdate();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't delete user from the database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void checkIfUserExists(User user) throws ToDoListException
    {
        checkIfUserExists(user.getId());
    }

    @Override
    public void checkIfUserExists(int userID) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            List<User> users = session.createQuery("from User").list();
            for (User user : users)
            {
                if (user.getId() == userID)
                {
                    return;
                }
            }
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            throw new ToDoListException("Couldn't connect to the database, please try again");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        throw new ToDoListException("User not exist");
    }

    @Override
    public void checkIfPasswordMatchToUser(User user) throws ToDoListException
    {
        List<User> listUsers = getUsersList();
        if (listUsers != null)
        {
            for (User users : listUsers)
            {
                if (users.getName().equals(user.getName()) && users.getPassword().equals(user.getPassword()))
                {
                    user.setId(users.getId());
                    return;
                }
            }
        }
        throw new ToDoListException("user name or password is incorrect");
    }

    @Override
    public User getUser(int userID) throws ToDoListException
    {
        try
        {
            Session session = factory.openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("from User where ID = " + userID).list();
            session.close();

            if (users.size() == 1)
            {
                return users.get(0);
            }
            return null;
        }
        catch (HibernateException e)
        {
            throw new ToDoListException(e.getMessage());
        }
    }

    @Override
    public void checkIfPasswordMatchToUser(int userID) throws ToDoListException
    {

    }

    @Override
    public List<User> getUsersList()
    {
        Session session = null;
        List<User> userList = null;

        try
        {
            session = factory.openSession();
            Query query = session.createQuery("from User");
            userList = query.list();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            throw new ToDoListException("Couldn't get users from the database");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
            return userList;
        }
    }

}
