/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package counselormgmtsystem;

import java.util.ArrayList;

public class ConsultationRecords {
    String recordID;
    String appointmentID;
    String studentID;
    String counselorID;
    String date;
    String notes;
    String recommendations;

   
    public ConsultationRecords(String recordID, String appointmentID, String studentID,
                               String counselorID, String date,
                               String notes, String recommendations) {
        this.recordID = recordID;
        this.appointmentID = appointmentID;
        this.studentID = studentID;
        this.counselorID = counselorID;
        this.date = date;
        this.notes = notes;
        this.recommendations = recommendations;
    }

    
    public void displayRecord() {
        System.out.println("===== Consultation Record =====");
        System.out.println("Record ID: " + recordID);
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Student ID: " + studentID);
        System.out.println("Counselor ID: " + counselorID);
        System.out.println("Date: " + date);
        System.out.println("Notes: " + notes);
        System.out.println("Recommendation: " + recommendations);
    }

    
    public String toFileLine() {
        return recordID + "|" + appointmentID + "|" + studentID + "|" + counselorID + "|"
                + date + "|" + notes + "|" + recommendations;
    }

    
    public static void viewRecordsByCounselor(ArrayList<ConsultationRecords> consultList, String counselorID) {
        System.out.println("===== Consultation Records for " + counselorID + " =====");

        for (ConsultationRecords record : consultList) {
            if (record.counselorID.equals(counselorID)) {
                record.displayRecord();
                System.out.println("------------------------------");
            }
        }
    }

    
    public void addToConsultationList(ArrayList<ConsultationRecords> consultList) {
        consultList.add(this);
        System.out.println("Consultation record added to list.");
    }

    
    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCounselorID() {
        return counselorID;
    }

    public void setCounselorID(String counselorID) {
        this.counselorID = counselorID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
