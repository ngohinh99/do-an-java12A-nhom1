package View;

import java.util.Scanner;

import org.json.JSONObject;

import Controller.HomeController;

import Model.Home;
import Util.Constants;

public class ManageHomeView {
    private Scanner sc;
    private HomeController homeController;

    public ManageHomeView() {
        this.sc = Constants.scanner;
        this.homeController = new HomeController();

    }

    public void display() {
        boolean isComeBack = false;
        while (true) {
            Constants.cls();
            if (Constants.isQuit)
                break;
            if (isComeBack)
                break;
            System.out.println("quan ly home");
            showHomes();
            menuManageHome();
            System.out.println("moi ban chon");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 0:
                    information();
                    break;
                case 1:// add home
                    add();// chua kiem tra trong list co hay chua, van them vao
                    break;
                case 2:
                    update();//chua song
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    isComeBack = true;
                    break;
                case 6:
                    Constants.isQuit = true;
                    break;

                default:
                    break;
            }
        }
    }

    private void information() {
        showHomes();
        System.out.println("ban hay chon id muon xem");
        String key = sc.nextLine();
        Home home = (Home) homeController.select(key);
        InforHome(home);
        if (Constants.continueYN())
            information();

    }

    private void menuManageHome() {
        System.out.println("0 - thong tin ");
        System.out.println("1 - add ");
        System.out.println("2 - update ");
        System.out.println("4 - delete ");
        System.out.println("5 - quay lai");
        System.out.println("6 - thoat");
    }

    private void delete() {
        Constants.cls();
        showHomes();
        System.out.println("nhap id ban muon xoa");
        String id = sc.nextLine();
        homeController.delete(id);

    }

    private void update() {
        Constants.cls();
        showHomes();
        System.out.println("nhap id muon chinh sua");
        String id = sc.nextLine();
        Home home = (Home) homeController.select(id);
        InforHome(home);
        System.out.println("ban muon thay doi thong tin gi");
        System.out.println("1 - thay doi home");
        System.out.println("2 - thay doi floor");
        System.out.println("3 - thay doi room");
        System.out.println("4 - quay lai");
        System.out.println("5 - thoat");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                updateHome(home);
                break;
            case 2:
                updateFloor(home);
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

            default:
                break;
        }
    }

    private void updateFloor(Home home) {
        System.out.println("ban ");
    }

    private void updateHome(Home home) {
        Constants.cls();
        InforHome(home);
        System.out.println(" 1 - ban muon thay doi dia chi");
        
        String placeOfOrigin = sc.nextLine();
        if (homeController.update(home, placeOfOrigin)) {
            System.out.println("thay doi thanh cong");
            InforHome(home);
        } else
            System.out.println("thay doi that bai");
        if (Constants.continueYN())
            updateHome(home);

    }

    private void add() {
        Constants.cls();
        System.out.println("them moi home moi");
        System.out.println("home gom id, dia chi, so tang");
        System.out.println("hay nhap id");
        String idHome = sc.nextLine();
        System.out.println("hay nhap dia chi");
        String placeOfOrigin = sc.nextLine();
        System.out.println("nhap so tang may tang");
        int floorNumber = Integer.parseInt(sc.nextLine());
        System.out.println("nhap so phong moi tang");
        int roomNumber = Integer.parseInt(sc.nextLine());

        JSONObject addHome = new JSONObject();
        addHome.put("idHome", idHome);
        addHome.put("placeOfOrigin", placeOfOrigin);
        addHome.put("floorNumber", floorNumber);
        addHome.put("roomNumber", roomNumber);
        if (homeController.addHome(addHome)) {
            System.out.println("them thanh cong");
            Home home = (Home) homeController.select(idHome);
            InforHome(home);

        } else
            System.out.println("them khong thanh cong");

        if (Constants.continueYN())
            add();

    }

    private void InforHome(Home home) {
        System.out.println(homeController.printInfo(home));
    }

    private void showHomes() {
        Constants.cls();
        String text = homeController.toString();
        if (text == "")
            System.out.println("loi");
        else
            System.out.println(text);
    }


}
