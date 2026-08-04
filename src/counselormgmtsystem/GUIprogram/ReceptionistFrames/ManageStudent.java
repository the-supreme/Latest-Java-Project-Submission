/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package counselormgmtsystem.GUIprogram.ReceptionistFrames;

import counselormgmtsystem.FileHandler;
import counselormgmtsystem.Receptionist;
import counselormgmtsystem.Student;
import javax.swing.table.DefaultTableModel;
import counselormgmtsystem.User;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author thesupreme
 */
public class ManageStudent extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManageStudent.class.getName());

    /**
     * Creates new form ManageStudent
     */
    private static Receptionist currentReceptionist;
    private DefaultTableModel model;

    public ManageStudent(Receptionist receptionist) {
        this.currentReceptionist = receptionist;
        initStudentTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void initStudentTable() {
        String[] columns = {
            "StudentID", "Username", "Full Name", "Intake Code", "Email", "Contact Number", "Emergency Contact"
        };

        this.model = new DefaultTableModel(columns, 0);

        initComponents();

        studentTable.setModel(model);

        studentTable.setRowHeight(28);
        studentTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
//        studentTable.setSelectionForeground(java.awt.Color.WHITE);

        JTableHeader header = studentTable.getTableHeader();
        header.setBackground(new java.awt.Color(0, 0, 102));
        header.setForeground(java.awt.Color.WHITE);
        header.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));

        header.setOpaque(true);

        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setBackground(new Color(0, 0, 102)); // Solid Dark Blue
                label.setForeground(Color.WHITE);          // White Text
                label.setFont(new Font("SansSerif", Font.BOLD, 12));
                label.setHorizontalAlignment(JLabel.CENTER); // Centered header text
                label.setOpaque(true);                     // Forces color painting

                // Subtle light gray border between header columns
                label.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(200, 200, 200)));

                return label;
            }
        });

        studentTable.setAutoCreateColumnsFromModel(true);

        for (User u : FileHandler.userList) {
            if (u instanceof Student s) {
                model.addRow(new Object[]{
                    s.getID(),
                    s.getUsername(),
                    s.getfullName(),
                    s.getIntakeCode(),
                    s.getEmail(),
                    s.getContactNumber(),
                    s.getEmergencyContact()
                });
            }
        }

        studentTable.setModel(model);
        final int[] lastSelectedRow = {-1};

        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int clickedRow = studentTable.getSelectedRow();

                // TOGGLE DESELECT: If user clicks the currently selected row again
                if (clickedRow == lastSelectedRow[0] && clickedRow != -1) {
                    clearTextFields(); // Clears all text boxes and removes table selection
                    lastSelectedRow[0] = -1; // Reset row tracker
                    return;
                }

                // SELECT ROW: Populate text fields with student details
                if (clickedRow != -1) {
                    lastSelectedRow[0] = clickedRow;
                    String studentID = model.getValueAt(clickedRow, 0).toString();

                    for (User u : FileHandler.userList) {
                        if (u.getID().equals(studentID) && u instanceof Student s) {
                            nameTF.setText(s.getfullName());
                            usernameTF.setText(s.getUsername());
                            passwordTF.setText(s.getPassword());
                            icTF.setText(s.getIntakeCode());
                            emailTF.setText(s.getEmail());
                            cnTF.setText(s.getContactNumber());
                            ecTF.setText(s.getEmergencyContact());
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        delButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        icTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cnTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ecTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Account Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentTable.setModel(model);
        studentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studentTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 600, 370));

        delButton.setBackground(new java.awt.Color(204, 0, 0));
        delButton.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        delButton.setForeground(new java.awt.Color(255, 255, 255));
        delButton.setText("Delete");
        delButton.setBorderPainted(false);
        delButton.addActionListener(this::delButtonActionPerformed);
        jPanel2.add(delButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        addButton.setBackground(new java.awt.Color(0, 0, 102));
        addButton.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorderPainted(false);
        addButton.addActionListener(this::addButtonActionPerformed);
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, -1, -1));

        updateButton.setBackground(new java.awt.Color(204, 102, 0));
        updateButton.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(this::updateButtonActionPerformed);
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        nameTF.addActionListener(this::nameTFActionPerformed);
        jPanel2.add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 190, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(" Username:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, -1));
        jPanel2.add(usernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 190, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Intake Code:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 111, -1));

        icTF.addActionListener(this::icTFActionPerformed);
        jPanel2.add(icTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        emailTF.addActionListener(this::emailTFActionPerformed);
        jPanel2.add(emailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 190, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("<html>Contact Number: <html>");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, -1));
        jPanel2.add(cnTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 190, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("<html> Emergency Contact: <html>");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 100, -1));
        jPanel2.add(ecTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 190, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Password: ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 20));

        passwordTF.addActionListener(this::passwordTFActionPerformed);
        jPanel2.add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTableData() {
        // Clear existing table rows
        model.setRowCount(0);

        // Repopulate rows from memory list
        for (User u : FileHandler.userList) {
            if (u instanceof Student s) {
                model.addRow(new Object[]{
                    s.getID(),
                    s.getUsername(),
                    s.getfullName(),
                    s.getIntakeCode(),
                    s.getEmail(),
                    s.getContactNumber(),
                    s.getEmergencyContact()
                });
            }
        }
    }

    private void clearTextFields() {
        nameTF.setText("");
        usernameTF.setText("");
        icTF.setText("");
        passwordTF.setText("");
        emailTF.setText("");
        cnTF.setText("");
        ecTF.setText("");
        studentTable.clearSelection();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = nameTF.getText().trim();
        String username = usernameTF.getText().trim();
        String password = passwordTF.getText();
        String intake = icTF.getText().trim();
        String email = emailTF.getText().trim();
        String contact = cnTF.getText().trim();
        String emergency = ecTF.getText().trim();

        String validationError = validateStudentInputs(name, username, password, intake, email, contact, emergency, null);
        if (validationError != null) {
            JOptionPane.showMessageDialog(this, validationError, "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean success = currentReceptionist.createStudentAccount(username, password, name, intake, email, contact, emergency);

        if (success) {
            loadTableData();
            clearTextFields();
            FileHandler.saveDataToFiles();
            JOptionPane.showMessageDialog(this, "Student Account Created Successfully!");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a student from the table to delete!");
            return;
        }

        String studentID = model.getValueAt(selectedRow, 0).toString();

        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete Student " + studentID + "?",
                "Confirm Delete",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            boolean success = currentReceptionist.deleteStudentAccount(studentID);

            if (success) {
                loadTableData();
                clearTextFields();
                FileHandler.saveDataToFiles();
                JOptionPane.showMessageDialog(this, "Student Account " + studentID + " Deleted!");
            }
        }
    }//GEN-LAST:event_delButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student from the table to update!", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String studentID = model.getValueAt(selectedRow, 0).toString();
        String name = nameTF.getText().trim();
        String username = usernameTF.getText().trim();
        String password = passwordTF.getText().trim();
        String intake = icTF.getText().trim();
        String email = emailTF.getText().trim();
        String contact = cnTF.getText().trim();
        String emergency = ecTF.getText().trim();

        // Perform Sequential Validation (shows first error)
        String validationError = validateStudentInputs(name, username, password, intake, email, contact, emergency, studentID);
        if (validationError != null) {
            JOptionPane.showMessageDialog(this, validationError, "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean success = currentReceptionist.updateStudentAccount(
                studentID, username, password, name, intake, email, contact, emergency
        );

        if (success) {
            loadTableData();
            clearTextFields();
            FileHandler.saveDataToFiles();
            JOptionPane.showMessageDialog(this, "Student " + studentID + " Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private String validateStudentInputs(String name, String username, String password, String intake, String email, String contact, String emergency, String currentStudentID) {
        // 1. Mandatory Presence Check
        if (name.isEmpty()) {
            return "Full Name cannot be empty.";
        }
        if (username.isEmpty()) {
            return "Username cannot be empty.";
        }
        if (password.isEmpty()) {
            return "Password cannot be empty.";
        }
        if (intake.isEmpty()) {
            return "Intake Code cannot be empty.";
        }
        if (email.isEmpty()) {
            return "Email cannot be empty.";
        }
        if (contact.isEmpty()) {
            return "Contact Number cannot be empty.";
        }
        if (emergency.isEmpty()) {
            return "Emergency Contact cannot be empty.";
        }

        // 2. Full Name Validation (Letters and spaces only, no digits)
        if (!name.matches("^[a-zA-Z\\s.'-]+$")) {
            return "Full Name can only contain alphabetical letters and spaces.";
        }

        // 3. Username Format & Uniqueness
        if (username.contains(" ")) {
            return "Username cannot contain spaces.";
        }
        for (User u : FileHandler.userList) {
            if (currentStudentID != null && u.getID().equalsIgnoreCase(currentStudentID)) {
                continue; // Skip current student during update
            }
            if (u.getUsername().equalsIgnoreCase(username)) {
                return "Username '" + username + "' is already taken. Please choose another.";
            }
        }

        // 4. Password Strength
        if (password.length() < 6) {
            return "Password must be at least 6 characters long.";
        }

        // 5. Intake Code Validation (Flexible: allows letters, numbers, hyphens, and slashes)
        if (!intake.matches("^[a-zA-Z0-9/\\-\\s]+$")) {
            return "Intake Code can only contain letters, numbers, hyphens, or slashes.";
        }

        // 6. Email Format Validation
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            return "Invalid Email format. Please enter a valid email address (e.g., alex.lee@mail.apu.edu.my).";
        }

        // 7. Contact Number Format (Malaysian format: e.g. 012-3456789 or 016-5554433)
        if (!contact.matches("^01[0-9]-[0-9]{7,8}$") && !contact.matches("^01[0-9]{8,9}$")) {
            return "Invalid Contact Number. Must be a valid Malaysian phone number (e.g., 016-5554433).";
        }

        // 8. Emergency Contact Validation (Flexible: allows phone numbers and descriptions)
        if (!emergency.matches("^[0-9\\-\\s()a-zA-Z]{9,30}$")) {
            return "Invalid Emergency Contact format. Please enter a valid contact number (e.g., 016-5550000 or 016-5550000 (Father)).";
        }

        return null; // All inputs passed!
    }

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void icTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ManageStudent(currentReceptionist).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField cnTF;
    private javax.swing.JButton delButton;
    private javax.swing.JTextField ecTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField icTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
