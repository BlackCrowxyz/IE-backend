package ir.asta.training.contacts.entities;

/**
 * Created by ASUS on 6/23/2019.
 */
public class ComingNewUser {
    private String token;
    private String last_username;
    private String new_username;
    private String password;
    private String email;
    private String role;
    private boolean active;

    public ComingNewUser() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLast_username() {
        return last_username;
    }

    public void setLast_username(String last_username) {
        this.last_username = last_username;
    }

    public String getNew_username() {
        return new_username;
    }

    public void setNew_username(String new_username) {
        this.new_username = new_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
