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
public class AddNewClientScreen extends JFrame {

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

    private void AddNewClientGUIScreen() {
        AddNewClient_GUI screen = new AddNewClient_GUI(this);
        appPanel.add(screen.GetFirstNameLabel());
        appPanel.add(screen.GetFirstNameField());
        appPanel.add(screen.GetLastNameLabel());
        appPanel.add(screen.GetLastNameField());
        appPanel.add(screen.GetGenderLabel());
        appPanel.add(screen.GetGenderField());
        appPanel.add(screen.GetAgeLabel());
        appPanel.add(screen.GetAgeField());
        appPanel.add(screen.GetAreaLabel());
        appPanel.add(screen.GetAreaField());
        appPanel.add(screen.GetPhoneLabel());
        appPanel.add(screen.GetPhoneField());
        appPanel.add(screen.GetIdNumberField());
        appPanel.add(screen.GetIdNumberLabel());
        appPanel.add(screen.GetSaveButton());
        appPanel.add(screen.GetBackTOHomeButton());
    }

    public AddNewClientScreen(String s) {
        super(s);
        SetProperties();
        SetMainPanel();
        AddNewClientGUIScreen();
        //Set Properties
        setVisible(true);
    }
}
