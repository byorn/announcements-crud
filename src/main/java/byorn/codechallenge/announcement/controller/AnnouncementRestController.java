package byorn.codechallenge.announcement.controller;

import byorn.codechallenge.announcement.dao.AnnouncementsDAO;
import byorn.codechallenge.announcement.entity.Announcement;
import byorn.codechallenge.announcement.viewhelper.AnnouncementViewHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
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
       announements.addAll(AnnouncementsDAO.getInstance().getAnnouncements());
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
                
                AnnouncementsDAO.getInstance().createAnnouncement(obj);
            }else{
              
                AnnouncementsDAO.getInstance().updateAnnouncement(obj);
            }
            
        }catch(Throwable ex){
            Logger.getLogger(AnnouncementRestController.class.getName()).log(Level.SEVERE, null, ex);
            
            return Response.status(200)
			.entity("Error occurred in Server")
			.build();
        }
	
        return Response.status(200)
			.entity("Successfully Saved : " + title)
			.build();
 
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id) {
       try{
             AnnouncementsDAO.getInstance().deleteAnnouncement(id);
       }catch(Throwable ex){
           Logger.getLogger(AnnouncementRestController.class.getName()).log(Level.SEVERE, null, ex);
            
            return Response.status(200)
			.entity("Error occurred in Server")
			.build();
       }
       return Response.status(200)
			.entity("Successfully Deleted")
			.build();
        
    }
   
}





