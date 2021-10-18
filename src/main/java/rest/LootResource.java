package rest;

import javax.ws.rs.*;

@Path("/loot")
public class LootResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }




}