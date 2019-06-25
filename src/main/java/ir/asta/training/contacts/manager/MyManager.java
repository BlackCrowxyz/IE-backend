package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.UserDAO;
import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.entities.UserToken;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.Response;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Inject
    private UserDAO dao;
    private int id = 1;

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
        System.out.println("is Email validated good: " + m_email.matches());
        if (!m_email.matches()) return false; //returns false if does not match

        // PASSWORD VALIDATION
        // (?=.*[a-z]) -> password should at least have 1 character
        // (?=.*[0-9]) -> password should at least have 1 digit
        //  .{8,}      -> at least 8 character
        //  $          -> end of password
        String password_regex = "^(?=.*[0-9])(?=.*[a-z]).{8,}$";
        Pattern p_pass = Pattern.compile(password_regex);
        Matcher m_pass = p_pass.matcher(entity.getPassword());
        System.out.println("is Password validated good: " + m_pass.matches());
        if (!m_pass.matches()) return false;
        return true;
    }

    @Transactional
    public ActionResult<Response> createUser(UserEntity entity){
        ActionResult<Response> result = new ActionResult<>();

        if (dao.containsUsernameInDB(entity.getUsername())){
            // Checking for the same user in Dao
            System.out.println("Dublicate User");
            result.setMessage("Duplicate user");
        }
        else if(!validation(entity)){
            //TODO: validation entered user information goes here
            System.out.println("User Validation Failed");
            result.setMessage("Validation failed");
        } else {
            entity.setToken(makeToken(id++));
            dao.saveUser(entity);
            result.setData(makeUserResponse(entity));
            result.setSuccess(true);
            result.setMessage("successful -> User added to DB");
        }
        return result;
    }

    private Response makeUserResponse(UserEntity entity) {
        return new Response(entity.getToken(), entity.getRole(), entity.getUsername());
    }

    @Transactional
    public ActionResult<Response> login(final UserEntity entity) {
        ActionResult<Response> result = new ActionResult<>();
        result.setMessage("failed -> no such user in DB");
        if (dao.containsUsernameInDB(entity.getUsername())){
            //TODO: try , catch for null user ?
            //Object obj = dao.getUserInfo(entity);
            //UserEntity user = (obj != entity) ? (UserEntity) obj : null;

            UserEntity user = dao.getUserInfo(entity);
            if (user == null){
                result.setMessage("failed -> wrong password");
                return result;
            } else if (Objects.equals(user.getPassword(), entity.getPassword())){
                //TODO: how to return the whole JSON to client ?
                result.setData(makeUserResponse(user));

//                System.out.println();
//                System.out.println(user);
//                System.out.println(user.getUsername());
//                System.out.println(user.getToken());
//                System.out.println();

                result.setSuccess(true);
                result.setMessage("successful -> got user from DB");
                return result;
            }
        }
        return result;
    }

    //Creating token for this user
    private String makeToken(int id) {
        return "asdf"+id+"zxvc"+id;
    }

    @Transactional
    public ActionResult<Response> sendToken(UserToken token) {
        ActionResult<Response> result = new ActionResult<>();
        result.setMessage("failed -> no such user in DB");
        System.out.println(token);
        System.out.println();
        if (dao.containsTokenInDB(token.getToken())){
            //TODO: try , catch for null user ?
            //Object obj = dao.getUserInfo(entity);
            //UserEntity user = (obj != entity) ? (UserEntity) obj : null;

            UserEntity user = dao.getUserInfoByToken(token.getToken());
            System.out.println("**************");
            if (user == null){
                result.setMessage("failed -> wrong password");
                return result;
            } else if (Objects.equals(user.getToken(), token.getToken())){
                result.setData(makeUserResponse(user));
//                System.out.println();
//                System.out.println(user.getUsername());
//                System.out.println(user.getToken());
//                System.out.println();
                result.setSuccess(true);
                result.setMessage("successful -> got user from DB");
                return result;
            }
        }
        return result;
    }

    @Transactional
    public ActionResult<List<PostResponse>> createPost(final PostEntity entity) {
        ActionResult<List<PostResponse>> result = new ActionResult<>();

        if (Objects.equals(entity.getDetail(), "")
                || Objects.equals(entity.getTitle(), "")
                || entity.getDetail() == null){
            result.setMessage("createPost > Failed");
            System.out.println("createPost > empty field");
            return result;
        }
        result.setSuccess(true);
        result.setMessage("createPost > Success");

        //dao.createPost(entity);
        dao.createPost(entity);
        //result.setData(makePostResponse(entity)); //sending the entire post that sent to server  back to client
        result.setData(dao.getMyPosts(entity.getFrom().getId()));
        //
        return result;
    }

    private PostResponse makePostResponse(PostEntity entity) {
        return new PostResponse(
                dao.getUserInfoById(entity.getTo().getId()),
                entity.getTitle(),
                entity.getStatus(),
                entity.getLastUpdate(),
                entity.getDetail(),
                entity.isSatisfied(),
                entity.getOtherDescriptions()
                );
    }
	
	@Transactional
    public ActionResult<List<PostResponse>> getAllPosts(final UserToken token) {
        ActionResult<List<PostResponse>> result = new ActionResult<>();
        result.setMessage("failed -> No such user in DB");
        if (dao.containsTokenInDB(token.getToken())){
            result.setMessage("failed -> Access denied");
            //if admin requested the posts
            if (Objects.equals(dao.getUserInfoByToken(token.getToken()).getRole(), "admin")){
                result.setData(dao.getAllPosts());
                result.setSuccess(true);
                result.setMessage("successful -> Got all posts from DB (ADMIN)");
            } else if(Objects.equals(dao.getUserInfoByToken(token.getToken()).getRole(), "prof")){ //prof requested the posts
                result.setData(dao.getRelatedPosts(dao.getUserInfoByToken(token.getToken()).getId()));
                result.setSuccess(true);
                result.setMessage("successful -> Got all posts from DB (PROF)");
            }
        }
        return result;
    }
	
	@Transactional
    public ActionResult<List<UserResponse>> getAllUsers(UserToken token) {
        ActionResult<List<UserResponse>> result = new ActionResult<>();
        result.setMessage("failed -> No such user in DB");
        if (dao.containsTokenInDB(token.getToken())){
            result.setMessage("failed -> Access denied");
            //if admin requested the posts
            if (Objects.equals(dao.getUserInfoByToken(token.getToken()).getRole(), "admin")){
                result.setData(dao.getAllUsers());
                result.setSuccess(true);
                result.setMessage("successful -> Got all users from DB");
            }
        }
        return result;
    }

	@Transactional
    public ActionResult<List<UserResponse>> manageUsers(final ComingNewUser newUser) {
        ActionResult<List<UserResponse>> result = new ActionResult<>();
        result.setMessage("failed -> Access denied");
        result.setData(dao.getAllUsers());
        //check if user info is okay
        if (validation(new UserEntity(null, newUser.getNew_username(), newUser.getEmail(), newUser.getPassword(), newUser.getPassword(), newUser.getRole(), newUser.isActive()))) {
            //if admin requested the change
            if (dao.containsTokenInDB(newUser.getToken()) && Objects.equals(dao.getUserInfoByToken(newUser.getToken()).getRole(), "admin")) {
                result.setMessage("failed -> No such user in DB to edit(or update)");
                if (dao.containsUsernameInDB(newUser.getLast_username())) { //does this user exist in DB?
                    System.out.println("- User edited (by ADMIN)");
                    dao.editUser(dao.getUserIdByUsername(newUser.getLast_username()), newUser.getNew_username(), newUser.getPassword(), newUser.getEmail(), newUser.getRole(), newUser.isActive());
//                    result.setData(dao.getAllUsers());
                    result.setSuccess(true);
                    result.setMessage("successful -> Got all users from DB and user updated");
                }
            } else if (dao.containsTokenInDB(newUser.getToken()) && Objects.equals(dao.getUserInfoByToken(newUser.getToken()).getUsername(), newUser.getLast_username())) { //if user requested the change
                System.out.println("- User edited (by USER itself)");
                dao.editUser(dao.getUserIdByUsername(newUser.getLast_username()), newUser.getNew_username(), newUser.getPassword(), newUser.getEmail(), newUser.getRole(), newUser.isActive());
                result.setMessage("successful -> Got all users from DB and user updated");
//                result.setData(dao.getAllUsers());
                result.setSuccess(true);
            }
        }
        return result;
    }
}
