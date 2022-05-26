/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class Login_GUI {

    private JFrame mainFrame;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login_GUI(JFrame frame) {
        mainFrame = frame;
        loginButton = new JButton("Login");
        SetActionListener();
    }

    public JLabel GetTitle() {
        JLabel title = new JLabel("Welcome to Hotel Reservation System");
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(100, 100, 300, 25);
        return title;
    }

    public JLabel GetUserLabel() {
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(70, 150, 80, 25);
        return userLabel;
    }

    public JLabel GetPasswordLabel() {
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 200, 80, 25);
        return passwordLabel;
    }

    public JTextField GetUserField() {
        userField = new JTextField();
        userField.setBounds(150, 150, 150, 25);
        return userField;
    }

    public JPasswordField GetPasswordField() {
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 150, 25);
        return passwordField;
    }

    public JButton GetLoginButton() {
        loginButton.setBounds(150, 250, 150, 25);
        return loginButton;
    }

    public void SetActionListener() {
        loginButton.addActionListener(new LoginActionListener());
    }

    private class LoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Receptionist receptionist = new Receptionist();
            receptionist.setUserName(userField.getText());
            receptionist.setPassword(String.valueOf(passwordField.getPassword()));
            if (receptionist.CheckIfAdmin()) {
                JOptionPane.showMessageDialog(mainFrame, "You are successfully logged in.");
                mainFrame.setVisible(false);
                HomeScreen homeScreen = new HomeScreen(mainFrame.getTitle());
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Failed to login.");
            }
        }

    }

}
