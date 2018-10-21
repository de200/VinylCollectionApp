package pl.vinyl_catalog.data;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {

    private static final long serialVersionUID = 5068565814883274510L;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String firsName, String lastName) {
        super();
        setFirstName(firsName);
        setLastName(lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString(){
        return getFirstName() + " " + getLastName();
    }
}
