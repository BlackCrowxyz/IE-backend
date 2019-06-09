package ir.asta.wise.core.reponse;

/**
 * Created by ASUS on 6/6/2019.
 */
public class Response {
    private String token;
    private String role;
    private String username;

    public Response() {
    }

    public Response(String token, String role, String username) {
        this.token = token;
        this.role = role;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
