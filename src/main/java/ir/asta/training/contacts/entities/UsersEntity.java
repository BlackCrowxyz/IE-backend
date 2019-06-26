package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.List;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

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
<<<<<<< HEAD
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
=======
    private List<PostEntity> sendPosts;

    @OneToMany(targetEntity = PostEntity.class, cascade = CascadeType.ALL, mappedBy = "to")
    private List<PostEntity> receivePosts;

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
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
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
