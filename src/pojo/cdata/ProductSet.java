package pojo.cdata;

import java.util.Objects;

public class ProductSet {
    private String totalPriceWithoutTax;
    private String totalExciseAmount;
    private String totalPriceWithTax;
    private String currencyCode;
    private String totalNdsAmount;
    private Products products;
    private String totalTurnoverSize;

    public ProductSet() {
    }


    //Getter
    public String getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public String getTotalExciseAmount() {
        return totalExciseAmount;
    }

    public String getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getTotalNdsAmount() {
        return totalNdsAmount;
    }

    public Products getProducts() {
        return products;
    }

    public String getTotalTurnoverSize() {
        return totalTurnoverSize;
    }


    //Setter
    public void setTotalPriceWithoutTax(String totalPriceWithoutTax) {
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }

    public void setTotalExciseAmount(String totalExciseAmount) {
        this.totalExciseAmount = totalExciseAmount;
    }

    public void setTotalPriceWithTax(String totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setTotalNdsAmount(String totalNdsAmount) {
        this.totalNdsAmount = totalNdsAmount;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setTotalTurnoverSize(String totalTurnoverSize) {
        this.totalTurnoverSize = totalTurnoverSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSet that = (ProductSet) o;
        return totalPriceWithoutTax.equals(that.totalPriceWithoutTax) && totalExciseAmount.equals(that.totalExciseAmount) && totalPriceWithTax.equals(that.totalPriceWithTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPriceWithoutTax, totalExciseAmount, totalPriceWithTax);
    }
}
