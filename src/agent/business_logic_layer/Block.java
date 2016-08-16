package agent.business_logic_layer;

/**
 *
 * @author arsalan
 */
public class Block {

    private int blockId;
    private String blockName;
    private int noOfHourOfLoadShed;
    private int pricePerFt;
    private int areaId;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getNoOfHourOfLoadShed() {
        return noOfHourOfLoadShed;
    }

    public void setNoOfHourOfLoadShed(int noOfHourOfLoadShed) {
        this.noOfHourOfLoadShed = noOfHourOfLoadShed;
    }

    public int getPricePerFt() {
        return pricePerFt;
    }

    public void setPricePerFt(int pricePerFt) {
        this.pricePerFt = pricePerFt;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
