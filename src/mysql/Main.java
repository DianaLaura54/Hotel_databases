package mysql;


import mysql.controller.MainController;
import mysql.model.Manage;
import mysql.view.MainView;

public class Main {
    public static void main(String[] args) {

        Manage manage = new Manage("management");
        MainView view = new MainView();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        MainController controller = new MainController(view, manage, dataBaseConnection);

    }
}
