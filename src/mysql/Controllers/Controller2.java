package mysql.Controllers;

import mysql.DataBaseConnection;
import mysql.Models.Hotels;
import mysql.Models.Manage;
import mysql.view.shopView2;
import mysql.view.shopView3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller2 {

    private shopView2 view2;
    private Manage manage;
    private DataBaseConnection dataBaseConnection;
    private int id;
    private int cod;
    private int ok = 0;
    private int verify = 0;
    private int guest_id;
    private int id_hotel;

    public Controller2(shopView2 view2, Manage manage, DataBaseConnection dataBaseConnection, int id, int guest_id) {
        this.view2 = view2;
        this.manage = manage;
        this.dataBaseConnection = dataBaseConnection;
        this.id = id;
        this.guest_id=guest_id;
        this.view2.addShowListener(new Controller2.SelectListener());
        this.view2.add2ShowListener(new Controller2.SelectListener2());
        this.view2.addCreateListener(new Controller2.CreateListener());
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                manage.getHotels().clear();
                view2.clearhotelcomboBox();
                view2.clear();
                ok = 0;
                verify = 0;
                Connection connection = dataBaseConnection.getConnection();
                String s = view2.getchoosecomboBox();
                PreparedStatement pst2 = connection.prepareStatement("Select hotel_chain_code from hotel_chains where hotel_chain_name=?");
                pst2.setString(1, s);
                ResultSet result = pst2.executeQuery();
                while (result.next()) {
                    cod = result.getInt(1);
                }
                PreparedStatement preparedStatement = connection.prepareStatement("Select * from hotel where country_code=? and hotel_chain_code=?");
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, cod);
                ResultSet result2 = preparedStatement.executeQuery();

                while (result2.next()) {
                    String name = result2.getString(5);
                    String name2 = result2.getString(6);
                    int stars=result2.getInt(4);
                    manage.getHotels().add(new Hotels(name, name2,stars));
                    view2.sethotelcomboBox(name);
                    ok = 1;
                }
                if (ok == 1) {
                    view2.sethotelstextArea(manage.getHotels().toString());
                } else {
                    view2.showMessage("Unfortunately the chain doesn't exist in the country.Pick a different one please!");
                    ok = 0;
                }
                connection.close();
            } catch (Exception ex) {
                view2.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class SelectListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok == 0)
                    view2.showMessage("there's nothing to choose");
                else {
                    String s = view2.gethotelcomboBox();
                    view2.showMessage("you have choosen " + s);
                    Connection connection = dataBaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("Select * from hotel");
                    ResultSet result2 = preparedStatement.executeQuery();
                    while(result2.next())
                    {
                        String str=result2.getString(5);

                        if(s.equals(str))
                        {
                        id_hotel=result2.getInt(1);
                        }
                    }

                    verify = 1;
                    connection.close();
                }
            } catch (Exception ex) {
                view2.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (verify == 0) {
                    view2.showMessage("please pick a hotel first");
                } else if (verify == 1) {
                    view2.dispose();
                    shopView3 view3 = new shopView3();
                    Controller3 controller3 = new Controller3(view3, manage, dataBaseConnection, id, id_hotel,guest_id);
                }
            } catch (Exception ex) {
                view2.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

}
