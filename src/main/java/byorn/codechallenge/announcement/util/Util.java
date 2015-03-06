package byorn.codechallenge.announcement.util;

/**
 *
 * @author Byorn
 */
public class Util {

    public static String handleNull(Object o){
        if(o==null){
            return "";
        }
        return o.toString();
    }
}
