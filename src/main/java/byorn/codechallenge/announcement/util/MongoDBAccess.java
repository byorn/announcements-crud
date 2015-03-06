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
import org.bson.types.ObjectId;

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
    /* ************************************************ */
    
   
    private final String COL_ID="_id";
    private final String COL_TITLE="title";
    private final String COL_BODY="body";
    private final String COL_STARTDATE="startDate";
    private final String COL_EXPIRYDATE="expiryDate";
    
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
            announcement.setId(Util.handleNull(dbObject.get(COL_ID)));
            announcement.setTitle(Util.handleNull(dbObject.get(COL_TITLE)));
            announcement.setBody(Util.handleNull(dbObject.get(COL_BODY)));
            announcement.setStartDate(Util.handleNull(dbObject.get(COL_STARTDATE)));
            announcement.setExpiryDate(Util.handleNull(dbObject.get(COL_EXPIRYDATE)));
            
            list.add(announcement);
        } 
       return list;
    }

    @Override
    public void createNew(Announcement announcement) {
        
        BasicDBObject doc = new BasicDBObject(COL_TITLE, announcement.getTitle())
        .append(COL_BODY, announcement.getBody())
        .append(COL_STARTDATE, announcement.getStartDate())
        .append(COL_EXPIRYDATE, announcement.getExpiryDate());
        
        getDBCollection().insert(doc);
    }

    @Override
    public void update(Announcement announcement) {
        DBObject original = findRecordToUpdate(announcement.getId());
        BasicDBObject newRecordToUpdate = new BasicDBObject(COL_TITLE, announcement.getTitle())
        .append(COL_BODY, announcement.getBody())
        .append(COL_STARTDATE, announcement.getStartDate())
        .append(COL_EXPIRYDATE, announcement.getExpiryDate());
        
        getDBCollection().update(original, newRecordToUpdate);
    }
    
    
    private DBObject findRecordToUpdate(String id){
            BasicDBObject query = new BasicDBObject();
            query.put("_id", new ObjectId(id));
            DBObject dbObj = getDBCollection().findOne(query);
            return dbObj;
    }
}
