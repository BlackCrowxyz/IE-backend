package ir.asta.training.contacts.services;

import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.entities.UserToken;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ASUS on 5/5/2019.
 */

@Path("/myservice")
public interface MyService {

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<Response> createUser(final UserEntity entity);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<Response> login(final UserEntity entity);

    @POST
    @Path("/sendToken")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<Response> sendToken(final UserToken token);

    @POST
    @Path("/createPost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<PostResponse>> createPost(final PostEntity entity);

}
