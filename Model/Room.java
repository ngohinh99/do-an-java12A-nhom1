package Model;

import Abstract.AId;

public class Room extends AId {
    private String roomWhich;
    private String roomNumber;// so phong
    private boolean emptyRoom;// trong hay khong
    private int typeRoom;// phong loai nao
    private MoneyRoom moneyRoom;

    public void setRoomWhich(String roomWhich) {
        this.roomWhich = roomWhich;
    }

    public Room(Floor floor) {
        this.id = floor.getId() + "phong";
        this.emptyRoom = true;

    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomWhich() {
        return roomWhich;
    }@Override
    public String toString() {
        return "id "+this.id+ ", phong trong " + emptyRoom + "\n";
    }

}
