package il.ac.hit;

/**
 * Created by artur on 11/03/2016.
 */
public class ToDoListException extends Exception
{
    private static final long serialVersionUID = 1L;


    public ToDoListException(String message)
    {
        super(message);
    }

    public ToDoListException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
