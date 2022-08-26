package Service;

import Iterface.IUsers;
import Repository.UserRepository;

public class UserService implements IUsers{
    private UserRepository userRepository;
    public UserService(){
        this.userRepository = new UserRepository();
    }

    @Override
    public boolean addUser(Object obj) {
        
        return userRepository.addUser(obj);
    }

    @Override
    public boolean checkInUses(Object obj1, Object obj2) {
        return userRepository.checkInUses(obj1, obj2);
    }

    @Override
    public boolean checkInformation(Object obj1, Object obj2) {
        return userRepository.checkInformation(obj1, obj2);
    }

    @Override
    public String checkIsAdmin(Object obj) {
        return userRepository.checkIsAdmin(obj);
    }

    @Override
    public boolean update(Object obj1, Object obj2) {
        
        return userRepository.update(obj1, obj2);
    }
    
}
