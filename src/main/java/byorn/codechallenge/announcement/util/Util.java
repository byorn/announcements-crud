/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
