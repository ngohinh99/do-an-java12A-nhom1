package Iterface;

import org.json.JSONObject;

public interface IUsers {
    boolean checkInUses(Object obj1, Object obj2);
    boolean addUser(Object obj);
    boolean checkInformation(Object obj1, Object obj2);
    String checkIsAdmin(Object obj);
    boolean update(Object obj1,Object obj2 );

}
