package pe.edu.upc.pwspringahorraland.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Discountdetail",
indexes= {@Index(columnList="CDiscount", name="Discountdetail_index_CDiscount"),
	      @Index(columnList="CProduct", name="Discountdetail_index_CProduct"),
	      @Index(columnList="CSeller", name="Discountdetail_index_CSeller")})
@IdClass(value = DiscountdetailId.class)
public class Discountdetail {
    @Id
    @Column(name="PerDiscount" )
    private int perDiscount;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CDiscount",columnDefinition="NUMERIC(4)")
    private Discount discount;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CProduct")
    private Product product;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CSeller",columnDefinition="NUMERIC(4)")
    private Seller seller;

	public int getPerDiscount() {
		return perDiscount;
	}

	public void setPerDiscount(int perDiscount) {
		this.perDiscount = perDiscount;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

    
    
    
}

      
    


