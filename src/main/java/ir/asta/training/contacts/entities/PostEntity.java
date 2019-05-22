package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ASUS on 5/19/2019.
 */
@Table(name = "Posts")
@Entity
public class PostEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//    @Column(name = "userID")
//    private UserEntity user;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
//    @Column(name = "responsible")
//    private UserEntity responsible;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private Date date;
//    @Column(name = "detail")
//    private DetailsEntity details;

    public PostEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

//    public UserEntity getResponsible() {
//        return responsible;
//    }
//
//    public void setResponsible(UserEntity responsible) {
//        this.responsible = responsible;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public DetailsEntity getDetails() {
//        return details;
//    }
//
//    public void setDetails(DetailsEntity details) {
//        this.details = details;
//    }
}
