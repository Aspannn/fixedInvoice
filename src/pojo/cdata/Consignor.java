package pojo.cdata;

public class Consignor {
    private String address;
    private String name;
    private String tin;


    public Consignor() {
    }


    //Getter
    public String getAddress() {
        return address;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
