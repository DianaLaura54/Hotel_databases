package mysql.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View2 extends JFrame {
    private JComboBox choosecomboBox;
    private JLabel hotelchainLabel;
    private JButton chooseButton;
    private JLabel hotelLabel;
    private JTextArea hotelstextArea;
    private JComboBox hotelcomboBox;
    private JButton reservationButton;
    private JButton choose2Button;

    public View2() {
        this.setResizable(false);
        this.setBounds(100, 100, 887, 664);
        this.getContentPane().setForeground(new Color(128, 0, 0));
        this.getContentPane().setBackground(new Color(178, 34, 34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        choosecomboBox = new JComboBox();
        choosecomboBox.setModel(new DefaultComboBoxModel(new String[]{"InterContinental", "Groupe Lucien Barrière", "Hilton Hotels & Resorts", "" +
                "Dedeman Hotels & Resorts International", "Okura Hotels and Resorts", "Skid Row Housing Trust"}));
        choosecomboBox.setMaximumRowCount(16);
        choosecomboBox.setBackground(new Color(210, 105, 30));
        choosecomboBox.setFont(new Font("Georgia", Font.PLAIN, 25));
        choosecomboBox.setBounds(170, 130, 477, 54);
        this.getContentPane().add(choosecomboBox);

        hotelchainLabel = new JLabel("Choose a hotel chain");
        hotelchainLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
        hotelchainLabel.setBounds(247, 44, 380, 44);
        this.getContentPane().add(hotelchainLabel);

        chooseButton = new JButton("Choose");
        chooseButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        chooseButton.setBackground(new Color(255, 140, 0));
        chooseButton.setBounds(266, 224, 260, 30);
        this.getContentPane().add(chooseButton);

        hotelLabel = new JLabel("Hotels");
        hotelLabel.setFont(new Font("Georgia", Font.PLAIN, 23));
        hotelLabel.setBounds(111, 279, 260, 44);
        this.getContentPane().add(hotelLabel);

        hotelstextArea = new JTextArea();
        hotelstextArea.setFont(new Font("Georgia", Font.PLAIN, 15));
        hotelstextArea.setBackground(new Color(245, 222, 179));
        hotelstextArea.setBounds(261, 294, 490, 218);
        this.getContentPane().add(hotelstextArea);

        JScrollPane scrollPane2 = new JScrollPane(hotelstextArea);
        scrollPane2.setBounds(261, 294, 490, 218);
        this.getContentPane().add(scrollPane2);

        hotelcomboBox = new JComboBox();
        hotelcomboBox.setBackground(new Color(210, 105, 30));
        hotelcomboBox.setFont(new Font("Georgia", Font.PLAIN, 15));
        hotelcomboBox.setBounds(10, 482, 237, 30);
        this.getContentPane().add(hotelcomboBox);

        reservationButton = new JButton("Make a reservation");
        reservationButton.setBackground(new Color(255, 215, 0));
        reservationButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        reservationButton.setBounds(551, 541, 260, 54);
        this.getContentPane().add(reservationButton);

        choose2Button = new JButton("Choose hotel");
        choose2Button.setBackground(new Color(255, 140, 0));
        choose2Button.setFont(new Font("Georgia", Font.PLAIN, 16));
        choose2Button.setBounds(10, 541, 237, 21);
        this.getContentPane().add(choose2Button);
        this.setVisible(true);
    }

    public String getchoosecomboBox() {
        return choosecomboBox.getSelectedItem().toString();

    }

    public void setchoosecomboBox(JComboBox choosecomboBox) {
        this.choosecomboBox = choosecomboBox;
    }

    public String gethotelcomboBox() {
        return hotelcomboBox.getSelectedItem().toString();
    }

    public void sethotelcomboBox(Object item) {
        this.hotelcomboBox.addItem(item);
    }

    public String hotelstextArea() {
        return hotelstextArea.getText();
    }

    public void clearhotelcomboBox() {
        this.hotelcomboBox.removeAllItems();

    }

    public void sethotelstextArea(String hotelstextArea) {
        this.hotelstextArea.setText(hotelstextArea);
    }

    public void clear() {
        hotelstextArea.setText(null);
    }

    public void addShowListener(ActionListener action) {
        chooseButton.addActionListener(action);
    }

    public void add2ShowListener(ActionListener action) {
        choose2Button.addActionListener(action);
    }

    public void addCreateListener(ActionListener action) {
        reservationButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
