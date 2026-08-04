package counselormgmtsystem;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Student extends User {
    protected String intakeCode;
    protected String email;
    protected String contactNumber;
    protected String emergencyContact;

    public Student(String ID, String username, String password, String fullName, String status, String intakeCode, String email, String contactNumber, String emergencyContact) {
        super(ID, username, password, fullName, status);
        this.intakeCode = intakeCode;
        this.email = email;
        this.contactNumber = contactNumber;
        this.emergencyContact = emergencyContact; 
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getIntakeCode() {
        return this.intakeCode;
    }

    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }
    
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getEmergencyContact() {
        return this.emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    
    public boolean bookAppointment(String counselorID, String date, String startTime, String bookingType) {
        if (counselorID == null || counselorID.startsWith("--") || date == null || date.isEmpty() || startTime == null || startTime.startsWith("--")) {
            return false;
        }

        String endTime;
        try {
            LocalTime start = LocalTime.parse(startTime);
            endTime = start.plusHours(1).toString();
        } catch (DateTimeParseException e) {
            endTime = startTime;
        }

        String apptId = FileHandler.generateUserID("APT", FileHandler.apptList, Appointment::getApptID);
        String queueNumber = FileHandler.generateUserID("Q", FileHandler.apptList, Appointment::getQueueNumber);

        Appointment newAppt = new Appointment(
            apptId, 
            queueNumber, 
            this.ID, 
            counselorID, 
            date, 
            startTime, 
            endTime, 
            bookingType, 
            "Scheduled"
        );

        FileHandler.apptList.add(newAppt);
        new FileHandler().saveDataToFiles();
        return true;
    }

    /**
     * Reschedules an existing appointment owned by this student.
     */
    public boolean rescheduleAppointment(String apptID, String newDate, String newStartTime) {
        Appointment target = null;
        for (Appointment appt : FileHandler.apptList) {
            if (appt.getApptID().equals(apptID) && appt.getStudentID().equals(this.ID)) {
                target = appt;
                break;
            }
        }

        if (target == null) return false;

        String newEndTime;
        try {
            LocalTime start = LocalTime.parse(newStartTime);
            newEndTime = start.plusHours(1).toString();
        } catch (DateTimeParseException e) {
            newEndTime = newStartTime;
        }

        target.setDate(newDate);
        target.setStartTime(newStartTime);
        target.setEndTime(newEndTime);
        target.setStatus("Rescheduled");

        new FileHandler().saveDataToFiles();
        return true;
    }

    /**
     * Cancels an existing appointment owned by this student.
     */
    public boolean cancelAppointment(String apptID) {
        for (Appointment appt : FileHandler.apptList) {
            if (appt.getApptID().equals(apptID) && appt.getStudentID().equals(this.ID)) {
                appt.setStatus("Cancelled");
                new FileHandler().saveDataToFiles();
                return true;
            }
        }
        return false;
    }

    /**
     * Submits feedback for a counselor.
     */
    public boolean submitFeedback(String counselorID, String feedbackText) {
        if (feedbackText == null || feedbackText.trim().isEmpty()) {
            return false;
        }
        Feedback fb = new Feedback(this.ID, counselorID, feedbackText.trim());
        FileHandler.feedbackList.add(fb);
        new FileHandler().saveDataToFiles();
        return true;
    }
    
    @Override
    public String toString() {
        return "User: " + this.ID
         + " " + this.username + " " + this.password + " " + this.fullName + " " + this.contactNumber + " " + this.intakeCode + " " + this.emergencyContact;
    }
}