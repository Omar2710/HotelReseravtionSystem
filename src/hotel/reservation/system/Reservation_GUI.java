/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dsa20
 */
public class Reservation_GUI {

    private Client client;
    private int clientId;
    private DataFileManager fileManager;
    private JFrame mainFrame;
    private JTextField searchField;
    private JButton saveNewButton;
    private JTextField reserNumber;
    private JComboBox roomNum;
    private JComboBox roomType;
    private JTextField numbOfBed;
    private JComboBox checkInDate;
    private JComboBox checkOutDate;
    private JComboBox additionalService;
    private JTextField paymentID;
    private JComboBox paymentType;
    private JTextField paymentAmount;
    private JButton saveButton;
    private JButton goToHome;

    private String roomTypes[] = {"", "Single", "Double", "Suite"};
    private String additionalServices[] = {"", "Gym", "Wifi", "Safari", "Gym + Wifi", "Gym + Safari", "Wifi + Safari", "Gym + Wifi + Safari"};

    public Reservation_GUI(JFrame frame, int clientId) {
        mainFrame = frame;
        saveNewButton = new JButton("Save");
        goToHome = new JButton("Back");
        roomType = new JComboBox(roomTypes);
        additionalService = new JComboBox(additionalServices);
        SetActionListeners();
        fileManager = new DataFileManager();
        client = fileManager.GetClient(clientId);
        this.clientId = clientId;
    }

    public JButton GetSaveButton() {
        saveNewButton.setBounds(350, 400, 80, 25);
        return saveNewButton;
    }

    public JLabel GetCheckInDateLabel() {
        JLabel label = new JLabel("Check in date: ");
        label.setBounds(20, 140, 150, 25);
        return label;
    }

    public JComboBox GetCheckInDateField() {
        String s[] = {"", "11-01-2022", "12-01-2022", "13-01-2022", "14-01-2022", "15-01-2022", "16-01-2022", "17-01-2022", "18-01-2022", "19-01-2022", "20-01-2022", "21-01-2022", "22-01-2022"};
        checkInDate = new JComboBox(s);
        checkInDate.setBounds(146, 140, 150, 25);
        return checkInDate;
    }

    public JLabel GetRoomNumberLabel() {
        JLabel label = new JLabel("Room Number: ");
        label.setBounds(20, 50, 150, 25);
        return label;
    }

   public JComboBox GetRoomNumberField() {
        String s[] = {"", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "2010", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"};
        roomNum = new JComboBox(s);
        roomNum.setBounds(146, 50, 150, 25);
        return roomNum;
    }

    public JLabel GetRoomTypeLabel() {
        JLabel label = new JLabel("RoomType: ");
        label.setBounds(20, 80, 150, 25);
        return label;
    }

    public JComboBox GetRoomTypeField() {
         JComboBox roomType = new JComboBox(new String []{"single" , "double" , "suite" });
        roomType.setBounds(146, 80, 150, 25);
        return roomType;
    }

    public JLabel GetNumbOfBedLabel() {
        JLabel label = new JLabel("Number of beds: ");
        label.setBounds(20, 110, 150, 25);
        return label;
    }

    public JTextField GetNumbOfBedField() {
        numbOfBed = new JTextField();
        numbOfBed.setBounds(146, 110, 150, 25);
        return numbOfBed;
    }

    public JLabel GetCheckOutDateLabel() {
        JLabel label = new JLabel("Check out date: ");
        label.setBounds(20, 170, 150, 25);

        return label;
    }

    public JComboBox GetCheckOutDateField() {
        String s[] = {"", "11-01-2022", "12-01-2022", "13-01-2022", "14-01-2022", "15-01-2022", "16-01-2022", "17-01-2022", "18-01-2022", "19-01-2022", "20-01-2022", "21-01-2022", "22-01-2022"};
        checkOutDate = new JComboBox(s);
        checkOutDate.setBounds(146, 170, 150, 25);
        return checkOutDate;
    }

    public JLabel GetIdpaymentTypeLabel() {
        JLabel label = new JLabel("Payment Type:");
        label.setBounds(20, 260, 150, 25);
        return label;
    }

    public JComboBox GetpaymentTypeField() {
        String s[] = {"", "Visa", "Cash"};
        paymentType = new JComboBox(s);
        paymentType.setBounds(146, 260, 150, 25);

        return paymentType;
    }

    public JLabel GetIdpaymentAmountLabel() {
        JLabel label = new JLabel("Payment Amount:");
        label.setBounds(20, 230, 150, 25);
        return label;
    }

    public JTextField GetpaymentAmountField() {
        paymentAmount = new JTextField();
        paymentAmount.setBounds(146, 230, 150, 25);
        return paymentAmount;
    }

    public JLabel GetadditionalServiceLabel() {
        JLabel label = new JLabel("Additional Service:");
        label.setBounds(20, 200, 150, 25);

        return label;
    }

    public JComboBox GetadditionalServiceField() {

        additionalService.setBounds(146, 200, 150, 25);
        return additionalService;
    }

    public JButton GetBackTOHomeButton() {
        goToHome.setBounds(20, 400, 120, 25);
        return goToHome;
    }

    private void SetActionListeners() {
        saveNewButton.addActionListener(new SaveActionListener());
        goToHome.addActionListener(new GoToHomeActionListener());
        roomType.addActionListener(new CalculatePaymentActionListener());
        additionalService.addActionListener(new CalculatePaymentActionListener());
    }

    private class CalculatePaymentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String roomTypeSelected = (String) roomType.getSelectedItem();
            String additionalServiceSelected = (String) additionalService.getSelectedItem();
            int paymentTotal = 0;
            if (roomTypeSelected.equals("Single")) {
                paymentTotal += 1000;
                numbOfBed.setText("1");
            } else if (roomTypeSelected.equals("Double")) {
                paymentTotal += 2000;
                numbOfBed.setText("2");
            } else {
                paymentTotal += 4000;
                numbOfBed.setText("4");
            }
            // Additonal
            switch (additionalServiceSelected) {
                case "Gym":
                    paymentTotal += 100;
                    break;
                case "Wifi":
                    paymentTotal += 30;
                    break;
                case "Safari":
                    paymentTotal += 600;
                    break;
                case "Gym + Wifi":
                    paymentTotal += 130;
                    break;
                case "Gym + Safari":
                    paymentTotal += 130;
                    break;
                case "Wifi + Safari":
                    paymentTotal += 630;
                    break;
                case "Gym + Wifi + Safari":
                    paymentTotal += 730;
                    break;
            }
            paymentAmount.setText(String.valueOf(paymentTotal));
        }
    }

    private class GoToHomeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            HomeScreen home = new HomeScreen(mainFrame.getTitle());
        }
    }

    private boolean IsInvalid() {
        return ((String) roomNum.getSelectedItem()).equals("")
                || ((String) checkInDate.getSelectedItem()).equals("")
                || ((String) checkOutDate.getSelectedItem()).equals("")
                || numbOfBed.getText().equals("")
                || paymentAmount.getText().equals("")
                || ((String) paymentType.getSelectedItem()).equals("")
                || ((String) roomType.getSelectedItem()).equals("");
    }

    private class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (IsInvalid()) {
                JOptionPane.showMessageDialog(mainFrame, "Make sure all fields are entered !");
                return;
            }
            String roomNumberSelected = (String) roomNum.getSelectedItem();
            String checkinDateSelected = (String) checkInDate.getSelectedItem();
            String checkoutDateSelected = (String) checkOutDate.getSelectedItem();
            String paymentTypeDateSelected = (String) paymentType.getSelectedItem();
            String roomTypeDateSelected = (String) roomType.getSelectedItem();
            String addAdditionalservice = (String) additionalService.getSelectedItem();
            // Check if reservation is available to book room, and date
            Reservation res = fileManager.GetReservationByDateRoomNum(Integer.valueOf(roomNumberSelected), checkinDateSelected);
            // Reservetion exists with same room, and same check-in date.
            if (res != null) {
                JOptionPane.showMessageDialog(mainFrame, "Reservation with same room and date already exists !");
            } else {
                client.setIDnumber(clientId);
                res = new Reservation(clientId);
                res.setCheckinDate(checkinDateSelected);
                res.setCheckoutDate(checkoutDateSelected);
                res.setNumberOfBeds(Integer.valueOf(numbOfBed.getText()));
                res.setPaymentAmount(Integer.valueOf(paymentAmount.getText()));
                res.setPaymentType(paymentTypeDateSelected);
                res.setRoomNumber(Integer.valueOf(roomNumberSelected));
                res.setRoomtype(roomTypeDateSelected);
                res.setReservationNumber(client.getIDnumber() + "_" + GetRandomNumber() + "_" + client.getFirstname());
                res.addAdditionalservice(addAdditionalservice);
                //Add reservation to the client
                client.AddReservation(res);
                boolean dataSaved = fileManager.SaveReservation(res) && fileManager.SaveClient(client);

                if (dataSaved) {
                    JOptionPane.showMessageDialog(mainFrame, "Reservation done successfully !");
                    mainFrame.setVisible(false);
                    HomeScreen home = new HomeScreen(mainFrame.getTitle());

                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Failed to reserve !");
                }

            }

        }
    }

    private int GetRandomNumber() {
        int min = 1;
        int max = 1000;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
