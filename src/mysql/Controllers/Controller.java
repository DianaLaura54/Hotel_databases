package mysql.Controllers;


import mysql.Models.Hotels;
import mysql.Models.Manage;
import mysql.Models.room_types;
import mysql.view.View;
import mysql.DataBaseConnection;
import mysql.view.View2;
import mysql.view.View4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    private View view;
    private Manage manage;
    private DataBaseConnection dataBaseConnection;
    private int ok = 0;
    private int cod;
    private int guest_id;


    public Controller(View view, Manage manage, DataBaseConnection dataBaseConnection) {
        this.view = view;
        this.manage = manage;
        this.dataBaseConnection = dataBaseConnection;

        this.view.addShowListener(new SelectListener());
        this.view.addCreateListener(new CreateListener());
        this.view.add2ShowListener(new SelectListener2());
        this.view.add2CreateListener(new CreateListener2());
        this.view.add3CreateListener(new CreateListener3());
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                manage.getHotels().clear();
                manage.getRoom_types().clear();
                Connection connection = dataBaseConnection.getConnection();
                String s = view.getcountryComboBox();
                PreparedStatement pst = connection.prepareStatement("Select country_code from country where country_name=?");
                pst.setString(1, s);
                ResultSet result = pst.executeQuery();
                while (result.next()) {
                    int id = result.getInt(1);
                    cod = id;
                    PreparedStatement pst2 = connection.prepareStatement("Select * from hotel where country_code=?");
                    pst2.setInt(1, id);
                    ResultSet result2 = pst2.executeQuery();
                    while (result2.next()) {
                        String name = result2.getString(5);
                        String name2 = result2.getString(6);
                        int stars = result2.getInt(4);
                        manage.getHotels().add(new Hotels(name, name2, stars));
                    }
                    PreparedStatement pst3 = connection.prepareStatement("Select room_standard_price,room_description from room_types where country_code=?");
                    pst3.setInt(1, id);
                    ResultSet result3 = pst3.executeQuery();
                    while (result3.next()) {
                        int price = result3.getInt(1);
                        String des = result3.getString(2);
                        manage.getRoom_types().add(new room_types(price, des));
                    }
                    view.setcountryTextArea(manage.getHotels().toString());
                    view.setPriceTextArea(manage.getRoom_types().toString());
                }
                connection.close();
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String s = view.getEmailTextField();
                if (s.indexOf('@') <= 0) {
                    view.showMessage("Bad input!");
                } else {
                    Connection connection = dataBaseConnection.getConnection();
                    String sql = "SELECT * FROM guests";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);
                    boolean alreadyExists = false;
                    while (result.next() && !alreadyExists) {
                        if (result.getString(2).equals(view.getEmailTextField())) {
                            alreadyExists = true;

                        }
                        guest_id = result.getInt(1);
                    }
                    if (alreadyExists) {
                        view.showErrorMessage("Account already exists!");
                    } else {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into guests (guest_email)" + "values (?)");
                        preparedStatement.setString(1, view.getEmailTextField());
                        preparedStatement.executeUpdate();
                        view.showMessage("Account successfully created!");
                        ok = 1;
                        guest_id++;

                    }
                    connection.close();
                }
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class SelectListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = dataBaseConnection.getConnection();
                String sql = "SELECT * FROM guests";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                boolean alreadyExists = false;
                while (result.next() && !alreadyExists) {
                    if (result.getString(2).equals(view.getEmailTextField())) {
                        alreadyExists = true;
                        guest_id = result.getInt(1);
                    }
                }
                if (alreadyExists) {
                    view.showMessage("logged");
                    ok = 2;
                } else {
                    view.showErrorMessage("account doesn't exist");
                }
                connection.close();
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok == 1 || ok == 2) {
                    view.dispose();
                    View2 view2 = new View2();
                    Controller2 controller2 = new Controller2(view2, manage, dataBaseConnection, cod, guest_id);
                } else {
                    view.showMessage("you haven't signed in");
                }
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok == 1) {
                    view.showMessage("you didn't make a booking yet");
                } else if (ok == 2) {
                    view.dispose();
                    View4 view4 = new View4();
                    Controller4 controller4 = new Controller4(view4, manage, dataBaseConnection, guest_id);
                } else {
                    view.showMessage("you haven't signed in");
                }
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
}


