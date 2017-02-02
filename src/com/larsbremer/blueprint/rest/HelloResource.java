package com.larsbremer.blueprint.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.larsbremer.blueprint.model.PojoObject;

import io.swagger.annotations.Api;

@Path("/hello")
@Api(value = "/hello", description = "Manage people")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response writeData(PojoObject pojoObj) {

		System.out.println("Current field: " + pojoObj.getField());
		pojoObj.setField(42);
		return Response.ok(pojoObj).build();
	}
}