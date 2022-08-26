package Model;

public class User {
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
    public boolean checkInformation(Object obj1, Object obj2){
        boolean isResult = false;
        int key = (Integer) obj2;
        switch (key) {
            case 0:
                if (this.userName.equals(obj1))
                    isResult = true;
                break;
            case 1:
                if (this.password.equals(obj1))
                    isResult = true;
                break;
            case 2:
                if (this.email.equals(obj1))
                    isResult = true;
                break;
            case 3:
                if (this.password.equals(obj1))
                    isResult = true;
                break;
            default:
                break;
        }
        return isResult;

    }

}
