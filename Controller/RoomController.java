package Controller;



import Iterface.IHome;
import Model.Room;
import Service.RoomService;

public class RoomController implements IHome<Room> {
    private RoomService roomService;

    public RoomController() {
        this.roomService = new RoomService();
    }

    @Override
    public String printInfo(Object obj) {
        return roomService.printInfo(obj);
    }

    @Override
    public boolean add(Room obj) {
            return roomService.add(obj);
    }

    @Override
    public String printList(Object obj) {
        return roomService.printList(obj);
    }

    @Override
    public Room select(String obj) {
        return roomService.select(obj);
    }

    @Override
    public boolean delete(String obj) {
        return roomService.delete(obj);
    }



    @Override
    public boolean update(Room obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }

}
