package pojo.cdata;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Root {
    private Invoice invoice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return invoice.equals(root.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice);
    }

    public Root() {
    }

    public Invoice getInvoice() {
        return invoice;
    }

    @XmlElement
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}