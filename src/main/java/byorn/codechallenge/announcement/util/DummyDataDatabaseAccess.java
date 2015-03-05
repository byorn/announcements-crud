/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byorn.codechallenge.announcement.util;

import byorn.codechallenge.announcement.entity.Announcement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Byorn
 */
public class DummyDataDatabaseAccess implements IDatabaseAccess{

    @Override
    public List<Announcement> getAnnouncements() {
         List<Announcement> list = new ArrayList(); 
       
         Announcement announcement = new Announcement();
         announcement.setId(1);
         announcement.setTitle("<a href='1'>There Is No Way To Protect Yourself If US Treasuries Default</a>");
         announcement.setBody("It is a long established fact that a reader will be "
                 + "distracted by the readable content of a page when looking at its layout. "
                 + "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, "
                 + "as opposed to using 'Content here, content here', making it look like readable English.");
         
      
         announcement.setStartDate("2013-10-11");
         announcement.setExpiryDate("2014-10-11");
         
         
         
         Announcement announcement1 = new Announcement();
         announcement1.setId(2);
         announcement1.setTitle("<a href='2'>States keep watch on school deals</a>");
         announcement1.setBody("It is a long established fact that a reader will be distracted by the readable "
                 + "content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a "
                 + "more-or-less normal distribution of letters, as opposed to using 'Content here, content here', "
                 + "making it look like readable English.");
         
      
         announcement1.setStartDate("2013-10-11");
         announcement1.setExpiryDate("2014-10-11");
         
         
         Announcement announcement2 = new Announcement();
         announcement2.setId(3);
         announcement2.setTitle("<a href='3'>Ron Paul Redux: The End Of Dollar Hegemony</a>");
         announcement2.setBody("It is a long established fact that a reader will be distracted by the readable "
                 + "content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a"
                 + " more-or-less normal distribution of letters, as opposed to using 'Content here, content here',"
                 + " making it look like readable English.");
         
      
         announcement2.setStartDate("2013-10-11");
         announcement2.setExpiryDate("2014-10-11");
         
         
        list.add(announcement);
        list.add(announcement1);
        list.add(announcement2);
      
       return list;
        
    }
    
}
