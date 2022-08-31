package Controller;

import Iterface.IUsers;
import Model.User;
import Repository.UserRepository;
import Util.Regex;

import org.json.JSONObject;

/**
 * LogInController
 */
public class UserController implements IUsers<User> {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
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
        if (Regex.checkRegex(userName, "username") && userRepository.searchInUser(userName, "username") == false)
            key++;
        // passs
        if (Regex.checkRegex(password, "password"))
            key++;

        // email
        if (Regex.checkRegex(email, "email") && userRepository.searchInUser(email, "email") == false)
            key++;
        // phone
        if (Regex.checkRegex(phoneNumber, "phoneNumber")
                && userRepository.searchInUser(phoneNumber, "phoneNumber") == false)
            key++;
        // neu cac dieu kien dung thi key ==4
        if (key == 4) {
            isResult = true;
            userRepository.addUser(new User(userName, password, email, phoneNumber));
        }
        return isResult;
    }

    @Override
    public boolean searchInUser(String obj1, String obj2) {

        // viet vao day
        return userRepository.searchInUser(obj1, obj2);
    }

    @Override
    public boolean checkInformation(Object obj1, String obj2) {
        String obj = (String) obj1;
        boolean isResult = false;
        switch (obj2) {
            case "username":
                if (Regex.checkRegex(obj, "username"))
                    isResult = userRepository.checkInformation(obj, "username");

                break;
            case "password":
                if (Regex.checkRegex(obj, "password"))
                    isResult = userRepository.checkInformation(obj, "password");
                break;
            case "email":
                if (Regex.checkRegex(obj, "email"))
                    isResult = userRepository.checkInformation(obj, "email");
                break;
            case "phoneNumber":
                if (Regex.checkRegex(obj, "phoneNumber"))
                    isResult = userRepository.checkInformation(obj, "phoneNumber");
                break;

            default:
                break;
        }
        return isResult;
    }


    @Override
    public boolean update(Object obj1, String obj2) {
        return false;
    }

    @Override
    public User select(String obj) {
        return userRepository.select(obj);
    }

}