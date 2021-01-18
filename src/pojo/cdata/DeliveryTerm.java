package pojo.cdata;

public class DeliveryTerm {
    private String contractDate;
    private boolean hasContract;
    private String destination;
    private String contractNum;
    private String term;
    private String transportTypeCode;
    private String deliveryConditionCode;

    public DeliveryTerm() {
    }


    //Getter

    public String getTransportTypeCode() {
        return transportTypeCode;
    }

    public String getDeliveryConditionCode() {
        return deliveryConditionCode;
    }

    public String getContractDate() {
        return contractDate;
    }

    public String getContractNum() {
        return contractNum;
    }

    public boolean isHasContract() {
        return hasContract;
    }

    public String getDestination() {
        return destination;
    }

    public String getTerm() {
        return term;
    }

    //Setter


    public void setDeliveryConditionCode(String deliveryConditionCode) {
        this.deliveryConditionCode = deliveryConditionCode;
    }

    public void setTransportTypeCode(String transportTypeCode) {
        this.transportTypeCode = transportTypeCode;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public void setHasContract(boolean hasContract) {
        this.hasContract = hasContract;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
