package Model;

import java.time.LocalDate;

import Abstract.AId;
import Util.Gender;

public class People extends AId{
    private String idPeople;
    private String name;
    private LocalDate birth;
    private Gender gender;
    private String placeOfOrigin;

    public People(String idPeople, String name, LocalDate birth, Gender gender, String placeOfOrigin) {
        this.idPeople = idPeople;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.placeOfOrigin = placeOfOrigin;
    }

    
    









}
