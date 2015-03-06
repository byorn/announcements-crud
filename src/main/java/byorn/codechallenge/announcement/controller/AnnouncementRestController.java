package byorn.codechallenge.announcement.controller;

import byorn.codechallenge.announcement.dao.AnnouncementsDAO;
import byorn.codechallenge.announcement.entity.Announcement;
import byorn.codechallenge.announcement.util.MongoDBAccess;
import byorn.codechallenge.announcement.viewhelper.AnnouncementViewHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Stateless
@Path("/rest")
public class AnnouncementRestController{

       
    
    @GET 
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAnnouncements() {
     
       List<Announcement> announements = new ArrayList<>();
       //announements.addAll(AnnouncementsDAO.newInstance().getAnnouncementsDummyData());
       announements.addAll(AnnouncementsDAO.newInstance().getAnnouncements());
       return Response.ok( announements).build();
    }
    
    
    @POST
    @Path("/post")
    public Response createOrUpdateAnnouncment(
                @FormParam("id") String id,
		@FormParam("title") String title,
                @FormParam("body") String body,
                @FormParam("startdate") String startDate,
                @FormParam("expirydate") String expiryDate) {
 
        Announcement obj = AnnouncementViewHelper.getAnnouncement(id, title, body, expiryDate, startDate);
        
        try{
            if("".equals(id)){
                
                AnnouncementsDAO.newInstance().createAnnouncement(obj);
            }else{
              
                AnnouncementsDAO.newInstance().updateAnnouncement(obj);
            }
            
        }catch(Throwable ex){
            Logger.getLogger(AnnouncementRestController.class.getName()).log(Level.SEVERE, null, ex);
            
            return Response.status(200)
			.entity("Error occurred in Server")
			.build();
        }
	
        return Response.status(200)
			.entity("Successfully Created : " + title)
			.build();
 
    }
   
}





