package il.ac.hit.model;

/**
 * Created by artur on 12/03/2016.
 */

public class User
{
    private int id;

    private String name;

    private String password;

    /**
     * Constructs a new User.
     */
    public User()
    {

    }

    public User(String name, String password)
    {
        super();
        setName(name);
        setPassword(password);
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result += prime * result + ((name == null) ? 0 : name.hashCode());
        result += prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /** {@inheritDoc} */
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
