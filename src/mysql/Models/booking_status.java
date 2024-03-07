package mysql.Models;

public class booking_status {
    private int booking_status_code;
    private String booking_status_description;

    public booking_status(int booking_status_code, String booking_status_description) {
        this.booking_status_description = booking_status_description;
        this.booking_status_code = booking_status_code;
    }

    public int getBooking_status_code() {
        return booking_status_code;
    }

    public void setBooking_status_code(int booking_status_code) {
        this.booking_status_code = booking_status_code;
    }

    public String getBooking_status_description() {
        return booking_status_description;
    }

    public void setBooking_status_description(String booking_status_description) {
        this.booking_status_description = booking_status_description;
    }

    @Override
    public String toString() {
        return "booking_status{" +
                "booking_status_code=" + booking_status_code +
                ", booking_status_description='" + booking_status_description + '\'' +
                '}';
    }
}
