/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class Home_GUI {

    private JFrame mainFrame;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addNewButton;
    DataFileManager fileManager;

    public Home_GUI(JFrame frame) {
        mainFrame = frame;
        searchButton = new JButton("Search");
        addNewButton = new JButton("Add New Client");
        SetActionListeners();
        fileManager = new DataFileManager();
    }

    public Collection<Reservation> GetTodayReservations() {
        Collection<Reservation> reservations = fileManager.GetTodayCheckoutReservations();
        return reservations;
    }

    public JLabel GetReservationsTitle() {
        JLabel title = new JLabel("Guests Checking Out Soon");
        title.setFont(new Font("Serif", Font.BOLD, 18));
        title.setBounds(20, 100, 300, 25);
        return title;
    }

    public JLabel GetReservation(Reservation res, int yAxis) {
        JLabel title = new JLabel("Res#: " + res.getReservationNumber() + " | Checkin Date: " + res.getCheckinDate() + " | Checkout Date: " + res.getCheckoutDate() + " | Room #: " + res.getRoomNumber());
        title.setFont(new Font("Serif", Font.PLAIN, 15));
        title.setBounds(20, yAxis, 550, 25);
        return title;
    }

    public JLabel GetSearchLabel() {
        JLabel searchLabel = new JLabel("Search");
        searchLabel.setBounds(20, 50, 50, 25);
        return searchLabel;
    }

    public JTextField GetSearchField() {
        searchField = new JTextField();
        searchField.setBounds(70, 50, 180, 25);
        return searchField;
    }

    public JButton GetSearchButton() {
        searchButton.setBounds(255, 50, 80, 25);
        return searchButton;
    }

    public JButton GetAddNewButton() {
        addNewButton.setBounds(340, 50, 140, 25);
        return addNewButton;
    }

    private void SetActionListeners() {
        addNewButton.addActionListener(new AddNewActionListener());
        searchButton.addActionListener(new SearchActionListener());
    }

    private Client SearchForClient(int Id) {
        HashMap<Integer, Client> clients = fileManager.ReadClients();
        return clients.getOrDefault(Id, null);
    }

    private boolean IsInvalid() {
        return searchField.getText().equals("");

    }

    private class SearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (IsInvalid()) {
                JOptionPane.showMessageDialog(mainFrame, "Make sure all fields are entered !");
                return;
            }
            int clientId = Integer.valueOf(searchField.getText());
            Client client = SearchForClient(clientId);
            if (client == null) {
                JOptionPane.showMessageDialog(mainFrame, "Client doesn't exist!");
            } else {
                mainFrame.setVisible(false);
                ClientScreen screen = new ClientScreen(mainFrame.getTitle(), clientId);
            }

        }
    }

    private class AddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            AddNewClientScreen screen = new AddNewClientScreen(mainFrame.getTitle());
        }
    }
}
