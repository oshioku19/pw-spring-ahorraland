package pe.edu.upc.pwspringahorraland.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Username", length = 120)
	private String username;

	@Column(name = "Password", length = 120)
	private String password;
	
	private Boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<TypeUser> typeUsers;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(int id, String username, String password, Boolean enabled, List<TypeUser> typeUsers) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.typeUsers = typeUsers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<TypeUser> getTypeUsers() {
		return typeUsers;
	}

	public void setTypeUsers(List<TypeUser> typeUsers) {
		this.typeUsers = typeUsers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
