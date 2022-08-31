package Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import Model.*;

public class Data {

    public static List<User> users = new ArrayList<>();
    public static Set<Home> homes = new HashSet<>();
    public static List<Floor> floors = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Information> informations = new ArrayList<>();
    public static HashMap<String, String>  carts = new HashMap<>();
    public static double moneyRoom = 3500000;

    public static void addData() {
        User user1 = new User("nguyenvana", "1", "a@gmail.com", "phoneNumber");
        User user2 = new User("nguyenvanb", "1", "b@gmail.com", "phoneNumber");
        Home home1 = new Home("001", "so 17, dich vong hau, cau giay, ha noi", 3);
        Home home2 = new Home("002", "so 18, dich vong hau, cau giay, ha noi", 4);
        Information information1 = new Information();
        information1.setInformation("thong bao 1");
        information1.setDaySubmitted(LocalDate.now());
        informations.add(information1);
        homes.add(home1);
        homes.add(home2);
        users.add(user1);
        users.add(user2);
        addFloorRoom(home1, 3);
        addFloorRoom(home2, 4);
        System.out.println(users.size());
        System.out.println(user1.toString());

    }

    private static void addFloorRoom(Home home, int romNumberOnFloor) {
        for (int i = 1; i <= romNumberOnFloor; i++) {
            Floor floor = new Floor(home, romNumberOnFloor);
            floor.setId(String.valueOf(i));// id
            floor.setFloorWhich(i);// tang mays
            floors.add(floor);
            for (int y = 1; y <= floor.getRoomNumber(); y++) {
                Room room = new Room(floor);
                room.setId(String.valueOf(y));
                room.setRoomWhich(String.valueOf(y));
                rooms.add(room);
                String idRoom = String.valueOf((int) (10000 * Math.random()));
                room.setIdRoom(idRoom);

            }
        }
    }

}
