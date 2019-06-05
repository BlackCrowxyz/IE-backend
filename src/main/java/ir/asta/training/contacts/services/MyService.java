package ir.asta.training.contacts.services;

import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ASUS on 5/5/2019.
 */

@Path("/myservice")
public interface MyService {

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<UserEntity> createUser(final UserEntity entity);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<UserEntity> login(final UserEntity entity);

    @POST
    @Path("/createPost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<PostEntity> createPost(final PostEntity entity);

}
