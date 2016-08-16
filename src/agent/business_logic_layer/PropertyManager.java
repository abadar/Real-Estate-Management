package agent.business_logic_layer;

import agent.data_access_layer.DAL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsalan
 */
public class PropertyManager {

    private DAL dal;

    public PropertyManager(DAL dal) {
        this.dal = dal;
    }

//--------------------------------------------
//---------- Add Functions Starts ------------
//--------------------------------------------
    /**
     * Function to add area
     *
     * @param area
     * @return
     */
    public boolean addArea(Area area) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `area` WHERE `areaName` = '" + area.getAreaName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `area`(`areaName`) VALUES ('" + area.getAreaName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add Block
     *
     * @param block
     * @return
     */
    public boolean addBlock(Block block) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `block` WHERE `blockName` = '" + block.getBlockName() + "' and `areaId` = " + block.getAreaId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `block`(`blockName`, `noOfHoursLoadShed`, `pricePerFt`, `areaId`) VALUES ('" + block.getBlockName() + "'," + block.getNoOfHourOfLoadShed() + "," + block.getPricePerFt() + "," + block.getAreaId() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add type
     *
     * @param type
     * @return
     */
    public boolean addType(PropertyType type) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `propertytype` WHERE `typeName` = '" + type.getTypeName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertytype`(`typeName`) VALUES ('" + type.getTypeName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add service
     *
     * @param service
     * @return
     */
    public boolean addService(PropertyService service) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `propertyservices` WHERE `serviceName` = '" + service.getServiceName() + "' and `serviceId` != " + service.getServiceId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertyservices`(`serviceName`) VALUES ('" + service.getServiceName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add characteristic
     *
     * @param characteristic
     * @return
     */
    public boolean addCharacteristic(PropertyCharacteristic characteristic) {
        boolean isAdded = false;
        try {
            String sql = "Select * from `propertycharacteristics` where `characteristicsName` = '" + characteristic.getCharacteristicName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertycharacteristics`(`characteristicsName`) VALUES ('" + characteristic.getCharacteristicName() + "');";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    //
    public boolean updateProperty(Property property) {
        boolean isAdded = false;
        ResultSet rSet;
        String sql;

        try {
            sql = "SELECT * FROM `property` WHERE `blockId` = " + property.getBlock().getBlockId() + " and `address` = '" + property.getAddress() + "' and `propertyId` != " + property.getPropertyId() + ";";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                int filterId = property.getFilter().getFilterId();
                int typeId = property.getType().getTypeId();
                sql = "UPDATE `property` SET `size`= " + property.getSize() + " ,`demand`=" + property.getDemand() + ",`variation`=" + property.getVariation() + ",`agreement`= '" + property.getAgreement() + "',`isAvalible`=" + property.isAvalible() + ",`isResidential`=" + property.isResidential() + ",`noOfRooms`=" + property.getNoOfRooms() + ",`dateOfOwnerShip`=?,`address`='" + property.getAddress() + "',`typeId`=" + typeId + ",`filterId`=" + filterId + " where  `propertyId` = " + property.getPropertyId() + ";";
                isAdded = dal.createStatement(sql, property.getDateOfOwnerShip());
                if (isAdded) {
                    updateServicesOfProperty(property);
                    updateCharacteristicsOfProperty(property);
                }
            }
        } catch (SQLException ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    private void updateServicesOfProperty(Property property) {
        try {
            String sql = "DELETE FROM `propertyhasservices` WHERE `propertyId` = " + property.getPropertyId() + ";";
            if (dal.createStatement(sql)) {
                addServicesOfProperty(property);
            }
        } catch (Exception e) {

        }
    }

    private void updateCharacteristicsOfProperty(Property property) {
        try {
            String sql = "DELETE FROM `propertyhascharacteristics` WHERE `propertyId` = " + property.getPropertyId() + ";";
            if (dal.createStatement(sql)) {
                addCharacteristicsOfProperty(property);
            }
        } catch (Exception e) {

        }
    }

    /**
     * Function to add property
     *
     * @param property
     * @return
     */
    public boolean addProperty(Property property) {
        boolean isAdded = false;
        ResultSet rSet;
        String sql;

        try {
            sql = "SELECT * FROM `property` WHERE `blockId` = " + property.getBlock().getBlockId() + " and `address` = '" + property.getAddress() + "';";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                int customerId = property.getCustomer().getId();
                int blockId = property.getBlock().getBlockId();
                int filterId = property.getFilter().getFilterId();
                int typeId = property.getType().getTypeId();
                sql = "INSERT INTO `property`(`customerid`, `size`, `demand`, `variation`, `sellingPrice`, `agreement`, `isAvalible`, `isResidential`, `noOfRooms`, `dateOfOwnerShip`, `dateOfArrival`, `address`, `typeId`, `blockId`, `filterId`) VALUES ("
                        + customerId + "," + property.getSize() + "," + property.getDemand() + "," + property.getVariation() + ",0,'" + property.getAgreement() + "'," + property.isAvalible() + "," + property.isResidential() + " ," + property.getNoOfRooms() + ",?,?,'" + property.getAddress() + "'," + typeId + "," + blockId + "," + filterId + ");";

                isAdded = dal.createStatement(sql, property.getDateOfOwnerShip(), property.getDateOfEntry());
                if (isAdded) {
                    int propertyId = getPropertyLatestId();
                    if (propertyId >= 0) {
                        property.setPropertyId(propertyId);
                        addServicesOfProperty(property);
                        addCharacteristicsOfProperty(property);
                        addImagesOfProperty(property);
                    } else {
                        isAdded = false;
                    }
                }
            }
        } catch (SQLException ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to get latest image id
     *
     * @return
     */
    private int getImageLatestId() {
        int id = 0;
        try {
            ResultSet rSet;
            String sql = "SELECT max(`imageId`) FROM `propertyimage`";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {
                id = rSet.getInt(1);
                id++;
            } else {
                id = 1;
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Function to get latest property id
     *
     * @return
     */
    private int getPropertyLatestId() {
        int id = -1;
        try {
            ResultSet rSet;
            String sql = "SELECT max(`propertyId`) FROM `property`";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {
                id = rSet.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Function to add services for a property
     *
     * @param property
     * @return
     */
    private boolean addServicesOfProperty(Property property) {
        boolean isAdded = true;
        try {
            ArrayList<PropertyService> services = property.getServices();
            PropertyService service;
            String sql;
            for (int i = 0; i < services.size() && isAdded; i++) {
                service = services.get(i);
                sql = "INSERT INTO `propertyhasservices`(`serviceId`, `propertyId`) VALUES (" + service.getServiceId() + "," + property.getPropertyId() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isAdded;
    }

    /**
     * Function to add characteristic for property
     *
     * @param property
     * @return
     */
    private boolean addCharacteristicsOfProperty(Property property) {
        boolean isAdded = true;
        try {
            ArrayList<PropertyCharacteristic> characteristics = property.getCharacteristics();
            PropertyCharacteristic characteristic;
            String sql;
            for (int i = 0; i < characteristics.size() && isAdded; i++) {
                characteristic = characteristics.get(i);
                sql = "INSERT INTO `propertyhascharacteristics`(`characteristicsId`, `propertyId`, `quantity`) VALUES (" + characteristic.getCharacteristicId() + "," + property.getPropertyId() + "," + characteristic.getQuantity() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add images for property
     *
     * @param property
     * @return
     */
    private boolean addImagesOfProperty(Property property) {
        boolean isAdded = false;
        ArrayList<String> links = property.getImages();
        DataManager dataManager = DataManager.getInstance();
        String customerName = property.getCustomer().getName();
        int propertyId = property.getPropertyId();
        String sql;
        dataManager.createFolder("Images\\" + customerName);
        int id;
        String filePath;
        for (int i = 0; i < links.size(); i++) {
            try {
                id = getImageLatestId();
                filePath = "Images\\" + customerName + "\\Image_" + id + ".jpg";
                dataManager.copyImage(links.get(i), filePath);
                sql = "INSERT INTO `propertyimage`(`imageLink`, `propertyId`) VALUES ('" + filePath + "'," + propertyId + ");";
                isAdded = dal.createStatement(sql);
            } catch (Exception ex) {
                Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isAdded;
    }

//--------------------------------------------
//-------- Update Functions Starts -----------
//--------------------------------------------
    /**
     * Function to Update Area
     *
     * @param area
     * @return
     */
    public boolean updateArea(Area area) {
        boolean isUpdated = false;

        try {
            String sql = "SELECT * FROM `area` WHERE `areaName` = '" + area.getAreaName() + "' and `areaId` != " + area.getAreaId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `area` SET `areaName`= '" + area.getAreaName() + "' WHERE `areaId` = " + area.getAreaId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Block
     *
     * @param block
     * @return
     */
    public boolean updateBlock(Block block) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `block` WHERE `blockName` = '" + block.getBlockName() + "' and `areaId` = " + block.getAreaId() + " and `blockId` != " + block.getBlockId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `block` SET `blockName`='" + block.getBlockName() + "',`noOfHoursLoadShed` = " + block.getNoOfHourOfLoadShed() + ",`pricePerFt` = " + block.getPricePerFt() + " WHERE `blockId` = " + block.getBlockId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Type
     *
     * @param type
     * @return
     */
    public boolean updateType(PropertyType type) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `propertytype` WHERE `typeName` = '" + type.getTypeName() + "' and `typeId` != " + type.getTypeId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertytype` SET `typeName` = '" + type.getTypeName() + "' WHERE `typeId` = " + type.getTypeId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Service
     *
     * @param service
     * @return
     */
    public boolean updateService(PropertyService service) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `propertyservices` WHERE `serviceName` = '" + service.getServiceName() + "' and `serviceId` != " + service.getServiceId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertyservices` SET `serviceName` = '" + service.getServiceName() + "' WHERE `serviceId` = " + service.getServiceId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Characteristic
     *
     * @param characteristic
     * @return
     */
    public boolean updateCharacteristic(PropertyCharacteristic characteristic) {
        boolean isUpdated = false;
        try {
            String sql = "Select * from `propertycharacteristics` where `characteristicsName` = '" + characteristic.getCharacteristicName() + "' and `characteristicsId` != " + characteristic.getCharacteristicId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertycharacteristics` SET `characteristicsName` = '" + characteristic.getCharacteristicName() + "' WHERE `characteristicsId` = " + characteristic.getCharacteristicId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

//--------------------------------------------
//----- List Retrival Functions Starts -------
//--------------------------------------------
    /**
     * Function to retrieve all Areas
     *
     * @return
     */
    public ArrayList<Area> getAreas() {
        ArrayList<Area> list = new ArrayList<Area>();
        try {
            String sql = "SELECT * FROM `area`;";
            ResultSet set = dal.executeStatement(sql);
            Area area;
            while (set.next()) {
                area = new Area();
                area.setAreaId(set.getInt(1));
                area.setAreaName(set.getString(2));
                list.add(area);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all blocks of area
     *
     * @param areaId
     * @return
     */
    public ArrayList<Block> getBlocksOfArea(int areaId) {
        ArrayList<Block> list = new ArrayList<Block>();
        try {
            String sql = "SELECT * FROM `block` where `areaId` = " + areaId + ";";
            ResultSet set = dal.executeStatement(sql);
            Block block;
            while (set.next()) {
                block = new Block();
                block.setBlockId(set.getInt(1));
                block.setBlockName(set.getString(2));
                block.setNoOfHourOfLoadShed(set.getInt(3));
                block.setPricePerFt(set.getInt(4));
                block.setAreaId(set.getInt(5));
                list.add(block);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all property types
     *
     * @return
     */
    public ArrayList<PropertyType> getPropertyTypes() {
        ArrayList<PropertyType> list = new ArrayList<PropertyType>();
        try {
            String sql = "SELECT * FROM `propertytype`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyType propertyType;
            while (set.next()) {
                propertyType = new PropertyType();
                propertyType.setTypeId(set.getInt(1));
                propertyType.setTypeName(set.getString(2));
                list.add(propertyType);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all characteristics
     *
     * @return
     */
    public ArrayList<PropertyCharacteristic> getPropertyCharacteristics() {
        ArrayList<PropertyCharacteristic> list = new ArrayList<PropertyCharacteristic>();
        try {
            String sql = "SELECT * FROM `propertycharacteristics`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyCharacteristic characteristic;
            while (set.next()) {
                characteristic = new PropertyCharacteristic();
                characteristic.setCharacteristicId(set.getInt(1));
                characteristic.setCharacteristicName(set.getString(2));
                list.add(characteristic);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all services
     *
     * @return
     */
    public ArrayList<PropertyService> getPropertyServices() {
        ArrayList<PropertyService> list = new ArrayList<PropertyService>();
        try {
            String sql = "SELECT * FROM `propertyservices`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyService service;
            while (set.next()) {
                service = new PropertyService();
                service.setServiceId(set.getInt(1));
                service.setServiceName(set.getString(2));
                list.add(service);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Property> getProperties(int customerId, int blockId) {

        ArrayList<Property> list = new ArrayList<Property>();
        try {
            String sql = "SELECT `propertyId` FROM `property` WHERE `blockId` = " + blockId + " and `customerid` = " + customerId + " and `isAvalible` = true;";
            ResultSet set = dal.executeStatement(sql);
            Property property = null;
            int propertyId;
            while (set.next()) {
                propertyId = set.getInt(1);
                property = getPropertyWithId(propertyId);
                list.add(property);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Block> getBlocks(int customerId, int areaId) {
        //SELECT distinct(a.`blockId`) FROM `property` a, `block` b WHERE a.`customerid` = 19 and b.`blockId` in (SELECT `blockId` FROM `block` WHERE `areaId` =  5)
        ArrayList<Block> list = new ArrayList<Block>();
        try {
            String sql = "SELECT * from `block` where `blockId` IN (SELECT distinct(a.`blockId`) FROM `property` a, `block` b WHERE a.`customerid` = " + customerId + " and b.`blockId` in (SELECT `blockId` FROM `block` WHERE `areaId` =  " + areaId + ")) and `areaId` = " + areaId + ";";
            ResultSet set = dal.executeStatement(sql);
            Block block;
            while (set.next()) {
                block = new Block();
                block.setBlockId(set.getInt(1));
                block.setBlockName(set.getString(2));
                block.setNoOfHourOfLoadShed(set.getInt(3));
                block.setPricePerFt(set.getInt(4));
                block.setAreaId(set.getInt(5));
                list.add(block);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Area> getAreasForCustomer(int customerId) {
        ArrayList<Area> areas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `area` WHERE `areaId` IN (SELECT `areaId` FROM `block` WHERE `blockId` IN (SELECT distinct(`blockId`) FROM `property` WHERE `customerid` = " + customerId + "));";
            ResultSet set = dal.executeStatement(sql);
            Area area;
            while (set.next()) {
                area = new Area();
                area.setAreaId(set.getInt(1));
                area.setAreaName(set.getString(2));
                areas.add(area);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areas;
    }

    public Property getPropertyWithId(int propertyId) {
        Property property = new Property();
        try {
            String sql = "SELECT a.*,b.`typeName`,c.`blockName`,c.`noOfHoursLoadShed`, c.`pricePerFt`, c.`areaId`,d.`filterName`,e.`customerName` FROM `property` a, `propertytype` b, `block` c, `propertyfilter` d, `customer` e WHERE a.`typeId` = b.`typeId` and a.`blockId` = c.`blockId` and a.`filterId` = d.`filterId` and a.`customerid` = e.`customerid` and a.`propertyId` =  " + propertyId + ";";
            ResultSet set = dal.executeStatement(sql);
            Customer customer;
            PropertyType type;
            PropertyFilter filter;
            Block block;
            if (set.next()) {
                customer = new Customer();
                type = new PropertyType();
                filter = new PropertyFilter();
                block = new Block();

                property.setPropertyId(set.getInt(1));
                customer.setId(set.getInt(2));
                customer.setName(set.getString(23));
                property.setCustomer(customer);
                property.setSize(set.getInt(3));
                property.setDemand(set.getInt(4));
                property.setVariation(set.getInt(5));
                property.setSellingPrice(set.getInt(6));
                property.setAgreement(set.getString(7));
                property.setIsAvalible(set.getBoolean(8));
                property.setIsResidential(set.getBoolean(9));
                property.setNoOfRooms(set.getInt(10));
                property.setDateOfOwnerShip(set.getDate(11));
                property.setDateOfEntry(set.getDate(12));
                property.setAddress(set.getString(13));
                type.setTypeId(set.getInt(14));
                type.setTypeName(set.getString(17));
                property.setType(type);
                block.setBlockId(set.getInt(15));
                block.setBlockName(set.getString(18));
                block.setNoOfHourOfLoadShed(set.getInt(19));
                block.setPricePerFt(set.getInt(20));
                block.setAreaId(set.getInt(21));
                property.setBlock(block);
                filter.setFilterId(set.getInt(16));
                filter.setFilterName(set.getString(22));
                property.setFilter(filter);

                property.setServices(getPropertyServicesOfProperty(property.getPropertyId()));
                property.setCharacteristics(getPropertyCharacteristicsOfProperty(property.getPropertyId()));
                property.setImages(getPropertyImagesOfProperty(property.getPropertyId()));
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return property;
    }

    public ArrayList<Property> getPropertyOfCustomer(int customerId) {
        ArrayList<Property> list = new ArrayList<Property>();
        try {
            String sql = "SELECT `propertyId` FROM `property` WHERE `customerid` = " + customerId + " and `isAvalible` = true;";
            ResultSet set = dal.executeStatement(sql);
            Property property = null;
            int propertyId;
            while (set.next()) {
                propertyId = set.getInt(1);
                property = getPropertyWithId(propertyId);
                property.setServices(getPropertyServices());
                property.setCharacteristics(getPropertyCharacteristics());
                property.setImages(getPropertyImagesOfProperty(property.getPropertyId()));

                list.add(property);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<String> getPropertyImagesOfProperty(int propertyId) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            String sql = "SELECT `imageLink` FROM `propertyimage` WHERE `propertyId` = " + propertyId + ";";
            ResultSet set = dal.executeStatement(sql);

            while (set.next()) {
                list.add(set.getString(1));
            }

        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<PropertyService> getPropertyServicesOfProperty(int propertyId) {
        ArrayList<PropertyService> list = new ArrayList<PropertyService>();
        try {
            String sql = "SELECT * FROM `propertyservices` WHERE `serviceId` in (SELECT `serviceId` FROM `propertyhasservices` WHERE `propertyId` = " + propertyId + ");";
            ResultSet set = dal.executeStatement(sql);
            PropertyService service;
            while (set.next()) {
                service = new PropertyService();
                service.setServiceId(set.getInt(1));
                service.setServiceName(set.getString(2));
                list.add(service);
            }

        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<PropertyCharacteristic> getPropertyCharacteristicsOfProperty(int propertyId) {
        ArrayList<PropertyCharacteristic> list = new ArrayList<PropertyCharacteristic>();
        try {
            String sql = "SELECT b.*, a.`quantity` FROM `propertyhascharacteristics` a,`propertycharacteristics` b where a.`characteristicsId`=b.`characteristicsId` and a.`propertyId` = " + propertyId + ";";
            ResultSet set = dal.executeStatement(sql);
            PropertyCharacteristic characteristic;
            while (set.next()) {
                characteristic = new PropertyCharacteristic();
                characteristic.setCharacteristicId(set.getInt(1));
                characteristic.setCharacteristicName(set.getString(2));
                characteristic.setQuantity(set.getInt(3));
                list.add(characteristic);
            }

        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Property> getPropertiesForSearch(String conditions) {
        ArrayList<Property> list = new ArrayList<>();
        try {

            String sql = "SELECT distinct(property.propertyid) FROM ";
            sql += conditions;
            ResultSet set = dal.executeStatement(sql);
            Property property = null;
            int propertyId;
            while (set.next()) {
                propertyId = set.getInt(1);
                property = getPropertyWithId(propertyId);
                property.setServices(getPropertyServicesOfProperty(propertyId));
                property.setCharacteristics(getPropertyCharacteristicsOfProperty(propertyId));
                property.setImages(getPropertyImagesOfProperty(property.getPropertyId()));

                list.add(property);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<String> getPropertySizeRangeOfType(int typeId) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            if (typeId != -1) {
                String sql = "SELECT min(`size`),max(`size`) FROM  `property` WHERE  `typeId` = " + typeId + ";";
                ResultSet set = dal.executeStatement(sql);
                int min, max;
                if (set.next()) {
                    min = set.getInt(1);
                    max = set.getInt(2);
                    list = getRangeList(min, max, 5);
                }
            } else {
                list = getRangeList(120, 1000, 5);
            }
        } catch (Exception ex) {
            list = getRangeList(120, 1000, 5);
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<String> getPropertyPriceRangeOfType(int typeId) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            if (typeId != -1) {
                String sql = "SELECT MIN(`demand`) , MAX(`demand`) FROM  `property` WHERE  `typeId` = " + typeId + ";";
                ResultSet set = dal.executeStatement(sql);
                int min, max;
                if (set.next()) {
                    min = set.getInt(1);
                    max = set.getInt(2);
                    list = getRangeList(min, max, 5);
                } else {
                    list = getRangeList(1000000, 10000000, 5);
                }
            } else {
                list = getRangeList(1000000, 10000000, 5);
            }
        } catch (Exception ex) {
            switch (typeId) {
                case 0:
                    list = getRangeList(10000, 100000, 5);
                    break;
                case 1:
                    list = getRangeList(3000000, 10000000, 5);
                    break;
                case 2:
                    list = getRangeList(1000000, 10000000, 5);
                    break;
                default:
                    list = getRangeList(1000000, 10000000, 5);
                    break;
            }
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private ArrayList<String> getRangeList(int min, int max, int factor) {
        ArrayList<String> list = new ArrayList<String>();
        int difference = (max - min) / factor;
        min += difference;
        max -= difference;
        list.add("less than " + min);
        for (int i = 0; i < factor - 2; i++) {
            list.add(min + " - " + (min + difference));
            min += difference;
        }
        list.add("greater than " + max);
        return list;
    }

    public boolean performSale(int propertyId, int soldToId, int sellPrice) {
        boolean isUpdated = false;
        try {
            Date date = new Date();
            String sql = "INSERT INTO `sales`(`propertyId`, `soldToCustomer`, `date`) VALUES (" + propertyId + "," + soldToId + ",?);";
            isUpdated = dal.createStatement(sql, date);
            if (isUpdated) {
                sql = "UPDATE `property` SET `sellingPrice` = " + sellPrice + ", `isAvalible` = false WHERE `propertyId` = " + propertyId + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    public ArrayList<ArrayList> getSales() {
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        try {
            String sql = "SELECT sales.date,customer.customername,property.sellingprice,(property.sellingprice/100)*5 \"5%\" from sales,customer,property where sales.soldtocustomer=customer.customerid and sales.propertyid=property.propertyid";
            ArrayList innerList;
            ResultSet set = dal.executeStatement(sql);
            while (set.next()) {
                innerList = new ArrayList<>();
                innerList.add(set.getDate(1));
                innerList.add(set.getString(2));
                innerList.add(set.getInt(3));
                innerList.add(set.getInt(4));
                list.add(innerList);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all filters
     *
     * @return
     */
    public ArrayList<PropertyFilter> getPropertyFilters() {
        ArrayList<PropertyFilter> list = new ArrayList<PropertyFilter>();
        try {
            String sql = "SELECT * FROM `propertyfilter`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyFilter filter;
            while (set.next()) {
                filter = new PropertyFilter();
                filter.setFilterId(set.getInt(1));
                filter.setFilterName(set.getString(2));
                list.add(filter);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
