package byorn.codechallenge.announcement.controller;

import byorn.codechallenge.announcement.dao.AnnouncementsDAO;
import byorn.codechallenge.announcement.entity.Announcement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Stateless
@Path("/rest")
public class AnnouncementRestController{

       
    
    @GET 
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAnnouncements() {
     
       return Response.ok( AnnouncementsDAO.newInstance().getAnnouncements()).build();
    }
   
}





