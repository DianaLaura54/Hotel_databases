package mysql.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class shopView4 extends JFrame {
    private JTextField datetextField;
    private JLabel dateLabel;
    private JComboBox paycomboBox;
    private  JLabel payLabel;
    private   JButton payButton;
    private JLabel totalLabel;
    private JTextArea totaltextArea;
    private JButton bookingButton;
    private  JButton showButton;
    private JTextField  pricetextField;
    private JLabel priceLabel;

    public shopView4() {
        this.setResizable(false);
        this.setBounds(100, 100, 887, 664);
        this.getContentPane().setForeground(new Color(128, 0, 0));
        this.getContentPane().setBackground(new Color(178, 34, 34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        datetextField = new JTextField();
        datetextField.setFont(new Font("Georgia", Font.PLAIN, 15));
        datetextField.setBounds(485, 196, 236, 36);
        datetextField.setBackground(new Color(255, 222, 173));
        getContentPane().add(datetextField);

        dateLabel = new JLabel("Date today");
        dateLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        dateLabel.setBounds(508, 144, 192, 29);
        getContentPane().add(dateLabel);

        paycomboBox = new JComboBox();
        paycomboBox.setBackground(new Color(255, 215, 0));
        paycomboBox.setFont(new Font("Georgia", Font.PLAIN, 20));
        paycomboBox.setBounds(41, 144, 256, 45);
        getContentPane().add(paycomboBox);

        JScrollPane scrollPane2 = new JScrollPane(paycomboBox);
        scrollPane2.setBounds(41, 144, 256, 45);
        this.getContentPane().add(scrollPane2);

        payLabel = new JLabel("Payment");
        payLabel.setFont(new Font("Georgia", Font.PLAIN, 40));
        payLabel.setBounds(318, 47, 312, 54);
        getContentPane().add(payLabel);

        payButton = new JButton("Pay");
        payButton.setBackground(new Color(255, 127, 80));
        payButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        payButton.setBounds(508, 312, 209, 45);
        getContentPane().add(payButton);

        totalLabel = new JLabel("the rest to pay is");
        totalLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        totalLabel.setBounds(74, 320, 192, 29);
        getContentPane().add(totalLabel);

        totaltextArea = new JTextArea();
        totaltextArea.setFont(new Font("Georgia", Font.PLAIN, 20));
        totaltextArea.setBounds(72, 359, 169, 29);
        totaltextArea.setBackground(new Color(255, 222, 173));
        getContentPane().add(totaltextArea);

         bookingButton = new JButton("Choose booking you want to pay");
        bookingButton.setBackground(new Color(240, 230, 140));
        bookingButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        bookingButton.setBounds(41, 220, 351, 60);
        getContentPane().add(bookingButton);

        showButton = new JButton("Show bookings");
        showButton.setBackground(new Color(238, 232, 170));
        showButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        showButton.setBounds(54, 74, 192, 45);
       this.getContentPane().add(showButton);

        pricetextField = new JTextField();
        pricetextField.setFont(new Font("Georgia", Font.PLAIN, 15));
        pricetextField.setBounds(485, 257, 236, 36);
        pricetextField.setBackground(new Color(255, 222, 173));
        this.getContentPane().add(pricetextField);

         priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        priceLabel.setBounds(736, 259, 192, 29);
      this.getContentPane().add(priceLabel);
        this.setVisible(true);
    }
    public int gettotaltextArea() {
        return Integer.parseInt(totaltextArea.getText());
    }
    public void settotaltextArea(int totaltextArea) {

        this.totaltextArea.setText(String.valueOf(totaltextArea));
    }
    public String getpaycomboBox()
    {
        return paycomboBox.getSelectedItem().toString();
    }
    public void setpaycomboBox(Object item)
    {
        this.paycomboBox.addItem(item);
    }
    public String getdatetextField() {
        return  datetextField.getText();
    }

    public void setdatetextField(String datetextField) {
        this.datetextField.setText(datetextField);
    }

    public int getpricetextField() {
        return Integer.parseInt(pricetextField.getText());
    }

    public void setpricetextField(int pricetextField) {
        this.pricetextField.setText(String.valueOf(pricetextField));
    }

    public void addShowListener(ActionListener action)
    {
        showButton.addActionListener(action);
    }
    public void addCreateListener(ActionListener action)
    {
        bookingButton.addActionListener(action);
    }
    public void addCreateListener2(ActionListener action)
    {
        payButton.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void clearpaycomboBox()
    {
        this.paycomboBox.removeAllItems();
    }

}
