package mysql.controller;

import mysql.DataBaseConnection;
import mysql.model.Manage;
import mysql.model.Rooms;
import mysql.view.ChooseView;
import mysql.view.PickView;
import mysql.view.PaymentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PickController {
    private PickView view3;
    private Manage manage;
    private DataBaseConnection dataBaseConnection;
    private int id;
    private int cod;
    private int j;
    private int guest_id;

    public PickController(PickView view3, Manage manage, DataBaseConnection dataBaseConnection, int id, int cod, int guest_id) {
        this.view3 = view3;
        this.manage = manage;
        this.dataBaseConnection = dataBaseConnection;
        this.view3.addShowListener(new PickController.SelectListener());
        this.view3.addShowListener2(new PickController.SelectListener2());
        this.view3.addCreateListener(new PickController.CreateListener());
        this.id = id;
        this.cod = cod;
        this.guest_id = guest_id;
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                view3.dispose();
                ChooseView view2 = new ChooseView();
                ChooseController controller2 = new ChooseController(view2, manage, dataBaseConnection, id, guest_id);
            } catch (Exception ex) {
                view3.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class SelectListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                manage.getRooms().clear();
                Connection connection = dataBaseConnection.getConnection();
                PreparedStatement pst2 = connection.prepareStatement("Select rooms.room_id,rooms.room_floor,rooms.room_number,room_types.room_description,rooms.smoking,rooms.available,rooms.room_price from rooms inner join room_types on rooms.room_type_code=room_types.room_type_code where hotel_id=? and available=?");
                pst2.setInt(1, cod);
                pst2.setInt(2, 1);
                ResultSet result = pst2.executeQuery();
                while (result.next()) {
                    int room_id = result.getInt(1);
                    int room_floor = result.getInt(2);
                    int room_number = result.getInt(3);
                    String room_type_code = result.getString(4);
                    String smoking = result.getString(5);
                    int available = result.getInt(6);
                    int room_price = result.getInt(7);

                    manage.getRooms().add(new Rooms(room_id, room_floor, room_number, room_type_code, smoking, available, room_price));
                }
                view3.setroomstextArea(manage.getRooms().toString());
                connection.close();
            } catch (Exception ex) {
                view3.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = dataBaseConnection.getConnection();
                int nr = view3.getnrtextField();
                int y = 0;
                for (int i = 0; i < manage.getRooms().size(); i++) {
                    if (nr == manage.getRooms().get(i).getRoom_id()) {
                        y = 1;
                        j = i;
                    }
                }
                if (y == 1) {
                    view3.showMessage("room selected");
                    PreparedStatement p = null;
                    manage.getRooms().get(j).setAvailable(0);
                    String sql = "update rooms set available='0' where room_id=?";
                    p = connection.prepareStatement(sql);
                    p.setInt(1, nr);
                    p.execute();

                    view3.showMessage("proceed to booking");
                    view3.dispose();
                    PaymentView view5 = new PaymentView();
                    PaymentController controller5 = new PaymentController(view5, manage, dataBaseConnection, cod, guest_id, nr);
                } else {
                    view3.showMessage("bad input");
                }
                connection.close();
            } catch (Exception ex) {
                view3.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
}
