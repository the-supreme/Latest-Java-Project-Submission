package counselormgmtsystem.GUIprogram.AdminFrames;

import counselormgmtsystem.Admin;
import counselormgmtsystem.Feedback;
import counselormgmtsystem.FileHandler;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class adminViewCounsFeedback extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminViewCounsFeedback.class.getName());
    private DefaultTableModel model = new DefaultTableModel(); 
    private String columnName[] = {"Student ID", "Counselor ID", "Feedback"};
    private Admin currentAdmin;

    public adminViewCounsFeedback(Admin admin) {
        this.currentAdmin = admin;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        if (FileHandler.feedbackList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }
        
        initComponents();
        model.setColumnIdentifiers(columnName);
        
        loadFeedback();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void loadFeedback() {
        model.setRowCount(0); 
        for (Feedback f : FileHandler.feedbackList) {
            model.addRow(new Object[]{
                f.getStudentID(), 
                f.getCounselorID(), 
                f.getFeedback() 
            });
        }
    }
    
    private void applyFilters() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        
        String query = searchTf.getText().trim();
        
        if (query.isEmpty() || query.equals("Search...")) {
            sorter.setRowFilter(null); 
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jPanel15.setBackground(new java.awt.Color(0, 0, 102));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("View Appointment History");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel14)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 0, 102));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("View Counselor Feedback");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel15)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 940, 50));

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 940, -1));

        searchTf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        searchTf.addActionListener(this::searchTfActionPerformed);
        searchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTfKeyPressed(evt);
            }
        });
        jPanel1.add(searchTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 269, -1));

        jLabel6.setText("Filter Counselors (Name, Contact Number & Email):");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 332, -1));

        searchBtn.setText("Search");
        searchBtn.addActionListener(this::searchBtnActionPerformed);
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(this::backBtnActionPerformed);
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTfActionPerformed
        applyFilters();
    }//GEN-LAST:event_searchTfActionPerformed

    private void searchTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTfKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            applyFilters();
        }
    }//GEN-LAST:event_searchTfKeyPressed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        applyFilters();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        adminManageCounselor counsPage = new adminManageCounselor(this.currentAdmin);
        counsPage.setLocationRelativeTo(null);
        counsPage.setVisible(true);
        this.dispose();    }//GEN-LAST:event_backBtnActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> {
            Admin mockupAdmin = new Admin("ADM000", "admin", "admin123", "System Admin", "012-3456789", "admin@apu.edu.my", "Room 4.2");
            new adminViewCounsFeedback(mockupAdmin).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTf;
    // End of variables declaration//GEN-END:variables
}
