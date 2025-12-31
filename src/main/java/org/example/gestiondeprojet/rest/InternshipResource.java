package org.example.gestiondeprojet.rest;


import org.example.gestiondeprojet.entity.Internship;
import org.example.gestiondeprojet.service.InternshipService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/internships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InternshipResource {

    @Inject
    InternshipService service;

    @GET
    public List<Internship> list() { return service.list(); }

    @POST
    public Response add(InternshipDTO dto) {
        try {
            System.out.println("=== DÉBUT CRÉATION STAGE ===");
            System.out.println("Titre: " + dto.getTitle());
            System.out.println("Student ID reçu: " + dto.getStudentId());
            System.out.println("Company ID reçu: " + dto.getCompanyId());
            
            Internship internship = service.add(dto);
            
            System.out.println("Stage créé avec succès! ID: " + internship.getId());
            System.out.println("=== FIN CRÉATION STAGE ===");
            
            return Response.status(Response.Status.CREATED).entity(internship).build();
        } catch (Exception e) {
            System.err.println("ERREUR lors de la création du stage: " + e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erreur: " + e.getMessage())
                          .build();
        }
    }

    @GET
    @Path("/{id}")
    public Internship get(@PathParam("id") Long id) { return service.get(id); }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}

