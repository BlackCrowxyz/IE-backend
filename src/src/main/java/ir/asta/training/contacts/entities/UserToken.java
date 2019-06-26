package ir.asta.training.contacts.entities;

/**
 * Created by ASUS on 6/6/2019.
 */
public class UserToken {
    private String token;

    public UserToken() {}

    public UserToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
