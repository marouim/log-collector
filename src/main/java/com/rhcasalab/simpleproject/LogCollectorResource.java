package com.rhcasalab.simpleproject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class LogCollectorResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "hello";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createLog(String event) {
        System.out.println("PROCESSING EVENT: " + event);

        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
        }
        
        System.out.println("DONE PROCESSING EVENT: " + event);
        return Response.ok().build();
    }

    @GET
    @Path("/healthz")
    @Produces(MediaType.TEXT_PLAIN)
    public Response health() {
        return Response.ok().build();
    }
}