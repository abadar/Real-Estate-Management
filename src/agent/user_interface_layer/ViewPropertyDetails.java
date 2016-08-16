package agent.user_interface_layer;

import agent.business_logic_layer.PropertyType;
import agent.business_logic_layer.PropertyFilter;
import agent.business_logic_layer.PropertyService;
import agent.business_logic_layer.Block;
import agent.business_logic_layer.Customer;
import agent.business_logic_layer.Property;
import agent.business_logic_layer.PropertyCharacteristic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arsalan
 */
public class ViewPropertyDetails extends javax.swing.JFrame {

    Property property;
    Customer customer;
    Block block;
    PropertyType type;
    ArrayList<PropertyCharacteristic> characteristics;
    ArrayList<PropertyService> services;
    ArrayList<String> images;
    PropertyFilter filter;
    private final DialogBox dialog = new DialogBox();

    /**
     * Creates new form ViewPropertyDetails
     */
    public ViewPropertyDetails(Property property) {
        initComponents();
        this.setTitle("Property Details");
        this.property = property;
        customer = property.getCustomer();
        block = property.getBlock();
        type = property.getType();
        filter = property.getFilter();
        images = property.getImages();
        services = property.getServices();
        characteristics = property.getCharacteristics();
        lblBlock.setText(block.getBlockName());
        lblCustomerName.setText(customer.getName());
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        lblDateOfArrival.setText(sdfDate.format(property.getDateOfEntry()));
        lblDateOfOwnership.setText(sdfDate.format(property.getDateOfOwnerShip()));
        lblDemand.setText("" + property.getDemand());
        lblLoadShed.setText("" + block.getNoOfHourOfLoadShed());
        lblNoOfRooms.setText("" + property.getNoOfRooms());
        lblPropertyFor.setText(filter.getFilterName());
        lblSize.setText("" + property.getSize());
        lblType.setText(type.getTypeName());
        txtAddress.setText(property.getAddress());
        txtAgreement.setText(property.getAgreement());
        String str = "";
        for (int i = 0; i < services.size(); i++) {
            str += services.get(i).getServiceName() + "\n";
        }
        txtServices.setText(str);
        DefaultTableModel model = (DefaultTableModel) tblCharacteristics.getModel();
        PropertyCharacteristic characteristic;
        for (int i = 0; i < characteristics.size(); i++) {
            characteristic = characteristics.get(i);
            model.insertRow(tblCharacteristics.getRowCount(), new Object[]{characteristic.getCharacteristicName(), characteristic.getQuantity()});
        }
        tblCharacteristics.setModel(model);
        model = (DefaultTableModel) tblImages.getModel();
        for (int i = 0; i < images.size(); i++) {
            model.insertRow(tblImages.getRowCount(), new Object[]{images.get(i)});
        }
        tblImages.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtServices = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAgreement = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnViewImage = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblImages = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCharacteristics = new javax.swing.JTable();
        lblDemand = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblPropertyFor = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblBlock = new javax.swing.JLabel();
        lblNoOfRooms = new javax.swing.JLabel();
        lblLoadShed = new javax.swing.JLabel();
        lblDateOfArrival = new javax.swing.JLabel();
        lblDateOfOwnership = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("No Of Hours of Loadshedding");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Customer Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Property Type");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Property For");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Block");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Date of Ownership");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 120, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Date of Arrival");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Size");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Services");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("No Of Rooms");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, 30));

        txtServices.setEditable(false);
        txtServices.setColumns(20);
        txtServices.setLineWrap(true);
        txtServices.setRows(5);
        jScrollPane1.setViewportView(txtServices);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 260, 100));

        txtAddress.setEditable(false);
        txtAddress.setColumns(20);
        txtAddress.setLineWrap(true);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Demand");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Address");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Agreement");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Characteristics");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, 30));

        txtAgreement.setEditable(false);
        txtAgreement.setColumns(20);
        txtAgreement.setLineWrap(true);
        txtAgreement.setRows(5);
        jScrollPane3.setViewportView(txtAgreement);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 260, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Images");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 30));

        btnViewImage.setText("View Image");
        btnViewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewImageActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        tblImages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Link"
            }
        ));
        jScrollPane5.setViewportView(tblImages);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 240, 100));

        tblCharacteristics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Characteristic", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblCharacteristics);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 520, 130));

        lblDemand.setText("jLabel16");
        getContentPane().add(lblDemand, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 30));
        getContentPane().add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, 30));
        getContentPane().add(lblPropertyFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 140, 30));

        lblSize.setText("jLabel16");
        getContentPane().add(lblSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 140, 30));

        lblBlock.setText("jLabel16");
        getContentPane().add(lblBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 30));

        lblNoOfRooms.setText("jLabel16");
        getContentPane().add(lblNoOfRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 140, 30));

        lblLoadShed.setText("jLabel16");
        getContentPane().add(lblLoadShed, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 90, 30));

        lblDateOfArrival.setText("jLabel16");
        getContentPane().add(lblDateOfArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 140, 30));

        lblDateOfOwnership.setText("jLabel16");
        getContentPane().add(lblDateOfOwnership, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 140, 30));

        lblType.setText("jLabel16");
        getContentPane().add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewImageActionPerformed
        // TODO add your handling code here:
        int index = tblImages.getSelectedRow();
        if (index >= 0) {
            String str = images.get(index);
            new ImageDisplay(str);
        } else {
            dialog.show("Please Select a row");
        }
    }//GEN-LAST:event_btnViewImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblBlock;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDateOfArrival;
    private javax.swing.JLabel lblDateOfOwnership;
    private javax.swing.JLabel lblDemand;
    private javax.swing.JLabel lblLoadShed;
    private javax.swing.JLabel lblNoOfRooms;
    private javax.swing.JLabel lblPropertyFor;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblType;
    private javax.swing.JTable tblCharacteristics;
    private javax.swing.JTable tblImages;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtAgreement;
    private javax.swing.JTextArea txtServices;
    // End of variables declaration//GEN-END:variables
}