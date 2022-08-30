package Util;

import java.util.Scanner;

import Model.User;

public class Constants {
    public static final User adminstrator = new User("adminstrator", "admin", "", "");
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isQuit = false;

    public static void cls() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean isQuit() {
        if (isQuit)
            scanner.close();
        return isQuit;

    }
    public static boolean continueYN() {
        boolean isContine = false;
        System.out.println("ban co muon tiep tuc Y/N");
        String key = scanner.nextLine();
        if (key.toUpperCase().equals("Y"))
            isContine = true;
        return isContine;
    }
    
}
