
import java.util.List;

import Data.ListData;
import Repository.RoomRepository;
import View.ManageHomeView;
import View.ManageUserView;
import View.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();

        ListData.addData();
        try {
        view.display();
        } catch (Exception e) {
        e.printStackTrace();
        }
        // ManageHomeView m = new ManageHomeView();
        // m.display();




    }
}
