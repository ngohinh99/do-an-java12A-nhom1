package Controller;

import Iterface.IHome;
import Model.Floor;
import Model.Home;
import Repository.FloorRepository;

public class FloorController implements IHome<Floor> {
    private FloorRepository floorRepository;

    public FloorController() {
        this.floorRepository = new FloorRepository();
    }



    @Override
    public String printInfo(Object obj) {
        return floorRepository.printInfo(obj);
    }

    @Override
    public String printList(Object obj) {
        if (obj instanceof Home)
            return floorRepository.printList(obj);
        else
            return "";
    }

    @Override
    public boolean add(Floor obj) {
        return floorRepository.add(obj);
    }

    @Override
    public Floor select(String obj) {
        return floorRepository.select(obj);
    }

    @Override
    public boolean delete(String obj) {
        return floorRepository.delete(obj);
    }






    @Override
    public boolean update(Floor obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }
}
