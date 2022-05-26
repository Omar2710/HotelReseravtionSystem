/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author dsa20
 */
public class Client implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private int IDnumber;
    private String area;
    private String phoneNumber;
    private String gender;
    private final HashMap<String, Reservation> reservations;

    public Client() {
        reservations = new HashMap<>();
    }

    public Reservation FindReservation(int resNum) {
        return this.reservations.getOrDefault(resNum, null);
    }

    public void AddReservation(Reservation res) {
        this.reservations.put(res.getReservationNumber(), res);
    }
    
    public HashMap<String, Reservation> GetReservations() {
        return this.reservations;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getGender() {
        return this.gender;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String Lastname) {
        this.lastName = Lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getarea() {
        return area;
    }

    public void setarea(String area) {
        this.area = area;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
