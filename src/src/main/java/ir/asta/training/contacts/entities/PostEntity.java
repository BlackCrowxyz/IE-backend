package ir.asta.training.contacts.entities;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 5/19/2019.
 */
@Table(name = "posts")
@Entity
public class PostEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int post_id;
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
//    @Column(name = "attachment")
//    private Attachment attachment;

    @OneToMany(targetEntity = DetailsEntity.class, cascade=CascadeType.ALL)
    private List<DetailsEntity> otherDescriptions;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UsersEntity from;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private UsersEntity to;

    public PostEntity(){}

    public PostEntity(String title, String status, String lastUpdate, String detail, boolean satisfied, UsersEntity from, UsersEntity to) {
        this.title = title;
        this.status = status;
        this.lastUpdate = lastUpdate;
        this.detail = detail;
        this.satisfied = satisfied;
        this.otherDescriptions = null;
        this.from = from;
        this.to = to;
    }

    public int getPost_id() {
        return post_id;
    }

//    public Attachment getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(Attachment attachment) {
//        this.attachment = attachment;
//    }


    public UsersEntity getFrom() {
        return from;
    }

    public void setFrom(UsersEntity from) {
        this.from = from;
    }

    public UsersEntity getTo() {
        return to;
    }

    public void setTo(UsersEntity to) {
        this.to = to;
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

    public List<DetailsEntity> getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(List<DetailsEntity> otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }


}
