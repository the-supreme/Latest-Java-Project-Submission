package counselormgmtsystem.GUIprogram.AdminFrames;

import counselormgmtsystem.Admin;
import counselormgmtsystem.Counselor;
import counselormgmtsystem.FileHandler;
import counselormgmtsystem.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class adminManageCounselor extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminManageCounselor.class.getName());

    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = new String[]{"ID", "Full Name", "Contact Number", "Email", "Specialisation", "Status"};

    private ArrayList<Counselor> counselorRefs = new ArrayList<>();
    private Counselor selectedCounselor = null;

    private Admin currentAdmin;

    public adminManageCounselor(Admin admin) {
        this.currentAdmin = admin;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        if (FileHandler.userList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }

        model.setColumnIdentifiers(columnName);
        initComponents();
        statusCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Active", "Inactive"}));
        loadCounselors();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void loadCounselors() {
        model.setRowCount(0);
        counselorRefs.clear();
        for (User u : FileHandler.userList) {
            if (u instanceof Counselor c) {
                counselorRefs.add(c);
                model.addRow(new Object[]{c.getID(), c.getfullName(), c.getContactNumber(), c.getEmail(), c.getSpecialization(), c.getStatus()});
            }
        }
        clearFields();
    }

    private void clearFields() {
        nameTf.setText("");
        if (usernameTF != null) {
            usernameTF.setText("");
        }
        contactTf.setText("");
        emailTf.setText("");
        specialisationTf.setText("");
        passwordTf.setText("");
        statusCb.setSelectedIndex(0);
        recepTable.clearSelection();
        selectedCounselor = null;
    }

    private String validateInputs(String name, String username, String contact, String email, String password, boolean isNewUser, String currentID) {
        // [UPDATED] Mandatory presence check
        if (name.isEmpty() || username.isEmpty() || contact.isEmpty() || email.isEmpty() || (isNewUser && password.isEmpty())) {
            return "All fields including Username are required.";
        }

        // [UPDATED] Check for spaces in username
        if (username.contains(" ")) {
            return "Username cannot contain spaces.";
        }

        // [UPDATED] Duplicate username check across all users in userList
        for (User u : FileHandler.userList) {
            if (!isNewUser && currentID != null && u.getID().equalsIgnoreCase(currentID)) {
                continue; // Skip current user when editing
            }
            if (u.getUsername().equalsIgnoreCase(username)) {
                return "Username '" + username + "' is already taken by another account.";
            }
        }

        // [UPDATED] Pass to standard FileHandler validation for email, phone, and password rules
        return FileHandler.validateData(name, contact, email, password, isNewUser, currentID);
    }

    private void applyFilters() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        recepTable.setRowSorter(sorter);

        String generalQuery = searchTf.getText().trim();

        if (generalQuery.isEmpty() || generalQuery.equals("Search...")) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + generalQuery, 1, 2, 3));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchTf = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recepTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        contactTf = new javax.swing.JTextField();
        nameTf = new javax.swing.JTextField();
        emailTf = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordTf = new javax.swing.JPasswordField();
        addBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        specialisationTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        statusCb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        cfTf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Counselors");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel5)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 950, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        searchTf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchTf.addActionListener(this::searchTfActionPerformed);
        searchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTfKeyPressed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(this::searchBtnActionPerformed);

        jLabel6.setText("Filter Counselors (Name, Contact Number & Email):");

        recepTable.setModel(model);
        recepTable.setGridColor(new java.awt.Color(255, 255, 255));
        recepTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recepTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(recepTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contactTf.addActionListener(this::contactTfActionPerformed);
        jPanel1.add(contactTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 79, 71, -1));

        nameTf.addActionListener(this::nameTfActionPerformed);
        jPanel1.add(nameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 71, -1));

        emailTf.addActionListener(this::emailTfActionPerformed);
        jPanel1.add(emailTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 113, 71, -1));

        editBtn.setBackground(new java.awt.Color(255, 153, 51));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.addActionListener(this::editBtnActionPerformed);
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(this::deleteBtnActionPerformed);
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jLabel1.setText("Full Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 76, -1));

        jLabel2.setText("Contact Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 82, -1, -1));

        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 116, 37, -1));

        jLabel4.setText("Status");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 60, -1));

        passwordTf.setText("jPasswordField1");
        jPanel1.add(passwordTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 181, 71, -1));

        addBtn.setBackground(new java.awt.Color(0, 0, 102));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(this::addBtnActionPerformed);
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel8.setText("Specialisation");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 150, 96, -1));

        specialisationTf.addActionListener(this::specialisationTfActionPerformed);
        jPanel1.add(specialisationTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 147, 71, -1));

        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 184, -1, -1));

        statusCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active ", "Inactive" }));
        jPanel1.add(statusCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel9.setText("Username");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 76, -1));

        usernameTF.addActionListener(this::usernameTFActionPerformed);
        jPanel1.add(usernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 71, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(this::backBtnActionPerformed);

        cfTf.setText("View Counselor Feedback");
        cfTf.addActionListener(this::cfTfActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(searchBtn))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cfTf))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(cfTf))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTfActionPerformed
        contactTf.requestFocus();
    }//GEN-LAST:event_contactTfActionPerformed

    private void nameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTfActionPerformed
        nameTf.requestFocus();
    }//GEN-LAST:event_nameTfActionPerformed

    private void emailTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTfActionPerformed
        emailTf.requestFocus();
    }//GEN-LAST:event_emailTfActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (selectedCounselor == null) {
            JOptionPane.showMessageDialog(this, "Please select a counselor from the table to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String pw = new String(passwordTf.getPassword());
        String username = usernameTF.getText().trim();
        String errorMessage = validateInputs(nameTf.getText().trim(), username, contactTf.getText().trim(), emailTf.getText().trim(), pw, false, selectedCounselor.getID());
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedCounselor.setUsername(username);
        selectedCounselor.setFullName(nameTf.getText().trim());
        selectedCounselor.setContactNumber(contactTf.getText().trim());
        selectedCounselor.setEmail(emailTf.getText().trim());
        selectedCounselor.setSpecialization(specialisationTf.getText().trim());
        selectedCounselor.setStatus(statusCb.getSelectedItem().toString());

        if (pw.length() > 0 && !pw.equals("jPasswordField1")) {
            selectedCounselor.setpassword(pw);
        }

        currentAdmin.manageRecord(FileHandler.userList, selectedCounselor, "UPDATE");
        FileHandler.saveDataToFiles();

        JOptionPane.showMessageDialog(this, "Counselor account updated successfully.");
        loadCounselors();
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (selectedCounselor == null) {
            JOptionPane.showMessageDialog(this, "Please select a counselor from the table to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete counselor \"" + selectedCounselor.getfullName() + "\"?\nThis will also remove all roster shifts assigned to this counselor.",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            String targetCounselorID = selectedCounselor.getID();

            currentAdmin.manageRecord(FileHandler.userList, selectedCounselor, "DELETE");

            FileHandler.rosterList.removeIf(roster -> roster.getCounselorID().equals(targetCounselorID));

            FileHandler.saveDataToFiles();

            JOptionPane.showMessageDialog(this, "Counselor account and associated roster shifts deleted.");
            loadCounselors();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String pw = new String(passwordTf.getPassword());
        String username = usernameTF.getText().trim();
        //validate
        String errorMessage = validateInputs(nameTf.getText().trim(), username, contactTf.getText().trim(), emailTf.getText().trim(), pw, true, null);
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //generate data
        String newID = FileHandler.generateUserID("CNS", FileHandler.userList, User::getID);
        String selectedStatus = statusCb.getSelectedItem().toString();

        Counselor newC = new Counselor(
                newID, username, pw, nameTf.getText().trim(), selectedStatus, specialisationTf.getText().trim(), contactTf.getText().trim(), emailTf.getText().trim()
        );
        
        currentAdmin.manageRecord(FileHandler.userList, newC, "ADD");
        FileHandler.saveDataToFiles();

        JOptionPane.showMessageDialog(this, "Counselor " + newID + " successfully added.");
        loadCounselors();
    }//GEN-LAST:event_addBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        manageUsersAdmin userPage = new manageUsersAdmin(this.currentAdmin);
        userPage.setLocationRelativeTo(null);
        userPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void recepTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recepTableMouseReleased
        int viewRow = recepTable.getSelectedRow();
        if (viewRow < 0) {
            return;
        }

        int modelRow = recepTable.convertRowIndexToModel(viewRow);

        selectedCounselor = counselorRefs.get(modelRow);

        nameTf.setText(selectedCounselor.getfullName());
        usernameTF.setText(selectedCounselor.getUsername());
        contactTf.setText(selectedCounselor.getContactNumber());
        emailTf.setText(selectedCounselor.getEmail());
        specialisationTf.setText(selectedCounselor.getSpecialization());
        statusCb.setSelectedItem(selectedCounselor.getStatus());
    }//GEN-LAST:event_recepTableMouseReleased

    private void searchTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTfKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            applyFilters();
        }
    }//GEN-LAST:event_searchTfKeyPressed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        applyFilters();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void specialisationTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialisationTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specialisationTfActionPerformed

    private void searchTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTfActionPerformed

    private void cfTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfTfActionPerformed
        adminViewCounsFeedback feedbackPage = new adminViewCounsFeedback(this.currentAdmin);
        feedbackPage.setLocationRelativeTo(null);
        feedbackPage.setVisible(true);
        this.dispose();    }//GEN-LAST:event_cfTfActionPerformed

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Admin mockupAdmin = new Admin("ADM000", "admin", "admin123", "System Admin", "012-3456789", "admin@apu.edu.my", "Room 4.2");
            new adminManageCounselor(mockupAdmin).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cfTf;
    private javax.swing.JTextField contactTf;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTf;
    private javax.swing.JPasswordField passwordTf;
    private javax.swing.JTable recepTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JTextField specialisationTf;
    private javax.swing.JComboBox<String> statusCb;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
