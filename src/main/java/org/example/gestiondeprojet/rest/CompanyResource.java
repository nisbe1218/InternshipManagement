package org.example.gestiondeprojet.rest;


import org.example.gestiondeprojet.entity.Company;
import org.example.gestiondeprojet.service.CompanyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource {

	@Inject
	CompanyService service;

	@GET
	public List<Company> list() { return service.list(); }

	@POST
	public Response add(Company c) {
		service.add(c);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	public Company get(@PathParam("id") Long id) { return service.get(id); }

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) { service.delete(id); }
}
