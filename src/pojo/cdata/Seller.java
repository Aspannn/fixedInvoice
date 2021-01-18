package pojo.cdata;

public class Seller {
    private int certificateSeries;
    private int trailer;
    private String bank;
    private String address;
    private String bik;
    private String name;
    private long tin;
    private String iik;
    private String certificateNum;
    private int kbe;


    public Seller() {
    }


    //Getter
    public int getCertificateSeries() {
        return certificateSeries;
    }

    public int getTrailer() {
        return trailer;
    }

    public String getBank() {
        return bank;
    }

    public String getAddress() {
        return address;
    }

    public String getBik() {
        return bik;
    }

    public String getName() {
        return name;
    }

    public long getTin() {
        return tin;
    }

    public String getIik() {
        return iik;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public int getKbe() {
        return kbe;
    }


    //Setter

    public void setCertificateSeries(int certificateSeries) {
        this.certificateSeries = certificateSeries;
    }

    public void setTrailer(int trailer) {
        this.trailer = trailer;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTin(long tin) {
        this.tin = tin;
    }

    public void setIik(String iik) {
        this.iik = iik;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public void setKbe(int kbe) {
        this.kbe = kbe;
    }
}
