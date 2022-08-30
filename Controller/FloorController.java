package Controller;

import Iterface.IHome;
import Model.Floor;
import Model.Home;
import Service.FloorService;

public class FloorController implements IHome<Floor> {
    private FloorService floorService;

    public FloorController() {
        this.floorService = new FloorService();
    }



    @Override
    public String printInfo(Object obj) {
        return floorService.printInfo(obj);
    }

    @Override
    public String printList(Object obj) {
        if (obj instanceof Home)
            return floorService.printList(obj);
        else
            return "";
    }

    @Override
    public boolean add(Floor obj) {
        return floorService.add(obj);
    }

    @Override
    public Floor select(String obj) {
        return floorService.select(obj);
    }

    @Override
    public boolean delete(String obj) {
        return floorService.delete(obj);
    }






    @Override
    public boolean update(Floor obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }
}
