package counselormgmtsystem;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHandler {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Appointment> apptList = new ArrayList<>();
    public static ArrayList<Roster> rosterList = new ArrayList<>();
    public static ArrayList<ConsultationRecords> consultList = new ArrayList<>();
    public static ArrayList<Feedback> feedbackList = new ArrayList<>();

    public void loadDataFromFiles() {
        userList.clear();
        apptList.clear();
        rosterList.clear();
        consultList.clear();
        feedbackList.clear();

        // Read Users File
        try (BufferedReader uReader = new BufferedReader(new FileReader("dataFiles/users.txt"))) {
            String line;
            while ((line = uReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Skip blank lines

                String[] userData = line.split("\\|");
                
                // Require at least 4 columns (ID, username, password, fullName)
                if (userData.length < 4) continue; 

                // Extract status from userData[4], or default to "Active" if missing
                String status = (userData.length >= 5) ? userData[4].trim() : "Active";

                // Read Admin File and Add to UserList
                if (userData[0].startsWith("ADM")) {
                    try (BufferedReader adminReader = new BufferedReader(new FileReader("dataFiles/admin.txt"))) {
                        String adminLine;
                        while ((adminLine = adminReader.readLine()) != null) {
                            String[] adminData = adminLine.trim().split("\\|");
                            // Admin has 4 columns: ID | Contact | Email | Room
                            if (adminData.length >= 4 && adminData[0].equals(userData[0])) {
                                Admin admin = new Admin(userData[0], userData[1], userData[2], userData[3], status, adminData[1], adminData[2], adminData[3]);
                                userList.add(admin);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Admin File can't be accessed.");
                    }
                }

                // Read Student File and Add to UserList
                else if (userData[0].startsWith("STD")) {
                    try (BufferedReader studentReader = new BufferedReader(new FileReader("dataFiles/student.txt"))) {
                        String studentLine;
                        while ((studentLine = studentReader.readLine()) != null) {
                            String[] studentData = studentLine.trim().split("\\|");
                            // Student has 5 columns: ID | Intake | Contact | Email | Emergency
                            if (studentData.length >= 5 && studentData[0].equals(userData[0])) {
                                Student student = new Student(userData[0], userData[1], userData[2], userData[3], status, studentData[1], studentData[2], studentData[3], studentData[4]);
                                userList.add(student);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Student File can't be accessed.");
                    }
                }

                // Read Receptionist File and Add to UserList
                else if (userData[0].startsWith("REC")) {
                    try (BufferedReader recepReader = new BufferedReader(new FileReader("dataFiles/receptionist.txt"))) {
                        String recepLine;
                        while ((recepLine = recepReader.readLine()) != null) {
                            String[] recepData = recepLine.trim().split("\\|");
                            
                            // Require at least 3 columns for Receptionist (ID | Contact | Email)
                            if (recepData.length >= 3 && recepData[0].equals(userData[0])) {
                                Receptionist receptionist = new Receptionist(userData[0], userData[1], userData[2], userData[3], status, recepData[1], recepData[2]);
                                userList.add(receptionist);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Receptionist File can't be accessed.");
                    }
                }

                // Read Counselor File and Add to UserList
                else if (userData[0].startsWith("CNS")) {
                    try (BufferedReader counsReader = new BufferedReader(new FileReader("dataFiles/counselor.txt"))) {
                        String counsLine;
                        while ((counsLine = counsReader.readLine()) != null) {
                            String[] counsData = counsLine.trim().split("\\|");
                            
                            // Require at least 4 columns for Counselor (ID | Specialization | Contact | Email)
                            if (counsData.length >= 4 && counsData[0].equals(userData[0])) {
                                Counselor counselor = new Counselor(userData[0], userData[1], userData[2], userData[3], status, counsData[1], counsData[2], counsData[3]);
                                userList.add(counselor);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Counselor File can't be accessed.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Users File can't be accessed.");
        }

        // Read Appointments File safely
        try (BufferedReader apptReader = new BufferedReader(new FileReader("dataFiles/appointments.txt"))) {
            String apptline;
            while ((apptline = apptReader.readLine()) != null) {
                apptline = apptline.trim();
                if (apptline.isEmpty()) continue;

                String[] appointmentData = apptline.split("\\|");
                // GUARD: Check length for 9 parameters
                if (appointmentData.length >= 9) {
                    Appointment appt = new Appointment(
                        appointmentData[0], 
                        appointmentData[1], 
                        appointmentData[2], 
                        appointmentData[3], 
                        appointmentData[4], 
                        appointmentData[5], 
                        appointmentData[6],
                        appointmentData[7],
                        appointmentData[8]
                    );
                    apptList.add(appt);
                } else {
                    System.out.println("Skipping invalid appointment row: " + apptline);
                }
            }
        } catch (IOException e) {
            System.out.println("Cant open the Appointment File");
        }

        // Read Rosters File safely
        try (BufferedReader rosterReader = new BufferedReader(new FileReader("dataFiles/rosters.txt"))) {
            String rosterLine;
            while ((rosterLine = rosterReader.readLine()) != null) {
                rosterLine = rosterLine.trim();
                if (rosterLine.isEmpty()) continue;

                String[] rosterData = rosterLine.split("\\|");
                if (rosterData.length >= 6) {
                    Roster roster = new Roster(rosterData[0], rosterData[1], rosterData[2], rosterData[3], rosterData[4]);
                    rosterList.add(roster);
                } else if (rosterData.length >= 5) {
                    Roster roster = new Roster(rosterData[0], rosterData[1], rosterData[2], rosterData[3], rosterData[4]);
                    rosterList.add(roster);
                }
            }
        } catch (IOException e) {
            System.out.println("Cant open the Roster File");
        }

        // Read Consultation Records File safely
        try (BufferedReader consultReader = new BufferedReader(new FileReader("dataFiles/consultationRecords.txt"))) {
            String consultLine;
            while ((consultLine = consultReader.readLine()) != null) {
                consultLine = consultLine.trim();
                if (consultLine.isEmpty()) continue;

                String[] consultData = consultLine.split("\\|");
                if (consultData.length >= 7) {
                    ConsultationRecords consult = new ConsultationRecords(consultData[0], consultData[1], consultData[2], consultData[3], consultData[4], consultData[5], consultData[6]);
                    consultList.add(consult);
                }
            }
        } catch (IOException e) {
            System.out.println("Cant open the ConsultationRecords File");
        }

        // Read Feedback File safely
        try (BufferedReader feedbackReader = new BufferedReader(new FileReader("dataFiles/feedback.txt"))) {
            String feedbackLine;
            while ((feedbackLine = feedbackReader.readLine()) != null) {
                feedbackLine = feedbackLine.trim();
                if (feedbackLine.isEmpty()) continue;

                String[] feedbackData = feedbackLine.split("\\|");
                if (feedbackData.length >= 3) {
                    Feedback feedback = new Feedback(feedbackData[0], feedbackData[1], feedbackData[2]);
                    feedbackList.add(feedback);
                }
            }
        } catch (IOException e) {
            System.out.println("Cant open the Feedback File");
        }
    }

    public static void saveDataToFiles() {
        ArrayList<String> adminList = new ArrayList<>(); 
        ArrayList<String> studentList = new ArrayList<>(); 
        ArrayList<String> counselorList = new ArrayList<>(); 
        ArrayList<String> receptionistList = new ArrayList<>(); 
        ArrayList<String> userDataList = new ArrayList<>();

        for (User user : userList) {
            // FIX: Append user.status here so it is not lost
            String userText = user.ID + "|" + user.username + "|" + user.password + "|" + user.fullName + "|" + user.status;
            userDataList.add(userText);

            if (user instanceof Admin admin) {
                String adminText = admin.ID + "|" + admin.contactNumber + "|" + admin.email + "|" + admin.officeRoom; 
                adminList.add(adminText);
            } else if (user instanceof Student student) {
                String studentText = student.ID + "|" + student.intakeCode + "|" + student.contactNumber + "|" + student.email + "|" + student.emergencyContact; 
                studentList.add(studentText);
            } else if (user instanceof Counselor counselor) {
                String counselorText = counselor.ID + "|" + counselor.specialization + "|" + counselor.contactNumber + "|" + counselor.email; 
                counselorList.add(counselorText);
            } else if (user instanceof Receptionist receptionist) {
                String receptionistText = receptionist.ID + "|" + receptionist.contactNumber + "|" + receptionist.email; 
                receptionistList.add(receptionistText);
            }
        }

        // write into users file
        try (BufferedWriter userWriter = new BufferedWriter(new FileWriter("dataFiles/users.txt"))) {
            for (String user : userDataList) {
                userWriter.write(user);
                userWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the users file");
        }

        try (BufferedWriter adminWriter = new BufferedWriter(new FileWriter("dataFiles/admin.txt"))) {
            for (String admin : adminList) {
                adminWriter.write(admin);
                adminWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the admin file");
        }

        try (BufferedWriter counselorWriter = new BufferedWriter(new FileWriter("dataFiles/counselor.txt"))) {
            for (String counselor : counselorList) {
                counselorWriter.write(counselor);
                counselorWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the counselor file");
        }

        try (BufferedWriter studentWriter = new BufferedWriter(new FileWriter("dataFiles/student.txt"))) {
            for (String student : studentList) {
                studentWriter.write(student);
                studentWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the student file");
        }

        try (BufferedWriter receptionistWriter = new BufferedWriter(new FileWriter("dataFiles/receptionist.txt"))) {
            for (String receptionist : receptionistList) {
                receptionistWriter.write(receptionist);
                receptionistWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the receptionist file");
        }

        // write into rosters
        ArrayList<String> listOfRosterText = new ArrayList<>(); 
        for (Roster roster : rosterList) {
            String rosterText = roster.getRosterID() + "|" + roster.getCounselorID() + "|" + roster.getDate() + "|" + roster.getStartTime() + "|" + roster.getEndTime();
            listOfRosterText.add(rosterText);
        }

        try (BufferedWriter rosterWriter = new BufferedWriter(new FileWriter("dataFiles/rosters.txt"))) {
            for (String roster : listOfRosterText) {
                rosterWriter.write(roster);
                rosterWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the Roster file");
        }

        // write into appointments
        ArrayList<String> listOfApptText = new ArrayList<>(); 
        for (Appointment appt : apptList) {
            String apptText = appt.getApptID() + "|" 
                            + appt.getQueueNumber() + "|" 
                            + appt.getStudentID() + "|" 
                            + appt.getCounselorID() + "|" 
                            + appt.getDate() + "|" 
                            + appt.getStartTime() + "|" 
                            + appt.getEndTime() + "|" 
                            + appt.getBookingType() + "|" 
                            + appt.getStatus();
            listOfApptText.add(apptText);
        }

        try (BufferedWriter apptWriter = new BufferedWriter(new FileWriter("dataFiles/appointments.txt"))) {
            for (String appt : listOfApptText) {
                apptWriter.write(appt);
                apptWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the Appointments file");
        }

        // write into consultation records
        ArrayList<String> listOfRecords = new ArrayList<>(); 
        for (ConsultationRecords record : consultList) {
            String consultText = record.recordID + "|" + record.appointmentID + "|" + record.studentID + "|" + record.counselorID + "|" + record.date + "|" + record.notes + "|" + record.recommendations;
            listOfRecords.add(consultText);
        }

        try (BufferedWriter recordWriter = new BufferedWriter(new FileWriter("dataFiles/consultationRecords.txt"))) {
            for (String record : listOfRecords) {
                recordWriter.write(record);
                recordWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the ConsultationRecords file");
        }

        // write into feedback file
        ArrayList<String> listOfFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            String feedbackText = feedback.getStudentID() + "|" + feedback.getCounselorID() + "|" + feedback.getFeedback();
            listOfFeedback.add(feedbackText);
        }

        try (BufferedWriter feedbackWriter = new BufferedWriter(new FileWriter("dataFiles/feedback.txt"))) {
            for (String feedback : listOfFeedback) {
                feedbackWriter.write(feedback);
                feedbackWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot open the Feedback file");
        }
    }

    public boolean checkLogin(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static <T> String generateUserID(String prefix, List<T> list, java.util.function.Function<T, String> idExtractor) {
        int max_id = 0;

        // 1. Scan the list in memory
        if (list != null && !list.isEmpty()) {
            for (T item : list) {
                String id = idExtractor.apply(item);
                if (id != null && id.startsWith(prefix)) {
                    String numericPart = id.replaceAll("\\D+", ""); // Extract digits
                    if (!numericPart.isEmpty()) {
                        try {
                            int num = Integer.parseInt(numericPart);
                            if (num > max_id) {
                                max_id = num;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }
            }
        }

        // 2. Generate next formatted ID (e.g., APT001, STD005)
        int new_num = max_id + 1;
        return prefix + String.format("%03d", new_num);
    }
    
    public static String validateData(String name, String contact, String email, String password, boolean isNewUser, String currentUserId) {

        // 1. Mandatory Fields Check
        if (name == null || name.trim().isEmpty() ||
            contact == null || contact.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            return "Full Name, Contact Number, and Email are required.";
        }

        // 2. Email Format Check
        if (!email.trim().matches("^[\\w.+-]+@([\\w-]+\\.)+[a-zA-Z]{2,}$")) {
            return "Please enter a valid email address.";
        }

        // 3. Contact Number Format Check (7-15 digits, allowing +, -, spaces)
        if (!contact.trim().matches("^[0-9+\\-\\s]{7,15}$")) {
            return "Please enter a valid contact number.";
        }

        // 4. Password Validation (Only checked if creating a new user or explicitly updating password)
        if (isNewUser || (password != null && !password.trim().isEmpty())) {
            if (password == null || password.length() < 8) {
                return "Password must be at least 8 characters long.";
            }
            if (!password.matches(".*\\d.*")) {
                return "Password must contain at least one number.";
            }
        }

        // 5. Universal Uniqueness Check against FileHandler.userList across ALL User subclass roles
        for (User u : FileHandler.userList) {
            
            // Skip checking against the user currently being edited
            if (currentUserId != null && u.getID() != null && u.getID().equalsIgnoreCase(currentUserId)) {
                continue;
            }

            String existingEmail = extractEmail(u);
            String existingContact = extractContact(u);

            if (!existingEmail.isEmpty() && existingEmail.equalsIgnoreCase(email.trim())) {
                return "A user with this email address already exists in the system.";
            }
            
            if (!existingContact.isEmpty() && existingContact.equals(contact.trim())) {
                return "A user with this contact number already exists in the system.";
            }
        }

        return null; // Passes all validation checks
    }
    
    private static String extractEmail(User u) {
        if (u instanceof Admin a) return a.getEmail() != null ? a.getEmail() : "";
        if (u instanceof Counselor c) return c.getEmail() != null ? c.getEmail()  : "";
        if (u instanceof Receptionist r) return r.getReceptionistEmail() != null ? r.getReceptionistEmail()  : "";
        if (u instanceof Student s) return s.getEmail() != null ? s.getEmail()  : "";
        return "";
    }

    // Helper: Inspects each subclass instance to get contact number without relying on User.java
    private static String extractContact(User u) {
        if (u instanceof Admin a) return a.getContactNumber() != null ? a.getContactNumber() : "";
        if (u instanceof Counselor c) return c.getContactNumber() != null ? c.getContactNumber() : "";
        if (u instanceof Receptionist r) return r.getReceptionistNumber() != null ? r.getReceptionistNumber() : "";
        if (u instanceof Student s) return s.getContactNumber() != null ? s.getContactNumber() : "";
        return "";
    }
}