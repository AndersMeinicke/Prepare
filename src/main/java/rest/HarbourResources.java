package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.HarbourFacade;
import facades.UserFacade;
import javassist.NotFoundException;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("harbour")
public class HarbourResources {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final HarbourFacade FACADE =  HarbourFacade.getHarbourFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.getAllHarbours())).build();
    }
}
