package agent.user_interface_layer;

import agent.business_logic_layer.Area;
import agent.business_logic_layer.Block;
import agent.business_logic_layer.Customer;
import agent.business_logic_layer.CustomerManager;
import agent.business_logic_layer.DataManager;
import agent.business_logic_layer.Property;
import agent.business_logic_layer.PropertyManager;
import agent.business_logic_layer.Validations;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arsalan
 */
public class PerformSale extends javax.swing.JPanel {

    private ArrayList<Customer> customerList;
    private ArrayList<Customer> customer2List;
    private ArrayList<Block> blocksList;
    private ArrayList<Area> areaList;
    private final PropertyManager propertyManager;
    private final CustomerManager customerManager;
    private DefaultTableModel model;
    private final DialogBox dialog;
    private ArrayList<Property> propertiesList;
    private final Validations validation;

    /**
     * Creates new form PerformSale
     */
    public PerformSale() {
        initComponents();
        validation = new Validations();
        propertyManager = DataManager.getInstance().getPropertyManager();
        customerManager = DataManager.getInstance().getCustomerManager();
        dialog = new DialogBox();
        fillAllDropDown();
    }

    public void fillAllDropDown() {
        fillCustomerDropDown();
    }

    private void fillCustomerDropDown() {
        customerList = customerManager.getCustomers();
        customer2List = new ArrayList<>(customerList);
        cmbCustomers.removeAllItems();
        cmbCustomers2.removeAllItems();
        if (customerList.size() > 0) {
            Customer customer;
            for (int i = 0; i < customerList.size(); i++) {
                customer = customerList.get(i);
                cmbCustomers.addItem(customer.getName());
                cmbCustomers2.addItem(customer.getName());
            }
        } else {
        }
    }

    private void fillAreaDropDown() {
        //  areaList = propertyManager.getAreas();
        cmbAreas.removeAllItems();
        if (areaList.size() > 0) {
            Area area;
            for (int i = 0; i < areaList.size(); i++) {
                area = areaList.get(i);
                cmbAreas.addItem(area.getAreaName());
            }
        } else {

        }
    }

    private void fillBlockDropDown() {
        int index = cmbAreas.getSelectedIndex();
        if (index >= 0) {
            cmbBlocks.removeAllItems();
            if (blocksList.size() > 0) {
                Block block;
                for (int i = 0; i < blocksList.size(); i++) {
                    block = blocksList.get(i);
                    cmbBlocks.addItem(block.getBlockName());
                }
            } else {

            }
        } else {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCustomers = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbBlocks = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbProperties = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbCustomers2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSell = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        spinSellPrice = new javax.swing.JSpinner();

        jPanel10.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Select Owner");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(320, 40, 90, 30);

        cmbCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomersActionPerformed(evt);
            }
        });
        jPanel10.add(cmbCustomers);
        cmbCustomers.setBounds(440, 40, 260, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Select Area");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(320, 90, 100, 30);

        cmbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreasActionPerformed(evt);
            }
        });
        jPanel10.add(cmbAreas);
        cmbAreas.setBounds(440, 90, 260, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Select Block");
        jPanel10.add(jLabel3);
        jLabel3.setBounds(320, 140, 90, 30);

        cmbBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBlocksActionPerformed(evt);
            }
        });
        jPanel10.add(cmbBlocks);
        cmbBlocks.setBounds(440, 140, 260, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Select Property");
        jPanel10.add(jLabel4);
        jLabel4.setBounds(320, 190, 100, 30);

        cmbProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropertiesActionPerformed(evt);
            }
        });
        jPanel10.add(cmbProperties);
        cmbProperties.setBounds(440, 190, 260, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Selling Price");
        jPanel10.add(jLabel5);
        jLabel5.setBounds(320, 290, 110, 30);

        cmbCustomers2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomers2ActionPerformed(evt);
            }
        });
        jPanel10.add(cmbCustomers2);
        cmbCustomers2.setBounds(440, 240, 260, 30);

        jButton1.setText("Sell Property");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1);
        jButton1.setBounds(360, 450, 340, 30);

        tblSell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Agreement", "Address", "Demand", "Variation"
            }
        ));
        jScrollPane1.setViewportView(tblSell);

        jPanel10.add(jScrollPane1);
        jScrollPane1.setBounds(20, 340, 980, 80);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Select New Owner");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(320, 240, 110, 30);

        spinSellPrice.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1000)));
        jPanel10.add(spinSellPrice);
        spinSellPrice.setBounds(440, 290, 260, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomersActionPerformed
        // TODO add your handling code here:
        int index = cmbCustomers.getSelectedIndex();
        if (index >= 0) {
            Customer customer = customerList.get(index);
            areaList = propertyManager.getAreasForCustomer(customer.getId());
            fillAreaDropDown();
        }
    }//GEN-LAST:event_cmbCustomersActionPerformed

    private void cmbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreasActionPerformed
        // TODO add your handling code here:
        int customerIndex = cmbCustomers.getSelectedIndex();
        int areaIndex = cmbAreas.getSelectedIndex();
        if (areaIndex >= 0 && customerIndex >= 0) {
            Customer customer = customerList.get(customerIndex);
            Area area = areaList.get(areaIndex);
            blocksList = propertyManager.getBlocks(customer.getId(), area.getAreaId());
            fillBlockDropDown();
        }
    }//GEN-LAST:event_cmbAreasActionPerformed

    private void cmbBlocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBlocksActionPerformed
        // TODO add your handling code here:
        int customerIndex = cmbCustomers.getSelectedIndex();
        int blockIndex = cmbBlocks.getSelectedIndex();
        if (customerIndex >= 0 && blockIndex >= 0) {
            Customer customer = customerList.get(customerIndex);
            Block block = blocksList.get(blockIndex);
            propertiesList = propertyManager.getProperties(customer.getId(), block.getBlockId());
            fillPropertyDropDown();
        }
    }//GEN-LAST:event_cmbBlocksActionPerformed

    private void cmbCustomers2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomers2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomers2ActionPerformed

    private void cmbPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropertiesActionPerformed
        // TODO add your handling code here:
        int index = cmbProperties.getSelectedIndex();
        if (index >= 0) {
            Property property = propertiesList.get(index);
            spinSellPrice.setValue(property.getDemand());
            createTable((String) cmbProperties.getSelectedItem(), property.getAgreement(), property.getAddress(), property.getDemand(), property.getVariation());
        }
    }//GEN-LAST:event_cmbPropertiesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index1 = cmbCustomers.getSelectedIndex();
        int index2 = cmbCustomers2.getSelectedIndex();
        if (index1 >= 0 && index2 >= 0) {
            if (index1 != index2) {
                int propertyId = propertiesList.get(cmbProperties.getSelectedIndex()).getPropertyId();
                Customer buyer = customer2List.get(index2);
                if (propertyManager.performSale(propertyId, buyer.getId(), (int) spinSellPrice.getValue())) {
                    dialog.show("Operation is Successfull");
                } else {
                    dialog.show("Error Occured");
                }
            } else {
                dialog.show("Buyer and Seller Cannot be same");
            }
        } else {
            dialog.show("Please select Seller and Buyer");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbAreas;
    private javax.swing.JComboBox cmbBlocks;
    private javax.swing.JComboBox cmbCustomers;
    private javax.swing.JComboBox cmbCustomers2;
    private javax.swing.JComboBox cmbProperties;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinSellPrice;
    private javax.swing.JTable tblSell;
    // End of variables declaration//GEN-END:variables

    private void fillPropertyDropDown() {
        cmbProperties.removeAllItems();
        if (propertiesList.size() > 0) {
            Property property;
            for (int i = 0; i < propertiesList.size(); i++) {
                property = propertiesList.get(i);
                cmbProperties.addItem("Property" + property.getPropertyId());
            }
        } else {

        }
    }

    private void createTable(String name, String agreement, String address, int demand, int variation) {
        tblSell.removeAll();
        model = (DefaultTableModel) tblSell.getModel();
        model.setRowCount(0);
        model.insertRow(tblSell.getRowCount(), new Object[]{name, agreement, address, demand, variation});
    }
}