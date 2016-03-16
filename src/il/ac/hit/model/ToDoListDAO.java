package il.ac.hit.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by artur on 07/03/2016.
 */
public class ToDoListDAO implements IToDoListDAO
{
    private static ToDoListDAO ourInstance;

    private SessionFactory factory;

    public static synchronized ToDoListDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new ToDoListDAO();
        }
        return ourInstance;
    }

    private ToDoListDAO()
    {
     try
     {

     }
     catch(HibernateException e)
     {
         e.printStackTrace();
     }
    }

    @Override
    public void addTask(Task task) throws ToDoListException
    {
        factory = new AnnotationConfiguration().configure("hibernate3.jar").buildSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            Transaction tx = session.getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            throw new ToDoListException("Couldn't add task to database");
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void updateTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(task);
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
    public void deleteTask(Task task) throws ToDoListException
    {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(task);
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
}
