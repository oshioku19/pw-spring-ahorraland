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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "Consumer",
	indexes= {@Index(columnList="NName", name="Consumer_index_NName"),
			 @Index(columnList="NLastname", name="Consumer_index_NLastname")})
@SequenceGenerator(name = "Consumer_consumer_id_seq", initialValue = 1, allocationSize = 1)
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Consumer_consumer_id_seq")
    @Column(name = "CConsumer",columnDefinition = "NUMERIC(6)")
    private Integer id;

    @Column(name = "NName",length = 50)
    private String name; //Lower camel case

    @Column(name = "NLastname",length = 25)
    private String lastName;

    @Pattern(regexp = "[0-9]{8}", message = "Escriba un Dni valido")
    @Column(name = "dni",nullable = false, length = 15 )
    private String dni;

    @Email
    @Column(name = "TEmail",length = 50,nullable = false)
    private String email;

    @Column(name = "NumTelephone",length = 20,nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY)
	private List<Sale> sales;
    
	@OneToOne(cascade = CascadeType.ALL)
	private Users users;

	// -- Constructor, Getter y Setter
    public Consumer() {
    	sales= new ArrayList<Sale>();
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



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	
    
}

