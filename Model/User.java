package Model;

import Abstract.AId;

public class User extends AId {
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    
    public User(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public boolean checkInformation(Object obj1, String obj2){
        boolean isResult = false;
        switch (obj2) {
            case "username":
                if (this.userName.equals(obj1))
                    isResult = true;
                break;
            case "password":
                if (this.password.equals(obj1))
                    isResult = true;
                break;
            case "email":
                if (this.email.equals(obj1))
                    isResult = true;
                break;
            case"phoneNumber":
                if (this.password.equals(obj1))
                    isResult = true;
                break;
            default:
                break;
        }
        return isResult;

    }



}
