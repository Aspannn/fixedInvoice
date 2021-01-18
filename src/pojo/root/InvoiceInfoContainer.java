package pojo.root;


public class InvoiceInfoContainer {
    private InvoiceSet invoiceSet;
    private String esf;

    public InvoiceInfoContainer() {
    }

    public InvoiceSet getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(InvoiceSet invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public String getEsf() {
        return esf;
    }

    public void setEsf(String esf) {
        this.esf = esf;
    }
}
