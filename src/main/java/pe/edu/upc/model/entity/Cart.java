package pe.edu.upc.model.entity;

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
@Table(name = "Cart",
indexes= {@Index(columnList="CSale", name="Cart_index_CSale"),
		  @Index(columnList="CProduct", name="Cart_index_CProduct"),
		  @Index(columnList="CSeller", name="Cart_index_CSeller")})
@IdClass(value = CartId.class)
public class Cart {

	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CSale",nullable =false)
	private Sale sale;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CProduct",columnDefinition="NUMERIC(4)")
	private Product product;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CSeller",columnDefinition="NUMERIC(4)")
	private Seller seller;
	
	@Id
	@Column(name="QProduct")
	private int quantity;
	
	@Id
	@Column(name="MPartialPrice")
	private int partialPrice;
}

