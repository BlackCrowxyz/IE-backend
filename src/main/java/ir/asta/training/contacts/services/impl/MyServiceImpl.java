package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.entities.UserToken;
import ir.asta.training.contacts.manager.MyManager;
import ir.asta.training.contacts.services.MyService;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.Response;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ASUS on 5/5/2019.
 */
@Named("MyServiceImpl")
public class MyServiceImpl implements MyService{

//    private Integer totalRequests = 0;
    @Inject
    private MyManager manager;

    @Override
    public ActionResult<Response> createUser(final UserEntity entity) {
        return manager.createUser(entity);
    }

    @Override
    public ActionResult<Response> login(final UserEntity entity) {return manager.login(entity);}

    @Override
    public ActionResult<Response> sendToken(final UserToken token){
        return manager.sendToken(token);
    }

    @Override
    public ActionResult<List<PostResponse>> createPost(final PostEntity entity) {return manager.createPost(entity);}
	
	  @Override
    public ActionResult<List<PostResponse>> getAllPosts(final UserToken token) {
        return manager.getAllPosts(token);
    }

    @Override
    public ActionResult<List<UserResponse>> getAllUsers(UserToken token) {
        return manager.getAllUsers(token);
    }

	@Override
    public ActionResult<List<UserResponse>> manageUsers(final ComingNewUser newUser) {
        return manager.manageUsers(newUser);
    }
	
}
