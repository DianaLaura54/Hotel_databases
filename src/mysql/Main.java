package mysql;


import mysql.Controllers.Controller;
import mysql.Models.Manage;
import mysql.view.shopView;

public class Main {
    public static void main(String[] args) {

        Manage manage = new Manage("management");
        shopView view = new shopView();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Controller controller = new Controller(view, manage, dataBaseConnection);

    }
}
