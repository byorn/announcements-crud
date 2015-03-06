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
    public void update(Announcement announcement);
}
