/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class Client_GUI {

    private JFrame mainFrame;
    private Client client;
    private DataFileManager fileManager;
    private JButton addNew;
    private int clientId;
    private JButton goToHome;

    public Client_GUI(JFrame frame, int clientId) {
        mainFrame = frame;
        fileManager = new DataFileManager();
        addNew = new JButton("Add New Reservation");
        goToHome = new JButton("Back");
        SetActionListeners();
        client = fileManager.GetClient(clientId);
        this.clientId = clientId;
    }

    public JLabel GetName() {
        JLabel title = new JLabel("Name: " + client.getFirstname() + " " + client.getLastname());
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(20, 20, 300, 25);
        return title;
    }

    public JLabel GetGender() {
        JLabel title = new JLabel("Gender: " + client.getGender());
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(20, 60, 300, 25);
        return title;
    }

    public JLabel GetAge() {
        JLabel title = new JLabel("Age: " + client.getAge());
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(20, 100, 300, 25);
        return title;
    }

    public JLabel GetArea() {
        JLabel title = new JLabel("Area: " + client.getarea());
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(20, 140, 300, 25);
        return title;
    }

    public JLabel GetPhone() {
        JLabel title = new JLabel("Phone: " + client.getPhoneNumber());
        title.setFont(new Font("Serif", Font.PLAIN, 18));
        title.setBounds(20, 180, 300, 25);
        return title;
    }

    public Collection<Reservation> GetClientReservations() {
        Collection<Reservation> reservations = client.GetReservations().values();
        return reservations;
    }

    public JLabel GetReservation(Reservation res, int yAxis) {
        JLabel title = new JLabel("Res#: " + res.getReservationNumber() + " | Checkin Date: " + res.getCheckinDate() + " | Checkout Date: " + res.getCheckoutDate() + " | Room #: " + res.getRoomNumber());
        title.setFont(new Font("Serif", Font.PLAIN, 15));
        title.setBounds(20, yAxis, 500, 25);
        return title;
    }

    public JLabel GetReservationsTitle() {
        JLabel title = new JLabel("Reservations");
        title.setFont(new Font("Serif", Font.BOLD, 18));
        title.setBounds(20, 215, 300, 25);
        return title;
    }

    public JButton GetAddNewReservationButton() {
        addNew.setBounds(300, 400, 180, 25);
        return addNew;
    }

    public JButton GetBackTOHomeButton() {
        goToHome.setBounds(20, 400, 120, 25);
        return goToHome;
    }

    private void SetActionListeners() {
        addNew.addActionListener(new AddNewActionListener());
        goToHome.addActionListener(new GoToHomeActionListener());
    }

    private class GoToHomeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            HomeScreen home = new HomeScreen(mainFrame.getTitle());
        }
    }

    private class AddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            ReservationScreen screen = new ReservationScreen(mainFrame.getTitle(), client.getIDnumber());
        }
    }
}
