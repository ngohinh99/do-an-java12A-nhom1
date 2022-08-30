package Repository;

import java.util.List;

import Data.ListData;
import Iterface.IHome;
import Model.Floor;
import Model.Room;

public class RoomRepository implements IHome<Room> {
    private List<Room> rooms;

    public RoomRepository() {
        this.rooms = ListData.rooms;
    
    }



    @Override
    public String printInfo(Object obj) {
        String result = "";
        if (obj instanceof Floor) {
            Floor floor = (Floor) obj;
            String idFloor = floor.getId();
            for (Room room : rooms) {
                if (room.getId().contains(idFloor)) {
                    result = result + "\t\t" + room.toString();
                }
            }

        }
        return result;
    }

    @Override
    public boolean add(Room obj) {
        return rooms.add(obj);
    }

    @Override
    public String printList(Object obj) {
        Floor floor = (Floor) obj;
        String idFloor = floor.getId();
        String result = "";
        for (Room room : rooms) {
            if (room.getId().contains(idFloor)) {
                result = result + room.toString();

            }
        }
        return result;
    }

    @Override
    public Room select(String obj) {
        return null;
    }
    @Override
    public boolean delete(String obj) {
        return rooms.removeIf(n ->n.getId().contains(obj));
    }







    @Override
    public boolean update(Room obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }

}
