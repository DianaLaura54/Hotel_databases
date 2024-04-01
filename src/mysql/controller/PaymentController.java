package mysql.controller;

import mysql.DataBaseConnection;
import mysql.model.Manage;
import mysql.model.Staff;
import mysql.view.PaymentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import static java.lang.Character.isDigit;

public class PaymentController {
    private PaymentView view5;
    private Manage manage;
    private DataBaseConnection dataBaseConnection;
    private int cod;
    private int ok = 0;
    private int ok2 = 0;
    private int guest_id;
    private int nr;
    private int staff_id;
    private int booking_id;

    public PaymentController(PaymentView view5, Manage manage, DataBaseConnection dataBaseConnection, int cod, int guest_id, int nr) {
        this.view5 = view5;
        this.manage = manage;
        this.dataBaseConnection = dataBaseConnection;
        this.cod = cod;// hotel-id(for the staff)
        this.guest_id = guest_id;// guest-id
        this.nr = nr;// room-id
        this.view5.addShowListener(new PaymentController.SelectListener());
        this.view5.addCreateListener(new PaymentController.SelectListener2());
        this.view5.addCreateListener2(new PaymentController.CreateListener());
        this.view5.addCreateListener3(new PaymentController.CreateListener2());
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                view5.clearstaffcomboBox();
                Connection connection = dataBaseConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement("Select * from staff where hotel_id=?");
                pst.setInt(1, cod);
                ResultSet result = pst.executeQuery();
                while (result.next()) {
                    staff_id = result.getInt(1);
                    String name = result.getString(2);
                    String name2 = result.getString(3);
                    manage.getStaff().add(new Staff(name2, name));
                    view5.setstaffcomboBox(name2 + " " + name);
                    ok = 1;
                }
                connection.close();
            } catch (Exception ex) {
                view5.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class SelectListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = dataBaseConnection.getConnection();
                if (ok == 1) {
                    view5.showMessage("staff choosen");

                } else {
                    view5.showMessage("please pick a staff member!");
                }
                connection.close();
            } catch (Exception ex) {
                view5.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok2 == 0) {
                    Connection connection = dataBaseConnection.getConnection();
                    String to = view5.gettotextField();
                    String from = view5.getfromtextField();
                    if (view5.gettotextField().equals("") || view5.getfromtextField().equals("")) {
                        view5.showMessage("please insert a date");
                    } else {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date date = sdf1.parse(from);
                        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date date2 = sdf2.parse(to);
                        java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime());
                        long k = date2.getTime() - date.getTime();
                        k = k / 86400000;
                        ok2 = 1;
                        PreparedStatement pst2 = connection.prepareStatement("Select room_price from rooms where room_id=?");
                        pst2.setInt(1, nr);
                        ResultSet result2 = pst2.executeQuery();
                        int price;
                        while (result2.next()) {
                            price = result2.getInt(1);
                            view5.settotaltextArea((int) (price * k));
                        }
                        PreparedStatement pst = connection.prepareStatement("insert into bookings(room_id,guest_id,staff_id,booking_status_code,date_from,date_to,rest,total)" + "values(?,?,?,?,?,?,?,?)");
                        pst.setInt(1, nr);
                        pst.setInt(2, guest_id);
                        pst.setInt(3, staff_id);
                        pst.setInt(4, 2);
                        pst.setDate(5, sqlStartDate);
                        pst.setDate(6, sqlEndDate);
                        pst.setInt(7, view5.gettotaltextArea());
                        pst.setInt(8, view5.gettotaltextArea());
                        pst.executeUpdate();
                    }
                    connection.close();
                }
            } catch (Exception ex) {
                view5.showMessage("Something went wrong!");
            }
        }
    }

    class CreateListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok2 == 1) {
                    Connection connection = dataBaseConnection.getConnection();
                    String from = view5.getfromtextField();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date date = sdf1.parse(from);
                    java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                    sqlStartDate = Date.valueOf(sqlStartDate.toLocalDate().minusDays(7));
                    int price = view5.getpaytextField();
                    PreparedStatement pst = connection.prepareStatement("Select booking_id from bookings");
                    ResultSet result = pst.executeQuery();
                    while (result.next()) {
                        booking_id = result.getInt(1);
                    }
                    if (price > view5.gettotaltextArea()) {
                        view5.showMessage("you don't need to pay that much");
                    }
                    if (price == view5.gettotaltextArea()) {
                        view5.showMessage("ok!your room is now paid for");
                        view5.settotaltextArea(0);
                        PreparedStatement p = null;
                        String sql = "update bookings set rest='0', booking_status_code='4' where booking_id=?";
                        p = connection.prepareStatement(sql);
                        p.setInt(1, booking_id);
                        p.execute();

                        PreparedStatement preparedStatement = connection.prepareStatement("insert into payments(booking_id,payment_amount,payment_date)" + "values (?,?,?)");
                        preparedStatement.setInt(1, booking_id);
                        preparedStatement.setInt(2, price);
                        preparedStatement.setDate(3, sqlStartDate);
                        preparedStatement.executeUpdate();
                    }

                    if (price < view5.gettotaltextArea()) {
                        int rest = view5.gettotaltextArea() - price;
                        view5.showMessage("ok!your room is now reserved");
                        view5.settotaltextArea(rest);
                        PreparedStatement p = null;
                        String sql = "update bookings set rest=?,booking_status_code='3' where booking_id=?";
                        p = connection.prepareStatement(sql);
                        p.setInt(1, rest);
                        p.setInt(2, booking_id);
                        p.execute();
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into payments(booking_id,payment_amount,payment_date)" + "values (?,?,?)");
                        preparedStatement.setInt(1, booking_id);
                        preparedStatement.setInt(2, price);
                        preparedStatement.setDate(3, sqlStartDate);
                        preparedStatement.executeUpdate();
                    }
                    connection.close();
                } else view5.showMessage("But you didn't do a booking yet");
            } catch (Exception ex) {
                view5.showMessage("Something went wrong!");
            }
        }
    }

}
