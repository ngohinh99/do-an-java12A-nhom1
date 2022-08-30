package Service;


import Iterface.IHome;
import Model.Room;
import Repository.RoomRepository;

public class RoomService implements IHome<Room> {
    private RoomRepository roomRepository;
public RoomService(){
    this.roomRepository = new RoomRepository();
}

@Override
public String printInfo(Object obj) {
    return roomRepository.printInfo(obj);
}
@Override
public boolean add(Room obj) {
    return roomRepository.add(obj);
}
@Override
public String printList(Object obj) {
    return roomRepository.printList(obj);
}
@Override
public Room select(String obj) {
    return roomRepository.select(obj);
}
@Override
public boolean delete(String obj) {
    return roomRepository.delete(obj);
}

@Override
public boolean update(Room obj, String obj2) {
    // TODO Auto-generated method stub
    return false;
}

}
