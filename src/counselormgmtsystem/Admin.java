package counselormgmtsystem;

import counselormgmtsystem.GUIprogram.AdminFrames.adminApptStats;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class Admin extends User {

    protected String contactNumber;
    protected String email;
    protected String officeRoom;

    public Admin(String ID, String username, String password, String fullName, String status, String contactNumber, String email, String officeRoom) {
        super(ID, username, password, fullName, status);
        this.contactNumber = contactNumber;
        this.email = email;
        this.officeRoom = officeRoom;
    }

    public Admin(String ID, String username, String password, String fullName, String contactNumber, String email, String officeRoom) {
        this(ID, username, password, fullName, "Active", contactNumber, email, officeRoom);
    }

    public Admin(String ID, String username, String password, String fullName, String contactNumber, String email) {
        this(ID, username, password, fullName, "Active", contactNumber, email, "TBD");
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

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

//manage users
    public void manageRecord(ArrayList<User> userList, User targetUser, String action) {
        if (userList == null || targetUser == null || action == null) {
            System.out.println("Error: invalid arguments supplied to manageRecord().");
            return;
        }

        switch (action.trim().toUpperCase()) {
            case "ADD":
                for (User u : userList) {
                    if (u.ID.equalsIgnoreCase(targetUser.ID)) {
                        System.out.println("Error: a user with ID " + targetUser.ID + " already exists.");
                        return;
                    }
                }
                userList.add(targetUser);
                System.out.println("--- Account " + targetUser.ID + " successfully added ---");
                break;

            case "UPDATE":
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).ID.equalsIgnoreCase(targetUser.ID)) {
                        userList.set(i, targetUser);
                        System.out.println("--- Account " + targetUser.ID + " successfully updated ---");
                        return;
                    }
                }
                System.out.println("Error: user ID " + targetUser.ID + " not found.");
                break;

            case "DELETE":
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).ID.equalsIgnoreCase(targetUser.ID)) {
                        userList.remove(i);
                        System.out.println("--- Account " + targetUser.ID + " successfully deleted ---");
                        return;
                    }
                }
                System.out.println("Error: user ID " + targetUser.ID + " not found.");
                break;

            default:
                System.out.println("Error: unsupported action \"" + action + "\". Use ADD, UPDATE or DELETE.");
        }
    }

// overload 2 - manage roster 
    public void manageRecord(ArrayList<Roster> rosterList, Roster targetRoster, String action) {
        if (rosterList == null || targetRoster == null || action == null) {
            System.out.println("Error: invalid arguments supplied to manageRecord().");
            return;
        }

        switch (action.trim().toUpperCase()) {
            case "ADD":
                int max = 0;
                for (Roster r : rosterList) {
                    try {
                        int num = Integer.parseInt(r.getRosterID().substring(3));
                        if (num > max) {
                            max = num;
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
                targetRoster.setRosterID(String.format("ROS%03d", max + 1));
                rosterList.add(targetRoster);
                System.out.println("--- Roster " + targetRoster.getRosterID() + " successfully added ---");
                break;

            case "UPDATE":
                for (int i = 0; i < rosterList.size(); i++) {
                    if (rosterList.get(i).getRosterID().equals(targetRoster.getRosterID())) {
                        rosterList.set(i, targetRoster);
                        System.out.println("--- Roster " + targetRoster.getRosterID() + " successfully updated ---");
                        new FileHandler().saveDataToFiles();
                        return;
                    }
                }
                System.out.println("Error: Roster ID " + targetRoster.getRosterID() + " not found.");
                break;

            case "DELETE":
                for (int i = 0; i < rosterList.size(); i++) {
                    if (rosterList.get(i).getRosterID().equals(targetRoster.getRosterID())) {
                        rosterList.remove(i);
                        System.out.println("--- Roster " + targetRoster.getRosterID() + " successfully deleted ---");
                        new FileHandler().saveDataToFiles();
                        return;
                    }
                }
                System.out.println("Error: Roster ID " + targetRoster.getRosterID() + " not found.");
                break;

            default:
                System.out.println("Error: unsupported action \"" + action + "\". Use ADD, UPDATE, or DELETE.");
        }

        new FileHandler().saveDataToFiles();
    }

    public String validateData(String counselorId, String dateStr, String startStr, String endStr, String currentRosterId) {
        if (counselorId.trim().isEmpty() || dateStr.trim().isEmpty() || startStr.trim().isEmpty() || endStr.trim().isEmpty()) {
            return "Counselor ID, Date, Start Time and End Time are required.";
        }

        boolean counselorExists = false;
        for (User u : FileHandler.userList) {
            if (u instanceof Counselor && u.ID.equalsIgnoreCase(counselorId.trim())) {
                counselorExists = true;

                String userStatus = (u.status != null) ? u.status : "";
                if (userStatus.equalsIgnoreCase("Inactive")) {
                    return "Cannot assign a roster. Counselor " + u.ID + " is currently marked as Inactive.";
                }
                break;
            }
        }

        if (!counselorExists) {
            return "The provided Counselor ID does not exist in the system.";
        }

        LocalDate rosterDate;
        LocalTime startTime, endTime;

        try {
            rosterDate = LocalDate.parse(dateStr.trim());
        } catch (DateTimeParseException e) {
            return "Date must be in yyyy-MM-dd format.";
        }

        try {
            startTime = LocalTime.parse(startStr.trim());
            endTime = LocalTime.parse(endStr.trim());
        } catch (DateTimeParseException e) {
            return "Times must be in HH:mm 24-hour format (e.g. 14:30).";
        }

        if (!endTime.isAfter(startTime)) {
            return "End Time must be after Start Time.";
        }

        // UPDATED: Shift duration validation for rosters
        long durationMinutes = Duration.between(startTime, endTime).toMinutes();
        if (durationMinutes < 30) {
            return "A roster shift must be at least 30 minutes long.";
        }

        LocalTime shiftStartLimit = LocalTime.of(8, 0);  // 08:00
        LocalTime shiftEndLimit = LocalTime.of(17, 0); // 17:00

        if (startTime.isBefore(shiftStartLimit) || endTime.isAfter(shiftEndLimit)) {
            return "Roster times must be within working hours (08:00 to 17:00).";
        }

        LocalDate today = LocalDate.now();
        if (rosterDate.isBefore(today)) {
            return "You cannot schedule a roster for a past date.";
        }
        if (rosterDate.isAfter(today.plusMonths(3))) {
            return "You cannot schedule a roster more than 3 months in advance.";
        }

        // Overlap and duplicate slot validation
        for (Roster r : FileHandler.rosterList) {
            if (currentRosterId != null && r.rosterID.equalsIgnoreCase(currentRosterId)) {
                continue;
            }
            if (r.counselorID.equalsIgnoreCase(counselorId.trim()) && r.date.equals(dateStr.trim())) {
                LocalTime existingStart = LocalTime.parse(r.startTime);
                LocalTime existingEnd = LocalTime.parse(r.endTime);

                if (startTime.isBefore(existingEnd) && endTime.isAfter(existingStart)) {
                    return "This counselor already has an overlapping shift on this date (" + r.startTime + " - " + r.endTime + ").";
                }
            }
        }

        return null;
    }

    // --- APPOINTMENT STATISTICS UPDATER ---
    public void updateApptStats(String dateFilter, adminApptStats frame) {
        int total = 0, completed = 0, cancelled = 0, pending = 0;
        int morningCount = 0, afternoonCount = 0, onlineCount = 0, walkInCount = 0;

        ArrayList<String> counselorIds = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (Appointment appt : FileHandler.apptList) {
            if (dateFilter != null && !dateFilter.trim().isEmpty()) {
                if (!appt.getDate().startsWith(dateFilter.trim())) {
                    continue;
                }
            }

            total++;
            String status = appt.getStatus();
            if (status.equalsIgnoreCase("Completed")) {
                completed++;
            } else if (status.equalsIgnoreCase("Cancelled")) {
                cancelled++;
            } else {
                pending++;
            }

            if (appt.getStartTime() != null && appt.getStartTime().compareTo("12:00") < 0) {
                morningCount++;
            } else {
                afternoonCount++;
            }

            String type = appt.getBookingType();
            if (type != null) {
                if (type.equalsIgnoreCase("Online")) {
                    onlineCount++;
                } else if (type.toLowerCase().contains("walk")) {
                    walkInCount++;
                }
            }

            if (!status.equalsIgnoreCase("Cancelled")) {
                String cID = appt.getCounselorID();
                int index = counselorIds.indexOf(cID);
                if (index == -1) {
                    counselorIds.add(cID);
                    counts.add(1);
                } else {
                    counts.set(index, counts.get(index) + 1);
                }
            }
        }

        frame.getApptBookedTf().setText(String.valueOf(total));
        frame.getApptCompletedTf().setText(String.valueOf(completed));
        frame.getApptCancelledTf().setText(String.valueOf(cancelled));
        frame.getApptPendingTf().setText(String.valueOf(pending));

        double rate = (completed + cancelled > 0) ? ((double) completed / (completed + cancelled)) * 100 : 0.0;
        frame.getCompletionRateTf().setText(String.format("%.1f%%", rate));

        frame.getMorningTf().setText(String.valueOf(morningCount));
        frame.getAfternoonTf().setText(String.valueOf(afternoonCount));
        frame.getOnlineTf().setText(String.valueOf(onlineCount));
        frame.getWalkInTf().setText(String.valueOf(walkInCount));

        frame.getModel().setRowCount(0);
        for (int i = 0; i < counselorIds.size(); i++) {
            frame.getModel().addRow(new Object[]{counselorIds.get(i), counts.get(i)});
        }
    }

    // --- REPORT GENERATOR ---
    public void generateReport(String category, String timeframe, String yearStr, String dateStr, adminGenerateReports frame) {
        String filterMatch = "";
        int targetQuarter = 0;

        try {
            if (yearStr.isEmpty()) {
                throw new Exception("Please enter a valid year.");
            }
            int year = Integer.parseInt(yearStr);
            if (year < 2024 || year > 2026) {
                throw new Exception("Year must be between 2024 and 2026.");
            }
            filterMatch = String.valueOf(year);

            if (!timeframe.equals("Yearly")) {
                if (dateStr.isEmpty()) {
                    throw new Exception("Please enter a value in the Month/Date field.");
                }
                if (timeframe.equals("Monthly")) {
                    int month = Integer.parseInt(dateStr);
                    if (month < 1 || month > 12) {
                        throw new Exception("Month must be 1-12.");
                    }
                    filterMatch += "-" + String.format("%02d", month);
                } else if (timeframe.equals("Quarterly")) {
                    targetQuarter = Integer.parseInt(dateStr.toUpperCase().replace("Q", ""));
                    if (targetQuarter < 1 || targetQuarter > 4) {
                        throw new Exception("Quarter must be 1-4.");
                    }
                } else if (timeframe.equals("Daily")) {
                    String[] parts = dateStr.split("-");
                    filterMatch += "-" + String.format("%02d", Integer.parseInt(parts[0])) + "-" + String.format("%02d", Integer.parseInt(parts[1]));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        frame.getModel().setRowCount(0);

        if (category.equals("Appointments")) {
            int total = 0, completed = 0, pending = 0, cancelled = 0;
            for (Appointment appt : FileHandler.apptList) {
                if (checkDateMatch(appt.getDate(), filterMatch, timeframe, targetQuarter)) {
                    total++;
                    if (appt.getStatus().equalsIgnoreCase("Completed")) {
                        completed++;
                    } else if (appt.getStatus().equalsIgnoreCase("Cancelled")) {
                        cancelled++;
                    } else {
                        pending++;
                    }

                    frame.getModel().addRow(new Object[]{
                        appt.getApptID(),
                        appt.getStudentID(),
                        appt.getCounselorID(),
                        appt.getDate(),
                        appt.getStartTime(),
                        appt.getEndTime(),
                        appt.getBookingType(),
                        appt.getQueueNumber(),
                        appt.getStatus()
                    });
                }
            }

            frame.getTotalTf().setText(String.valueOf(total));
            frame.getCompletedTf().setText(String.valueOf(completed));
            frame.getPendingTf().setText(String.valueOf(pending));
            frame.getCancelledTf().setText(String.valueOf(cancelled));

        } else if (category.equals("Counselor Workload")) {
            ArrayList<String> counselorIds = new ArrayList<>();
            ArrayList<Integer> counts = new ArrayList<>();

            for (Appointment appt : FileHandler.apptList) {
                if (checkDateMatch(appt.getDate(), filterMatch, timeframe, targetQuarter) && !appt.getStatus().equalsIgnoreCase("Cancelled")) {
                    String cID = appt.getCounselorID();
                    int index = counselorIds.indexOf(cID);
                    if (index == -1) {
                        counselorIds.add(cID);
                        counts.add(1);
                    } else {
                        counts.set(index, counts.get(index) + 1);
                    }
                }
            }

            for (int i = 0; i < counselorIds.size(); i++) {
                frame.getModel().addRow(new Object[]{counselorIds.get(i), counts.get(i)});
            }
            frame.getTotalTf().setText(String.valueOf(FileHandler.userList.size()));
            frame.getCompletedTf().setText(String.valueOf(counselorIds.size()));

        } else if (category.equals("Consultation Records")) {
            int total = 0;
            ArrayList<String> uniqueStudents = new ArrayList<>();

            for (ConsultationRecords record : FileHandler.consultList) {
                if (checkDateMatch(record.getDate(), filterMatch, timeframe, targetQuarter)) {
                    total++;
                    if (!uniqueStudents.contains(record.getStudentID())) {
                        uniqueStudents.add(record.getStudentID());
                    }
                    frame.getModel().addRow(new Object[]{record.getRecordID(), record.getAppointmentID(), record.getStudentID(), record.getCounselorID(), record.getDate(), record.getNotes()});
                }
            }
            frame.getTotalTf().setText(String.valueOf(total));
            frame.getCompletedTf().setText(String.valueOf(uniqueStudents.size()));
        }

        if (frame.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "No records found for this timeframe.", "Report Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean checkDateMatch(String recordDate, String filterMatch, String timeframe, int targetQuarter) {
        if (timeframe.equals("Quarterly")) {
            if (!recordDate.startsWith(filterMatch)) {
                return false;
            }
            try {
                int month = Integer.parseInt(recordDate.split("-")[1]);
                int recordQuarter = (month - 1) / 3 + 1;
                return recordQuarter == targetQuarter;
            } catch (Exception e) {
                return false;
            }
        } else {
            return recordDate.startsWith(filterMatch);
        }
    }

    @Override
    public String toString() {
        return "User: " + this.ID
                + " " + this.username + " " + this.password + " " + this.fullName + " " + this.contactNumber + " " + this.email + " " + this.officeRoom + " " + (this.status != null ? this.status : "");
    }
}
