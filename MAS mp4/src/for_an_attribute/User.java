package for_an_attribute;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class User {
    private static long countId = 0L;
    private long id;
    private String login;
    private String password;
    private String mail;
    private String firstName, lastName;

    public static final Set<String> userMails = new HashSet<>();

    public User(String login, String password, String mail, String firstName, String lastName) {
        countId++;
        try {
            setId(countId);
            setLogin(login);
            setPassword(password);
            setMail(mail);
            setFirstName(firstName);
            setLastName(lastName);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            countId--;
        }
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
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null){
            throw new IllegalArgumentException("Password cannot be null, it is mandatory field");
        }
        if(password.equals("")){
            throw new IllegalArgumentException("Password cannot be empty string");
        }
        if(!passwordPatternMatches(password)){
            throw new IllegalArgumentException("Entered password is not valid. Please enter a new one");
        }
        this.password = password;
    }

    /*
        Password must contain at least one digit [0-9].
        Password must contain at least one lowercase Latin character [a-z].
        Password must contain at least one uppercase Latin character [A-Z].
        Password must contain at least one special character like ! @ # & ( ).
        Password must contain a length of at least 8 characters and a maximum of 20 characters.
    * */
    public static boolean passwordPatternMatches(String password){
        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        return Pattern.compile(regexPattern).matcher(password).matches();
    }

    public void changePassword(String password){
        if(this.password.equals(password)){
            throw new IllegalArgumentException("New password cannot be same as previous");
        }
        setPassword(password);
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
        if(!mailPatternMatches(mail)){
            throw new IllegalArgumentException("Entered Email address is not valid. Please enter a new one");
        }
        if(userMails.contains(mail)){
            throw new IllegalArgumentException("This mail is already on use, Please use another mail address");
        }
        this.mail = mail;
        userMails.add(mail);
    }

    public static boolean mailPatternMatches(String mail){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(mail).matches();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("First Name cannot be null, it is mandatory field");
        }
        if(firstName.equals("")){
            throw new IllegalArgumentException("First Name cannot be empty string");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("Last Name cannot be null, it is mandatory field");
        }
        if(lastName.equals("")){
            throw new IllegalArgumentException("Last Name cannot be empty string");
        }
        this.lastName = lastName;
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
