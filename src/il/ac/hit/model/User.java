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
    public User(String name, String password, int id)
    {
        super();
        setName(name);
        setPassword(password);
        setId(id);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setId(int id)
    {
        this.id = id;
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
}
