package counselormgmtsystem.GUIprogram.AdminFrames;

import counselormgmtsystem.Admin;
import counselormgmtsystem.FileHandler;
import counselormgmtsystem.Receptionist;
import counselormgmtsystem.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class adminManageRecep extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminManageRecep.class.getName());
    private DefaultTableModel model = new DefaultTableModel();
    private String columnName[] = {"ID", "Full Name", "Contact Number", "Email", "Status"};

    private ArrayList<Receptionist> receptionistRefs = new ArrayList<>();
    private Receptionist selectedReceptionist = null;
    private Admin currentAdmin;

    public adminManageRecep(Admin admin) {
        this.currentAdmin = admin;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        if (FileHandler.userList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }

        model.setColumnIdentifiers(columnName);
        initComponents();
        statusCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Active", "Inactive"}));
        loadReceptionists();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        statusCb = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        recepTable = new javax.swing.JTable();
        searchTf = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contactTf.addActionListener(this::contactTfActionPerformed);
        jPanel1.add(contactTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 71, -1));

        nameTf.addActionListener(this::nameTfActionPerformed);
        jPanel1.add(nameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 71, -1));

        emailTf.addActionListener(this::emailTfActionPerformed);
        jPanel1.add(emailTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 71, -1));

        editBtn.setBackground(new java.awt.Color(255, 153, 0));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.addActionListener(this::editBtnActionPerformed);
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 278, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(this::deleteBtnActionPerformed);
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 278, -1, -1));

        jLabel1.setText("Full Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 76, -1));

        jLabel2.setText("Contact Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 37, -1));

        jLabel4.setText("Status");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        passwordTf.setText("jPasswordField1");
        jPanel1.add(passwordTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 71, -1));

        addBtn.setBackground(new java.awt.Color(0, 0, 102));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(this::addBtnActionPerformed);
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 278, -1, -1));

        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        statusCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jPanel1.add(statusCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabel8.setText("Username");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 76, -1));

        usernameTF.addActionListener(this::usernameTFActionPerformed);
        jPanel1.add(usernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 71, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 85, 330, 350));

        recepTable.setBorder(new javax.swing.border.MatteBorder(null));
        recepTable.setModel(model);
        recepTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                recepTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(recepTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 472, 320));

        searchTf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTfKeyPressed(evt);
            }
        });
        getContentPane().add(searchTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 269, -1));

        searchBtn.setText("Search");
        searchBtn.addActionListener(this::searchBtnActionPerformed);
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Filter Receptionists (Name, Contact Number & Email):");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 332, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(this::backBtnActionPerformed);
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 473, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Receptionists");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel5)
                .addContainerGap(423, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 485, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadReceptionists() {
        model.setRowCount(0);
        receptionistRefs.clear();
        for (User u : FileHandler.userList) {
            if (u instanceof Receptionist) {
                Receptionist r = (Receptionist) u;
                receptionistRefs.add(r);
                model.addRow(new Object[]{r.getID(), r.getfullName(), r.getReceptionistNumber(), r.getReceptionistEmail(), r.getStatus()});
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
        passwordTf.setText("");
        statusCb.setSelectedIndex(0);
        recepTable.clearSelection();
        selectedReceptionist = null;
    }

    private String validateInputs(String name, String username, String contact, String email, String password, boolean isNewUser, String currentID) {
        if (name.isEmpty() || username.isEmpty() || contact.isEmpty() || email.isEmpty() || (isNewUser && password.isEmpty())) {
            return "All fields including Username are required.";
        }

        if (username.contains(" ")) {
            return "Username cannot contain spaces.";
        }

        for (User u : FileHandler.userList) {
            if (!isNewUser && currentID != null && u.getID().equalsIgnoreCase(currentID)) {
                continue; // Skip current user when editing
            }
            if (u.getUsername().equalsIgnoreCase(username)) {
                return "Username '" + username + "' is already taken by another account.";
            }
        }

        return FileHandler.validateData(name, contact, email, password, isNewUser, currentID);
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (selectedReceptionist == null) {
            JOptionPane.showMessageDialog(this, "Please select a receptionist from the table to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String pw = new String(passwordTf.getPassword());
        String username = usernameTF.getText().trim();

        String errorMessage = validateInputs(nameTf.getText().trim(), username, contactTf.getText().trim(), emailTf.getText().trim(), pw, false, selectedReceptionist.getID());
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedReceptionist.setUsername(username);
        selectedReceptionist.setFullName(nameTf.getText().trim());
        selectedReceptionist.setReceptionistNumber(contactTf.getText().trim());
        selectedReceptionist.setReceptionistEmail(emailTf.getText().trim());
        selectedReceptionist.setStatus(statusCb.getSelectedItem().toString());

        if (pw.length() > 0 && !pw.equals("passwordTf")) {
            selectedReceptionist.setpassword(pw);
        }

        currentAdmin.manageRecord(FileHandler.userList, selectedReceptionist, "UPDATE");

        FileHandler.saveDataToFiles();
        JOptionPane.showMessageDialog(this, "Receptionist account updated successfully.");
        loadReceptionists();

    }//GEN-LAST:event_editBtnActionPerformed

    private void contactTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTfActionPerformed
        contactTf.requestFocus();
    }//GEN-LAST:event_contactTfActionPerformed

    private void nameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTfActionPerformed
        nameTf.requestFocus();
    }//GEN-LAST:event_nameTfActionPerformed

    private void emailTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTfActionPerformed
        emailTf.requestFocus();
    }//GEN-LAST:event_emailTfActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String query = searchTf.getText();
        executeSearch(query);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTfKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String query = searchTf.getText();
            executeSearch(query);
        }
    }//GEN-LAST:event_searchTfKeyPressed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String pw = new String(passwordTf.getPassword());
        String username = usernameTF.getText().trim();
        String errorMessage = validateInputs(nameTf.getText().trim(), username, contactTf.getText().trim(), emailTf.getText().trim(), pw, true, null);
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String newID = FileHandler.generateUserID("REC", FileHandler.userList, User::getID);
        String selectedStatus = statusCb.getSelectedItem().toString();

        Receptionist newReceptionist = new Receptionist(
                newID,
                username,
                pw,
                nameTf.getText().trim(),
                selectedStatus,
                contactTf.getText().trim(),
                emailTf.getText().trim()
        );
        //admin method overload
        currentAdmin.manageRecord(FileHandler.userList, newReceptionist, "ADD");

        FileHandler.saveDataToFiles();

        JOptionPane.showMessageDialog(this, "Receptionist " + newID + " successfully added.");
        loadReceptionists();
    }//GEN-LAST:event_addBtnActionPerformed

    private void recepTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recepTableMouseReleased
        int viewRow = recepTable.getSelectedRow();

        if (viewRow < 0) {
            return;
        }

        int modelRow = recepTable.convertRowIndexToModel(viewRow);
        selectedReceptionist = receptionistRefs.get(modelRow);
        String name = String.valueOf(model.getValueAt(modelRow, 1));
        String contact = String.valueOf(model.getValueAt(modelRow, 2));
        String email = String.valueOf(model.getValueAt(modelRow, 3));

        nameTf.setText(name);
        usernameTF.setText(selectedReceptionist.getUsername());
        contactTf.setText(contact);
        emailTf.setText(email);
        statusCb.setSelectedItem(selectedReceptionist.getStatus());
        selectedReceptionist = receptionistRefs.get(modelRow);
    }//GEN-LAST:event_recepTableMouseReleased

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (selectedReceptionist == null) {
            JOptionPane.showMessageDialog(this, "Please select a receptionist from the table to delete.",
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete receptionist \"" + selectedReceptionist.getfullName() + "\"? This cannot be undone.",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        currentAdmin.manageRecord(FileHandler.userList, selectedReceptionist, "DELETE");

        FileHandler.saveDataToFiles();

        JOptionPane.showMessageDialog(this, "Receptionist account deleted.");
        loadReceptionists();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        manageUsersAdmin userPage = new manageUsersAdmin(this.currentAdmin);
        userPage.setLocationRelativeTo(null);
        userPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

    private void executeSearch(String query) {
        if (recepTable == null) {
            return;
        }

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) recepTable.getModel();
        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> sorter
                = new javax.swing.table.TableRowSorter<>(model);
        recepTable.setRowSorter(sorter);

        if (query.trim().isEmpty() || query.equals("Search...")) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + query));
        }
    }

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
            System.out.println("Warning: Data load failed, starting with empty state: " + e.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTf;
    private javax.swing.JPasswordField passwordTf;
    private javax.swing.JTable recepTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JComboBox<String> statusCb;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables

}
