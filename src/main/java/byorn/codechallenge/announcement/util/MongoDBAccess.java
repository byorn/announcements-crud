package byorn.codechallenge.announcement.util;

import byorn.codechallenge.announcement.entity.Announcement;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Byorn
 */
public class MongoDBAccess implements IDatabaseAccess{

    /** We can move these parameters to a properties File **/
    private final String HOST="localhost";
    private final int PORT=27017;
    private final String DATABASE="announcements";
    private final String COLLECTION_NAME="announcements";
    
    
    private static MongoClient mongoClient = null;
    
    
    
    
    private DBCollection getDBCollection(){
       try {
            if(mongoClient==null){
                mongoClient = new MongoClient( HOST , PORT );
            }
        } catch (UnknownHostException ex) {
              Logger.getLogger(MongoDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        DB db = mongoClient.getDB( DATABASE );
               
        return db.getCollection(COLLECTION_NAME);
    }
    
    
    
    @Override
    public List<Announcement> getAnnouncements() {
       
        List<Announcement> list = new ArrayList(); 
        DBCursor cursor = getDBCollection().find();
      
	while(cursor.hasNext()) {
	    DBObject dbObject = cursor.next();
            Announcement announcement = new Announcement();
            announcement.setTitle(Util.handleNull(dbObject.get("title")));
            announcement.setBody(Util.handleNull(dbObject.get("body")));
            announcement.setStartDate(Util.handleNull(dbObject.get("startDate")));
            announcement.setExpiryDate(Util.handleNull(dbObject.get("expiryDate")));
            
            list.add(announcement);
        } 
       return list;
    }

    @Override
    public void createNew(Announcement announcement) {
        
        BasicDBObject doc = new BasicDBObject("title", announcement.getTitle())
        .append("body", announcement.getBody())
        .append("startDate", announcement.getStartDate())
        .append("expiryDate", announcement.getExpiryDate());
        
        getDBCollection().insert(doc);
    }
    
}
