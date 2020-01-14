package jenkins.coby;

public class User {

    private String password;
    private String salt;
    private String hashedPassword;

    public User() {
        this("not set","not set","not set");
    }

    public User(String password, String salt, String hashedPassword) {
        this.password = password;
        this.salt = salt;
        this.hashedPassword = hashedPassword;
    }

    public User(String password) {
        this.password = password;
        salt = "not set";
        hashedPassword = "not set";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
