package pe.edu.upc.pwspringahorraland.models.entity;

import java.io.Serializable;
import java.util.Objects;


public class CartId implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer sale;


    private Integer product;

    public CartId() {
        super();
    }
    public CartId(Integer sale, Integer product) {
        super();
        this.sale = sale;
        this.product = product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sale,product);
    }
    @Override
    public boolean equals (Object obj) {
        if(this==obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        CartId cartId =(CartId)obj;

        if (this.sale !=cartId.sale)
            return false;
        if(this.product!=cartId.product)
            return false;
        return true;
    }

    public Integer getSale() {
        return sale;
    }
    public void setSale(Integer sale) {
        this.sale = sale;
    }
    public Integer getProduct() {
        return product;
    }
    public void setProduct(Integer product) {
        this.product = product;
    }


}
