package View;

import java.util.Scanner;

import Controller.UserController;
import Util.Constants;

public class LogInView {
    private Scanner scanner;
    private UserController userController;
    private AdminstratorView adminstratorView;
    private ForgotPasswordView forgotPasswordView;
    private UserView userView;

    public LogInView() {
        this.scanner = new Scanner(System.in);
        this.userController = new UserController();
        this.adminstratorView = new AdminstratorView();
        this.forgotPasswordView = new ForgotPasswordView();
        this.userView = new UserView();
    }

    public void LogIn() {
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
        Constants.cls();
        boolean isQuit = false;
        while (true) {
            System.out.println("nhap username: ");
            String username = scanner.nextLine();

            String text = userController.checkIsAdmin(username);
            if (text.equals("")) {// khong ton tai
                System.out.println("khong ton tai moi nhap lai");
                System.out.println("ban muon tiep tuc Y/N");
                String key = scanner.nextLine();
                if (key.toUpperCase().equals("Y"))
                    LogIn();
                break;
            } else {

                while (true) {
                    System.out.println("nhap password: ");
                    String password = scanner.nextLine();

                    if (text.equals(password)) {
                        if (username.equals("adminstrator"))
                            adminstratorView.display();
                        userView.display();
                    } else {
                        System.out.println("pass sai");
                        System.out.println("1 - dang nhap lai");
                        System.out.println("2 - quen pass");
                        System.out.println("3 - quay lai ");
                        int key = Integer.parseInt(scanner.nextLine());
                        if (key == 1)
                            LogIn();
                        if (key == 2)
                            forgotPasswordView.display();
                        if (key == 3)
                            isQuit = true;
                    }

                    if (isQuit == true)
                        break;
                }
            }
            
            if (isQuit == true)
                break;

        }
    }

}
