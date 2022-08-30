package Util;

import java.util.regex.Pattern;

public class Regex {
    /*
     * 0 - username
     * 1- pass
     * 2 - email
     * 3- phone
     */
    public static boolean checkRegex(String obj, String obj2){
    
        String key = (String) obj2;
        String USERNAME = "Adminstrator";
        String PASSWPRD = "^(?=.*[A-Z])(?=.*[@#$%^&+=]).{7,15}$";
        String EMAIL = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String PHONENUMBER = "^([0][\\d]{9})|([+][8][4][\\d]{9})$";
        boolean result = false;

        switch (key) {
            case "username":
            result = obj.equals(USERNAME)? false: true;
                break;
            case "password":
             result = Pattern.matches(PASSWPRD, obj);
                break;
            case "email":
            result = Pattern.matches(EMAIL, obj);
                break;
            case "phoneNumber":
            result = Pattern.matches(PHONENUMBER, obj);
                break;
        
            default:
                break;
        }
        
        return result;
    }

}
