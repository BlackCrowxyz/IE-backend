package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ASUS on 5/14/2019.
 */

@Entity
@Table(name = "usersInfo")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "user_id")
    private int id;
    @Column(name = "token")
    private String token;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Transient
    private String repassword;
    @Column(name = "role")
    private String role;
    @Column(name = "is_active")
    private boolean Active;

    public UserEntity(){}

    public UserEntity(String token, String username, String email, String password, String repassword, String role, boolean active) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
        this.role = role;
        Active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRepassword() {return repassword;}

    public void setRepassword(String repassword) {this.repassword = repassword;}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
