package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.LootDTO;
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


    @POST
    @Consumes("application/json")
    public Response addLoot(String loot){
        LootDTO dto = gson.fromJson(loot,LootDTO.class);
        dto = instance.addLoot(dto);

        return Response.ok(gson.toJson(dto)).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteLoot(@PathParam("id") Long id){
        instance.deleteLoot(id);
        return Response.ok().build();
    }



}