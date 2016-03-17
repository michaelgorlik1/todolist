package il.ac.hit.model;

import java.util.Date;

/**
 * Created by artur on 11/03/2016.
 */
public class
Task
{
    private String title;
    private String description;
    private Date date;
    private int taskID;
    private int userID;

    public Task()
    {
    }

    public Task(String title, String description, Date date, int taskID)
    {
        super();
        setTitle(title);
        setDescription(description);
        setDate(date);
        setTaskID(taskID);
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        if (date == null)
        {
            date = new Date();
        }
        this.date = date;
    }

    public int getTaskID()
    {
        return taskID;
    }

    public void setTaskID(int taskID)
    {
        this.taskID = taskID;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", Id=" + taskID +
                '}';
    }
}
