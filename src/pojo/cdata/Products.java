package pojo.cdata;

import java.util.List;

public class Products {
    private List<Product> product;

    public Products() {
    }

    //Getter
    public List<Product> getProduct() {
        return product;
    }

    //Setter
    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
