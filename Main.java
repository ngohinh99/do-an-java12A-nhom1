
import java.util.List;

import Data.Data;
import Repository.RoomRepository;
import View.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();

        Data.addData();
        try {
        view.display();
        } catch (Exception e) {
        e.printStackTrace();
        }
        // ManageHomeView m = new ManageHomeView();
        // m.display();




    }
}
