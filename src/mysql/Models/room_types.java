package mysql.Models;

public class room_types {

    private int room_standard_price;
    private String room_description;

    public room_types(int room_standard_price,String room_description)
    {

        this.room_standard_price=room_standard_price;
        this.room_description=room_description;

    }
    public int getRoom_standard_price() {
        return room_standard_price;
    }

    public void setRoom_standard_price(int room_standard_price) {
        this.room_standard_price = room_standard_price;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    @Override
    public String toString() {
        return "room_standard_price=" + room_standard_price +
                ", room_description='" + room_description +"\n";
    }
}
