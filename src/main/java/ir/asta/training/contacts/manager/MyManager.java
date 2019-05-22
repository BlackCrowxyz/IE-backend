package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.UserDAO;
import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ASUS on 5/5/2019.
 */
@Named("MyManager")
public class MyManager {

    private Integer totalRequests = 0;
    @Inject
    private UserDAO dao;
//    private MyDao dao;

    private boolean validation(final UserEntity entity) {
        // checking of emptiness & pass==repass VALIDATION
        if (entity.getUsername().isEmpty() || entity.getUsername().length() < 3 ||
                entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getRepassword().isEmpty() ||
                (!Objects.equals(entity.getPassword(), entity.getRepassword()))) {
            System.out.println("empty OR pass!=repass");
            return false;
        }
        // EMAIL VALIDATION
        String email_regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p_email = Pattern.compile(email_regex);
        Matcher m_email = p_email.matcher(entity.getEmail());
        System.out.println("is Email validated: " + !m_email.matches());
        if (!m_email.matches()) return false; //returns false if does not match

        // PASSWORD VALIDATION
        // (?=.*[a-z]) -> password should at least have 1 character
        // (?=.*[0-9]) -> password should at least have 1 digit
        //  .{8,}      -> at least 8 character
        //  $          -> end of password
        String password_regex = "^(?=.*[0-9])(?=.*[a-z]).{8,}$";
        Pattern p_pass = Pattern.compile(password_regex);
        Matcher m_pass = p_pass.matcher(entity.getPassword());
        System.out.println("is Password validated: " + !m_pass.matches());
        if (!m_pass.matches()) return false;
        return true;
    }

    @Transactional
    public ActionResult<UserEntity> createUser(final UserEntity entity){
        ActionResult<UserEntity> result = new ActionResult<>();

        if (dao.containsUser(entity.getUsername())){
            // Checking for the same user in Dao
            System.out.println("Dublicate User");
            result.setMessage("Duplicate user");
        }
        else if(!validation(entity)){
            //TODO: validation entered user information goes here
            System.out.println("User Validation Failed");
            result.setMessage("Validation failed");
        } else {
            dao.saveUser(entity);
            result.setData(entity);
            result.setSuccess(true);
            result.setMessage("successful -> User added to DB");
        }
        return result;
    }

    @Transactional
    public ActionResult<UserEntity> login(final UserEntity entity) {
        ActionResult<UserEntity> result = new ActionResult<>();
        result.setMessage("failed -> no such user in DB");
        if (dao.containsUser(entity.getUsername())){
            //TODO: try , catch for null user ?
            //Object obj = dao.getUserInfo(entity);
            //UserEntity user = (obj != entity) ? (UserEntity) obj : null;
            UserEntity user = dao.getUserInfo(entity);
            if (user == null){
                result.setMessage("failed -> wrong password");
                return result;
            } else if (Objects.equals(user.getPassword(), entity.getPassword())){
                //TODO: how to return the whole JSON to client ?
                result.setData(user);

                System.out.println();
                System.out.println(user);
                System.out.println(user.getEmail());
                System.out.println();

                result.setSuccess(true);
                result.setMessage("successful -> got user from DB");
                return result;
            }
        }
        return result;
    }

    public void deleteAll() {
        dao.deleteAll();
    }

//    public ActionResult<PostEntity> createPost(final PostEntity entity) {
//        ActionResult<PostEntity> result = new ActionResult<>();
//
//        if (Objects.equals(entity.getDetail(), "")
//                || Objects.equals(entity.getTitle(), "")
//                || entity.getResponsible() == null){
//            result.setMessage("createPost > Failed");
//            System.out.println("createPost > empty field");
//            return result;
//        }
//        result.setSuccess(true);
//        result.setMessage("createPost > Success");
//
//        dao.createPost(entity);
//        return result;
//    }

}
