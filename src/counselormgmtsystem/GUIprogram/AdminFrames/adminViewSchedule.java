package counselormgmtsystem.GUIprogram.AdminFrames;
import counselormgmtsystem.Admin;
import counselormgmtsystem.Appointment;
import counselormgmtsystem.FileHandler;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class adminViewSchedule extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminViewSchedule.class.getName());
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = new String[]{"Appointment ID", "Student ID", "Counselor ID", "Date", "Time", "Booking Type", "Queue No", "Status"};

    private ArrayList<Appointment> appointmentRefs = new ArrayList<>();
    private Appointment selectedSchedule = null;
    private Admin currentAdmin;

    public adminViewSchedule(Admin admin) {
        this.currentAdmin = admin;
        if (FileHandler.apptList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }

        if (FileHandler.rosterList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }

        model.setColumnIdentifiers(columnName);
        initComponents();
        loadSchedules();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void loadSchedules() {
        model.setRowCount(0);
        appointmentRefs.clear();
        for (Appointment a : FileHandler.apptList) {
            appointmentRefs.add(a);
            model.addRow(new Object[]{
                a.getApptID(),
                a.getStudentID(),
                a.getCounselorID(),
                a.getDate(),
                a.getStartTime(),
                a.getEndTime(),
                a.getBookingType(),
                a.getQueueNumber(),
                a.getStatus()
            });
        }
        selectedSchedule = null;
        scheduleTable.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        counselorTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        counselorBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scheduleTable.setModel(model);
        scheduleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                scheduleTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(scheduleTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 940, 390));

        jLabel1.setText("Select Appointment to Cancel:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 205, -1));

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(this::cancelBtnActionPerformed);
        getContentPane().add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(this::backBtnActionPerformed);
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, -1));

        counselorTf.addActionListener(this::counselorTfActionPerformed);
        getContentPane().add(counselorTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 177, -1));

        jLabel2.setText("Filter by CounselorID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 205, -1));

        counselorBtn.setText("Filter");
        counselorBtn.addActionListener(this::counselorBtnActionPerformed);
        getContentPane().add(counselorBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("View Schedule");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 489, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, -1, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (selectedSchedule == null) {
            JOptionPane.showMessageDialog(this, "Please select an appointment from the table to cancel.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel Appointment " + selectedSchedule.getApptID() + "?",
                "Confirm Cancel", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String errorMessage = currentAdmin.cancelAppointment(selectedSchedule);

            if (errorMessage != null) {
                //alr cancelled or smth went wrongg
                JOptionPane.showMessageDialog(this, errorMessage, "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                loadSchedules();
                JOptionPane.showMessageDialog(this, "Appointment cancelled successfully. The Roster slot is now Available again.");
            }
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void counselorTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counselorTfActionPerformed
        counselorBtnActionPerformed(evt);
    }//GEN-LAST:event_counselorTfActionPerformed

    private void counselorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counselorBtnActionPerformed
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        scheduleTable.setRowSorter(sorter);

        String query = counselorTf.getText().trim();

        if (query.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            //apply filter specifically to counselorId (row 2)
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query, 2));
        }
    }//GEN-LAST:event_counselorBtnActionPerformed

    private void scheduleTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleTableMouseReleased
        int viewRow = scheduleTable.getSelectedRow();
        if (viewRow < 0) {
            return;
        }
        int modelRow = scheduleTable.convertRowIndexToModel(viewRow);
        selectedSchedule = appointmentRefs.get(modelRow);
    }//GEN-LAST:event_scheduleTableMouseReleased

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        adminManageRoster manageRosterPage = new adminManageRoster(this.currentAdmin);
        manageRosterPage.setLocationRelativeTo(null);
        manageRosterPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        FileHandler fh = new FileHandler();
        try {
            fh.loadDataFromFiles();
        } catch (Exception e) {
            System.out.println("Warning: Data load failed: " + e.getMessage());
        }
        //**dummy admin, delete ltr
        java.awt.EventQueue.invokeLater(() -> {
            Admin mockupAdmin = new Admin("ADM000", "admin", "admin123", "System Admin", "012-3456789", "admin@apu.edu.my", "Room 4.2");
            new adminViewSchedule(mockupAdmin).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton counselorBtn;
    private javax.swing.JTextField counselorTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable scheduleTable;
    // End of variables declaration//GEN-END:variables
}
