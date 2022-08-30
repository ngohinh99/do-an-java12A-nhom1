package Model;

import java.time.LocalDate;

import Abstract.AId;
import Util.Gender;

public class People extends AId{
    private String idPeople;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate birth;
    private Gender gender;
    private String placeOfOrigin;
    
    public People(String idPeople, String firstName, String lastName, String phoneNumber, String email, LocalDate birth,
            Gender gender, String placeOfOrigin) {
        this.idPeople = idPeople;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.placeOfOrigin = placeOfOrigin;
    }








}
