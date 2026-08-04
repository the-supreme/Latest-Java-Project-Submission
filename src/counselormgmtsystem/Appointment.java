package counselormgmtsystem;

public class Appointment {
    protected String apptID;
    protected String queueNumber;
    protected String studentID;
    protected String counselorID;
    protected String date;
    protected String startTime;
    protected String endTime;
    protected String bookingType;
    protected String status;

    public Appointment(String apptID, String queueNumber, String studentID, String counselorID, String date, String startTime, String endTime, String bookingType, String status) {
        this.apptID = apptID;
        this.queueNumber = queueNumber;
        this.studentID = studentID;
        this.counselorID = counselorID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingType = bookingType;
        this.status = status;
    }

    // --- Getters ---

    public String getApptID() {
        return apptID;
    }

    public String getQueueNumber() {
        return queueNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCounselorID() {
        return counselorID;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getBookingType() {
        return bookingType;
    }

    public String getStatus() {
        return status;
    }

    // --- Setters ---

    public void setApptID(String apptID) {
        this.apptID = apptID;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setCounselorID(String counselorID) {
        this.counselorID = counselorID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Appointment: " + this.apptID + " " + this.queueNumber + " " + this.studentID + " " + this.counselorID + " " + this.date + " " + this.startTime + " " + this.endTime + " " + this.bookingType + " " + this.status;
    }
}