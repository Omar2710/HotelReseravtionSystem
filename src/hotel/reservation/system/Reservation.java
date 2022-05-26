/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author dsa20
 */
public class Reservation implements Serializable {

    public int roomNumber;
    public String roomtype;
    private String reservationNumber;
    private int numberOfBeds;
    private String checkinDate;
    private String checkoutDate;
    private String additionalServices;
    private int additionalServiceAmount;
    private int paymentId;
    private int paymentAmount;
    private String paymentType;
    private int clientId;

    public Reservation(int clientId) {
        this.clientId = clientId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAdditionalServiceAmount() {
        return additionalServiceAmount;
    }

    public void setAdditionalServiceAmount(int additionalServiceAmount) {
        this.additionalServiceAmount = additionalServiceAmount;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int id) {
        this.clientId = id;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public String setPaymentType(String paymentType) {
        return this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

//    public Rooms getRoom() {
//        return room;
//    }
//
//    public void setRoom(Rooms room) {
//        this.room = room;
//    }
    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;

    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

//    public String getreservationIfExists() {
//        String data = "";
//        try {
//            //Check if the directory exists
//            String directoryName = "data/Bookings/";
//            File directory = new File(directoryName);
//            //If the directory is not found then create it and its parents
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            //Check if the reservation file exists
//            File f = new File(directoryName + reservationNumber + ".txt");
//            if (f.exists()) {
//                Scanner read = new Scanner(f);
//                while (read.hasNextLine()) {
//                    data += read.nextLine() + "#";
//                }
//            }
//        } catch (Exception e) {
//            System.out.println();
//        }
//        return data;
//    }
//
//    public boolean saveDataToBookingFile() {
//        try {
//            String fileName = directoryName + reservationNumber + ".txt";
//            File file = new File(fileName);
//            PrintWriter w = new PrintWriter(file);
//            w.print(reservationNumber);
//            w.println();
//            w.write(checkinDate);
//            w.println();
//            w.print(checkoutDate);
//            w.println();
//            w.print(roomtype);
//            w.println();
//            w.print(paymentType);
//            w.println();
//            w.print(paymentId);
//            w.println();
//            w.print(paymentAmount);
//            w.println();
//            w.print(additionalServiceAmount);
//            w.println();
//            w.print(additionalServiceAmount + paymentAmount);
//            w.close();
//            return true;
//            //}
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return false;
//    }
    public int getTotalAmount() {
        return additionalServiceAmount + paymentAmount;
    }

    public String getAdditionalServices() {
        return this.additionalServices;
    }

    public void addAdditionalservice(String additionalServices) {

        switch (additionalServices) {
            case "gym":
                additionalServiceAmount = 100;
                break;
            case "wifi":
                additionalServiceAmount = 30;
                break;
            case "safari":
                additionalServiceAmount = 600;
                break;
            case "gym&wifi":
                additionalServiceAmount = 130;
                break;
            case "wifi&gym":
                additionalServiceAmount = 130;
                break;
            case "wifi&safari":
                additionalServiceAmount = 630;
                break;
            case "safari&wifi":
                additionalServiceAmount = 630;
                break;
            case "gym&safari":
                additionalServiceAmount = 700;
                break;
            case "safari&gym":
                additionalServiceAmount = 700;
                break;
            case "all":
                additionalServiceAmount = 730;
                break;
        }

    }
}
