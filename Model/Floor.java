package Model;

import Abstract.AId;

public class Floor extends AId {
    private int floorWhich;
    private int roomNumber;//may phong

    public Floor(Home home, int roomNumber) {
    this.id = home.getId() + "tang";
    this.roomNumber = roomNumber;
    }

    public void setFloorWhich(int floorWhich) {
        this.floorWhich = floorWhich;
    }

    public int getFloorWhich() {
        return floorWhich;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    @Override
    public String toString() {
        return "id "+this.id  + ", so phong=" + roomNumber + "\n";
    }

}
