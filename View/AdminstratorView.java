package View;

import java.util.Scanner;

import Util.Constants;

public class AdminstratorView {
    private Scanner sc = Constants.scanner;
    private ManageUserView manageUserView;
    private ManageHomeView manageHomeView;

    public AdminstratorView() {
        this.manageUserView = new ManageUserView();
        this.manageHomeView = new ManageHomeView();

    }

    public void display() {
        /*
         * 1- quan ly nguo thue
         * 2- quan ly user
         * 3- quan ly phong tro
         * 
         */
        Boolean isComeBack = false;

        while (true) {
            Constants.cls();
            if (Constants.isQuit)
                break;
            if (isComeBack)
                break;
            menuAdminstratorView();

            System.out.println("hay chon nao: ");
            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1:// quan ly nguoi thue

                    break;
                case 2:// quan ly users
                    manageUserView.display();
                    break;
                case 3:
                    manageHomeView.display();
                    break;
                case 4:
                    isComeBack = true;
                    break;
                case 5:
                    Constants.isQuit = true;
                    break;

                default:
                    break;
            }

        }
    }

    private void menuAdminstratorView() {
        System.out.println("xin chao adminstrator");
        System.out.println("ban muon lam gi");
        System.out.println("1 - quan ly nguoi thue");
        System.out.println("2 - quan ly users ");
        System.out.println("3 - quan ly phong tro");
        System.out.println("4 - dang suat");
        System.out.println("5 - thoat");
    }

}
