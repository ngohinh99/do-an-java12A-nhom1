package View;

import java.util.Scanner;

import org.json.JSONObject;

import Controller.*;
import Model.Home;
import Util.Constants;

public class AdminstratorView {
    private Scanner sc = Constants.scanner;
    private InformationController informationController;
    private HomeController homeController;
    private UserController userController;

    public AdminstratorView() {
        this.informationController = new InformationController();
        this.homeController = new HomeController();
        this.userController = new UserController();

    }

    public void displayAdminstratorView() {
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
                case 0:
                    moreInformation();
                    break;
                case 1:// quan ly nguoi thue

                    break;
                case 2:// quan ly users
                    displayMangerUserview();
                    break;
                case 3:// quan ly phong tro
                    displayManagetHomeView();
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

    private void moreInformation() {
        Constants.cls();
        System.out.println("hay nhap thong tin can thong bao");
        String text = sc.nextLine();
        if (informationController.add(text))
            System.out.println("them thanh cong");
        if (Constants.continueYN())
            moreInformation();

    }

    private void menuAdminstratorView() {
        System.out.println("xin chao adminstrator");
        System.out.println("ban muon lam gi");
        System.out.println("0 - thong tin phong tro");
        System.out.println("1 - quan ly nguoi thue");
        System.out.println("2 - quan ly users ");
        System.out.println("3 - quan ly phong tro");
        System.out.println("4 - dang suat");
        System.out.println("5 - thoat");

    }

    private void displayManagetHomeView() {
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
                    informationHome();
                    break;
                case 1:// add home
                    add();// chua kiem tra trong list co hay chua, van them vao
                    break;
                case 2:
                    update();// chua song
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

    private void informationHome() {
        showHomes();
        System.out.println("ban hay chon id muon xem");
        String key = sc.nextLine();
        Home home = (Home) homeController.select(key);
        InforHome(home);
        if (Constants.continueYN())
            informationHome();

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

    private void displayMangerUserview() {
        /*
         * 1 them user
         * 2- thay doi thong tin
         * 3 - xoa user
         * 4- quay lai
         * 5 thoat
         */
        Boolean isComeBank = false;

        while (true) {
            Constants.cls();
            if (Constants.isQuit)
                break;
            if (isComeBank)
                break;
            menuManageUserView();
            System.out.println("hay nhap vao day");
            int key = Integer.parseInt(sc.nextLine());

            switch (key) {
                case 1:// them user
                    addUser();
                    break;
                case 2:// thay doi thong tin
                    updateUser();
                    break;
                case 3:// xoa user

                    break;
                case 4:// quay lai
                    isComeBank = true;
                    break;
                case 5:// thoat
                    Constants.isQuit = true;
                    break;

                default:
                    break;
            }
        }

    }

    private void updateUser() {
        Constants.cls();
        /*
         * 
         */
    }

    public void addUser() {
        /*
         * nhap tu ban phim cac thong tin
         */
        Constants.cls();
        System.out.println("tao moi tai khoan");
        System.out.println("nhap userName: ");
        String userName = sc.nextLine();
        System.out.println("nhap pass:(1- in hoa, 1 - ki tu dac biet, 7-15 ki tu) ");
        String password = sc.nextLine();
        System.out.println("nhap email: ");
        String email = sc.nextLine();
        System.out.println("nhap sdt: ");
        String phoneNumber = sc.nextLine();
        /*
         * tao JSON va ep cac thong tin vao JSON
         */
        JSONObject user = new JSONObject();
        user.put("userName", userName);
        user.put("password", password);
        user.put("email", email);
        user.put("phoneNumber", phoneNumber);
        /*
         * thong bao them thanh cong
         */
        if (userController.addUser(user))
            System.out.println("ban da them thanh cong");
        else
            System.out.println("them khong thanh cong ");
        // can them thong bao loi gi

        if (Constants.continueYN())
            addUser();

    }

    private void menuManageUserView() {
        System.out.println("xin chao den voi quan ly user");
        System.out.println("ban muon lam gi");
        System.out.println("1 - them moi user");
        System.out.println("2 - chinh sua thong tin");
        System.out.println("3 - xoa user");
        System.out.println("4 - quay lai muc luc dau");
        System.out.println("5 - thoat");
    }
}
