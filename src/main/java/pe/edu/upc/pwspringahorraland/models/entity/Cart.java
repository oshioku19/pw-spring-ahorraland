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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cart",
indexes= {@Index(columnList="CSale", name="Cart_index_CSale"),
		  @Index(columnList="CProduct", name="Cart_index_CProduct"),
		})
@IdClass(value = CartId.class)
public class Cart {
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CSale",nullable =true)
	private Sale sale;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CProduct",columnDefinition="NUMERIC(4)",nullable =true)
	private Product product;
	
	
	@NotNull
	@Column(name="QProduct")
	private int quantity;
	
	
	@Column(name="MPartialPrice")
	private int partialPrice;

	
	
	public Cart() {
		super();
	}


	public Sale getSale() {
		return sale;
	}


	public void setSale(Sale sale) {
		this.sale = sale;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPartialPrice() {
		return partialPrice;
	}


	public void setPartialPrice(int partialPrice) {
		this.partialPrice = partialPrice;
	}
	
	
	
}

