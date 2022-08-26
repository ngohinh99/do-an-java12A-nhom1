package Util;

import java.util.regex.Pattern;

public class Regex {
    /*
     * 0 - username
     * 1- pass
     * 2 - email
     * 3- phone
     */
    public static boolean checkRegex(String obj, int key){
        String USERNAME = "Adminstrator";
        String PASSWPRD = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).{7,15}$";
        String EMAIL = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String PHONENUMBER = "^([0][\\d]{9})|([+][8][4][\\d]{9})$";
        boolean result = false;

        switch (key) {
            case 0:
            result = obj.equals(USERNAME)? false: true;
                break;
            case 1:
             result = Pattern.matches(PASSWPRD, obj);
                break;
            case 2:
            result = Pattern.matches(EMAIL, obj);
                break;
            case 3:
            result = Pattern.matches(PHONENUMBER, obj);
                break;
        
            default:
                break;
        }
        
        return result;
    }

}
