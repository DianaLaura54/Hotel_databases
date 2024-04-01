package mysql.model;

public class Country {
    String country_name;
    String country_currency;

    public Country(String country_name, String country_currency) {
        this.country_currency = country_currency;
        this.country_name = country_name;
    }
}
