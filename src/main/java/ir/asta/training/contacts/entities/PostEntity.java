package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 5/19/2019.
 */
@Table(name = "posts_table")
@Entity
public class PostEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int post_id;

    @Column(name = "from_who")
    private String from_who;
    @Column(name = "to_who")
    private String to_who;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private String status;
    @Column(name = "lastUpdate")
    private String lastUpdate;
    @Column(name = "detail")
    private String detail;
    @Column(name = "satisfied")
    private boolean satisfied;

    @OneToMany(targetEntity = DetailsEntity.class)
    private List<DetailsEntity> otherDescriptions;

    public PostEntity(){}
    public PostEntity(String from, String to, List<DetailsEntity> otherDescriptions, String title, String status, String lastUpdate, String detail, boolean satisfied) {
        this.from_who = from;
        this.from_who = to;
        this.otherDescriptions = otherDescriptions;
        this.title = title;
        this.status = status;
        this.lastUpdate = lastUpdate;
        this.detail = detail;
        this.satisfied = satisfied;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    public String getFrom_who() {
        return from_who;
    }

    public void setFrom_who(String from_who) {
        this.from_who = from_who;
    }

    public String getTo_who() {
        return to_who;
    }

    public void setTo_who(String to_who) {
        this.to_who = to_who;
    }

    public List<DetailsEntity> getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(List<DetailsEntity> otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    //    public String getResponsible() {
//        return responsible;
//    }
//
//    public void setResponsible(String responsible) {
//        this.responsible = responsible;
//    }
}
