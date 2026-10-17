package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestApi {
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    //getListUE
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUe(){
        return Response
                .status(200)
                .entity(helper.getListeUE())
                .build();
    }
    @Path("/add")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUe(UniteEnseignement ue){
        if(helper.addUniteEnseignement(ue)) {
        return Response.status(201).entity("created").build();
        }
        else{
            return Response.status(400).entity("failed").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam("code") int code){
        return Response.status(200).entity((helper.getUEByCode(code))).build();
    }

    @PUT
    @Path("/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUE(
            @PathParam("code") int code,
            UniteEnseignement ue) {

        if (helper.updateUniteEnseignement(code, ue)) {
            return Response
                    .status(200)
                    .entity("updated")
                    .build();
        } else {
            return Response
                    .status(404)
                    .entity("UE introuvable")
                    .build();
        }
    }

    // =========================
    // DELETE : Supprimer une UE
    // =========================
    @DELETE
    @Path("/{code}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE(@PathParam("code") int code) {

        if (helper.deleteUniteEnseignement(code)) {
            return Response
                    .status(200)
                    .entity("deleted")
                    .build();
        } else {
            return Response
                    .status(404)
                    .entity("UE introuvable")
                    .build();
        }
    }


}
