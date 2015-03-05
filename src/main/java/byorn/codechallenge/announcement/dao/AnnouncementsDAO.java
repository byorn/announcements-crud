/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    private static final AnnouncementsDAO instance = new AnnouncementsDAO();
    
    public static AnnouncementsDAO newInstance(){
        return instance;
    }
    
    public List<Announcement> getAnnouncementsDummyData(){
        IDatabaseAccess dbAccess = new DummyDataDatabaseAccess();
        
        return dbAccess.getAnnouncements();
    }
    
    public List<Announcement> getAnnouncements(){
        IDatabaseAccess dbAccess = new MongoDBAccess();
        
        return dbAccess.getAnnouncements();
    }
    
    
    public void createAnnouncement(Announcement obj){
        IDatabaseAccess dbAccess = new MongoDBAccess();
        
        dbAccess.createNew(obj);
    }
    
}
