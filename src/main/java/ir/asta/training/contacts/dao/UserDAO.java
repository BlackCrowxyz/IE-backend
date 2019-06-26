package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.ComingPost;
import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
<<<<<<< HEAD
import ir.asta.training.contacts.entities.UsersEntity;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.UserResponse;
=======
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

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

<<<<<<< HEAD
    public void saveUser(UserEntity entity){
        entityManager.persist(entity);
    }

    public void saveToUsers(UsersEntity entity){
        entityManager.persist(entity);
    }
=======
    public void saveUser(UserEntity entity){entityManager.persist(entity);}
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

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
<<<<<<< HEAD
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
            System.out.println("\n * * POST ID = "+pe.getPost_id());
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
            System.out.println("\n * * POST ID = "+pe.getPost_id());
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
            System.out.println("\n * * POST ID = "+pe.getPost_id());
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

    public String getUsernameById(int to_id) {
        Query query = entityManager.createQuery("select u from UserEntity u where u.id=:id");
        query.setParameter("id", to_id);
        return ((UserEntity) query.getSingleResult()).getUsername();
    }

    public int getUserIdByUsername(String username) {
        Query query = entityManager.createQuery("select u from UserEntity u where u.username=:username");
        query.setParameter("username", username);
        return ((UserEntity) query.getSingleResult()).getId();
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


    public void editUser(int id, String username, String password, String email, String role, boolean active) {
        Query query = entityManager.createQuery("update UserEntity u SET u.username=:username, u.email=:email, u.password=:password, u.role=:role, u.Active=:active WHERE u.id=:id");
        query.setParameter("username", username).setParameter("password", password).setParameter("email", email).setParameter("role", role).setParameter("active", active).setParameter("id", id);
        query.executeUpdate();
    }

    public void deleteUser(int id, String username) {
        Query query = entityManager.createQuery("delete from UserEntity u WHERE u.id=:id AND u.username=:username");
        query.setParameter("username", username).setParameter("id", id);
        query.executeUpdate();
    }

    public void updatePost(ComingPost entity) {
//        Query query = entityManager.createQuery("update PostEntity p SET p.to=:to, p.status=:status, p.lastUpdate=:lastUpdate, p.otherDescriptions=:otherDescriptions WHERE p.post_id=:id");
//        Query query = entityManager.createQuery("select p.post_id from PostEntity p where p.otherDescriptions.detail_id=: SET p.to=:to, p.status=:status, p.lastUpdate=:lastUpdate, p.otherDescriptions=:otherDescriptions WHERE p.post_id=:id");
        System.out.println("updatePost here :+>");
        Query query = entityManager.createQuery("update PostEntity p SET p.to=:to, p.status=:status, p.lastUpdate=:lastUpdate WHERE p.post_id=:id");
        query.setParameter("to", getUsersInfoById(entity.getTo_id()));
        query.setParameter("status", entity.getStatus());
        query.setParameter("lastUpdate", entity.getLastUpdate());
//        query.setParameter("otherDescriptions", entity.getOtherDescriptions());
        query.setParameter("id", entity.getPost_id());
=======
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
	
	public void editUser(int id, String username, String password, String email, String role, boolean active) {
        Query query = entityManager.createQuery("update UserEntity u SET u.username=:username, u.email=:email, u.password=:password, u.role=:role, u.Active=:active WHERE u.id=:id");
        query.setParameter("username", username).setParameter("password", password).setParameter("email", email).setParameter("role", role).setParameter("active", active).setParameter("id", id);
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98
        query.executeUpdate();
    }
}
