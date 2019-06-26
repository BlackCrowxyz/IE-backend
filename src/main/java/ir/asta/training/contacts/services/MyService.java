package ir.asta.training.contacts.services;

<<<<<<< HEAD
import ir.asta.training.contacts.entities.*;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.Response;
import ir.asta.wise.core.reponse.UserResponse;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
=======
import ir.asta.training.contacts.entities.PostEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.entities.UserToken;
import ir.asta.wise.core.datamanagement.ActionResult;
import ir.asta.wise.core.reponse.PostResponse;
import ir.asta.wise.core.reponse.Response;
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

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
<<<<<<< HEAD
    //For getting user info without loging in(using token)
=======
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

    @POST
    @Path("/createPost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public ActionResult<List<PostResponse>> createPost(final ComingPost entity) throws Exception;

    //just returns all posts to (ADMIN|PROF|STUDENT) page
    @POST
    @Path("/getAllPosts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<PostResponse>> getAllPosts(final UserToken token);

    //just returns all users to ADMIN page
    @POST
    @Path("/getAllUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<UserResponse>> getAllUsers(final UserToken token);

    //TODO: accept a user
    //TODO: edit profile from user
    //TODO: edit profile from admin
    @POST
    @Path("/manageUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<UserResponse>> manageUsers(final ComingNewUser newUser);

    //TODO: delete a user
    @POST
    @Path("/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<UserResponse>> deleteUser(final ComingNewUser newUser);

    //TODO: like a post

    //TODO: filter posts by time, sender, responsible and ...

    //** TODO: اقدام روی پست
    @POST
    @Path("/managePosts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult managePosts(final ComingPost entity);
=======
    public ActionResult<List<PostResponse>> createPost(final PostEntity entity);

	//just returns all posts to (ADMIN|PROF|STUDENT) page
    @POST
    @Path("/getAllPosts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<PostResponse>> getAllPosts(final UserToken token);
>>>>>>> 5c4601b3a0d4e3aaa8b55c1b8c267b765c13df98

    //just returns all users to ADMIN page
    @POST
    @Path("/getAllUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<UserResponse>> getAllUsers(final UserToken token);
	
	//TODO: accept a user
    //TODO: edit profile from user
    //TODO: edit profile from admin
    @POST
    @Path("/manageUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<List<UserResponse>> manageUsers(final ComingNewUser newUser);
	
}
