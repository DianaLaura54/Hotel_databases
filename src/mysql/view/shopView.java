package mysql.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class shopView extends JFrame {

    private JButton showButton;
    private  JComboBox countryComboBox;
    private JTextArea countryTextArea;
    private  JLabel hotelLabel;
    private JLabel searchLabel;
    private  JButton reservationButton;
    private JTextArea PriceTextArea;
    private JLabel hotel2Label;
    private JLabel priceLabel;
    private JLabel emailLabel;
private JTextField emailTextField;
private JButton createButton;
private JButton LoginButton;
private   JButton payButton;

    public shopView() {
        this.setResizable(false);
        this.setBounds(100, 100, 887, 664);
        this.getContentPane().setForeground(new Color(128, 0, 0));
       this.getContentPane().setBackground(new Color(178, 34, 34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        showButton = new JButton("Show");
        showButton.setBackground(new Color(255, 222, 173));
        showButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        showButton.setBounds(54, 299, 172, 68);
        this.getContentPane().add(showButton);

         countryComboBox = new JComboBox();
        countryComboBox.setForeground(new Color(205, 133, 63));
        countryComboBox.setBackground(new Color(255, 160, 122));
        countryComboBox.setFont(new Font("Georgia", Font.PLAIN, 25));
        countryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Romania", "England", "Japan", "United States", "France", "Turkey"}));
        countryComboBox.setBounds(54, 212, 210, 54);
        this.getContentPane().add(countryComboBox);

       countryTextArea = new JTextArea();
        countryTextArea.setBackground(new Color(233, 150, 122));
        countryTextArea.setFont(new Font("Georgia", Font.PLAIN, 15));
        countryTextArea.setBounds(357, 212, 253, 300);
        this.getContentPane().add(countryTextArea);

        JScrollPane scrollPane = new JScrollPane(countryTextArea);
        scrollPane.setBounds(357, 212, 253, 300);
        this.getContentPane().add(scrollPane);

       hotelLabel = new JLabel("Hotel agency");
        hotelLabel.setFont(new Font("Georgia", Font.PLAIN, 50));
        hotelLabel.setBounds(252, 33, 308, 93);
        this.getContentPane().add(hotelLabel);

       searchLabel = new JLabel("Search by country");
        searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        searchLabel.setBounds(70, 151, 253, 34);
       this.getContentPane().add(searchLabel);

        reservationButton = new JButton("Make a reservation");
        reservationButton.setBackground(new Color(255, 222, 173));
        reservationButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        reservationButton.setBounds(370, 552, 210, 54);
       this.getContentPane().add(reservationButton);

        PriceTextArea = new JTextArea();
        PriceTextArea.setBackground(new Color(233, 150, 122));
        PriceTextArea.setFont(new Font("Georgia", Font.PLAIN, 15));
        PriceTextArea.setBounds(643, 212, 220, 300);
        this.getContentPane().add(PriceTextArea);

        JScrollPane scrollPane2 = new JScrollPane(PriceTextArea);
        scrollPane2.setBounds(643, 212, 220, 300);
        this.getContentPane().add(scrollPane2);

       hotel2Label = new JLabel("Hotels in the country");
        hotel2Label.setFont(new Font("Georgia", Font.PLAIN, 20));
        hotel2Label.setBounds(357, 152, 198, 34);
        this.getContentPane().add(hotel2Label);

        priceLabel = new JLabel("Standard prices in the country");
        priceLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        priceLabel.setBounds(579, 126, 284, 59);
        this.getContentPane().add(priceLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        emailLabel.setBounds(90, 424, 135, 29);
       this.getContentPane().add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Georgia", Font.PLAIN, 25));
        emailTextField.setColumns(10);
        emailTextField.setBackground(new Color(240, 230, 140));
        emailTextField.setBounds(25, 479, 239, 36);
       this.getContentPane().add(emailTextField);

         createButton = new JButton("Register");
        createButton.setBackground(new Color(255, 140, 0));
        createButton.setBounds(42, 552, 85, 21);
        this.getContentPane().add(createButton);

       LoginButton = new JButton("Login ");
        LoginButton.setBackground(new Color(255, 140, 0));
        LoginButton.setBounds(187, 552, 85, 21);
        this.getContentPane().add(LoginButton);

      payButton = new JButton("Pay");
        payButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        payButton.setBackground(new Color(255, 222, 173));
        payButton.setBounds(634, 552, 210, 54);
        getContentPane().add(payButton);

        this.setVisible(true);
    }
    public String getcountryTextArea() {
        return countryTextArea.getText();
    }

    public void setcountryTextArea(String countryTextArea) {
        this.countryTextArea.setText(countryTextArea);
    }

    public String getPriceTextArea() {
        return PriceTextArea.getText();
    }

    public void setPriceTextArea(String PriceTextArea) {
        this.PriceTextArea.setText(PriceTextArea);
    }

    public String getcountryComboBox()
    {
        return countryComboBox.getSelectedItem().toString();

    }
    public void setcountryComboBox(JComboBox countryComboBox)
    {
        this.countryComboBox=countryComboBox;
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.setText(emailTextField);
    }

    public void addShowListener(ActionListener action) {
        showButton.addActionListener(action);
    }
    public void addCreateListener(ActionListener action)
    {
        createButton.addActionListener(action);
    }
    public void add2ShowListener(ActionListener action)
    {
        LoginButton.addActionListener(action);
    }
    public void add2CreateListener(ActionListener action)
    {
        reservationButton.addActionListener(action);
    }
    public void add3CreateListener(ActionListener action)
    {
        payButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void refresh()
    {
        emailTextField.setText(null);
    }
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this,message,"ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        refresh();
    }


}




