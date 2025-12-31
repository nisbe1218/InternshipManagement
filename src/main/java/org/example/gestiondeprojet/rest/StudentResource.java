package org.example.gestiondeprojet.rest;


import org.example.gestiondeprojet.entity.Student;
import org.example.gestiondeprojet.service.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    StudentService service;

    @GET
    public List<Student> list() { return service.list(); }

    @POST
    public Response add(Student s) {
        service.add(s);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Student get(@PathParam("id") Long id) { return service.get(id); }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) { service.delete(id); }
}
