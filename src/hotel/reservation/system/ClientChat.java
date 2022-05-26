/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.PrintWriter;
//import java.lang.System.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ClientChat extends JFrame implements Runnable {
    
    Socket socket;

int port;

String name;

JTextArea textArea = new JTextArea (40, 50);

public ClientChat (int port, String name) throws IOException {

this.port = port;

this.name = name;

socket = new Socket ("localhost", port);

setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

setSize (600, 800);

JPanel panel = new JPanel();

textArea.setEditable (false);

textArea.setLineWrap (true);


JTextField textField = new JTextField (40);
JButton button = new JButton ("send");



button.addActionListener (e->{

try {

String str = textField.getText();

PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

out.println(str);

 textArea.append("--" + str + " {::SENT) " + "\n");
 textField.setText("");



} catch (IOException ex) {

Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
}
});

JScrollPane scrollpane = new JScrollPane (textArea);

panel.add(scrollpane);
panel.add (textField);
panel.add (button);

add(panel);

setVisible (true);
}
@Override

public void run () {

try {

while (true) {

BufferedReader bf = new BufferedReader(new InputStreamReader (socket.getInputStream()));

String str = "";

str=bf.readLine();

textArea.append("--" + str + " (:: RECEIVED)" + "\n");

System.out.println("sent message");
}
} catch (IOException ex) {

Logger.getLogger (ClientChat.class.getName()).log(Level.SEVERE, null, ex);
  
      
}
}
}
    
    
    
    

