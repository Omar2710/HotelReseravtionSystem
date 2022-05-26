/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer extends Thread {
    
    
    int port;

ServerSocket serversocket;

public ChatServer (int port) throws IOException {

this.port = port;

serversocket = new ServerSocket (port);

}

@Override

public void run() {

while (true) {
try {

Socket socketl=serversocket.accept();

PrintWriter outl= new PrintWriter (socketl.getOutputStream(), true);

BufferedReader inl= new BufferedReader (new InputStreamReader (socketl.getInputStream()));


Socket socket2 = serversocket.accept();

PrintWriter out2 =new PrintWriter (socket2.getOutputStream(), true); 

BufferedReader in2 = new BufferedReader (new InputStreamReader (socket2.getInputStream()));

String msgl, msg2;

new Thread (new Runnable () {

@Override

public void run () {

while (true) {

String msgl = "";

try {

msgl = inl.readLine();

} catch (IOException ex) {

Logger.getLogger (ChatServer.class.getName()).log (Level. SEVERE, null, ex);
    
}
out2.println(msgl);

out2.flush();
}
}
}).start();

new Thread (new Runnable() {

@Override

public void run () {

while (true) {

String msg1 = "";

   try {

          msg1 = in2.readLine();

       }catch (IOException ex) {

   Logger.getLogger (ChatServer.class.getName()).log(Level.SEVERE, null, ex);
    }
      outl.println(msg1); 
      outl.flush();
    }
  }
 }).start();

  } catch (IOException ex) {

    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
  }
}
