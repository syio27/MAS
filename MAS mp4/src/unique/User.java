package unique;

import java.util.*;

public class User {
    private static final Map<String, User> extent = new HashMap<>();

    private static long countId = 0L;
    private long id;
    private String login;                   // { Unique }
    private String password;
    private String mail;
    private String firstName, lastName;

    public User(String login, String password, String mail, String firstName, String lastName) {
        countId++;
        setId(countId);
        setLogin(login);
        setPassword(password);
        setMail(mail);
        setFirstName(firstName);
        setLastName(lastName);
        extent.putIfAbsent(login, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login == null){
            throw new IllegalArgumentException("Login cannot be null, it is mandatory field");
        }
        if(login.equals("")){
            throw new IllegalArgumentException("Login cannot be empty string");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if(mail == null){
            throw new IllegalArgumentException("Mail cannot be null, it is mandatory field");
        }
        if(mail.equals("")){
            throw new IllegalArgumentException("Mail cannot be empty string");
        }
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static Map<String, User> getExtent() {
        return extent;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
