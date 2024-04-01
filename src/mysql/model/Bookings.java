package mysql.model;

public class Bookings {
    private int booking_id;
    private String to;
    private String from;
    private String booking_status_code;

    public Bookings(int booking_id, String to, String from, String booking_status_code) {
        this.booking_id = booking_id;
        this.to = to;
        this.from = from;
        this.booking_status_code = booking_status_code;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_status_code() {
        return booking_status_code;
    }

    public void setBooking_status_code(String booking_status_code) {
        this.booking_status_code = booking_status_code;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "booking_id=" + booking_id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", booking_status_code=" + booking_status_code +
                '}';
    }
}
