package counselormgmtsystem.GUIprogram.AdminFrames;
import counselormgmtsystem.Admin;
import counselormgmtsystem.FileHandler;
import counselormgmtsystem.Roster;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

////ADD VALIDATION WHETHER OR NOT NEW ROSTER SLOT OVERLAPS W OTHER SLOTS
///ADD VALIDATION WHETHER RECORD ALREADY EXISTS
///
public class adminManageRoster extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminManageRoster.class.getName());
 
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = new String[]{"Roster ID", "Counselor ID", "Date", "Start Time", "End Time", "Status"};
 
    private ArrayList<Roster> rosterRefs = new ArrayList<>();
    private Roster selectedRoster = null;
    private Admin currentAdmin;

    public adminManageRoster(Admin admin) {
        this.currentAdmin = admin;
        
        if (FileHandler.rosterList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }
        
        model.setColumnIdentifiers(columnName);
        initComponents();
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Booked" }));
        loadRosters();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTf = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dateTf = new javax.swing.JTextField();
        counselorIdTf = new javax.swing.JTextField();
        startTf = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        endTf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rosterTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        dateFilterTf = new javax.swing.JTextField();
        dateFilterBtn = new javax.swing.JButton();
        scheduleBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTfKeyPressed(evt);
            }
        });
        getContentPane().add(searchTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 149, -1));

        searchBtn.setText("Search");
        searchBtn.addActionListener(this::searchBtnActionPerformed);
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jLabel6.setText("Filter by CounselorID:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 132, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateTf.addActionListener(this::dateTfActionPerformed);
        jPanel1.add(dateTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 79, 71, -1));

        counselorIdTf.addActionListener(this::counselorIdTfActionPerformed);
        jPanel1.add(counselorIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 39, 71, -1));

        startTf.addActionListener(this::startTfActionPerformed);
        jPanel1.add(startTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 119, 71, -1));

        editBtn.setBackground(new java.awt.Color(255, 153, 0));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.addActionListener(this::editBtnActionPerformed);
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 267, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(this::deleteBtnActionPerformed);
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 267, -1, -1));

        jLabel1.setText("Counselor ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 42, 76, -1));

        jLabel2.setText("Date");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 82, -1, -1));

        jLabel3.setText("Start Time");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 122, 77, -1));

        jLabel4.setText("End Time");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 162, -1, -1));

        addBtn.setBackground(new java.awt.Color(0, 0, 102));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(this::addBtnActionPerformed);
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 267, -1, -1));

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Booked" }));
        statusCombo.addActionListener(this::statusComboActionPerformed);
        jPanel1.add(statusCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 199, 71, -1));

        jLabel7.setText("Status");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 202, 70, -1));

        endTf.addActionListener(this::endTfActionPerformed);
        jPanel1.add(endTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 159, 71, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 330, 330));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Rosters");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        rosterTable.setModel(model);
        rosterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rosterTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(rosterTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 510, 370));

        jLabel8.setText("Filter Date (yyyy-MM-dd):");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));
        getContentPane().add(dateFilterTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 100, -1));

        dateFilterBtn.setText("Filter");
        dateFilterBtn.addActionListener(this::dateFilterBtnActionPerformed);
        getContentPane().add(dateFilterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, -1));

        scheduleBtn.setText("View Schedule");
        scheduleBtn.addActionListener(this::scheduleBtnActionPerformed);
        getContentPane().add(scheduleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -80, 980, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadRosters() {
        model.setRowCount(0);
        rosterRefs.clear();
        for (Roster r : FileHandler.rosterList) {
            rosterRefs.add(r);
            model.addRow(new Object[]{r.getRosterID(), r.getCounselorID(), r.getDate(), r.getStartTime(),r.getEndTime()});
        }
        clearFields();
    }
 
    private void clearFields() {
        counselorIdTf.setText("");
        dateTf.setText("");
        startTf.setText("");
        endTf.setText("");
        statusCombo.setSelectedIndex(0);
        rosterTable.clearSelection();
        selectedRoster = null;
    }

    private void applyFilters() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        rosterTable.setRowSorter(sorter);

        String generalQuery = searchTf.getText().trim();
        String dateQuery = dateFilterTf.getText().trim();
        //list to hold filters
        java.util.List<RowFilter<Object, Object>> filters = new ArrayList<>();

        //general search - id, couns, status 
        if (!generalQuery.isEmpty()) {
            filters.add(RowFilter.regexFilter("(?i)" + generalQuery, 0, 1, 5));
        }

        //date search
        if (!dateQuery.isEmpty()) {
            filters.add(RowFilter.regexFilter("^" + dateQuery + "$", 2)); 
        }

        //apply filters
        if (filters.isEmpty()) {
            sorter.setRowFilter(null); //show everything if no filters applied
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filters));
        }
    }
    
    private void searchTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTfKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            applyFilters();
        }
    }//GEN-LAST:event_searchTfKeyPressed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         applyFilters();
    }//GEN-LAST:event_searchBtnActionPerformed
   
    private void dateTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTfActionPerformed
        dateTf.requestFocus();
    }//GEN-LAST:event_dateTfActionPerformed

    private void counselorIdTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counselorIdTfActionPerformed
        counselorIdTf.requestFocus();
    }//GEN-LAST:event_counselorIdTfActionPerformed

    private void startTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTfActionPerformed
        startTf.requestFocus();
    }//GEN-LAST:event_startTfActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (selectedRoster == null) return;

            String error = currentAdmin.validateData(counselorIdTf.getText(), dateTf.getText(), startTf.getText(), endTf.getText(), selectedRoster.getRosterID());
            if (error != null) { JOptionPane.showMessageDialog(this, error); return; }

            selectedRoster.setCounselorID(counselorIdTf.getText().trim());
            selectedRoster.setDate(dateTf.getText().trim());
            selectedRoster.setStartTime(startTf.getText().trim());
            selectedRoster.setEndTime(endTf.getText().trim());

            currentAdmin.manageRecord(FileHandler.rosterList, selectedRoster, "UPDATE");
            loadRosters();
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (selectedRoster == null) return;
            if (JOptionPane.showConfirmDialog(this, "Delete?") == JOptionPane.YES_OPTION) {
                currentAdmin.manageRecord(FileHandler.rosterList, selectedRoster, "DELETE");
                loadRosters();
            }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String error = currentAdmin.validateData(counselorIdTf.getText(), dateTf.getText(), startTf.getText(), endTf.getText(), null);
            if (error != null) { JOptionPane.showMessageDialog(this, error); return; }

            Roster newR = new Roster("", counselorIdTf.getText().trim(), dateTf.getText().trim(), startTf.getText().trim(), endTf.getText().trim());
            currentAdmin.manageRecord(FileHandler.rosterList, newR, "ADD");

            loadRosters();
    }//GEN-LAST:event_addBtnActionPerformed

    private void statusComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboActionPerformed
    }//GEN-LAST:event_statusComboActionPerformed

    private void rosterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rosterTableMouseReleased
        int viewRow = rosterTable.getSelectedRow();

        if (viewRow < 0) {
            return;
        }

        int modelRow = rosterTable.convertRowIndexToModel(viewRow);

        String counselor = String.valueOf(model.getValueAt(modelRow, 1));
        String date = String.valueOf(model.getValueAt(modelRow, 2));
        String start = String.valueOf(model.getValueAt(modelRow, 3));
        String end = String.valueOf(model.getValueAt(modelRow, 4));

        counselorIdTf.setText(counselor);
        dateTf.setText(date);
        startTf.setText(start);
        endTf.setText(end);

        selectedRoster = rosterRefs.get(modelRow);
    }//GEN-LAST:event_rosterTableMouseReleased

    private void endTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTfActionPerformed
    }//GEN-LAST:event_endTfActionPerformed

    private void dateFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFilterBtnActionPerformed
        applyFilters();
    }//GEN-LAST:event_dateFilterBtnActionPerformed

    private void scheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleBtnActionPerformed
        adminViewSchedule viewSchedulePage = new adminViewSchedule(this.currentAdmin);
        viewSchedulePage.setLocationRelativeTo(null);
        viewSchedulePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scheduleBtnActionPerformed


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

        java.awt.EventQueue.invokeLater(() -> {
            //**dummy admin, delete ltr
            Admin mockupAdmin = new Admin("ADM000", "admin", "admin123", "System Admin", "012-3456789", "admin@apu.edu.my", "Room 4.2");
            new adminManageRoster(mockupAdmin).setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField counselorIdTf;
    private javax.swing.JButton dateFilterBtn;
    private javax.swing.JTextField dateFilterTf;
    private javax.swing.JTextField dateTf;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField endTf;
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
    private javax.swing.JTable rosterTable;
    private javax.swing.JButton scheduleBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JTextField startTf;
    private javax.swing.JComboBox<String> statusCombo;
    // End of variables declaration//GEN-END:variables

}
