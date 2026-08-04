package counselormgmtsystem.GUIprogram.StudentFrames;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import counselormgmtsystem.Student;
import counselormgmtsystem.Counselor;
import counselormgmtsystem.FileHandler;

public class CounselorProfileGUI extends JFrame {

    private static final Color COLOR_NAVY = new Color(10, 10, 90);
    private static final Color COLOR_DARK_GRAY = new Color(70, 74, 79);
    private static final Color COLOR_WHITE = new Color(255, 255, 255);

    private final Student currentStudent;

    private JTable counselorTable;
    private JTextField txtID, txtName, txtSpecialization, txtContact, txtEmail;
    private JButton btnGiveFeedback;

    public CounselorProfileGUI(Student student) {
        this.currentStudent = student;
        setTitle("Counselor Profiles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(940, 540);
        setMinimumSize(new Dimension(940, 540));
        setLocationRelativeTo(null);

        if (FileHandler.userList.isEmpty()) {
            new FileHandler().loadDataFromFiles();
        }

        buildUI();
        populateTable();
    }

    private void buildUI() {
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(COLOR_WHITE);

        // Header
        JLabel lblHeader = new JLabel("Counselor Profiles", SwingConstants.CENTER);
        lblHeader.setOpaque(true);
        lblHeader.setBackground(COLOR_NAVY);
        lblHeader.setForeground(COLOR_WHITE);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeader.setPreferredSize(new Dimension(940, 45));
        add(lblHeader, BorderLayout.NORTH);

        // Table
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"CounselorID", "Name", "Specialization", "Contact", "Email"}
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        };
        counselorTable = new JTable(model);
        counselorTable.setRowHeight(24);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setOpaque(true);
        headerRenderer.setBackground(COLOR_DARK_GRAY);
        headerRenderer.setForeground(COLOR_WHITE);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 12));
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        counselorTable.getTableHeader().setDefaultRenderer(headerRenderer);
        counselorTable.getTableHeader().setReorderingAllowed(false);

        counselorTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) fillDetailsFromSelection();
        });
        JScrollPane tableScroll = new JScrollPane(counselorTable);
        tableScroll.setPreferredSize(new Dimension(920, 260));
        add(tableScroll, BorderLayout.CENTER);

        // Detail panel
        JPanel detailPanel = new JPanel(new GridBagLayout());
        detailPanel.setBorder(BorderFactory.createTitledBorder("Counselor Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtID = new JTextField(); txtID.setEditable(false);
        txtName = new JTextField(); txtName.setEditable(false);
        txtSpecialization = new JTextField(); txtSpecialization.setEditable(false);
        txtContact = new JTextField(); txtContact.setEditable(false);
        txtEmail = new JTextField(); txtEmail.setEditable(false);

        addDetailRow(detailPanel, gbc, 0, "Counselor ID:", txtID);
        addDetailRow(detailPanel, gbc, 1, "Name:", txtName);
        addDetailRow(detailPanel, gbc, 2, "Specialization:", txtSpecialization);
        addDetailRow(detailPanel, gbc, 3, "Contact Number:", txtContact);
        addDetailRow(detailPanel, gbc, 4, "Email:", txtEmail);

        btnGiveFeedback = new JButton("Give Feedback");
        btnGiveFeedback.setBackground(COLOR_NAVY);
        btnGiveFeedback.setForeground(COLOR_WHITE);
        btnGiveFeedback.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGiveFeedback.setFocusPainted(false);
        btnGiveFeedback.setEnabled(false);
        btnGiveFeedback.addActionListener(e -> openFeedbackPanel());

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        detailPanel.add(btnGiveFeedback, gbc);

        add(detailPanel, BorderLayout.SOUTH);
    }

    private void addDetailRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(field, gbc);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) counselorTable.getModel();
        model.setRowCount(0);
        for (var user : FileHandler.userList) {
            if (user instanceof Counselor c) {
                model.addRow(new Object[]{
                        c.getID(), c.getfullName(), c.getSpecialization(), c.getContactNumber(), c.getEmail()
                });
            }
        }
    }

    private void fillDetailsFromSelection() {
        int row = counselorTable.getSelectedRow();
        if (row == -1) {
            btnGiveFeedback.setEnabled(false);
            return;
        }
        txtID.setText((String) counselorTable.getValueAt(row, 0));
        txtName.setText((String) counselorTable.getValueAt(row, 1));
        txtSpecialization.setText((String) counselorTable.getValueAt(row, 2));
        txtContact.setText((String) counselorTable.getValueAt(row, 3));
        txtEmail.setText((String) counselorTable.getValueAt(row, 4));
        btnGiveFeedback.setEnabled(true);
    }

    private void openFeedbackPanel() {
        String counselorID = txtID.getText();
        String counselorName = txtName.getText();

        JDialog dialog = new JDialog(this, "Feedback Panel", true);
        dialog.setSize(400, 320);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));

        JLabel lblHeader = new JLabel("Feedback Panel", SwingConstants.CENTER);
        lblHeader.setOpaque(true);
        lblHeader.setBackground(COLOR_NAVY);
        lblHeader.setForeground(COLOR_WHITE);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblHeader.setPreferredSize(new Dimension(400, 40));
        dialog.add(lblHeader, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblCounselor = new JLabel("Counselor: " + counselorName + " (" + counselorID + ")");
        lblCounselor.setFont(new Font("Segoe UI", Font.BOLD, 12));
        centerPanel.add(lblCounselor, BorderLayout.NORTH);

        JTextArea txtFeedback = new JTextArea();
        txtFeedback.setLineWrap(true);
        txtFeedback.setWrapStyleWord(true);
        JScrollPane feedbackScroll = new JScrollPane(txtFeedback);
        centerPanel.add(feedbackScroll, BorderLayout.CENTER);

        JButton btnSave = new JButton("Save");
        btnSave.setBackground(COLOR_NAVY);
        btnSave.setForeground(COLOR_WHITE);
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(e -> {
            String feedbackText = txtFeedback.getText().trim();
            if (currentStudent == null) {
                JOptionPane.showMessageDialog(dialog, "No student is logged in.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // CALLING METHOD FROM STUDENT CLASS
            boolean success = currentStudent.submitFeedback(counselorID, feedbackText);

            if (success) {
                JOptionPane.showMessageDialog(dialog, "Feedback submitted. Thank you!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please enter your feedback before saving.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        centerPanel.add(btnSave, BorderLayout.SOUTH);

        dialog.add(centerPanel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
}