package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ASUS on 5/14/2019.
 */
@Table(name = "users_table")
@Entity
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Transient
    private String repassword;
    @Column(name = "student")
    private boolean student;
    @Column(name = "active")
    private boolean active;

    @OneToMany(targetEntity = PostEntity.class)
    private List<PostEntity> sendPosts;

    @OneToMany(targetEntity = PostEntity.class)
    private List<PostEntity> receivePosts;

    public UserEntity(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<PostEntity> getSendPosts() {
        return sendPosts;
    }

    public void setSendPosts(List<PostEntity> sendPosts) {
        this.sendPosts = sendPosts;
    }

    public List<PostEntity> getReceivePosts() {
        return receivePosts;
    }

    public void setReceivePosts(List<PostEntity> receivePosts) {
        this.receivePosts = receivePosts;
    }
}