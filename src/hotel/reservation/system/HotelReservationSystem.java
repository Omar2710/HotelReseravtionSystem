/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.reservation.system;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NullPointerException;
import java.util.HashMap;
import java.util.HashSet;

public class HotelReservationSystem {

    public static void main(String[] args) throws IOException {
        LoginScreen app = new LoginScreen("Hotel Reservation System");
        
         ChatServer server = new ChatServer(6969);
        server.start();
        ClientChat client1 = new ClientChat (6969 , "client1");
        ClientChat client2 = new ClientChat (6969 , "client2");
        
        Thread t1 = new Thread(client1);
        Thread t2 = new Thread(client2);
        t1.start();
        t2.start();
        
    }
}
