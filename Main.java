
import View.ManageUserView;
import View.View;

public class Main {

    public static void main(String[] args) {
        
        View view = new View();

        // try {
        //     view.display();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        ManageUserView m = new ManageUserView();
        m.display();
    }
}
