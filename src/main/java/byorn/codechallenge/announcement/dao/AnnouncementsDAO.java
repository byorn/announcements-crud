package byorn.codechallenge.announcement.dao;

import byorn.codechallenge.announcement.entity.Announcement;
import byorn.codechallenge.announcement.util.DummyDataDatabaseAccess;
import byorn.codechallenge.announcement.util.IDatabaseAccess;
import byorn.codechallenge.announcement.util.MongoDBAccess;
import java.util.List;

/**
 *
 * @author Byorn
 */
public class AnnouncementsDAO {

    private static final AnnouncementsDAO INSTANCE = new AnnouncementsDAO();

    public static AnnouncementsDAO getInstance() {
        return INSTANCE;
    }

    public List<Announcement> getAnnouncementsDummyData() {
        IDatabaseAccess dbAccess = new DummyDataDatabaseAccess();

        return dbAccess.getAnnouncements();
    }

    public List<Announcement> getAnnouncements() {
        IDatabaseAccess dbAccess = MongoDBAccess.getInstance();

        return dbAccess.getAnnouncements();
    }

    public void createAnnouncement(Announcement obj) {
        IDatabaseAccess dbAccess = MongoDBAccess.getInstance();

        dbAccess.createNew(obj);
    }

    public void updateAnnouncement(Announcement obj) {
        IDatabaseAccess dbAccess = MongoDBAccess.getInstance();

        dbAccess.update(obj);
    }
    
    public void deleteAnnouncement(String id){
         IDatabaseAccess dbAccess = MongoDBAccess.getInstance();
         
         dbAccess.delete(id);
    }

}
