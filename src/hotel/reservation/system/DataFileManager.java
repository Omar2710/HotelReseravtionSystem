/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.awt.List;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author dsa20
 */
public class DataFileManager {

    private final String clientsFile = "data_clients.bin";
    private final String reservationsFile = "data_reservations.bin";

    public boolean SaveClients(HashMap<Integer, Client> data) {
        File file = new File(clientsFile);
        try (FileOutputStream fileStream = new FileOutputStream(file);
                ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);) {
            objectStream.writeObject(data);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public HashMap<Integer, Client> ReadClients() {
        HashMap<Integer, Client> data = null;
        File file = new File(clientsFile);
        try (FileInputStream fileStream = new FileInputStream(file);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);) {
            data = (HashMap<Integer, Client>) objectStream.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //If we reached this far and still null, then initialize with empty
        if (data == null) {
            data = new HashMap<Integer, Client>();
        }
        return data;
    }

    private boolean SaveReservations(HashMap<String, Reservation> data) {
        File file = new File(reservationsFile);
        try (FileOutputStream fileStream = new FileOutputStream(file);
                ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);) {
            objectStream.writeObject(data);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private HashMap<String, Reservation> ReadReservations() {
        HashMap<String, Reservation> data = null;
        File file = new File(reservationsFile);
        try (FileInputStream fileStream = new FileInputStream(file);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);) {
            data = (HashMap<String, Reservation>) objectStream.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //If we reached this far and still null, then initialize with empty
        if (data == null) {
            data = new HashMap<String, Reservation>();
        }
        return data;
    }

    public Collection<Reservation> GetTodayCheckoutReservations() {
        Collection<Reservation> reservationsFound = new ArrayList<Reservation>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        HashMap<String, Reservation> reservations = this.ReadReservations();
        for(Reservation r : reservations.values()){
            if(r.getCheckoutDate().equals(today)){
                reservationsFound.add(r);
            }
        }
        return reservationsFound;
    }

    public Reservation GetReservation(int reservationNum) {
        HashMap<String, Reservation> reservations = this.ReadReservations();
        return reservations.getOrDefault(reservationNum, null);
    }

    public boolean SaveReservation(Reservation r) {
        HashMap<String, Reservation> reservations = this.ReadReservations();
        reservations.put(r.getReservationNumber(), r);
        return SaveReservations(reservations);
    }

    public Reservation GetReservationByDateRoomNum(int roomNum, String checkinDate) {
        HashMap<String, Reservation> reservations = this.ReadReservations();
        for (Reservation res : reservations.values()) {
            if (res.getRoomNumber() == roomNum && res.getCheckinDate().equals(checkinDate)) {
                return res;
            }
        }
        return null;
    }

    public Client GetClient(int clientId) {
        HashMap<Integer, Client> clients = this.ReadClients();
        return clients.getOrDefault(clientId, null);
    }

    public boolean SaveClient(Client c) {
        HashMap<Integer, Client> clients = this.ReadClients();
        clients.put(c.getIDnumber(), c);
        return SaveClients(clients);
    }
}
