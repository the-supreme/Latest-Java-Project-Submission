package counselormgmtsystem.GUIprogram.AdminFrames;
import counselormgmtsystem.Admin;
import counselormgmtsystem.FileHandler;
//import counselormgmtsystem.adminApptHistory;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class adminApptStats extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminApptStats.class.getName());
    private DefaultTableModel model = new DefaultTableModel();
    private Admin currentAdmin;


    public adminApptStats(Admin admin) {
        this.currentAdmin = admin;
        
        if (FileHandler.apptList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }
        
        model.setColumnIdentifiers(new String[]{"Counselor ID", "Total Bookings Handled"});
        initComponents();
        JTextField[] dashboardFields = {apptBookedTf, apptCompletedTf, apptCancelledTf, 
                                        apptPendingTf, completionRateTf, morningTf, 
                                        afternoonTf, onlineTf, walkInTf};
        for (JTextField tf : dashboardFields) {
            tf.setEditable(false);
            tf.setHorizontalAlignment(JTextField.CENTER);
     
        }

        calculateStats("");
    }

    public javax.swing.JTextField getApptBookedTf() { return apptBookedTf; }
    public javax.swing.JTextField getApptCompletedTf() { return apptCompletedTf; }
    public javax.swing.JTextField getApptCancelledTf() { return apptCancelledTf; }
    public javax.swing.JTextField getApptPendingTf() { return apptPendingTf; }
    public javax.swing.JTextField getCompletionRateTf() { return completionRateTf; }
    public javax.swing.JTextField getMorningTf() { return morningTf; }
    public javax.swing.JTextField getAfternoonTf() { return afternoonTf; }
    public javax.swing.JTextField getOnlineTf() { return onlineTf; }
    public javax.swing.JTextField getWalkInTf() { return walkInTf; }
    public DefaultTableModel getModel() { return model; }

    private void calculateStats(String dateFilter) {
        currentAdmin.updateApptStats(dateFilter, this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        apptCompletedTf = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        apptBookedTf = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        apptCancelledTf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dateFilterTf = new javax.swing.JTextField();
        dateFilterBtn = new javax.swing.JButton();
        viewAllBtn = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        apptPendingTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        counselorTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        completionRateTf = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        afternoonTf = new javax.swing.JTextField();
        morningTf = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        walkInTf = new javax.swing.JTextField();
        onlineTf = new javax.swing.JTextField();
        apptHistoryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(940, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Appointments Completed"));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apptCompletedTf.setBackground(new java.awt.Color(255, 255, 255));
        apptCompletedTf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apptCompletedTf.setBorder(null);
        apptCompletedTf.addActionListener(this::apptCompletedTfActionPerformed);
        jPanel14.add(apptCompletedTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 40));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 190, 110));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Appointments Booked"));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apptBookedTf.setBackground(new java.awt.Color(255, 255, 255));
        apptBookedTf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apptBookedTf.setBorder(null);
        apptBookedTf.addActionListener(this::apptBookedTfActionPerformed);
        jPanel12.add(apptBookedTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 40));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 110));

        jPanel11.setBackground(new java.awt.Color(0, 0, 102));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("View Appointment Statistics");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(341, 341, 341))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 950, 50));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Appointments Cancelled"));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apptCancelledTf.setBackground(new java.awt.Color(255, 255, 255));
        apptCancelledTf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apptCancelledTf.setBorder(null);
        apptCancelledTf.addActionListener(this::apptCancelledTfActionPerformed);
        jPanel25.add(apptCancelledTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 40));

        getContentPane().add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, 110));

        jLabel11.setText("Filter By Month (yy-mm):");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(dateFilterTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 100, -1));

        dateFilterBtn.setText("Filter");
        dateFilterBtn.addActionListener(this::dateFilterBtnActionPerformed);
        getContentPane().add(dateFilterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        viewAllBtn.setText("View All");
        viewAllBtn.addActionListener(this::viewAllBtnActionPerformed);
        getContentPane().add(viewAllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Pending Appointments"));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apptPendingTf.setBackground(new java.awt.Color(255, 255, 255));
        apptPendingTf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apptPendingTf.setBorder(null);
        apptPendingTf.addActionListener(this::apptPendingTfActionPerformed);
        jPanel29.add(apptPendingTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 40));

        getContentPane().add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 190, 110));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        counselorTable.setModel(model);
        jScrollPane1.setViewportView(counselorTable);

        jLabel1.setText("Appointments Handled Per Counselor:");

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment Completion Rate"));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completionRateTf.setBackground(new java.awt.Color(255, 255, 255));
        completionRateTf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        completionRateTf.setBorder(null);
        completionRateTf.addActionListener(this::completionRateTfActionPerformed);
        jPanel27.add(completionRateTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 36, -1, 61));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Busiest Hours"));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Morning Sessions:");
        jPanel26.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 34, -1, -1));

        jLabel3.setText("Afternoon Sessions:");
        jPanel26.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 66, -1, -1));
        jPanel26.add(afternoonTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 63, 71, -1));
        jPanel26.add(morningTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 31, 71, -1));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Booking Types"));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Online:");
        jPanel28.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 34, -1, -1));

        jLabel12.setText("Walk In:");
        jPanel28.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 66, -1, -1));
        jPanel28.add(walkInTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 63, 71, -1));

        onlineTf.addActionListener(this::onlineTfActionPerformed);
        jPanel28.add(onlineTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 31, 71, -1));

        apptHistoryBtn.setText("View Appointment History Log");
        apptHistoryBtn.addActionListener(this::apptHistoryBtnActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apptHistoryBtn)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(apptHistoryBtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apptCompletedTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptCompletedTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apptCompletedTfActionPerformed

    private void apptBookedTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptBookedTfActionPerformed
    }//GEN-LAST:event_apptBookedTfActionPerformed

    private void apptCancelledTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptCancelledTfActionPerformed
    }//GEN-LAST:event_apptCancelledTfActionPerformed

    private void dateFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFilterBtnActionPerformed
        String filter = dateFilterTf.getText().trim();
        calculateStats(filter);                                 
    }//GEN-LAST:event_dateFilterBtnActionPerformed

    private void completionRateTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completionRateTfActionPerformed
    }//GEN-LAST:event_completionRateTfActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        dateFilterTf.setText("");
        calculateStats("");
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void apptPendingTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptPendingTfActionPerformed
    }//GEN-LAST:event_apptPendingTfActionPerformed

    private void apptHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptHistoryBtnActionPerformed
        adminApptHistory apptHistoryPage = new adminApptHistory(this.currentAdmin);
        apptHistoryPage.setLocationRelativeTo(null);
        apptHistoryPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_apptHistoryBtnActionPerformed

    private void onlineTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineTfActionPerformed
    }//GEN-LAST:event_onlineTfActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        FileHandler fh = new FileHandler();
        try {
            fh.loadDataFromFiles();
        } catch (Exception e) {
            System.out.println("Warning: Data load failed: " + e.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> {
            Admin mockupAdmin = new Admin("ADM000", "admin", "admin123", "System Admin", "012-3456789", "admin@apu.edu.my", "Room 4.2");
            new adminApptStats(mockupAdmin).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField afternoonTf;
    private javax.swing.JTextField apptBookedTf;
    private javax.swing.JTextField apptCancelledTf;
    private javax.swing.JTextField apptCompletedTf;
    private javax.swing.JButton apptHistoryBtn;
    private javax.swing.JTextField apptPendingTf;
    private javax.swing.JTextField completionRateTf;
    private javax.swing.JTable counselorTable;
    private javax.swing.JButton dateFilterBtn;
    private javax.swing.JTextField dateFilterTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField morningTf;
    private javax.swing.JTextField onlineTf;
    private javax.swing.JButton viewAllBtn;
    private javax.swing.JTextField walkInTf;
    // End of variables declaration//GEN-END:variables
}
