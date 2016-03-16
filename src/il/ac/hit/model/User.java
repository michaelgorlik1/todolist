package il.ac.hit.model;

/**
 * Created by artur on 12/03/2016.
 */

public class User
{
    private int id;

    private String name;

    private String password;

    public User()
    {

    }

    public User(String name, String password)
    {
        super();
        setName(name);
        setPassword(password);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
