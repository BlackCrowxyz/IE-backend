package ir.asta.training.contacts.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 5/14/2019.
 */
@Table(name = "users")
@Entity
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    //REPASSWORD IS IN DATABASE !!!
    @Transient
    private String repassword;
    @Column(name = "is_student")
    private boolean isStudent;
    @Column(name = "is_active")
    private boolean isActive;

    public UserEntity(){}

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

    public boolean isStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean student) {
        isStudent = student;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getRepassword() {return repassword;}

    public void setRepassword(String repassword) {this.repassword = repassword;}
}
