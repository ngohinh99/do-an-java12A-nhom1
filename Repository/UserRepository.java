package Repository;

import java.util.List;
import Data.Data;
import Model.User;
import Util.Constants;
import Iterface.IUsers;

public class UserRepository implements IUsers<User> {
    private User admin = Constants.adminstrator;
    private User user;
    private List<User> users;

    public UserRepository() {
        this.user = null;
        this.users = Data.users;
    }

    /*
     * 0 - nhap lai username
     * 1- la admin nguoi quan ly
     * 2 - user nguoi dungf
     */

    @Override
    public boolean addUser(Object obj) {
        boolean isResult = false;
        User us = (User) obj;
        if (isResult == false) {
            users.add(us);
            isResult = true;
        }
        return isResult;
    }

    @Override
    public boolean searchInUser(String obj1, String obj2) {
        /*
         * 0 - username
         * 1- pass
         * 2 - email
         * 3- phone
         */
        boolean isResult = false;
        if (admin.getUserName().equals(obj1)) {
            return isResult;
        } else {
            switch (obj2) {
                case "username":
                    for (User us : users) {
                        if (us.getUserName().equals(obj1)){
                            user = us;
                            isResult = true;
                        }      
                    }
                    break;
                case "password":
                    isResult = true;
                    break;
                case "email":
                    for (User us : users) {
                         if(us.getEmail().equals(obj1))isResult = true;
                    }
                    break;
                case "phoneNumber":
                    for (User us : users) {
                        if(us.getPhoneNumber().equals(obj1))isResult = true;
                    }
                    break;

                default:
                    break;
            }
        }

        return isResult;
    }

    @Override
    public boolean checkInformation(Object obj1, String obj2) {
        return user.checkInformation(obj1, obj2);
    }

    @Override
    public boolean update(Object obj1, String obj2) {
        return false;
    }

    @Override
    public User select(String obj) {
        User result = null;
        if (admin.getUserName().equals(obj)) {
            result = admin;
        } else if (searchInUser(obj, "username")) {
            result = user;
        }
        return result;
    }

}
