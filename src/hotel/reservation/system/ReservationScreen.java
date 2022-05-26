/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dsa20
 */
public class ReservationScreen extends JFrame {

    private void SetProperties() {
        setSize(500, 500);
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

    public void ReserScreen() {
        Reservation_GUI res = new Reservation_GUI(this, clientId);
        appPanel.add(res.GetRoomNumberLabel());
        appPanel.add(res.GetRoomNumberField());
        appPanel.add(res.GetRoomTypeLabel());
        appPanel.add(res.GetRoomTypeField());
        appPanel.add(res.GetNumbOfBedLabel());
        appPanel.add(res.GetNumbOfBedField());
        appPanel.add(res.GetCheckInDateLabel());
        appPanel.add(res.GetCheckInDateField());
        appPanel.add(res.GetCheckOutDateLabel());
        appPanel.add(res.GetCheckOutDateField());
        appPanel.add(res.GetadditionalServiceLabel());
        appPanel.add(res.GetIdpaymentTypeLabel());
        appPanel.add(res.GetpaymentTypeField());
        appPanel.add(res.GetpaymentAmountField());
        appPanel.add(res.GetIdpaymentAmountLabel());
        appPanel.add(res.GetadditionalServiceField());
        appPanel.add(res.GetSaveButton());
        appPanel.add(res.GetBackTOHomeButton());
    }

    public ReservationScreen(String s, int clientId) {
        super(s);
        this.clientId = clientId;
        SetProperties();
        SetMainPanel();
        ReserScreen();
        //Set Properties
        setVisible(true);
    }

}
