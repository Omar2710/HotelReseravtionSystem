/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class LoginScreen extends JFrame {

    private void SetProperties() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel appPanel;

    private void SetMainPanel() {
        appPanel = new JPanel();
        add(appPanel);
        appPanel.setLayout(null);
    }

    private void LoginGUIScreen() {
        Login_GUI login = new Login_GUI(this);
        appPanel.add(login.GetTitle());
        appPanel.add(login.GetUserLabel());
        appPanel.add(login.GetPasswordLabel());
        appPanel.add(login.GetUserField());
        appPanel.add(login.GetPasswordField());
        appPanel.add(login.GetLoginButton());
    }

    public LoginScreen(String s) {
        super(s);
        SetProperties();
        SetMainPanel();
        LoginGUIScreen();
        //Set Properties
        setVisible(true);
    }
}
