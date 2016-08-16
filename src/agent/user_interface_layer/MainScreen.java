package agent.user_interface_layer;

import agent.business_logic_layer.DataManager;
import agent.business_logic_layer.User;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author MuhammadArsalan
 */
public class MainScreen extends javax.swing.JFrame {

    private final LoginPage login;
    private final User user;
    private ViewPropertyForOwner owner;
    private ViewPropertyForViewer viewer;

    public MainScreen(LoginPage login) {
        initComponents();
        this.login = login;
        setDimensions();
        user = DataManager.getInstance().getCurrentUser();
        addTabs();
        setView();
        selectCurrentTab();
    }

    private void setDimensions() {
        this.setPreferredSize(new Dimension(1115, 620));//650
        this.setMaximumSize(new Dimension(1115, 620));
        this.setMinimumSize(new Dimension(1115, 620));
        this.setBounds(70, 60, 200, 430);
    }

    private void selectCurrentTab() {
        mainTab.setSelectedIndex(2);
        this.setTitle("View Properties");
    }

    private void setView() {
        lblUserName.setText("Welcome " + user.getName());
        if (user.getCategory().equals("Viewer")) {
            btnSettings.setEnabled(false);
            btnCustomers.setEnabled(false);
            btnSales.setEnabled(false);
            btnManageProperty.setEnabled(false);
        }
    }

    private void addTabs() {
        mainTab.add(new UpdatePassword(), "Settings");
        mainTab.add(new ManageCustomer(), "Customers");
        if (user.getCategory().equals("Viewer")) {
            viewer = new ViewPropertyForViewer();
            mainTab.add(viewer, "View Property");
        } else {
            owner = new ViewPropertyForOwner();
            mainTab.add(owner, "View Property");
        }
        mainTab.add(new ManageProperty(), "Manage Property");
        mainTab.add(new ManageSales(), "Manage Sales");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel17 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        logoutButton = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnViewProperty = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        btnManageProperty = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        mainTab = new javax.swing.JTabbedPane();
        jLabel3 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(null);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Log Out.png"))); // NOI18N
        logoutButton.setToolTipText("Logout from Session");
        logoutButton.setContentAreaFilled(false);
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton);
        logoutButton.setBounds(1020, 10, 60, 70);

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Manage Account.png"))); // NOI18N
        btnSettings.setToolTipText("Manage Account");
        btnSettings.setContentAreaFilled(false);
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSettings);
        btnSettings.setBounds(330, 10, 60, 70);

        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Employees.png"))); // NOI18N
        btnCustomers.setToolTipText("Manage Customers");
        btnCustomers.setContentAreaFilled(false);
        btnCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        getContentPane().add(btnCustomers);
        btnCustomers.setBounds(410, 10, 60, 70);

        btnViewProperty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Receipt.png"))); // NOI18N
        btnViewProperty.setToolTipText("View Property");
        btnViewProperty.setContentAreaFilled(false);
        btnViewProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPropertyActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewProperty);
        btnViewProperty.setBounds(490, 10, 60, 70);

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/innerLogo.png"))); // NOI18N
        getContentPane().add(jLabel57);
        jLabel57.setBounds(10, -10, 100, 100);

        btnManageProperty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Alter.png"))); // NOI18N
        btnManageProperty.setToolTipText("Manage Property");
        btnManageProperty.setContentAreaFilled(false);
        btnManageProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePropertyActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageProperty);
        btnManageProperty.setBounds(570, 10, 60, 70);

        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sales Record.png"))); // NOI18N
        btnSales.setToolTipText("Manage Sales");
        btnSales.setContentAreaFilled(false);
        btnSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSales);
        btnSales.setBounds(650, 10, 60, 70);

        mainTab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        mainTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainTab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabStateChanged(evt);
            }
        });
        getContentPane().add(mainTab);
        mainTab.setBounds(0, 90, 1110, 530);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Product By TECHNOCredibles");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(820, 60, 170, 20);

        lblUserName.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("Welcome");
        getContentPane().add(lblUserName);
        lblUserName.setBounds(740, 10, 280, 19);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel48);
        jLabel48.setBounds(0, 0, 1110, 90);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(800, 30, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Are you sure you wanna logout?",
                "Log Out",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            this.dispose();
            DataManager.getInstance().closeDatabase();
            login.setUpUI();
            login.setVisible(true);
        }

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        this.setTitle("Settings");
        mainTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        this.setTitle("Manage Customers");
        mainTab.setSelectedIndex(1);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnViewPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPropertyActionPerformed
        this.setTitle("View Properties");
        mainTab.setSelectedIndex(2);
        if (user.getCategory().equals("Viewer")) {
            viewer.fillAllDropDowns();
            viewer.performSearch();
        } else {
            owner.fillAllDropDowns();
            owner.performSearch();
        }
    }//GEN-LAST:event_btnViewPropertyActionPerformed

    private void btnManagePropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePropertyActionPerformed
        this.setTitle("Manage Property");
        mainTab.setSelectedIndex(3);
    }//GEN-LAST:event_btnManagePropertyActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        this.setTitle("Sales");
        mainTab.setSelectedIndex(4);
    }//GEN-LAST:event_btnSalesActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void mainTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mainTabStateChanged
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainScreen().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnManageProperty;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnViewProperty;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainTab;
    // End of variables declaration//GEN-END:variables

}