package Model;

import java.time.LocalDate;

import Util.Gender;

public class People {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate birth;
    private Gender gender;
    private PlaceOfOrigin placeOfOrigin;
    
    public People(String id, String firstName, String lastName, String phoneNumber, String email, LocalDate birth,
            Gender gender, PlaceOfOrigin placeOfOrigin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.placeOfOrigin = placeOfOrigin;
    }




}
