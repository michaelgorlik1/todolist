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
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result += prime * result + ((name == null) ? 0 : name.hashCode());
        result += prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
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

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;

        User user = (User) obj;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;

    }
}
