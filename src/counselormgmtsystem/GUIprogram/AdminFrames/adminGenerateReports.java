package counselormgmtsystem;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class adminGenerateReports extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminGenerateReports.class.getName());
    private DefaultTableModel model = new DefaultTableModel();
    private Admin currentAdmin;

    public adminGenerateReports(Admin admin) {
        this.currentAdmin = admin;
        if (FileHandler.apptList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }
        initComponents();
        jTable1.setModel(model);

        JTextField[] displayFields = {totalTf, completedTf, pendingTf, cancelledTf};
        for (JTextField tf : displayFields) {
            tf.setEditable(false);
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        }

        updateUIForCategory();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    //getters so admin can update ui
    public DefaultTableModel getModel() {
        return model;
    }

    public javax.swing.JTextField getTotalTf() {
        return totalTf;
    }

    public javax.swing.JTextField getCompletedTf() {
        return completedTf;
    }

    public javax.swing.JTextField getPendingTf() {
        return pendingTf;
    }

    public javax.swing.JTextField getCancelledTf() {
        return cancelledTf;
    }

    private void updateUIForCategory() {
        String category = (String) jComboBox2.getSelectedItem();

        //reset Text Fields
        totalTf.setText("");
        completedTf.setText("");
        pendingTf.setText("");
        cancelledTf.setText("");

        if (category.equals("Appointments")) {
            jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
            jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Completed"));

            //show all boxes
            jPanel15.setVisible(true);
            jPanel14.setVisible(true);

            model.setColumnIdentifiers(new String[]{"Appt ID", "Student ID", "Counselor ID", "Date", "Start Time", "End Time", "Booking Type", "Queue Number", "Status"});

        } else if (category.equals("Counselor Workload")) {
            jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Counselors"));
            jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Active Counselors"));

            //hide boxes
            jPanel15.setVisible(false);
            jPanel14.setVisible(false);

            model.setColumnIdentifiers(new String[]{"Counselor ID", "Total Bookings Handled"});

        } else if (category.equals("Consultation Records")) {
            jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Records"));
            jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Unique Students"));

            jPanel15.setVisible(false);
            jPanel14.setVisible(false);

            model.setColumnIdentifiers(new String[]{"Record ID", "Appt ID", "Student ID", "Counselor ID", "Date", "Notes"});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        totalTf = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        completedTf = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        pendingTf = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        cancelledTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        yearTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateTf = new javax.swing.JTextField();
        generateBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Manage Receptionists");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Report Generation");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(405, 405, 405))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 950, 50));

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 257, 940, 283));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalTf.setBackground(new java.awt.Color(255, 255, 255));
        totalTf.setBorder(null);
        totalTf.addActionListener(this::totalTfActionPerformed);
        jPanel12.add(totalTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 60));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Completed\n"));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completedTf.setBackground(new java.awt.Color(255, 255, 255));
        completedTf.setBorder(null);
        completedTf.addActionListener(this::completedTfActionPerformed);
        jPanel13.add(completedTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, 60));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Pending\n"));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pendingTf.setBackground(new java.awt.Color(255, 255, 255));
        pendingTf.setBorder(null);
        pendingTf.addActionListener(this::pendingTfActionPerformed);
        jPanel15.add(pendingTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 33, 170, 60));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Cancelled"));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelledTf.setBackground(new java.awt.Color(255, 255, 255));
        cancelledTf.setBorder(null);
        cancelledTf.addActionListener(this::cancelledTfActionPerformed);
        jPanel14.add(cancelledTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 23, 170, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Timeframe:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 27, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Monthly", "Quarterly", "Yearly" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 24, -1, -1));

        jLabel2.setText("Year:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 27, 37, -1));

        yearTf.addActionListener(this::yearTfActionPerformed);
        jPanel1.add(yearTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 24, 53, -1));

        jLabel3.setText("<html>Month/Q/Date (mm-dd):<html>");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 89, -1));

        dateTf.addActionListener(this::dateTfActionPerformed);
        jPanel1.add(dateTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 24, 71, -1));

        generateBtn.setText("Generate Report");
        generateBtn.addActionListener(this::generateBtnActionPerformed);
        jPanel1.add(generateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 24, -1, -1));

        exportBtn.setText("Export to File");
        exportBtn.addActionListener(this::exportBtnActionPerformed);
        jPanel1.add(exportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 24, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Appointments", "Counselor Workload", "Consultation Records", " " }));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 24, 119, -1));

        jLabel4.setText("Category:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 64, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(288, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void totalTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTfActionPerformed

    private void completedTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completedTfActionPerformed

    private void cancelledTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelledTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelledTfActionPerformed

    private void pendingTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingTfActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "The table is empty. Generate a report first before exporting.", "Export Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Dropdown option for export type
        String[] options = {"Export as PDF", "Export as Excel (CSV)"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Select the format you would like to export the report to:",
                "Choose Export Format",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            exportToPDF();
        } else if (choice == 1) {
            exportToExcel();
        }
    }//GEN-LAST:event_exportBtnActionPerformed

    private void exportToPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Report As PDF");
        String category = (String) jComboBox2.getSelectedItem();
        fileChooser.setSelectedFile(new java.io.File(category.replaceAll("\\s+", "_") + "_Report.pdf"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            // Ensure .pdf extension
            if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".pdf");
            }

            try {
                // 1. Setup Header and Footer
                String reportTitle = category + " Report (" + jComboBox1.getSelectedItem() + ")";
                java.text.MessageFormat header = new java.text.MessageFormat(reportTitle);
                java.text.MessageFormat footer = new java.text.MessageFormat("Page - {0}");

                // 2. Configure Print Attributes to target PDF / File Stream
                javax.print.attribute.HashPrintRequestAttributeSet attr = new javax.print.attribute.HashPrintRequestAttributeSet();
                attr.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE); // Fits wide tables better

                // Check if any Print Service exists
                javax.print.PrintService[] services = java.awt.print.PrinterJob.lookupPrintServices();
                if (services.length == 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "No Print Service or Virtual PDF Printer found on your system!\n\n"
                            + "Please enable 'Microsoft Print to PDF' (Windows) or 'Save as PDF' in your OS settings,\n"
                            + "or use the 'Export as Excel (CSV)' option instead.",
                            "Print Service Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // 3. Print the JTable
                boolean complete = jTable1.print(
                        javax.swing.JTable.PrintMode.FIT_WIDTH,
                        header,
                        footer,
                        false, // set to false so it doesn't force a native print dialog if headless
                        attr,
                        true
                );

                if (complete) {
                    JOptionPane.showMessageDialog(this, "PDF Report successfully generated!", "Export Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (java.awt.print.PrinterException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Could not complete PDF export: " + e.getMessage() + "\n\nTip: You can export as Excel (CSV) as an alternative!",
                        "Export Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // --- 2. EXCEL EXPORT (.CSV FORMAT) ---
    private void exportToExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Report As Excel / CSV");
        String category = (String) jComboBox2.getSelectedItem();
        fileChooser.setSelectedFile(new java.io.File(category.replaceAll("\\s+", "_") + "_Report.csv"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".csv");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {

                // Write Excel Column Headers
                for (int i = 0; i < model.getColumnCount(); i++) {
                    writer.write("\"" + model.getColumnName(i) + "\"" + (i == model.getColumnCount() - 1 ? "" : ","));
                }
                writer.newLine();

                // Write Data Rows
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object val = model.getValueAt(row, col);
                        String strVal = (val != null) ? val.toString().replace("\"", "\"\"") : "";
                        writer.write("\"" + strVal + "\"" + (col == model.getColumnCount() - 1 ? "" : ","));
                    }
                    writer.newLine();
                }

                JOptionPane.showMessageDialog(this, "Excel Report successfully saved to:\n" + fileToSave.getAbsolutePath(), "Export Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error exporting to Excel: " + e.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateInputs(String timeframe, String yearStr, String dateStr) {
        // 1. Validate Year
        if (yearStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 4-digit year (e.g., 2026).", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            int year = Integer.parseInt(yearStr);
            if (year < 2000 || year > 2100) {
                JOptionPane.showMessageDialog(this, "Year must be between 2000 and 2100.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Year must be a valid number.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // 2. Validate Date/Month/Quarter field based on selected timeframe
        switch (timeframe) {
            case "Daily":
                // Format expected: MM-DD or M-D (e.g. 05-20 or 5-20)
                if (!dateStr.matches("^(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[01])$")) {
                    JOptionPane.showMessageDialog(this, "For 'Daily' timeframe, format must be MM-DD (e.g., 05-12).", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                break;

            case "Monthly":
                // Format expected: MM or M (e.g. 05 or 5)
                if (!dateStr.matches("^(0?[1-9]|1[0-2])$")) {
                    JOptionPane.showMessageDialog(this, "For 'Monthly' timeframe, format must be MM (e.g., 05 for May).", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                break;

            case "Quarterly":
                // Format expected: Q1, Q2, Q3, Q4 or 1, 2, 3, 4
                if (!dateStr.matches("(?i)^(Q[1-4]|[1-4])$")) {
                    JOptionPane.showMessageDialog(this, "For 'Quarterly' timeframe, enter Q1, Q2, Q3, or Q4.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                break;

            case "Yearly":
                // For yearly reports, specific month/day input isn't strictly necessary, but clear it or ignore safely
                break;
        }

        return true;
    }

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        String category = (String) jComboBox2.getSelectedItem();
        String timeframe = (String) jComboBox1.getSelectedItem();
        String yearStr = yearTf.getText().trim();
        String dateStr = dateTf.getText().trim();
        
        if (!validateInputs(timeframe, yearStr, dateStr)) {
            return;
        }
        
        currentAdmin.generateReport(category, timeframe, yearStr, dateStr, this);

        }//GEN-LAST:event_generateBtnActionPerformed


    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        updateUIForCategory();    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void yearTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTfActionPerformed

    private void dateTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTfActionPerformed

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cancelledTf;
    private javax.swing.JTextField completedTf;
    private javax.swing.JTextField dateTf;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton generateBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pendingTf;
    private javax.swing.JTextField totalTf;
    private javax.swing.JTextField yearTf;
    // End of variables declaration//GEN-END:variables
}
