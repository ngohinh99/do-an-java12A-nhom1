package View;

import java.util.Scanner;

import Controller.InformationController;
import Controller.RoomController;
import Model.User;
import Util.Constants;

public class UserView {
    private Scanner sc = Constants.scanner;
    private InformationController informationController;
    private RoomController roomController;

    public UserView() {
        this.informationController = new InformationController();
        this.roomController = new RoomController();
    }

    public void display() {
        boolean isComeBack = false;
        while (true) {
            Constants.cls();
            if (isComeBack)
                break;
            if (Constants.isQuit)
                break;
            menuUserView();
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:// trang chu
                    //chua song
                    break;
                case 2://

                    break;
                case 3://
                
                    break;
                case 4://
                    isComeBack = true;
                    break;
                case 5:// trang chu
                    Constants.isQuit = true;
                    break;

                default:
                    break;
            }
        }
    }



   
    private void menuUserView() {
        System.out.println("chao mung ban den voi phong tro");
        System.out.println("1 - trang chu");
        System.out.println("2 - vi cua ban");
        System.out.println("3 - tai khoan");
        System.out.println("4 - dang suat");
        System.out.println("5 thoat");
    }

}
