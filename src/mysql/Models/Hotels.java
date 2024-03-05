package mysql.Models;

public class Hotels {
    private String hotel_name;
    private String hotel_address;
    private int stars;
    public Hotels(String hotel_name,String hotel_address,int stars)
    {
 this.hotel_name=hotel_name;
 this.hotel_address=hotel_address;
 this.stars=stars;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    @Override
    public String toString() {
        return
                "hotel_name='" + hotel_name + '\'' +
                ", hotel_address='" + hotel_address + '\'' +
                ", stars=" + stars +
                "\n";
    }
}
