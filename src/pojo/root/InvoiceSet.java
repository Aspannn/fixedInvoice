package pojo.root;

import java.util.List;

public class InvoiceSet {
    private List<InvoiceInfo> invoiceInfo;

    public InvoiceSet() {
    }

    public List<InvoiceInfo> getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(List<InvoiceInfo> invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }
}
