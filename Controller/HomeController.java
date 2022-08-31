package Controller;

import org.json.JSONObject;

import Iterface.IHome;
import Model.Floor;
import Model.Home;
import Model.Room;
import Repository.HomeRepository;

public class HomeController implements IHome<Home> {
    private HomeRepository homeRepository;
    private FloorController floorController;
    private RoomController roomController;

    public HomeController() {
        this.homeRepository = new HomeRepository();
        this.floorController = new FloorController();
        this.roomController = new RoomController();
    }

    @Override
    public String toString() {
        return homeRepository.toString();
    }

    @Override
    public String printInfo(Object obj) {
        return homeRepository.printInfo(obj);
    }

    @Override
    public boolean add(Home obj) {
        return homeRepository.add(obj);
    }

    @Override
    public String printList(Object obj) {
        return null;
    }

    @Override
    public Home select(String obj) {
        return homeRepository.select(obj);
    }

    @Override
    public boolean delete(String obj) {
        homeRepository.delete(obj);
        floorController.delete(obj);
        roomController.delete(obj);
        return true;
    }

    public boolean addHome(JSONObject jsonObject) {
        boolean result = false;
        JSONObject home = (JSONObject) jsonObject;
        String idHome = home.getString("idHome");
        String placeOfOrigin = home.getString("placeOfOrigin");
        int floorNumber = home.getInt("floorNumber");
        int roomNumber = home.getInt("roomNumber");

        Home home1 = new Home(idHome, placeOfOrigin, floorNumber);
        if (add(home1)) {
            for (int i = 1; i <= floorNumber; i++) {
                Floor floor = new Floor(home1, roomNumber);
                floor.setId(String.valueOf(i));// id
                floor.setFloorWhich(i);// tang mays
                floorController.add(floor);
                for (int y = 1; y <= floor.getRoomNumber(); y++) {
                    Room room = new Room(floor);
                    room.setId(String.valueOf(y));
                    room.setRoomWhich(String.valueOf(y));
                    roomController.add(room);
                    while (true) {
                        String idRoom = String.valueOf((int) (10000 * Math.random()));
                        if (roomController.searchInRooms(idRoom, " ")) {
                        } else {
                            room.setIdRoom(idRoom);
                            break;
                        }

                    }
                    result = true;
                }
            }

        }

        return result;
    }

    @Override
    public boolean update(Home obj, String obj2) {
        return homeRepository.update(obj, obj2);
    }
}
