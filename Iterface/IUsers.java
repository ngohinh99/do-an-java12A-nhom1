package Iterface;


public interface IUsers<T> {
    boolean searchInUser(String obj1, String obj2);
    boolean addUser(Object obj);
    boolean checkInformation(Object obj1, String obj2);
    T select(String obj);
    boolean update(Object obj1,String obj2 );

}
