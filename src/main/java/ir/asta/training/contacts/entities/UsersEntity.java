package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by ASUS on 6/7/2019.
 */
@Entity
@Table(name = "Users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "token", nullable = false)
    private String token;

    @OneToMany(targetEntity = PostEntity.class, cascade = CascadeType.ALL, mappedBy = "from")
    private Set<PostEntity> sendPosts;

    @OneToMany(targetEntity = PostEntity.class, cascade = CascadeType.ALL, mappedBy = "to")
    private Set<PostEntity> receivePosts;

    public UsersEntity() {}

    public UsersEntity(String token) {this.token = token;}

    public Set<PostEntity> getSendPosts() {
        return sendPosts;
    }

    public void setSendPosts(Set<PostEntity> sendPosts) {
        this.sendPosts = sendPosts;
    }

    public Set<PostEntity> getReceivePosts() {
        return receivePosts;
    }

    public void setReceivePosts(Set<PostEntity> receivePosts) {
        this.receivePosts = receivePosts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
