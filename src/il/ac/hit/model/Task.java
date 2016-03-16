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
    private int taskId;

    public Task()
    {}



    public Task(String title, String description, Date date, int taskId)
    {
        super();
        setTitle(title);
        setDescription(description);
        setDate(date);
        setTaskId(taskId);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setDate(Date date)
    {
        if(date == null)
        {
            date = new Date();
        }
        this.date=date;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public Date getDate()
    {
        return date;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    @Override
    public String toString()
    {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
