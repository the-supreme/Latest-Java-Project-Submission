package counselormgmtsystem.GUIprogram.StudentFrames;

import javax.swing.table.DefaultTableModel;
import counselormgmtsystem.Student;
import counselormgmtsystem.Appointment;
import counselormgmtsystem.Counselor;
import counselormgmtsystem.FileHandler;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class StudentDashboardGUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentDashboardGUI.class.getName());

    private Student currentStudent;
    private final FileHandler fileHandler = new FileHandler();

    private static final java.awt.Color COLOR_NAVY = new java.awt.Color(10, 10, 90);
    private static final java.awt.Color COLOR_DARK_GRAY = new java.awt.Color(70, 74, 79);
    private static final java.awt.Color COLOR_WHITE = new java.awt.Color(255, 255, 255);
    private static final java.awt.Color COLOR_ORANGE = new java.awt.Color(214, 137, 16);
    private static final java.awt.Color COLOR_RED = new java.awt.Color(178, 34, 34);
    private static final java.awt.Color COLOR_GRAY_BUTTON = new java.awt.Color(96, 100, 105);

    public StudentDashboardGUI() {
        initComponents();
        applyCustomStyling();
        this.setSize(940, 540);
        this.setMinimumSize(new java.awt.Dimension(940, 540));
    }

    public StudentDashboardGUI(Student student) {
        this();
        this.currentStudent = student;

        if (FileHandler.userList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }
        populateCounselorList();

        if (student != null) {
            lblWelcomeInfo.setText("Welcome, " + student.getfullName() + " - Student ID: " + student.getID());
        } else {
            lblWelcomeInfo.setText("Welcome, Guest - Student ID: N/A");
        }
        loadAppointmentsData();
    }

    private void applyCustomStyling() {
        getContentPane().setBackground(COLOR_WHITE);

        pnlHeader.setBackground(COLOR_NAVY);
        lblWelcomeInfo.setForeground(COLOR_WHITE);
        lblWelcomeInfo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

        pnlSchedule.setBackground(COLOR_WHITE);
        pnlManage.setBackground(COLOR_WHITE);

        txtDate.setBackground(COLOR_DARK_GRAY);
        txtDate.setForeground(COLOR_WHITE);
        txtDate.setCaretColor(COLOR_WHITE);

        cmbCounselor.setBackground(COLOR_DARK_GRAY);
        cmbCounselor.setForeground(COLOR_WHITE);

        cmbStartTime.setBackground(COLOR_DARK_GRAY);
        cmbStartTime.setForeground(COLOR_WHITE);

        cmbEndTime.setBackground(COLOR_DARK_GRAY);
        cmbEndTime.setForeground(COLOR_WHITE);

        btnBookSession.setBackground(COLOR_NAVY);
        btnBookSession.setForeground(COLOR_WHITE);
        btnBookSession.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        btnReschedule.setBackground(COLOR_ORANGE);
        btnReschedule.setForeground(COLOR_WHITE);
        btnReschedule.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        btnCancel.setBackground(COLOR_RED);
        btnCancel.setForeground(COLOR_WHITE);
        btnCancel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        btnRefresh.setBackground(COLOR_GRAY_BUTTON);
        btnRefresh.setForeground(COLOR_WHITE);
        btnRefresh.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        appointmentTable.setBackground(COLOR_WHITE);
        appointmentTable.setGridColor(COLOR_DARK_GRAY);

        javax.swing.table.DefaultTableCellRenderer headerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        headerRenderer.setOpaque(true);
        headerRenderer.setBackground(COLOR_DARK_GRAY);
        headerRenderer.setForeground(COLOR_WHITE);
        headerRenderer.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        headerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        appointmentTable.getTableHeader().setDefaultRenderer(headerRenderer);
        appointmentTable.getTableHeader().setReorderingAllowed(false);
    }

    public void loadAppointmentsData() {
        DefaultTableModel model = (DefaultTableModel) appointmentTable.getModel();
        model.setRowCount(0);

        if (currentStudent == null) {
            return;
        }

        for (Appointment appt : FileHandler.apptList) {
            if (appt.getStudentID().equals(currentStudent.getID())) {
                String dateTime = appt.getDate() + " " + appt.getStartTime() + " - " + appt.getEndTime();
                model.addRow(new Object[]{
                    appt.getApptID(),
                    appt.getStudentID(),
                    appt.getCounselorID(),
                    dateTime,
                    appt.getBookingType(),
                    appt.getQueueNumber(),
                    appt.getStatus()
                });
            }
        }
    }

    private void populateCounselorList() {
        if (FileHandler.userList.isEmpty()) {
            fileHandler.loadDataFromFiles();
        }

        javax.swing.DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<>();
        model.addElement("-- Select Counselor --");

        for (Object user : FileHandler.userList) {
            if (user instanceof Counselor counselor) {
                String displayName = counselor.getID();
                if (counselor.getfullName() != null && !counselor.getfullName().isEmpty()) {
                    displayName += " - " + counselor.getfullName();
                }
                model.addElement(displayName);
            }
        }

        cmbCounselor.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblWelcomeInfo = new javax.swing.JLabel();
        pnlSchedule = new javax.swing.JPanel();
        lblCounselor = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        cmbCounselor = new javax.swing.JComboBox<>();
        cmbStartTime = new javax.swing.JComboBox<>();
        cmbEndTime = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        btnBookSession = new javax.swing.JButton();
        pnlManage = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnReschedule = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 540));
        setPreferredSize(new java.awt.Dimension(940, 540));
        setResizable(false);

        lblWelcomeInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeInfo.setText("Welcome, [Student Name] - Student ID: [Student ID]");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
                pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(lblWelcomeInfo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
                pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblWelcomeInfo)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlSchedule.setBorder(javax.swing.BorderFactory.createTitledBorder("Schedule New Session"));
        pnlSchedule.setPreferredSize(new java.awt.Dimension(360, 230));

        lblCounselor.setText("Counselor:");
        lblDate.setText("Date (YYYY-MM-DD):");
        lblStartTime.setText("Start Time:");
        lblEndTime.setText("End Time:");

        cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- Start --", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"
        }));
        cmbStartTime.addActionListener(this::cmbStartTimeActionPerformed);

        cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- End --", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
        }));

        btnBookSession.setText("Book Session");
        btnBookSession.addActionListener(this::btnBookSessionActionPerformed);

        javax.swing.GroupLayout pnlScheduleLayout = new javax.swing.GroupLayout(pnlSchedule);
        pnlSchedule.setLayout(pnlScheduleLayout);
        pnlScheduleLayout.setHorizontalGroup(
                pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                                .addComponent(lblCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                                .addComponent(cmbCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                                .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                                .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnBookSession, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlScheduleLayout.setVerticalGroup(
                pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlScheduleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCounselor)
                                        .addComponent(cmbCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDate)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblStartTime)
                                        .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEndTime)
                                        .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBookSession, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlManage.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Records"));
        pnlManage.setPreferredSize(new java.awt.Dimension(360, 200));

        btnCancel.setText("Cancel Selected Session");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        btnReschedule.setText("Reschedule Session");
        btnReschedule.addActionListener(this::btnRescheduleActionPerformed);

        btnRefresh.setText("Refresh Table");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        javax.swing.GroupLayout pnlManageLayout = new javax.swing.GroupLayout(pnlManage);
        pnlManage.setLayout(pnlManageLayout);
        pnlManageLayout.setHorizontalGroup(
                pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlManageLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReschedule, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlManageLayout.setVerticalGroup(
                pnlManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlManageLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReschedule, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ApptID", "StudentID", "Counselor", "Date & Time", "Type", "Queue", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        appointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appointmentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pnlSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                                        .addComponent(pnlManage, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlManage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>                          

    // --- Auto-default End Time to 1 Hour later when Start Time changes ---
    private void cmbStartTimeActionPerformed(java.awt.event.ActionEvent evt) {
        if (cmbStartTime.getSelectedIndex() > 0) {
            String selectedStart = (String) cmbStartTime.getSelectedItem();
            try {
                LocalTime start = LocalTime.parse(selectedStart);
                LocalTime defaultEnd = start.plusHours(1);
                String endStr = String.format("%02d:%02d", defaultEnd.getHour(), defaultEnd.getMinute());

                for (int i = 0; i < cmbEndTime.getItemCount(); i++) {
                    if (cmbEndTime.getItemAt(i).equals(endStr)) {
                        cmbEndTime.setSelectedIndex(i);
                        break;
                    }
                }
            } catch (DateTimeParseException ignored) {
            }
        }
    }

    private void btnBookSessionActionPerformed(java.awt.event.ActionEvent evt) {
        if (currentStudent == null) {
            JOptionPane.showMessageDialog(this, "No student is logged in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbCounselor.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid counselor.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String rawCounselor = (String) cmbCounselor.getSelectedItem();
        String counselorID = rawCounselor.split(" - ")[0].trim();
        String dateStr = txtDate.getText().trim();

        if (cmbStartTime.getSelectedIndex() <= 0 || cmbEndTime.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Please select both a Start Time and an End Time.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String startStr = (String) cmbStartTime.getSelectedItem();
        String endStr = (String) cmbEndTime.getSelectedItem();

        // VALIDATIONS
        String error = validateBookingInputs(dateStr, startStr, endStr, counselorID, null);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error, "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Generate Appt ID & Queue Number
        String newApptID = FileHandler.generateUserID("APT", FileHandler.apptList, Appointment::getApptID);
        String queueNum = "Q" + String.format("%03d", FileHandler.apptList.size() + 1);

        Appointment newAppt = new Appointment(
                newApptID, queueNum, currentStudent.getID(), counselorID, dateStr, startStr, endStr, "Online", "Scheduled"
        );

        FileHandler.apptList.add(newAppt);
        FileHandler.saveDataToFiles();

        loadAppointmentsData();
        JOptionPane.showMessageDialog(this, "Session " + newApptID + " booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        cmbCounselor.setSelectedIndex(0);
        txtDate.setText("");
        cmbStartTime.setSelectedIndex(0);
        cmbEndTime.setSelectedIndex(0);
    }

    private void btnRescheduleActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = appointmentTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment from the table to reschedule.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String apptId = (String) appointmentTable.getValueAt(selectedRow, 0);
        String counselorID = (String) appointmentTable.getValueAt(selectedRow, 2);
        String newDate = txtDate.getText().trim();

        if (cmbStartTime.getSelectedIndex() <= 0 || cmbEndTime.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Please select both Start Time and End Time from the panel.", "Input Required", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String newStartStr = (String) cmbStartTime.getSelectedItem();
        String newEndStr = (String) cmbEndTime.getSelectedItem();

        // VALIDATIONS
        String error = validateBookingInputs(newDate, newStartStr, newEndStr, counselorID, apptId);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error, "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (Appointment appt : FileHandler.apptList) {
            if (appt.getApptID().equals(apptId)) {
                appt.setDate(newDate);
                appt.setStartTime(newStartStr);
                appt.setEndTime(newEndStr);
                appt.setStatus("Rescheduled");
                break;
            }
        }

        FileHandler.saveDataToFiles();
        loadAppointmentsData();
        JOptionPane.showMessageDialog(this, "Appointment " + apptId + " rescheduled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        txtDate.setText("");
        cmbStartTime.setSelectedIndex(0);
        cmbEndTime.setSelectedIndex(0);
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        appointmentTable.clearSelection();
        loadAppointmentsData();
        JOptionPane.showMessageDialog(this, "Table view refreshed.", "Refreshed", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = appointmentTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment from the table to cancel.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel the selected session?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String apptId = (String) appointmentTable.getValueAt(selectedRow, 0);

            for (Appointment appt : FileHandler.apptList) {
                if (appt.getApptID().equals(apptId)) {
                    appt.setStatus("Cancelled");
                    break;
                }
            }

            FileHandler.saveDataToFiles();
            loadAppointmentsData();
            JOptionPane.showMessageDialog(this, "Session status updated to Cancelled.");
        }
    }

    private void appointmentTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow != -1) {
            String counselorID = appointmentTable.getValueAt(selectedRow, 2).toString();
            String dateTime = appointmentTable.getValueAt(selectedRow, 3).toString();

            for (int i = 0; i < cmbCounselor.getItemCount(); i++) {
                if (cmbCounselor.getItemAt(i).startsWith(counselorID)) {
                    cmbCounselor.setSelectedIndex(i);
                    break;
                }
            }

            String[] parts = dateTime.split(" ");
            if (parts.length >= 4) {
                txtDate.setText(parts[0]);
                cmbStartTime.setSelectedItem(parts[1]);
                cmbEndTime.setSelectedItem(parts[3]);
            }
        }
    }

// --- Helper Validation Method ---
    private String validateBookingInputs(String dateStr, String startStr, String endStr, String counselorID, String currentApptId) {
        LocalDate rosterDate;
        LocalTime startTime, endTime;

        // 1. Date Format Validation
        try {
            rosterDate = LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            return "Date must be in YYYY-MM-DD format.";
        }

        // 2. Past Date Validation
        LocalDate today = LocalDate.now();
        if (rosterDate.isBefore(today)) {
            return "You cannot schedule an appointment for a past date.";
        }

        // 3. NEW: 3 Months Advance Limit Validation
        if (rosterDate.isAfter(today.plusMonths(3))) {
            return "You cannot schedule an appointment more than 3 months in advance.";
        }

        // 4. Time Format Validation
        try {
            startTime = LocalTime.parse(startStr);
            endTime = LocalTime.parse(endStr);
        } catch (DateTimeParseException e) {
            return "Invalid time format.";
        }

        // 5. Time Logic Validation
        if (!endTime.isAfter(startTime)) {
            return "End Time must be after Start Time.";
        }

        // 6. Session Duration Validation (1 to 2 hours)
        long duration = Duration.between(startTime, endTime).toMinutes();
        if (duration < 60 || duration > 120) {
            return "A session must be between 1 hour (60 mins) and 2 hours (120 mins) long.";
        }

        // 7. Counselor Overlapping Booking Guard
        for (Appointment a : FileHandler.apptList) {
            if (currentApptId != null && a.getApptID().equals(currentApptId)) {
                continue;
            }
            if (a.getStatus().equalsIgnoreCase("Cancelled")) {
                continue;
            }

            if (a.getCounselorID().equals(counselorID) && a.getDate().equals(dateStr)) {
                LocalTime existingStart = LocalTime.parse(a.getStartTime());
                LocalTime existingEnd = LocalTime.parse(a.getEndTime());

                if (startTime.isBefore(existingEnd) && endTime.isAfter(existingStart)) {
                    return "Counselor already has a booking during this time slot (" + a.getStartTime() + " - " + a.getEndTime() + ").";
                }
            }
        }

        return null; // Passes all validation checks
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton btnBookSession;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReschedule;
    private javax.swing.JComboBox<String> cmbCounselor;
    private javax.swing.JComboBox<String> cmbStartTime;
    private javax.swing.JComboBox<String> cmbEndTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCounselor;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblWelcomeInfo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlManage;
    private javax.swing.JPanel pnlSchedule;
    private javax.swing.JTextField txtDate;
    // End of variables declaration                     
}
