package mysql.Models;

public class Rooms {
    private int room_number;
    private int room_floor;

    private String smoking;
    private String room_type;
    private int room_id;
    private int room_price;
    private int available;

    public Rooms(int room_id, int room_floor, int room_number, String room_type, String smoking, int available, int room_price) {
        this.room_id = room_id;
        this.room_floor = room_floor;
        this.room_number = room_number;
        this.room_price = room_price;
        this.room_type = room_type;
        this.smoking = smoking;
        this.available = available;

    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "room_id=" + room_id +
                ", room_number=" + room_number +
                ", room_floor=" + room_floor +
                ", room_price='" + room_price + '\'' +
                ", room_type='" + room_type + '\'' +
                ", smoking=" + smoking
                + "\n";
    }
}
