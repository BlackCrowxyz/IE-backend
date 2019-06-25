package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/15/2019.
 */
@Named("userDao")
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean containsUsernameInDB(String username){
        Query query = entityManager.createQuery("Select u FROM UserEntity u WHERE u.username=:username");
        query.setParameter("username", username); //avoid SQL injection
        List list = query.getResultList();
        return list.size() > 0;
    }

    public boolean containsTokenInDB(String token){
        Query query = entityManager.createQuery("Select u FROM UserEntity u WHERE u.token=:token");
        query.setParameter("token", token); //avoid SQL injection
        List list = query.getResultList();
        System.out.println(list.size());
        System.out.println(query.getSingleResult());
        System.out.println(((UserEntity)query.getSingleResult()).getUsername());
        return list.size() > 0;
    }

    public void saveUser(UserEntity entity){entityManager.persist(entity);}

    public UserEntity getUserInfo(final UserEntity entity) {
        String username = entity.getUsername();
        String password = entity.getPassword();
        Query query = entityManager.createQuery("select u from UserEntity u where u.username=:username and u.password=:password");
        query.setParameter("username", username); //avoid SQL injection
        query.setParameter("password", password); //avoid SQL injection
        Object obj = query.getSingleResult();
        return (obj != null) ? (UserEntity) obj : entity; //returning the entity
    }

    public UserEntity getUserInfoByToken(String token) {
        Query query = entityManager.createQuery("select u from UserEntity u where u.token=:token");
        query.setParameter("token", token); //avoid SQL injection
        return (UserEntity) query.getSingleResult(); //returning the entity
    }

    public void createPost(final PostEntity entity) {entityManager.persist(entity);}

    //get my posts (student)
    public List<PostResponse> getMyPosts(int from_id){
        List<PostResponse> posts = new ArrayList<>();
        Query query = entityManager.createQuery("select u from PostEntity u where u.from.id = :id");
        query.setParameter("id", from_id);
        List<PostEntity> postEntities = query.getResultList();
        System.out.println(postEntities.size());
        for (PostEntity pe: postEntities) {
            posts.add(
                    new PostResponse(
                            pe.getPost_id(),
                            this.getUsernameById(pe.getTo().getId()),
                            this.getUsernameById(pe.getFrom().getId()),
                            pe.getTitle(),
                            pe.getStatus(),
                            pe.getLastUpdate(),
                            pe.getDetail(),
                            pe.isSatisfied(),
                            pe.getOtherDescriptions()
                    )
            );
        }
        return posts;
    }
	
	//get my related posts (prof)
    public List<PostResponse> getRelatedPosts(int to_id){
        List<PostResponse> posts = new ArrayList<>();
        Query query = entityManager.createQuery("select u from PostEntity u where u.to.id = :id");
        query.setParameter("id", to_id);
        List<PostEntity> postEntities = query.getResultList();
        System.out.println(postEntities.size());
        for (PostEntity pe: postEntities) {
            posts.add(
                    new PostResponse(
                            pe.getPost_id(),
                            this.getUsernameById(pe.getTo().getId()),
                            this.getUsernameById(pe.getFrom().getId()),
                            pe.getTitle(),
                            pe.getStatus(),
                            pe.getLastUpdate(),
                            pe.getDetail(),
                            pe.isSatisfied(),
                            pe.getOtherDescriptions()
                    )
            );
        }
        return posts;
    }
	
	//get all posts (admin)
    public List<PostResponse> getAllPosts(){
        List<PostResponse> posts = new ArrayList<>();
        Query query = entityManager.createQuery("select u from PostEntity u");
        List<PostEntity> postEntities = query.getResultList();
        System.out.println(postEntities.size());
        for (PostEntity pe: postEntities) {
            posts.add(
                    new PostResponse(
                            pe.getPost_id(),
                            this.getUsernameById(pe.getTo().getId()),
                            this.getUsernameById(pe.getFrom().getId()),
                            pe.getTitle(),
                            pe.getStatus(),
                            pe.getLastUpdate(),
                            pe.getDetail(),
                            pe.isSatisfied(),
                            pe.getOtherDescriptions()
                    )
            );
        }
        return posts;
    }

	public List<UserResponse> getAllUsers() {
        List<UserResponse> users = new ArrayList<>();
        Query query = entityManager.createQuery("select u from UserEntity u");
        List<UserEntity> userEntities = query.getResultList();
        System.out.println(userEntities.size());
        for (UserEntity ue: userEntities) {
            users.add(
                    new UserResponse(
                            ue.getUsername(),
                            ue.getEmail(),
                            ue.getPassword(),
                            ue.getRole(),
                            ue.isActive()
                    )
            );
        }
        return users;
    }
	
     public UsersEntity getUsersInfoById(int id) {
        try{
            Query query = entityManager.createQuery("select u from UsersEntity u where u.id=:id");
            query.setParameter("id", id);
            return (UsersEntity) query.getSingleResult();
        } catch (Exception e){
            System.out.println("ERRRRRRRRROOOOOORRR\n\n");
            System.out.println(e);
            System.out.println("\n\nERRRRRRRRROOOOOORRR");
            return null;
        }
    }
}
