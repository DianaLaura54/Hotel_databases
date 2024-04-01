package mysql.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PickView extends JFrame {
    private JButton goBackButton;
    private JLabel roomLabel;
    private JTextArea roomstextArea;
    private JButton showButton;
    private JLabel insertLabel;
    private JButton bookingButton;
    private JTextField nrtextField;

    public PickView() {
        this.setResizable(false);
        this.setBounds(100, 100, 887, 664);
        this.getContentPane().setForeground(new Color(128, 0, 0));
        this.getContentPane().setBackground(new Color(178, 34, 34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        goBackButton = new JButton("Go back");
        goBackButton.setBackground(new Color(255, 255, 0));
        goBackButton.setForeground(new Color(0, 0, 0));
        goBackButton.setFont(new Font("Georgia", Font.PLAIN, 25));
        goBackButton.setBounds(59, 503, 178, 58);
        this.getContentPane().add(goBackButton);

        roomLabel = new JLabel("Please pick an available room for a booking");
        roomLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
        roomLabel.setBounds(174, 31, 502, 65);
        this.getContentPane().add(roomLabel);

        roomstextArea = new JTextArea();
        roomstextArea.setBackground(new Color(255, 228, 196));
        roomstextArea.setFont(new Font("Georgia", Font.PLAIN, 20));
        roomstextArea.setBounds(425, 143, 415, 449);
        this.getContentPane().add(roomstextArea);

        JScrollPane scrollPane2 = new JScrollPane(roomstextArea);
        scrollPane2.setBounds(425, 143, 415, 449);
        this.getContentPane().add(scrollPane2);

        showButton = new JButton("Show");
        showButton.setBackground(new Color(255, 140, 0));
        showButton.setFont(new Font("Georgia", Font.PLAIN, 15));
        showButton.setBounds(576, 106, 99, 21);
        this.getContentPane().add(showButton);

        insertLabel = new JLabel("Insert the id of the room");
        insertLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        insertLabel.setBounds(38, 143, 261, 58);
        this.getContentPane().add(insertLabel);

        nrtextField = new JTextField();
        nrtextField.setFont(new Font("Georgia", Font.PLAIN, 10));
        nrtextField.setBackground(new Color(255, 228, 181));
        nrtextField.setBounds(60, 211, 158, 21);
        this.getContentPane().add(nrtextField);
        nrtextField.setColumns(10);

        bookingButton = new JButton("Booking");
        bookingButton.setBackground(new Color(255, 165, 0));
        bookingButton.setForeground(new Color(0, 0, 0));
        bookingButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        bookingButton.setBounds(59, 271, 158, 33);
        this.getContentPane().add(bookingButton);

        this.setVisible(true);
    }

    public String getroomstextArea() {
        return roomstextArea.getText();
    }

    public void setroomstextArea(String roomstextArea) {
        this.roomstextArea.setText(roomstextArea);
    }

    public int getnrtextField() {
        return Integer.parseInt(nrtextField.getText());
    }

    public void setnrtextField(int nrtextField) {

        this.nrtextField.setText(String.valueOf(nrtextField));
    }

    public void addShowListener(ActionListener action) {
        goBackButton.addActionListener(action);
    }

    public void addShowListener2(ActionListener action) {
        showButton.addActionListener(action);
    }

    public void addCreateListener(ActionListener action) {
        bookingButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
