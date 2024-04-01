package mysql.controller;

import mysql.DataBaseConnection;
import mysql.model.Bookings;
import mysql.model.Manage;
import mysql.view.BookingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import static java.lang.Character.isDigit;

public class BookingController {
    private BookingView view4;
    private Manage manage;
    private DataBaseConnection dataBaseConnection;
    private int guest_id;
    private int id; //booking-id
    private int price;
    private int ok = 0;
    private int ok2 = 0;
    private java.util.Date data;
    private int room;//room-id

    public BookingController(BookingView view4, Manage manage, DataBaseConnection dataBaseConnection, int guest_id) {
        this.view4 = view4;
        this.manage = manage;
        this.dataBaseConnection = dataBaseConnection;
        this.guest_id = guest_id;
        this.view4.addShowListener(new BookingController.SelectListener());
        this.view4.addCreateListener(new BookingController.CreateListener());
        this.view4.addCreateListener2(new BookingController.CreateListener2());
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                view4.clearpaycomboBox();
                manage.getBookings().clear();
                Connection connection = dataBaseConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement("Select bookings.booking_id,bookings.booking_status_code,bookings.date_from,bookings.date_to,booking_status.booking_status_description from bookings inner join booking_status on bookings.booking_status_code=booking_status.booking_status_code where bookings.guest_id=?");
                pst.setInt(1, guest_id);
                ResultSet result = pst.executeQuery();
                while (result.next()) {
                    int booking_id = result.getInt(1);
                    int booking_status = result.getInt(2);
                    String from = result.getString(3);
                    String to = result.getString(4);
                    String booking = result.getString(5);
                    ok = 1;
                    if (booking_status != 4 && booking_status != 1) {
                        manage.getBookings().add(new Bookings(booking_id, to, from, booking));
                    }
                }
                for (int i = 0; i < manage.getBookings().size(); i++) {
                    view4.setpaycomboBox(manage.getBookings().get(i));
                }

                connection.close();
            } catch (Exception ex) {
                view4.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok == 1) {
                    Connection connection = dataBaseConnection.getConnection();
                    String s = view4.getpaycomboBox();
                    for (int i = 0; i < manage.getBookings().size(); i++) {
                        if (s.equals(manage.getBookings().get(i).toString())) {
                            id = manage.getBookings().get(i).getBooking_id();
                        }
                    }
                    PreparedStatement pst = connection.prepareStatement("Select * from bookings where booking_id=?");
                    pst.setInt(1, id);
                    ResultSet result = pst.executeQuery();
                    while (result.next()) {
                        price = result.getInt(8);
                        data = result.getDate(6);
                        room = result.getInt(2);

                    }
                    view4.settotaltextArea(price);
                    ok2 = 1;
                    connection.close();
                } else {
                    view4.showMessage("you didn't pick a booking to pay for");
                }

            } catch (Exception ex) {
                view4.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok2 == 1) {
                    Connection connection = dataBaseConnection.getConnection();
                    String from = view4.getdatetextField();

                    if (view4.getdatetextField().equals("")) {
                        view4.showMessage("please insert a date");
                    }


                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date date = sdf.parse(from);
                    java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());


                    long k = data.getTime() - date.getTime();
                    k = k / 86400000;
                    if (k > 7) {
                        view4.showMessage("is the date correct?");
                    } else {
                        int price = view4.getpricetextField();


                        if (sqlEndDate.compareTo(data) > 0) {
                            view4.showMessage("unfortunately you didn't pay on time so your reservation is cancelled");
                            PreparedStatement p = null;
                            String sql = "update bookings set booking_status_code='1' where booking_id=?";
                            p = connection.prepareStatement(sql);
                            p.setInt(1, id);
                            p.execute();
                            PreparedStatement p2 = null;
                            String sql2 = "update rooms set available='1' where room_id=?";
                            p2 = connection.prepareStatement(sql2);
                            p2.setInt(1, room);
                            p2.execute();

                        } else {
                            if (price > view4.gettotaltextArea()) {
                                view4.showMessage("you don't need to pay that much");
                            }
                            if (price == view4.gettotaltextArea()) {
                                view4.showMessage("ok!your room is now paid for");
                                view4.settotaltextArea(0);
                                PreparedStatement p = null;
                                String sql = "update bookings set rest='0', booking_status_code='4' where booking_id=?";
                                p = connection.prepareStatement(sql);
                                p.setInt(1, id);
                                p.execute();
                                PreparedStatement preparedStatement = connection.prepareStatement("insert into payments(booking_id,payment_amount,payment_date)" + "values (?,?,?)");
                                preparedStatement.setInt(1, id);
                                preparedStatement.setInt(2, price);
                                preparedStatement.setDate(3, sqlEndDate);
                                preparedStatement.executeUpdate();
                            }
                            if (price < view4.gettotaltextArea()) {
                                view4.showMessage("ok!your room is now reserved");
                                int rest = view4.gettotaltextArea() - price;
                                view4.settotaltextArea(rest);
                                PreparedStatement p = null;
                                String sql = "update bookings set rest=?, booking_status_code='3' where booking_id=?";
                                p = connection.prepareStatement(sql);
                                p.setInt(1, rest);
                                p.setInt(2, id);
                                p.execute();
                                PreparedStatement preparedStatement = connection.prepareStatement("insert into payments(booking_id,payment_amount,payment_date)" + "values (?,?,?)");
                                preparedStatement.setInt(1, id);
                                preparedStatement.setInt(2, price);
                                preparedStatement.setDate(3, sqlEndDate);
                                preparedStatement.executeUpdate();
                            }
                        }
                    }
                    connection.close();
                } else view4.showMessage("you didn't pick a booking");
            } catch (Exception ex) {
                view4.showMessage("bad input!");

            }
        }
    }

}
