/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package counselormgmtsystem;

/**
 *
 * @author tzhen
 */
public class Feedback {
    String studentID;
    String counselorID;
    String feedback;

    public Feedback(String studentID, String counselorID, String feedback) {
        this.studentID = studentID;
        this.counselorID = counselorID;
        this.feedback = feedback;
    }

    public String toFileLine() {
        return studentID + "|" + counselorID + "|" + feedback;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
