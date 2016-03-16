package il.ac.hit.model;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

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
        factory = new AnnotationConfiguration().configure("hibernate3.jar").buildSessionFactory();
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            session.save(task);
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
            Transaction tx = session.getTransaction();
            if (tx.isActive())
            {
                tx.rollback();
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
    public void deleteTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            session.beginTransaction();
            session.delete(task);
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
            throw new ToDoListException("Couldn't delete task");
        }
        finally
        {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void addUser(User user) throws ToDoListException
    {
        Session session = factory.openSession();
        try
        {
            if (user.getPassword().length() < 5)
                throw new ToDoListException("Password is too short");
           /* if (!user.getEmail().contains("@"))
                throw new ToDoListException("Invalid email");
                */
            String hql = "FROM User WHERE name= :name";
            Query query = session.createQuery(hql);
            query.setString("name", user.getName());
            if (!query.list().isEmpty())
                throw new ToDoListException("User already exists");
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

    }

    @Override
    public void deleteUser(User user) throws ToDoListException
    {

    }
}
