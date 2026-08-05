/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package counselormgmtsystem;

/**
 *
 * @author tzhen
 */

public class Counselor extends User {
    protected String specialization;
    protected String contactNumber;
    protected String email;


    public Counselor(String ID, String username, String password, String fullName, String status, String specialization, String contactNumber, String email) {
        super(ID, username, password, fullName, status);
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.email = email;
    }


    public Counselor(String ID, String username, String password, String fullName) {
        super(ID, username, password, fullName, "Available");
        this.specialization = "General Counseling";
        this.contactNumber = "Not Set";
        this.email = "Not Set";
    }

    public String toFileLine() {
        return ID + "|" + specialization + "|" + contactNumber + "|" + email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
