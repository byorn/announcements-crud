/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byorn.codechallenge.announcement.util;

import byorn.codechallenge.announcement.entity.Announcement;
import java.util.List;

/**
 *
 * @author Byorn
 */
public interface IDatabaseAccess {
    public List<Announcement> getAnnouncements();
    public void createNew(Announcement announcement);
}
