package Controller;



import Iterface.IHome;
import Model.Room;
import Repository.RoomRepository;

public class RoomController implements IHome<Room> {
    private RoomRepository roomRepository;

    public RoomController() {
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
        return false;
    }

    public String printEmptyRoom() {
        return roomRepository.printEmptyRoom();
    }
    public boolean searchInRooms(String obj1, String obj2) {
        return roomRepository.searchInUser(obj1, obj2);
    }

}
