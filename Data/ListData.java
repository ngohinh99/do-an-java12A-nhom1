package Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import Model.Floor;
import Model.Home;
import Model.Room;
import Model.User;

public class ListData {

    public static List<User> users = new ArrayList<>();
    public static Set<Home> homes = new HashSet<>();
    public static List<Floor> floors = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    
    public static void addData(){
        User user = new User("userName", "password", "email", "phoneNumber");
        Home home1 = new Home("001","so 17, dich vong hau, cau giay, ha noi",3);
        Home home2 = new Home("002","so 18, dich vong hau, cau giay, ha noi",4);
        homes.add(home1);
        homes.add(home2);
        users.add(user);
        addFloorRoom(home1, 3);
        addFloorRoom(home2, 4);


    }
    private static void addFloorRoom(Home home, int romNumberOnFloor){
        for (int i = 1; i <= romNumberOnFloor; i++) {
            Floor floor = new Floor(home,romNumberOnFloor);
            floor.setId(String.valueOf(i));// id
            floor.setFloorWhich(i);// tang mays
            floors.add(floor);
            for (int y = 1; y <= floor.getRoomNumber(); y++) {
                Room room = new Room(floor);
                room.setId(String.valueOf(y));
                room.setRoomWhich(String.valueOf(y));
                rooms.add(room);
            }
        }
    }



}
