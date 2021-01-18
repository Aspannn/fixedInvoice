package pojo.root;


public class InvoiceInfo {
    private String invoiceBody;

    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public InvoiceInfo() {
    }

    public String getInvoiceBody() {
        return invoiceBody;
    }

    public void setInvoiceBody(String invoiceBody) {
        this.invoiceBody = invoiceBody;
    }
}
