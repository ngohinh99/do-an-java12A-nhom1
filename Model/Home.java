package Model;

import Abstract.AId;

public  class Home extends AId {
    private String idHome;
    private String placeOfOrigin;// dia chi
    private int floorNumber;//so tang
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }
    public Home(String idHome,String placeOfOrigin,int floorNumber) {
        this.idHome = idHome;
        this.placeOfOrigin = placeOfOrigin;
        this.id = "home"+ this.idHome;
        this.floorNumber = floorNumber;

    }


    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return "id "+this.id+ ", dia chi: " + placeOfOrigin+ "\n";
    }
}
