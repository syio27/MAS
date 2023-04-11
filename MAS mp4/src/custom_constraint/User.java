package custom_constraint;

public class User {
    private String username;
    private String password;
    private String status;

    public User(String username, String password, String status){
        setUsername(username);
        setPassword(password);
        setStatus(status);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null){
            throw new IllegalArgumentException("username cannot be null");
        }
        if(username.isBlank()){
            throw new IllegalArgumentException("username cannot be empty");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null){
            throw new IllegalArgumentException("password cannot be null");
        }
        if(password.isBlank()){
            throw new IllegalArgumentException("password cannot be empty");
        }
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!(status.equals(UserStatus.ACTIVE.toString()) || status.equals(UserStatus.BANNED.toString()) ||
                status.equals(UserStatus.CONFIRMED.toString()) || status.equals(UserStatus.NOTCONFIRMED.toString()))){
            throw new IllegalArgumentException("Wrong status!");
        }
        this.status = status;
    }

    public void newStatus(String status){
        if(this.status.equals(status)){
            throw new IllegalArgumentException("Status cannot be same as previous");
        }
        setStatus(status);
    }
}
