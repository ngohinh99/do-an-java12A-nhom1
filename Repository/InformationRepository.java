package Repository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Data.Data;
import Model.Information;

public class InformationRepository {
    private List<Information> informations;

    
    public InformationRepository(){
        this.informations = Data.informations;
    }


    public boolean add(String text) {
        Information information = new Information();
        information.setInformation(text);
        information.setDaySubmitted(LocalDate.now());
        return informations.add(information);
    }


    public String printInformation() {
        String result = "";
        Collections.sort(informations, new Comparator<Information>() {
            @Override
            public int compare(Information o1, Information o2){
                return o1.getDaySubmitted().isAfter(o2.getDaySubmitted())? 1:-1;
            }
        });
        if(informations.size() <= 3){
            for(Information i: informations){
                result = result + i.toString();
            }
        } else {
            for(int i = 0; i < 3; i++){
                result = result + informations.get(i).toString();
            }
        }
        return result;
    }
}
