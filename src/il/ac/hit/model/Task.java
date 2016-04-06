package il.ac.hit.model;

/**
 * Created by artur on 11/03/2016.
 */
public class Task {
    /*private String title;
    private Date date;*/
    private String description;
    private int taskID;
    private int userID;

    /**
     * Constructs a new Task.
     */
    public Task( ) {
    }

    public Task(String description, int userID)
    {
        super();
        setDescription(description);
        setUserID(userID);
    }

   /* public Task(String title, String description, Date date, int userID) {
        super( );
        setTitle(title);
        setDescription(description);
        setDate(date);
        setUserID(userID);
    }*/

    /**
     * Getter for property 'userID'.
     *
     * @return Value for property 'userID'.
     */
    public int getUserID( ) {
        return userID;
    }

    /**
     * Setter for property 'userID'.
     *
     * @param userID Value to set for property 'userID'.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Getter for property 'title'.
     *
     * @return Value for property 'title'.
     */
/*    public String getTitle( ) {
        return title;
    }*/

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
/*    public void setTitle(String title) {
        this.title = title;
    }*/

    /**
     * Getter for property 'description'.
     *
     * @return Value for property 'description'.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Setter for property 'description'.
     *
     * @param description Value to set for property 'description'.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
/*    public Date getDate( ) {
        return date;
    }*/

    /**
     * Setter for property 'date'.
     *
     * @param date Value to set for property 'date'.
     */
/*    public void setDate(Date date) {
        if (date == null) {
            date = new Date( );
        }
        this.date = date;
    }*/

    /**
     * Getter for property 'taskID'.
     *
     * @return Value for property 'taskID'.
     */
    public int getTaskID( ) {
        return taskID;
    }

    /**
     * Setter for property 'taskID'.
     *
     * @param taskID Value to set for property 'taskID'.
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /** {@inheritDoc} */
    /*@Override
    public String toString( ) {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", Id=" + taskID +
                '}';
    }*/
}
