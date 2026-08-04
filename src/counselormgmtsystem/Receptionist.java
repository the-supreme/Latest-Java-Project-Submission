package counselormgmtsystem;

public class Receptionist extends User {
    protected String contactNumber;
    protected String email;

    public Receptionist(String ID, String username, String password, String fullName, String status, String contactNumber, String email) {
        super(ID, username, password, fullName, status);
        this.email = email;
        this.contactNumber = contactNumber; 
    }

    public String getReceptionistEmail() {
        return this.email;
    }

    public void setReceptionistEmail(String email) {
        this.email = email;
    }

    public String getReceptionistNumber() {
        return this.contactNumber;
    }

    public void setReceptionistNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean createStudentAccount(String username, String password, String fullName, String intakeCode, String email, String contactNumber, String emergencyContact) {
        String newStudentID = FileHandler.generateUserID("STD", FileHandler.userList, User::getID);
        Student newStudent = new Student(newStudentID, username, password, fullName, status, intakeCode, email, contactNumber, emergencyContact);  
        FileHandler.userList.add(newStudent);
        return true;
    }

    public boolean updateStudentAccount(String studentID, String username, String password, String fullName, String intakeCode, String email, String contactNumber, String emergencyContact) {
        for (User u : FileHandler.userList) {
            if (u.getID().equals(studentID) && u instanceof Student s) {
                s.setUsername(username);
                s.setpassword(password);
                s.setFullName(fullName);
                s.setIntakeCode(intakeCode);
                s.setEmail(email);
                s.setContactNumber(contactNumber);
                s.setEmergencyContact(emergencyContact);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteStudentAccount(String studentID) {
        return FileHandler.userList.removeIf(u -> u.getID().equals(studentID));
    }

    public Appointment createAppointment(String studentID, String bookingType, String apptDate, String startTime, String endTime) {
        String newApptID = FileHandler.generateUserID("APT", FileHandler.apptList, Appointment::getApptID);
        String newQueueNum = "Walk-In".equals(bookingType) ? generateQueueNumber(apptDate) : "";

        Appointment newAppt = new Appointment(
            newApptID, newQueueNum, studentID, "", apptDate, startTime, endTime, bookingType, "Scheduled"
        );

        FileHandler.apptList.add(newAppt);
        FileHandler.saveDataToFiles();
        return newAppt;
    }

    public boolean updateAppointment(String apptID, String studentID, String bookingType, String date, String startTime, String endTime) {
        for (Appointment a : FileHandler.apptList) {
            if (a.getApptID().equals(apptID)) {
                // Adjust queue number if converting to/from Walk-In or changing dates
                if ("Walk-In".equals(bookingType)) {
                    if (!"Walk-In".equals(a.getBookingType()) || !date.equals(a.getDate())) {
                        a.setQueueNumber(generateQueueNumber(date));
                    }
                } else {
                    a.setQueueNumber("");
                }

                a.setStudentID(studentID);
                a.setBookingType(bookingType);
                a.setDate(date);
                a.setStartTime(startTime);
                a.setEndTime(endTime);

                FileHandler.saveDataToFiles();
                return true;
            }
        }
        return false;
    }

    public boolean deleteAppointment(String apptID) {
        boolean removed = FileHandler.apptList.removeIf(a -> a.getApptID().equals(apptID));
        if (removed) {
            FileHandler.saveDataToFiles();
        }
        return removed;
    }

    public boolean assignCounselor(String apptID, String counselorID) {
        for (Appointment a : FileHandler.apptList) {
            if (a.getApptID().equals(apptID)) {
                a.setCounselorID(counselorID);
                FileHandler.saveDataToFiles();
                return true;
            }
        }
        return false;
    }

    public String generateQueueNumber(String targetDate) {
        int maxQueueNum = 0;
        for (Appointment appt : FileHandler.apptList) {
            if (targetDate.equals(appt.getDate()) && appt.getQueueNumber() != null && !appt.getQueueNumber().isEmpty()) {
                String qStr = appt.getQueueNumber().replaceAll("\\D+", "");
                if (!qStr.isEmpty()) {
                    try {
                        int num = Integer.parseInt(qStr);
                        if (num > maxQueueNum) {
                            maxQueueNum = num;
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }
        }
        return String.format("Q%03d", maxQueueNum + 1);
    }

    public boolean manageRecords(String action, Student studentData) {
        switch (action.toUpperCase()) {
            case "CREATE":
                return createStudentAccount(
                    studentData.getUsername(),
                    studentData.getPassword(),
                    studentData.getfullName(),
                    studentData.getIntakeCode(),
                    studentData.getEmail(),
                    studentData.getContactNumber(),
                    studentData.getEmergencyContact()
                );

            case "UPDATE":
                return updateStudentAccount(
                    studentData.getID(),
                    studentData.getUsername(),
                    studentData.getPassword(),
                    studentData.getfullName(),
                    studentData.getIntakeCode(),
                    studentData.getEmail(),
                    studentData.getContactNumber(),
                    studentData.getEmergencyContact()
                );

            case "DELETE":
                return deleteStudentAccount(studentData.getID());

            default:
                System.out.println("Invalid Action Command for Student Record.");
                return false;
        }
    }

    public boolean manageRecords(String action, Appointment apptData) {
        switch (action.toUpperCase()) {
            case "CREATE":
                Appointment created = createAppointment(
                    apptData.getStudentID(),
                    apptData.getBookingType(),
                    apptData.getDate(),
                    apptData.getStartTime(),
                    apptData.getEndTime()
                );
                return created != null;

            case "UPDATE":
                return updateAppointment(
                    apptData.getApptID(),
                    apptData.getStudentID(),
                    apptData.getBookingType(),
                    apptData.getDate(),
                    apptData.getStartTime(),
                    apptData.getEndTime()
                );

            case "DELETE":
                return deleteAppointment(apptData.getApptID());

            case "ASSIGN":
                return assignCounselor(apptData.getApptID(), apptData.getCounselorID());

            default:
                System.out.println("Invalid Action Command for Appointment Record.");
                return false;
        }
    }

    @Override
    public String toString() {
        return "User: " + this.ID + " " + this.username + " " + this.password + " " + this.fullName + " " + this.contactNumber + " " + this.email;
    }
}