package agent.user_interface_layer;

import agent.business_logic_layer.Area;
import agent.business_logic_layer.Block;
import agent.business_logic_layer.Customer;
import agent.business_logic_layer.CustomerManager;
import agent.business_logic_layer.DataManager;
import agent.business_logic_layer.Property;
import agent.business_logic_layer.PropertyFilter;
import agent.business_logic_layer.PropertyManager;
import agent.business_logic_layer.PropertyType;
import agent.business_logic_layer.Validations;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arsalan
 */
public class ViewPropertyForViewer extends javax.swing.JPanel {

    private ArrayList<PropertyType> propertyTypeList;
    private ArrayList<Block> blocksList;
    private ArrayList<Area> areaList;
    private ArrayList<PropertyFilter> propertyForList;
    private ArrayList<String> priceRanges;
    private ArrayList<String> sizeRanges;
    private final PropertyManager propertyManager;
    private final CustomerManager customerManager;
    private ArrayList<Property> properties;
    private final DialogBox dialog;
    private final Validations validation;

    /**
     * Creates new form ViewPropertyForViewer
     */
    public ViewPropertyForViewer() {
        initComponents();
        propertyManager = DataManager.getInstance().getPropertyManager();
        customerManager = DataManager.getInstance().getCustomerManager();
        validation = new Validations();
        fillAllDropDowns();
        performSearch();
        dialog = new DialogBox();
    }

    public void fillAllDropDowns() {
        fillAreaDropDown();
        fillPropertyForDropDown();
        fillPropertyTypeDropDown();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblProperties = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        recieptAddProdError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbBlocks = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbPrices = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        cmbSizes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbPropertyFilter = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbPropertyType = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtKeyWords = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbSort = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jPanel4.setLayout(null);

        tblProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property Id", "Demand", "Variation", "Address", "Agreement"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProperties.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(tblProperties);

        jPanel4.add(jScrollPane6);
        jScrollPane6.setBounds(20, 90, 1070, 360);

        btnDetails.setText("Details");
        btnDetails.setToolTipText("Remove Item");
        btnDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(btnDetails);
        btnDetails.setBounds(1000, 460, 90, 30);

        recieptAddProdError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(recieptAddProdError);
        recieptAddProdError.setBounds(810, 130, 280, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Area");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(510, 10, 40, 30);

        cmbAreas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "1", "2" }));
        cmbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreasActionPerformed(evt);
            }
        });
        jPanel4.add(cmbAreas);
        cmbAreas.setBounds(550, 10, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Block");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(690, 10, 40, 30);

        cmbBlocks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "1 - 10", "20 - 50" }));
        jPanel4.add(cmbBlocks);
        cmbBlocks.setBounds(730, 10, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Price Range");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(280, 50, 80, 30);

        cmbPrices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Area 1", "Area 2", "Area 3" }));
        jPanel4.add(cmbPrices);
        cmbPrices.setBounds(360, 50, 170, 30);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel4.add(btnSearch);
        btnSearch.setBounds(1000, 50, 90, 30);

        cmbSizes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any" }));
        jPanel4.add(cmbSizes);
        cmbSizes.setBounds(610, 50, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Size Range");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(540, 50, 70, 30);

        cmbPropertyFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Area 1", "Area 2", "Area 3" }));
        jPanel4.add(cmbPropertyFilter);
        cmbPropertyFilter.setBounds(920, 10, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Property For");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(840, 10, 80, 30);

        cmbPropertyType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Area 1", "Area 2", "Area 3" }));
        cmbPropertyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropertyTypeActionPerformed(evt);
            }
        });
        jPanel4.add(cmbPropertyType);
        cmbPropertyType.setBounds(110, 50, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Property Type");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(10, 50, 100, 30);
        jPanel4.add(txtKeyWords);
        txtKeyWords.setBounds(80, 10, 420, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Key words");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 10, 70, 30);

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Size", "Price", "Date", "Block", "Area", "Customer", "Property For", "Property Type" }));
        jPanel4.add(cmbSort);
        cmbSort.setBounds(830, 50, 160, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Sort By");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(770, 50, 60, 30);

        jButton3.setText("Refresh");
        jPanel4.add(jButton3);
        jButton3.setBounds(470, 460, 250, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        int index = tblProperties.getSelectedRow();
        if (index >= 0) {
            Property property = properties.get(index);
            new ViewPropertyDetails(property).setVisible(true);
        } else {
            dialog.show("Please Select a row");
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void cmbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreasActionPerformed
        // TODO add your handling code here:
        fillBlockDropDown();
    }//GEN-LAST:event_cmbAreasActionPerformed

    private void cmbPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropertyTypeActionPerformed
        // TODO add your handling code here:
        fillPriceDropDown();
        fillSizeDropDown();
    }//GEN-LAST:event_cmbPropertyTypeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        performSearch();
    }//GEN-LAST:event_btnSearchActionPerformed
    public void setTable() {
        String[] tableColumnsName = {"Property Id", "Demand", "Variation", "Address", "Agreement"};
        DefaultTableModel aModel = (DefaultTableModel) tblProperties.getModel();
        aModel.setRowCount(0);
        aModel.setColumnIdentifiers(tableColumnsName);
        Property property;

        for (int i = 0; i < properties.size(); i++) {
            property = properties.get(i);
            Object[] objects = new Object[5];
            objects[0] = property.getPropertyId();
            objects[1] = property.getDemand();
            objects[2] = property.getVariation();
            objects[3] = property.getAddress();
            objects[4] = property.getAgreement();
            aModel.addRow(objects);
        }
        tblProperties.setModel(aModel);
    }

    public void performSearch() {
        int areaInd = cmbAreas.getSelectedIndex() - 1;
        int blockInd = cmbBlocks.getSelectedIndex() - 1;
        int typeInd = cmbPropertyType.getSelectedIndex() - 1;
        int priceInd = cmbPrices.getSelectedIndex() - 1;
        int sizeInd = cmbSizes.getSelectedIndex() - 1;
        int filterInd = cmbPropertyFilter.getSelectedIndex() - 1;
        int sortInd = cmbSort.getSelectedIndex() - 1;
        String sql = "";
        String keywords = txtKeyWords.getText();
        if (areaInd >= 0 && !validation.isEmpty(keywords)) {
            sql += "property,area,block,propertycharacteristics,propertyhascharacteristics where property.blockid = block.blockid and area.areaid=block.areaid and `isAvalible` = true ";
            sql += "and propertyhascharacteristics.propertyid = property.propertyid and propertyhascharacteristics.characteristicsid = propertycharacteristics.characteristicsid ";
            sql += "and area.areaid = " + areaList.get(areaInd).getAreaId() + " ";
            String s[] = keywords.split(",");
            for (int i = 0; i < s.length; i++) {
                sql += "and (propertycharacteristics.characteristicsname = '" + s[i] + "') \n";
            }
        } else if (areaInd >= 0) {
            sql += "property,area,block where property.blockid = block.blockid and area.areaid=block.areaid and `isAvalible` = true";
            sql += "and area.areaid = " + areaList.get(areaInd).getAreaId() + " ";
        } else if (!validation.isEmpty(keywords)) {
            sql += "property,propertycharacteristics,propertyhascharacteristics where `isAvalible` = true ";
            sql += "and propertyhascharacteristics.propertyid = property.propertyid and propertyhascharacteristics.characteristicsid = propertycharacteristics.characteristicsid ";
            String s[] = keywords.split(",");
            for (int i = 0; i < s.length; i++) {
                sql += "and (propertycharacteristics.characteristicsname = '" + s[i] + "') \n";
            }
        } else {
            sql += "`property` WHERE `isAvalible` = true ";
        }
        if (typeInd >= 0) {
            sql += "AND (property.`typeId` =  " + propertyTypeList.get(typeInd).getTypeId() + ") \n";
        }
        if (priceInd == 0) {
            String arr[] = priceRanges.get(0).split("less than ");
            int price = Integer.parseInt(arr[1]);
            sql += "AND (property.`demand` <  " + price + ") \n";
        } else if (priceInd == priceRanges.size() - 1) {
            String arr[] = priceRanges.get(0).split("less than ");
            int price = Integer.parseInt(arr[1]);
            sql += "AND (property.`demand` >  " + price + ") \n";
        } else if (priceInd > 0) {
            String str = priceRanges.get(priceInd).replace("-", "AND");
            sql += "AND (property.`demand` BETWEEN " + str + ")\n";
        }
        if (sizeInd == 0) {
            String arr[] = sizeRanges.get(0).split("less than ");
            int price = Integer.parseInt(arr[1]);
            sql += "AND (property.`size` <  " + price + ") \n";
        } else if (sizeInd == sizeRanges.size() - 1) {
            String arr[] = sizeRanges.get(0).split("less than ");
            int price = Integer.parseInt(arr[1]);
            sql += "AND (property.`size` >  " + price + ") \n";
        } else if (sizeInd > 0) {
            String str = sizeRanges.get(sizeInd).replace("-", "AND");
            sql += "AND (property.`size` BETWEEN " + str + ")\n";
        }
        if (filterInd >= 0) {
            sql += "AND (property.`filterId` =  " + propertyForList.get(filterInd).getFilterId() + ") \n";
        }
        if (blockInd >= 0) {
            sql += "AND (property.`blockId` = " + blocksList.get(blockInd).getBlockId() + ") \n";
        }
        // 

        if (sortInd >= 0) {
            switch (sortInd) {
                case 0:
                    sql += "ORDER BY `size` ASC;";
                    break;
                case 1:
                    sql += "ORDER BY `demand` ASC;";
                    break;
                case 2:
                    sql += "ORDER BY `dateOfArrival` DESC;";
                    break;
                case 3:
                    sql += "ORDER BY `blockId` ASC;";
                    break;
                case 4:
                    sql += "ORDER BY `customerid` ASC;";
                    break;
                case 5:
                    sql += "ORDER BY `typeId` ASC;";
                    break;

            }
        }
        properties = propertyManager.getPropertiesForSearch(sql);

        setTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbAreas;
    private javax.swing.JComboBox cmbBlocks;
    private javax.swing.JComboBox cmbPrices;
    private javax.swing.JComboBox cmbPropertyFilter;
    private javax.swing.JComboBox cmbPropertyType;
    private javax.swing.JComboBox cmbSizes;
    private javax.swing.JComboBox cmbSort;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel recieptAddProdError;
    private javax.swing.JTable tblProperties;
    private javax.swing.JTextField txtKeyWords;
    // End of variables declaration//GEN-END:variables

    private void fillPropertyForDropDown() {
        propertyForList = propertyManager.getPropertyFilters();
        cmbPropertyFilter.removeAllItems();
        cmbPropertyFilter.addItem("Any");
        if (propertyForList.size() > 0) {
            PropertyFilter filter;
            for (int i = 0; i < propertyForList.size(); i++) {
                filter = propertyForList.get(i);
                cmbPropertyFilter.addItem(filter.getFilterName());
            }
        } else {
        }
    }

    private void fillPriceDropDown() {
        int propertyType = cmbPropertyType.getSelectedIndex() - 1;
        if (propertyType >= 0) {
            priceRanges = propertyManager.getPropertyPriceRangeOfType(propertyTypeList.get(propertyType).getTypeId());

        } else {
            priceRanges = propertyManager.getPropertyPriceRangeOfType(-1);
        }
        cmbPrices.removeAllItems();
        cmbPrices.addItem("Any");
        if (priceRanges.size() > 0) {
            for (int i = 0; i < priceRanges.size(); i++) {
                cmbPrices.addItem(priceRanges.get(i));
            }
        } else {
        }
    }

    private void fillSizeDropDown() {
        int propertyType = cmbPropertyType.getSelectedIndex() - 1;
        if (propertyType >= 0) {
            sizeRanges = propertyManager.getPropertySizeRangeOfType(propertyTypeList.get(propertyType).getTypeId());
        } else {
            sizeRanges = propertyManager.getPropertySizeRangeOfType(-1);
        }
        cmbSizes.removeAllItems();
        cmbSizes.addItem("Any");
        if (sizeRanges.size() > 0) {
            for (int i = 0; i < sizeRanges.size(); i++) {
                cmbSizes.addItem(sizeRanges.get(i));
            }
        } else {
        }
    }

    private void fillPropertyTypeDropDown() {
        propertyTypeList = propertyManager.getPropertyTypes();
        cmbPropertyType.removeAllItems();
        cmbPropertyType.addItem("Any");
        if (propertyTypeList.size() > 0) {
            PropertyType propertyType;
            for (int i = 0; i < propertyTypeList.size(); i++) {
                propertyType = propertyTypeList.get(i);
                cmbPropertyType.addItem(propertyType.getTypeName());
            }
        } else {

        }
    }

    private void fillAreaDropDown() {
        areaList = propertyManager.getAreas();
        cmbAreas.removeAllItems();
        cmbAreas.addItem("Any");
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
        int index = cmbAreas.getSelectedIndex() - 1;
        if (index >= 0) {
            blocksList = propertyManager.getBlocksOfArea(areaList.get(index).getAreaId());
            cmbBlocks.removeAllItems();
            cmbBlocks.addItem("Any");
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

}
