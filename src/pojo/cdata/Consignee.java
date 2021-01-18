package pojo.cdata;

public class Consignee {
    private String address;
    private String countryCode;
    private String name;
    private String tin;

    public Consignee() {
    }

    //Getter
    public String getAddress() {
        return address;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public String getTin() {
        return tin;
    }

    //Setter

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
