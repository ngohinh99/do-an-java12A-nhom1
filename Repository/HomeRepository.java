package Repository;


import java.util.Set;

import Data.Data;
import Iterface.IHome;
import Model.Home;

public class HomeRepository implements IHome<Home> {
    private Set<Home> homes;
    private FloorRepository floorRepository;

    public HomeRepository() {
        this.homes = Data.homes;
        this.floorRepository = new FloorRepository();
    }

    @Override
    public String toString() {
        String result = "";
        int index = 1;
        for (Home home : homes) {
            result = result + "home " + index + " " + home.toString();
            index++;
        }

        return result;
    }


    @Override
    public String printInfo(Object obj) {
        String result = "";
        if(obj instanceof Home){
            Home home = (Home) obj;
            result = home.toString() + floorRepository.printInfo(obj);
        }
        return result;
    }

    @Override
    public boolean add(Home obj) {
        Home addHome = (Home) obj;
        return homes.add(addHome);
    }

    @Override
    public String printList(Object obj) {
        return null;
    }

    @Override
    public Home select(String obj) {
        Home result = null;
        for (Home ho : homes) {
            if (ho.getId().contains(obj)) {
                result = ho;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String obj) {
        return homes.removeIf(n ->n.getId().contains(obj));
    }


    @Override
    public boolean update(Home obj, String obj2) {
        obj.setPlaceOfOrigin(obj2);
        return true;
    }




}
