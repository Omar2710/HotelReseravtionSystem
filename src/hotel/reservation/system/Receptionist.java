/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.reservation.system;

/**
 *
 * @author Mohamed ashraf
 */
public class Receptionist {

    private String userName;
    private String Password;

    public Receptionist() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean CheckIfAdmin() {
        if (userName.equals("admin") && Password.equals("123")) {
            return true;
        }
        return false;
    }
}
