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
        try {
            session.beginTransaction();
            String hql = "DELETE FROM Task WHERE id = :Id";
            Query query = session.createQuery(hql);
            query.setParameter("Id", task.getId());
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't delete task");
        } finally {
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
        Session session = factory.openSession();
        try {
            String hql = "FROM User WHERE name= :name";
            Query query = session.createQuery(hql);
            query.setString("name", user.getName());
            if (!query.list().isEmpty())
                throw new ToDoListException("Username already exists in the database");
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't update task on the database");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(User user) throws ToDoListException
    {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            String hql = "DELETE FROM User WHERE name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", user.getName());
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't delete user from the database");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
