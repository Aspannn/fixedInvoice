package pojo.cdata;

public class Customer {
    private String address;
    private String countryCode;
    private String name;
    private String tin;
    private Statuses statuses;

    public Customer() {
    }

    //Getter

    public Statuses getStatuses() {
        return statuses;
    }

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

    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

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
