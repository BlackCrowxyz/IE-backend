package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.manager.MyManager;
import ir.asta.training.contacts.services.MyService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ASUS on 5/5/2019.
 */
@Named("MyServiceImpl")
public class MyServiceImpl implements MyService{

//    private Integer totalRequests = 0;
    @Inject
    private MyManager manager;

    @Override
    public ActionResult<UserEntity> createUser(final UserEntity entity) {
        return manager.createUser(entity);
    }

    @Override
    public ActionResult<UserEntity> login(final UserEntity entity) {return manager.login(entity);}

//    @Override
//    public ActionResult<PostEntity> createPost(final PostEntity entity) {return manager.createPost(entity);}

    @Override
    public void deleteAll() {
        manager.deleteAll();
    }

}
