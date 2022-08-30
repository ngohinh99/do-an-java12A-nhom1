package Controller;

import org.json.JSONObject;

import Iterface.IHome;
import Model.Floor;
import Model.Home;
import Model.Room;
import Service.HomeService;

public class HomeController implements IHome<Home> {
    private HomeService homeService;
    private FloorController floorController;
    private RoomController roomController;

    public HomeController() {
        this.homeService = new HomeService();
        this.floorController = new FloorController();
        this.roomController = new RoomController();
    }

    @Override
    public String toString() {
        return homeService.toString();
    }



    @Override
    public String printInfo(Object obj) {
            return homeService.printInfo(obj) ;
    }

    @Override
    public boolean add(Home obj) {
        return homeService.add(obj);
    }

    @Override
    public String printList(Object obj) {
        return null;
    }

    @Override
    public Home select(String obj) {
        return homeService.select(obj);
    }

    @Override
    public boolean delete(String obj) {
        homeService.delete(obj);
        floorController.delete(obj);
        roomController.delete(obj);
        return true;
    }
    public boolean addHome(JSONObject jsonObject){
        boolean result = false;
        JSONObject home = (JSONObject) jsonObject;
        String idHome = home.getString("idHome");
        String placeOfOrigin = home.getString("placeOfOrigin");
        int floorNumber = home.getInt("floorNumber");
        int roomNumber = home.getInt("roomNumber");

        Home home1 = new Home(idHome, placeOfOrigin,floorNumber);
        if (add(home1)) {
            for (int i = 1; i <= floorNumber; i++) {
                Floor floor = new Floor(home1,roomNumber);
                floor.setId(String.valueOf(i));// id
                floor.setFloorWhich(i);// tang mays
                floorController.add(floor);
                for (int y = 1; y <= floor.getRoomNumber(); y++) {
                    Room room = new Room(floor);
                    room.setId(String.valueOf(y));
                    room.setRoomWhich(String.valueOf(y));
                    roomController.add(room);
                    result = true;
                }
            }

        }

        return result;
    }



    @Override
    public boolean update(Home obj, String obj2) {
        return homeService.update(obj, obj2);
    }
}
