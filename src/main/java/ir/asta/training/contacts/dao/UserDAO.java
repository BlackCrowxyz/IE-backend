package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.DetailsEntity;
import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ASUS on 5/15/2019.
 */
@Named("userDao")
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean containsUser(String username){
        Query query = entityManager.createQuery("Select u FROM UserEntity u WHERE u.username=:username");
        query.setParameter("username", username); //avoid SQL injection
        List list = query.getResultList();
        return list.size() > 0;
    }

    public void saveUser(final UserEntity entity){entityManager.persist(entity);}

    public UserEntity getUserInfo(final UserEntity entity) {
        //TODO: complete this part
        String username = entity.getUsername();
        String password = entity.getPassword();
        Query query = entityManager.createQuery("select u from UserEntity u where u.username=:username and u.password=:password");
        query.setParameter("username", username); //avoid SQL injection
        query.setParameter("password", password); //avoid SQL injection
        Object obj = query.getSingleResult();
        return (obj != null) ? (UserEntity) obj : entity; //returning the entity
    }

    public void createPost(final PostEntity entity) {
        //TODO: Complete this part for adding post to DataBase
        System.out.println(entity.getLastUpdate());
        System.out.println(entity.getDetail());
        System.out.println(entity.getFrom_who());
        System.out.println(entity.getOtherDescriptions());
        for (DetailsEntity d : entity.getOtherDescriptions()) {
            System.out.println(d.getDetail_id());
            System.out.println(d.getResponsible());
            System.out.println(d.getText());
        }
        System.out.println(entity.getPost_id());
        System.out.println(entity.getStatus());
        System.out.println(entity.getTitle());
        System.out.println(entity.getTo_who());
        /*
        TODO : look for the "user"'s ID with it's username(from) in DB and then add the post to it...
        */
        entityManager.persist(entity);

//        return null;
    }
}
