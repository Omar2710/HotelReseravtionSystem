/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author yaya1
 */
public class AddNewClient_GUI {

    private JFrame mainFrame;
    private JTextField idNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField age;
    private JTextField gender;
    private JButton goToHome;
    private JTextField phoneNumber;
    private JTextField area;
    private JButton saveButton;
    private DataFileManager fileManager;

    public AddNewClient_GUI(JFrame frame) {
        mainFrame = frame;
        saveButton = new JButton("Save Client");
        goToHome = new JButton("Back");
        fileManager = new DataFileManager();
        SetActionListener();
    }

    private boolean IsInvalid() {
        return firstName.getText().equals("")
                ||  age.getText().equals("")
                || idNumber.getText().equals("")
                || lastName.getText().equals("")
                || gender.getText().equals("")
                || phoneNumber.getText().equals("")
                || area.getText().equals("");
    }

    public JLabel GetFirstNameLabel() {
        JLabel label = new JLabel("First name:");
        label.setBounds(20, 20, 150, 25);
        return label;
    }

    public JTextField GetFirstNameField() {
        firstName = new JTextField();
        firstName.setBounds(115, 20, 150, 25);
        return firstName;
    }

    public JLabel GetLastNameLabel() {
        JLabel label = new JLabel("Last name:");
        label.setBounds(20, 50, 150, 25);
        return label;
    }

    public JTextField GetLastNameField() {
        lastName = new JTextField();
        lastName.setBounds(115, 50, 150, 25);
        return lastName;
    }

    public JLabel GetAgeLabel() {
        JLabel label = new JLabel("Age:");
        label.setBounds(20, 80, 150, 25);
        return label;
    }

    public JTextField GetAgeField() {
        age = new JTextField();
        age.setBounds(115, 80, 150, 25);
        return age;
    }

    public JLabel GetGenderLabel() {
        JLabel label = new JLabel("Gender:");
        label.setBounds(20, 110, 150, 25);
        return label;
    }

    public JTextField GetGenderField() {
        gender = new JTextField();
        gender.setBounds(115, 110, 150, 25);
        return gender;
    }

    public JLabel GetPhoneLabel() {
        JLabel label = new JLabel("Phone Number:");
        label.setBounds(20, 140, 150, 25);
        return label;
    }

    public JTextField GetPhoneField() {
        phoneNumber = new JTextField();
        phoneNumber.setBounds(115, 140, 150, 25);
        return phoneNumber;
    }

    public JLabel GetAreaLabel() {
        JLabel label = new JLabel("Area:");
        label.setBounds(20, 170, 150, 25);
        return label;
    }

    public JTextField GetAreaField() {
        area = new JTextField();
        area.setBounds(115, 170, 150, 25);
        return area;
    }

    public JLabel GetIdNumberLabel() {
        JLabel label = new JLabel("Id Number:");
        label.setBounds(20, 200, 150, 25);
        return label;
    }

    public JTextField GetIdNumberField() {
        idNumber = new JTextField();
        idNumber.setBounds(115, 200, 150, 25);
        return idNumber;
    }

    public JButton GetSaveButton() {
        saveButton.setBounds(350, 400, 120, 25);
        return saveButton;
    }

    public JButton GetBackTOHomeButton() {
        goToHome.setBounds(20, 400, 120, 25);
        return goToHome;
    }

    public void SetActionListener() {
        saveButton.addActionListener(new SaveActionListener());
        goToHome.addActionListener(new GoToHomeActionListener());
    }

    private Client GetClient(int Id) {
        HashMap<Integer, Client> clients = fileManager.ReadClients();
        Client client = clients.getOrDefault(Id, null);
        return client;
    }

    private class GoToHomeActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);
            HomeScreen home = new HomeScreen(mainFrame.getTitle());
        }
    }

    private class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             if (IsInvalid()) {
                JOptionPane.showMessageDialog(mainFrame, "Make sure all fields are entered !");
                return;
             }
            HashMap<Integer, Client> clients = fileManager.ReadClients();
            int clientId = Integer.valueOf(idNumber.getText());
            Client client = GetClient(clientId);
            if (client != null) {
                JOptionPane.showMessageDialog(mainFrame, "Client already exists");
            } else {
                client = new Client();
                client.setFirstname(firstName.getText());
                client.setLastname(lastName.getText());
                client.setAge(Integer.valueOf(age.getText()));
                client.setarea(area.getText());
                client.setGender(gender.getText());
                client.setPhoneNumber(phoneNumber.getText());
                clients.put(clientId, client);
                boolean dataSaved = fileManager.SaveClients(clients);
                if (dataSaved) {
                    JOptionPane.showMessageDialog(mainFrame, "Client added successfully !");
                    mainFrame.setVisible(false);
//                    HomeScreen home = new HomeScreen(mainFrame.getTitle());
                    ReservationScreen r = new ReservationScreen(mainFrame.getTitle(), clientId);
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Failed to save data !");
                }
            }
        }

    }
}
