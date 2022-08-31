package Repository;

import java.util.List;

import Data.Data;
import Iterface.IHome;
import Model.Floor;
import Model.Home;

public class FloorRepository implements IHome<Floor> {
    private List<Floor> floors;
    private RoomRepository roomRepository;

    public FloorRepository() {
        this.floors = Data.floors;
        this.roomRepository = new RoomRepository();
    }



    @Override
    public String printInfo(Object obj) {
        String result = "";
        if(obj instanceof Floor){
            Floor floor = (Floor) obj;
            result= floor.toString();
        } 
        if(obj instanceof Home){
            Home home = (Home)obj;
            String idHome = home.getId();
            for(Floor floor: floors){
                if(floor.getId().contains(idHome)){
                    result = result +"\t"+ floor.toString() + roomRepository.printInfo(floor);
                }
            }
        }
        return result;

    }

    @Override
    public String printList(Object obj) {
        Home home = (Home) obj;
        String result = "";
        for (Floor floor : floors) {
            if (floor.getId().contains(home.getId())) {
                result = result + floor.toString();

            }
        }
        return result;
    }

    @Override
    public Floor select(String obj) {
        Floor result = null;
        for (Floor floor : floors) {
            if (floor.getId().equals(obj))
                result = floor;
        }
        return result;
    }
    

    @Override
    public boolean delete(String obj) {
        return floors.removeIf(n ->n.getId().contains(obj));
 
    }

    @Override
    public boolean add(Floor obj) {
        return floors.add(obj);
    }







    @Override
    public boolean update(Floor obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }
}
