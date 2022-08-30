package Service;


import Iterface.IHome;
import Model.Home;
import Repository.HomeRepository;

public class HomeService implements IHome<Home> {
    private HomeRepository homeRepository;

    public HomeService(){
        this.homeRepository = new HomeRepository();
    }
    @Override
    public String toString(){
        return homeRepository.toString();
    }

    @Override
    public String printInfo(Object obj) {
        return homeRepository.printInfo(obj);
    }
    @Override
    public boolean add(Home obj) {
        return homeRepository.add(obj);
    }
    @Override
    public String printList(Object obj) {
        return null;
    }
    @Override
    public Home select(String obj) {
        return homeRepository.select(obj);
    }
    @Override
    public boolean delete(String obj) {
        return homeRepository.delete(obj);
    }

    @Override
    public boolean update(Home obj, String obj2) {
        return homeRepository.update(obj, obj2);
    }



}
