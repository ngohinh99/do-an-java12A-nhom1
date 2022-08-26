package View;

import java.util.Scanner;
import Util.Constants;

/**
 * View
 */
public class View {
    private Scanner sc = Constants.scanner;
    public static boolean isQuit = false;
    private LogInView logInView;
    private RegisterView registerView;

    public View() {
        // this.scanner = new Scanner(System.in);
        this.logInView = new LogInView();
        this.registerView = new RegisterView();
    }

    public void display() {

        while (true) {
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
                    logInView.LogIn();
                    break;
                case 2:// dang ki
                    registerView.register();
                    break;
                case 3:// thoat
                isQuit = true;
                    break;

                default:
                    break;
            }
            if (isQuit == true)
                break;
        }

    }

    private void menuDisplay() {
        System.out.println("xin chao den voi phong tro!!");
        System.out.println("1 - dang nhap");
        System.out.println("2 - quen mat khau");
        System.out.println("3 - thoat");
    }

}