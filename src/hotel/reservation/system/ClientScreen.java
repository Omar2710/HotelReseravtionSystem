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
public class ClientScreen extends JFrame {

    private void SetProperties() {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel appPanel;
    private int clientId;

    private void SetMainPanel() {
        appPanel = new JPanel();
        add(appPanel);
        appPanel.setLayout(null);
    }

    private void ClientGUIScreen() {
        Client_GUI screen = new Client_GUI(this, clientId);
        appPanel.add(screen.GetName());
        appPanel.add(screen.GetGender());
        appPanel.add(screen.GetAge());
        appPanel.add(screen.GetPhone());
        appPanel.add(screen.GetArea());
        appPanel.add(screen.GetAddNewReservationButton());
        appPanel.add(screen.GetBackTOHomeButton());
        appPanel.add(screen.GetReservationsTitle());
        int yAxis = 240;
        for (Reservation res : screen.GetClientReservations()) {
            appPanel.add(screen.GetReservation(res, yAxis));
            yAxis += 20;
        }
    }

    public ClientScreen(String s, int clientId) {
        super(s);
        this.clientId = clientId;
        SetProperties();
        SetMainPanel();
        ClientGUIScreen();
        //Set Properties
        setVisible(true);
    }
}
