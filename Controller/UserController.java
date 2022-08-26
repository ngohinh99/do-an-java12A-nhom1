package Controller;

import Iterface.IUsers;
import Model.User;
import Service.UserService;
import Util.Regex;

import org.json.JSONObject;

/**
 * LogInController
 */
public class UserController implements IUsers {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    public boolean addUser(Object obj) {
        /* lay thong tin tu JSON */
        boolean isResult = false;
        JSONObject user = (JSONObject) obj;
        String userName = user.getString("userName");
        String password = user.getString("password");
        String email = user.getString("email");
        String phoneNumber = user.getString("phoneNumber");

        /*
         * 0 - username
         * 1- pass
         * 2 - email
         * 3- phone
         */
        int key = 0;// kiem tra xem dieu kien co dung, dung thi cong mot
        // kiem tra ten co dung cau truc va da ton tai hay chua
        if (Regex.checkRegex(userName, 0) == true && userService.checkInUses(userName, 0) == false)
            key++;
        // passs
        if (Regex.checkRegex(password, 1))
            key++;

        // email
        if (Regex.checkRegex(email, 2) == true && userService.checkInUses(email, 2) == false)
            key++;
        // phone
        if (Regex.checkRegex(phoneNumber, 3) == true && userService.checkInUses(phoneNumber, 3) == false)
            key++;
        // neu cac dieu kien dung thi key ==4
        if (key == 4) {
            isResult = true;
            userService.addUser(new User(userName, password, email, phoneNumber));
        }
        return isResult;
    }

    @Override
    public boolean checkInUses(Object obj1, Object obj2) {
        return userService.checkInUses(obj1, obj2);
    }

    @Override
    public boolean checkInformation(Object obj1, Object obj2) {
        return userService.checkInformation(obj1, obj2);
    }

    @Override
    public String checkIsAdmin(Object obj) {
        return userService.checkIsAdmin(obj);
    }

    @Override
    public boolean update(Object obj1, Object obj2) {
        // TODO Auto-generated method stub
        return false;
    }

}