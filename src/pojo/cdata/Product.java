package pojo.cdata;

import javax.xml.bind.annotation.XmlType;
import java.util.Locale;
import java.util.Objects;

@XmlType(propOrder = {"catalogTruId", "description", "exciseAmount", "exciseRate", "ndsAmount", "ndsRate", "priceWithTax", "priceWithoutTax", "productDeclaration", "productNumberInDeclaration", "quantity", "tnvedName", "truOriginCode",
        "turnoverSize", "unitCode", "unitNomenclature", "unitPrice"})
public class Product {
    private String unitPrice;
    private String unitNomenclature;
    private String catalogTruId;
    private String quantity;
    private String tnvedName;
    private String priceWithTax;
    private String exciseRate;
    private String description;
    private String truOriginCode;
    private String unitCode;
    private String priceWithoutTax;
    private String turnoverSize;
    private String ndsAmount;
    private String exciseAmount;
    private String productNumberInDeclaration;
    private String productDeclaration;
    private String ndsRate;

    public Product() {
    }


    //Getter
    public String getUnitPrice() {
        return unitPrice;
    }

    public String getUnitNomenclature() {
        return unitNomenclature;
    }

    public String getCatalogTruId() {
        return catalogTruId;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTnvedName() {
        return tnvedName;
    }

    public String getPriceWithTax() {
        return priceWithTax;
    }

    public String getExciseRate() {
        return exciseRate;
    }

    public String getDescription() {
        return description;
    }

    public String getTruOriginCode() {
        return truOriginCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public String getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public String getTurnoverSize() {
        return turnoverSize;
    }

    public String getNdsAmount() {
        return ndsAmount;
    }

    public String getExciseAmount() {
        return exciseAmount;
    }

    public String getProductNumberInDeclaration() {
        return productNumberInDeclaration;
    }

    public String getProductDeclaration() {
        return productDeclaration;
    }

    public String getNdsRate() {
        return ndsRate;
    }


    //Setter
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitNomenclature(String unitNomenclature) {
        this.unitNomenclature = unitNomenclature;
    }

    public void setCatalogTruId(String catalogTruId) {
        this.catalogTruId = catalogTruId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTnvedName(String tnvedName) {
        this.tnvedName = tnvedName;
    }

    public void setPriceWithTax(String priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public void setExciseRate(String exciseRate) {
        this.exciseRate = exciseRate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTruOriginCode(String truOriginCode) {
        this.truOriginCode = truOriginCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public void setPriceWithoutTax(String priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    public void setTurnoverSize(String turnoverSize) {
        this.turnoverSize = turnoverSize;
    }

    public void setNdsAmount(String ndsAmount) {
        this.ndsAmount = ndsAmount;
    }

    public void setExciseAmount(String exciseAmount) {
        this.exciseAmount = exciseAmount;
    }

    public void setProductNumberInDeclaration(String productNumberInDeclaration) {
        this.productNumberInDeclaration = productNumberInDeclaration;
    }

    public void setProductDeclaration(String productDeclaration) {
        this.productDeclaration = productDeclaration;
    }

    public void setNdsRate(String ndsRate) {
        this.ndsRate = ndsRate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return unitPrice.equals(product.unitPrice) && description.trim().toLowerCase(Locale.ROOT).equals(product.description.trim().toLowerCase(Locale.ROOT));
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice, description);
    }
}
