/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class HomeScreen extends JFrame {

    private void SetProperties() {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel appPanel;

    private void SetMainPanel() {
        appPanel = new JPanel();
        add(appPanel);
        appPanel.setLayout(null);
    }

    private void HomeGUIScreen() {
        Home_GUI home = new Home_GUI(this);
        appPanel.add(home.GetSearchLabel());
        appPanel.add(home.GetSearchField());
        appPanel.add(home.GetSearchButton());
        appPanel.add(home.GetAddNewButton());
        appPanel.add(home.GetReservationsTitle());
        int yAxis = 130;
        for (Reservation res : home.GetTodayReservations()) {
            appPanel.add(home.GetReservation(res, yAxis));
            yAxis += 20;
        }
    }

    public HomeScreen(String s) {
        super(s);
        SetProperties();
        SetMainPanel();
        HomeGUIScreen();
        //Set Properties
        setVisible(true);
    }
}
