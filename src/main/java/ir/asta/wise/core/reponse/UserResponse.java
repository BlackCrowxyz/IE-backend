package ir.asta.wise.core.reponse;

/**
 * Created by ASUS on 6/23/2019.
 */
public class UserResponse {

    private String username;
    private String email;
    private String password;
    private String role;
    private boolean Active;

    public UserResponse() {}

    public UserResponse(String username, String email, String password, String role, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        Active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
