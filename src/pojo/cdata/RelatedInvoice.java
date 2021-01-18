package pojo.cdata;

public class RelatedInvoice {
    private String date;
    private String registrationNumber;
    private long num;

    public RelatedInvoice() {
    }


    //Getter
    public String getDate() {
        return date;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public long getNum() {
        return num;
    }


    //Setter


    public void setDate(String date) {
        this.date = date;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
