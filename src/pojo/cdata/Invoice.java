package pojo.cdata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement(name = "v2:invoice")
@XmlType(propOrder = {"a", "v", "date", "invoiceType", "num", "operatorFullname", "relatedInvoice", "turnoverDate", "consignee",
        "consignor", "customers", "deliveryDocDate", "deliveryDocNum", "deliveryTerm", "productSet", "sellers", "publicOffice"})
public class Invoice {
    private String date;
    private Consignee consignee;
    private DeliveryTerm deliveryTerm;
    private long num;
    private String operatorFullname;
    private ProductSet productSet;
    private String a;
    private String v;
    private RelatedInvoice relatedInvoice;
    private String deliveryDocDate;
    private String invoiceType;
    private Customers customers;
    private String deliveryDocNum;
    private String turnoverDate;
    private Consignor consignor;
    private Sellers sellers;
    private PublicOffice publicOffice;


    public Invoice() {
    }


    //Getter

    public PublicOffice getPublicOffice() {
        return publicOffice;
    }

    public String getDate() {
        return date;
    }

    public String getA() {
        return a;
    }

    public String getDeliveryDocNum() {
        return deliveryDocNum;
    }

    public Consignee getConsignee() {
        return consignee;
    }

    public DeliveryTerm getDeliveryTerm() {
        return deliveryTerm;
    }

    public long getNum() {
        return num;
    }

    public String getOperatorFullname() {
        return operatorFullname;
    }

    public ProductSet getProductSet() {
        return productSet;
    }

    public String getV() {
        return v;
    }

    public RelatedInvoice getRelatedInvoice() {
        return relatedInvoice;
    }

    public String getDeliveryDocDate() {
        return deliveryDocDate;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public Customers getCustomers() {
        return customers;
    }


    public String getTurnoverDate() {
        return turnoverDate;
    }

    public Consignor getConsignor() {
        return consignor;
    }

    public Sellers getSellers() {
        return sellers;
    }


    //Setter


    public void setPublicOffice(PublicOffice publicOffice) {
        this.publicOffice = publicOffice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlAttribute(name = "xmlns:n0")
    public void setV(String v) {
        this.v = v;
    }

    public void setDeliveryDocNum(String deliveryDocNum) {
        this.deliveryDocNum = deliveryDocNum;
    }

    public void setConsignee(Consignee consignee) {
        this.consignee = consignee;
    }

    public void setDeliveryTerm(DeliveryTerm deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setOperatorFullname(String operatorFullname) {
        this.operatorFullname = operatorFullname;
    }

    public void setProductSet(ProductSet productSet) {
        this.productSet = productSet;
    }

    @XmlAttribute(name = "xmlns:a")
    public void setA(String a) {
        this.a = a;
    }

    public void setRelatedInvoice(RelatedInvoice relatedInvoice) {
        this.relatedInvoice = relatedInvoice;
    }

    public void setDeliveryDocDate(String deliveryDocDate) {
        this.deliveryDocDate = deliveryDocDate;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }


    public void setTurnoverDate(String turnoverDate) {
        this.turnoverDate = turnoverDate;
    }

    public void setConsignor(Consignor consignor) {
        this.consignor = consignor;
    }

    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return num == invoice.num && date.equals(invoice.date) && productSet.equals(invoice.productSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, num, productSet);
    }
}
