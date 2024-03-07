package mysql;


import mysql.Controllers.Controller;
import mysql.Models.Manage;
import mysql.view.View;

public class Main {
    public static void main(String[] args) {

        Manage manage = new Manage("management");
        View view = new View();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Controller controller = new Controller(view, manage, dataBaseConnection);

    }
}
