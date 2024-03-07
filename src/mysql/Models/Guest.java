package mysql.Models;

public class Guest {
    private String email;
    private int id;

    public Guest(String email) {
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

