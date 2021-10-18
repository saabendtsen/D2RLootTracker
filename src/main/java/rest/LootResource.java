package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.LootFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/loot")
public class LootResource {
    private final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final LootFacade instance = LootFacade.getInstance(EMF);



    @GET
    @Produces("application/json")
    public Response getAllLoot() {
        return Response.ok(gson.toJson(instance.getAllLoot()),"application/json").build();
    }




}