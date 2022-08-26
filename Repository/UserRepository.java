package Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Model.User;
import Util.Constants;
import Iterface.IUsers;

public class UserRepository implements IUsers {
    private User admin = Constants.adminstrator;
    private User user;
    private static List<User> users = new ArrayList<>(
            Arrays.asList(new User("userName", "password", "email", "phoneNumber")));

    public UserRepository() {
        this.user = null;
    }

    /*
     * 0 - nhap lai username
     * 1- la admin nguoi quan ly
     * 2 - user nguoi dungf
     */
    public String checkIsAdmin(Object obj) {
        String result = "";
        if (admin.getUserName().equals(obj)) {
            result = admin.getPassword();
        } else if (checkInUses(obj, 0)) {
            result = user.getUserName();
        }
        return result;
    }

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
    public boolean checkInUses(Object obj1, Object obj2) {
        /*
         * 0 - username
         * 1- pass
         * 2 - email
         * 3- phone
         */
        int key = (Integer) obj2;
        boolean isResult = false;
        if (admin.equals(obj1)) {
            return isResult;
        } else {
            switch (key) {
                case 0:
                    for (User us : users) {
                        isResult = us.getUserName().equals(obj1);
                        if (isResult == true)
                            user = us;
                    }
                    break;
                case 1:
                    isResult = true;
                    break;
                case 2:
                    for (User us : users) {
                        isResult = us.getEmail().equals(obj1);
                    }
                    break;
                case 3:
                    for (User us : users) {
                        isResult = us.getPhoneNumber().equals(obj1);
                    }
                    break;

                default:
                    break;
            }
        }

        return isResult;
    }

    @Override
    public boolean checkInformation(Object obj1, Object obj2) {
        return user.checkInformation(obj1, obj2);
    }

    @Override
    public boolean update(Object obj1, Object obj2) {
        // TODO Auto-generated method stub
        return false;
    }



}
