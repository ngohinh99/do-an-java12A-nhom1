package Iterface;

public interface IHome<T> {
 T select(String obj);
 String printInfo(Object obj);
 boolean add(T obj);
 String printList(Object obj);
 boolean delete(String obj);
 boolean update(T obj, String obj2);

}
