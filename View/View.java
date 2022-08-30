package View;

import java.util.Scanner;

import Controller.UserController;
import Util.Constants;

/**
 * View
 */
public class View {
    private Scanner sc = Constants.scanner;
    private UserController userController;
    private AdminstratorView adminstratorView;
    private UserView userView;
    private ManageUserView manageUserView;

    public View() {
        this.userController = new UserController();
        this.adminstratorView = new AdminstratorView();
        this.userView = new UserView();
        this.manageUserView = new ManageUserView();
    }

    public void display() {

        while (true) {
            if (Constants.isQuit())
                break;
            Constants.cls();
            menuDisplay();
            System.out.println("hay chon:");
            int key = Integer.parseInt(sc.nextLine());
            /*
             * 1- dang nhap
             * 2- dang ky
             * 3 -thoat
             */
            switch (key) {
                case 1:// dang nhap
                    LogIn();
                    break;
                case 2:// dang ki == tao moi mot tai khoan
                    manageUserView.addUser();
                    break;
                case 3:// thoat
                    Constants.isQuit = true;
                    break;

                default:
                    break;
            }
        }

    }

    private void LogIn() {

        /*
         * nhap user name neu khong co thi nhap lai or thoat
         * nhap pass
         * ---neu la tai khoan a adminstrator thi vao adminstratorView
         * ---neu la tai khoan user thi vao userView
         * - -nhap sai thi
         * ------1 - dang nhap lai
         * ------2 - quen pass
         * ------3 - that ra man hinh View
         */
        boolean isComeBack = false;
        while (true) {
            Constants.cls();
            if (isComeBack)
                break;

            if (Constants.isQuit)
                break;
            System.out.println("nhap username: ");
            String username = sc.nextLine();

            String text = userController.checkIsAdmin(username);
            if (text.equals("")) {// khong ton tai
                System.out.println("khong ton tai moi nhap lai");
                if (Constants.continueYN())
                    LogIn();
                break;
            } else {

                while (true) {

                    System.out.println("nhap password: ");
                    String password = sc.nextLine();

                    if (text.equals(password)) {
                        if (username.equals("adminstrator"))
                            try {
                                adminstratorView.display();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        else
                            try {
                                userView.display();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                    } else
                        try {
                            wrongPassword();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }

    private void wrongPassword() {

        while (true) {
            Constants.cls();
            if (Constants.isQuit)
                break;

            System.out.println("pass sai");
            System.out.println("1 - dang nhap lai");
            System.out.println("2 - quen pass");
            System.out.println("3 - quay lai");
            System.out.println("4 - thoat ");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    LogIn();
                    break;
                case 2:
                    forgotPassword();

                    break;
                case 3:
                    display();
                    break;
                case 4:
                    Constants.isQuit = true;
                    break;
                default:
                    break;
            }

        }

    }

    private void forgotPassword() {

        while (true) {
            Constants.cls();
            System.out.println("lay lai pass");
            System.out.println("nhap username");
            String username = sc.nextLine();
            if (userController.checkInUses(username, "username")) {
                System.out.println("nhap email/phoneNumber da dang ky");
                String emailOrPhoneNumber = sc.nextLine();

                if (userController.checkInformation(emailOrPhoneNumber, "emailOrPhoneNumber")) {
                    System.out.println("pass  cau truc 7-15 ky tu, co 1 in hoa, 1 ky tu dac biet");
                    System.out.println("nhap password moi");
                    String password = sc.nextLine();
                    if (userController.update(password, "password"))
                        break;

                } else {
                    System.out.println("email/phone khong dung");
                }
            } else
                System.out.println("user khong co trong he thong");

        }
    }

    private void menuDisplay() {
        System.out.println("xin chao den voi phong tro!!");
        System.out.println("1 - dang nhap");
        System.out.println("2 - dang ky");
        System.out.println("3 - thoat");
    }

}