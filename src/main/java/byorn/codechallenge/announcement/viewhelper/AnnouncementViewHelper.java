package byorn.codechallenge.announcement.viewhelper;

import byorn.codechallenge.announcement.entity.Announcement;

/**
 *
 * @author Byorn
 */
public class AnnouncementViewHelper {
    
       
    public static Announcement getAnnouncement(String id, String title, String body, String expiryDate, String startDate){
        Announcement obj = new Announcement();
        obj.setId(id);
        obj.setTitle(title);
        obj.setBody(body);
        obj.setStartDate(startDate);
        obj.setExpiryDate(expiryDate);
        return obj;
    }
    
}
