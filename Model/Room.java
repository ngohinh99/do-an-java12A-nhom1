package Model;

import Abstract.AId;
import Data.Data;

public class Room extends AId {
    private String roomWhich;
    private boolean emptyRoom;// trong hay khong
    private double moneyRoom;
    private String idRoom;

    public Room(Floor floor) {
        this.id = floor.getId() + "phong";
        this.emptyRoom = true;
        this.moneyRoom = Data.moneyRoom;

    }
    public String getIdRoom() {
        return idRoom;
    }
    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public void setMoneyRoom(double moneyRoom) {
        this.moneyRoom = moneyRoom;
    }

    public void setEmptyRoom(boolean emptyRoom) {
        this.emptyRoom = emptyRoom;
    }

    public boolean isEmptyRoom() {
        return emptyRoom;
    }

    public String getRoomWhich() {
        return roomWhich;
    }@Override
    public String toString() {
        return "id "+this.idRoom+" "+ this.id+", gia tien "+this.moneyRoom+ ", phong trong " + emptyRoom + "\n";
    }
    public void setRoomWhich(String roomWhich) {
        this.roomWhich = roomWhich;
    }
}
