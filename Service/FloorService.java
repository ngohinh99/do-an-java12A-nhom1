package Service;


import Iterface.IHome;
import Model.Floor;
import Repository.FloorRepository;

public class FloorService implements IHome<Floor> {
    private FloorRepository floorRepository;
    public FloorService(){
        this.floorRepository = new FloorRepository();
    }

    @Override
    public String printInfo(Object obj) {
        return floorRepository.printInfo(obj);
    }
    @Override
    public String printList(Object obj) {
        return floorRepository.printList(obj);
    }
    @Override
    public boolean add(Floor obj) {
        return floorRepository.add(obj);
    }
    @Override
    public Floor select(String obj) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean delete(String obj) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public boolean update(Floor obj, String obj2) {
        // TODO Auto-generated method stub
        return false;
    }
}
