package View;

import java.util.Scanner;

import org.json.JSONObject;

import Controller.UserController;
import Util.Constants;

public class ManageUserView {
    private Scanner sc = Constants.scanner;
    private UserController userController;

    public ManageUserView() {
        this.userController = new UserController();
    }

    public void display() {
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
