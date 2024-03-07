package mysql.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View5 extends JFrame {
    private JLabel staffLabel;
    private JComboBox staffcomboBox;
    private JLabel fromLabel;
    private JLabel bookingLabel;
    private JLabel toLabel;
    private JTextField fromtextField;
    private JTextField totextField;
    private JButton bookButton;
    private JLabel payLabel;
    private JTextField paytextField;
    private JLabel totalLabel;
    private JTextArea totaltextArea;
    private JButton payButton;
    private JButton staffButton;
    private JButton showButton;

    public View5() {
        this.setResizable(false);
        this.setBounds(100, 100, 887, 664);
        this.getContentPane().setForeground(new Color(128, 0, 0));
        this.getContentPane().setBackground(new Color(178, 34, 34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        staffLabel = new JLabel("Choose staff");
        staffLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        staffLabel.setBounds(114, 148, 190, 30);
        getContentPane().add(staffLabel);

        staffcomboBox = new JComboBox();
        staffcomboBox.setBackground(new Color(245, 222, 179));
        staffcomboBox.setFont(new Font("Georgia", Font.PLAIN, 20));
        staffcomboBox.setBounds(81, 214, 236, 30);
        getContentPane().add(staffcomboBox);

        fromLabel = new JLabel("Date  from");
        fromLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        fromLabel.setBounds(525, 119, 222, 30);
        getContentPane().add(fromLabel);

        bookingLabel = new JLabel("Make a booking");
        bookingLabel.setFont(new Font("Georgia", Font.PLAIN, 35));
        bookingLabel.setBounds(307, 29, 366, 41);
        getContentPane().add(bookingLabel);

        toLabel = new JLabel("Date  to");
        toLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        toLabel.setBounds(525, 270, 222, 30);
        getContentPane().add(toLabel);

        fromtextField = new JTextField();
        fromtextField.setFont(new Font("Georgia", Font.PLAIN, 20));
        fromtextField.setBounds(488, 177, 281, 54);
        fromtextField.setBackground(new Color(240, 128, 128));
        getContentPane().add(fromtextField);
        fromtextField.setColumns(10);

        totextField = new JTextField();
        totextField.setFont(new Font("Georgia", Font.PLAIN, 20));
        totextField.setBackground(new Color(240, 128, 128));
        totextField.setColumns(10);
        totextField.setBounds(488, 333, 281, 54);
        getContentPane().add(totextField);

        bookButton = new JButton("Book");
        bookButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        bookButton.setBackground(new Color(218, 165, 32));
        bookButton.setBounds(64, 349, 281, 47);
        getContentPane().add(bookButton);

        payLabel = new JLabel("Pay a sum");
        payLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        payLabel.setBounds(509, 426, 222, 30);
        getContentPane().add(payLabel);

        paytextField = new JTextField();
        paytextField.setFont(new Font("Georgia", Font.PLAIN, 20));
        paytextField.setColumns(10);
        paytextField.setBackground(new Color(240, 128, 128));
        paytextField.setBounds(488, 496, 281, 54);
        getContentPane().add(paytextField);

        totalLabel = new JLabel("Price");
        totalLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        totalLabel.setBounds(64, 460, 222, 30);
        getContentPane().add(totalLabel);

        totaltextArea = new JTextArea();
        totaltextArea.setFont(new Font("Georgia", Font.PLAIN, 20));
        totaltextArea.setBounds(64, 496, 253, 47);
        totaltextArea.setBackground(new Color(240, 128, 128));
        getContentPane().add(totaltextArea);

        payButton = new JButton("Pay");
        payButton.setBackground(new Color(245, 222, 179));
        payButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        payButton.setBounds(525, 568, 215, 35);
        getContentPane().add(payButton);

        staffButton = new JButton("Choose staff");
        staffButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        staffButton.setBackground(new Color(245, 222, 179));
        staffButton.setBounds(89, 270, 215, 35);
        getContentPane().add(staffButton);

        showButton = new JButton("Show staff");
        showButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        showButton.setBackground(new Color(245, 222, 179));
        showButton.setBounds(89, 84, 215, 35);
        getContentPane().add(showButton);
        this.setVisible(true);
    }

    public String gettotextField() {
        return totextField.getText();
    }

    public void settotextField(String totextField) {
        this.totextField.setText(totextField);
    }

    public String getfromtextField() {
        return fromtextField.getText();
    }

    public void setfromtextField(String fromtextField) {
        this.fromtextField.setText(fromtextField);
    }

    public void clearstaffcomboBox() {
        this.staffcomboBox.removeAllItems();

    }

    public String getstaffcomboBox() {
        return staffcomboBox.getSelectedItem().toString();
    }

    public void setstaffcomboBox(Object item) {
        this.staffcomboBox.addItem(item);
    }

    public int gettotaltextArea() {
        return Integer.parseInt(totaltextArea.getText());
    }

    public void settotaltextArea(int totaltextArea) {
        this.totaltextArea.setText(String.valueOf(totaltextArea));
    }

    public int getpaytextField() {
        return Integer.parseInt(paytextField.getText());
    }

    public void setpaytextField(int paytextField) {
        this.paytextField.setText(String.valueOf(paytextField));
    }

    public void addShowListener(ActionListener action) {
        showButton.addActionListener(action);
    }

    public void addCreateListener(ActionListener action) {
        staffButton.addActionListener(action);
    }

    public void addCreateListener2(ActionListener action) {
        bookButton.addActionListener(action);
    }

    public void addCreateListener3(ActionListener action) {
        payButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
