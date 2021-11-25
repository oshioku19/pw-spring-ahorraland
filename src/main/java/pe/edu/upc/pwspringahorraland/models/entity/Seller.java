package pe.edu.upc.pwspringahorraland.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Sellers", indexes = { @Index(columnList = "NSeller", name = "Seller_index_NSeller"),
		@Index(columnList = "NLastname", name = "Seller_index_NLastname") })
@SequenceGenerator(name = "Seller_seller_id_seq", initialValue = 1, allocationSize = 1)
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seller_seller_id_seq")
	@Column(name = "CSeller", columnDefinition = "NUMERIC(5)")
	private Integer id;

	@Column(name = "NSeller", length = 50, nullable = false)
	private String name;

	@Column(name = "NLastname", length = 50, nullable = false)
	private String lastName;

	@Pattern(regexp = "[0-9]{8}", message = "Escriba un Dni valido")
	@Column(name = "Dni", nullable = false, length = 15)
	private String dni;

	// --RELACION CON CODIGO DE IdentificationType--

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
	private List<Product> product;

	@OneToOne(cascade = CascadeType.ALL)
	private Users users;

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
