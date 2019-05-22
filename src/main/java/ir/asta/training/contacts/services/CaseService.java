package ir.asta.training.contacts.services;

import ir.asta.training.contacts.entities.CaseEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ASUS on 5/4/2019.
 */

@Path("/case")
public interface CaseService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CaseEntity> getAll();
}
