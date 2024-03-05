package mysql.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manage {
    private String name;
    private List<Hotels> hotels;
    private List<room_types> room_types;
    private List<Guest> guest;
    private List<Rooms> rooms;
    private List<Staff> staff;
    private List<Bookings> bookings;
    Map map=new HashMap();

    public Manage(String name)
    {
        this.name=name;
        this.hotels=new ArrayList<>();
        this.room_types=new ArrayList<>();
        this.guest=new ArrayList<>();
        this.rooms=new ArrayList<>();
        this.staff=new ArrayList<>();
        this.bookings=new ArrayList<>();
    }

    public  List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<room_types> getRoom_types() {
        return room_types;
    }

    public void setRoom_types(List<room_types> room_types) {
        this.room_types = room_types;
    }

    public List<Guest> getGuest() {
        return guest;
    }

    public void setGuest(List<Guest> guest) {
        this.guest = guest;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(List<Bookings> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "name='" + name + '\'' +
                ", hotels=" + hotels +
                '}';
    }
}
