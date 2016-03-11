package il.ac.hit;

/**
 * Created by artur on 07/03/2016.
 */
public class HibernateToDoListItemDAO implements IToDoListItemDAO
{
    private static HibernateToDoListItemDAO ourInstance = new HibernateToDoListItemDAO();

    public static HibernateToDoListItemDAO getInstance()
    {
        return ourInstance;
    }

    private HibernateToDoListItemDAO()
    {
    }
}
