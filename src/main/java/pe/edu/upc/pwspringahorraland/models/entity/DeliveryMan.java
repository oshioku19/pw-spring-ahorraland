package pe.edu.upc.pwspringahorraland.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name="DeliveryMan",
indexes= {@Index(columnList="NDeliveryMan", name="DeliveryMan_index_NDeliveryMan")})
@SequenceGenerator(name = "DeliveryMan_deliveryMan_id_seq", initialValue = 1, allocationSize = 1)
public class DeliveryMan{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DeliveryMan_deliveryMan_id_seq")
	@Column(name = "CDeliveryMan", columnDefinition = "NUMERIC(5)")
	private Integer id;
	
	@Column(name = "NDeliveryMan", length = 50, nullable = false)
	private String name;
	
	@Column(name = "TBio", nullable = false)
	private String bio;
	
	@Column(name = "TAddress", length = 50, nullable = false)
	private String address;
	
	@Positive
    @Column(name = "NumRating", length = 3, nullable = false)
    private String rating;
	
	@Positive
    @Column(name = "NumSales", nullable = false)
    private String sales;
	//--@OneToMany(mappedBy = "deliveryman", fetch = FetchType.LAZY)
	//--private List<Shipping> shipping;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}
	
	
	
}

