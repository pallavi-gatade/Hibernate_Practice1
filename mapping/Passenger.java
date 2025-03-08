package one.to.one.mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "passenger_id" ,length = 200)
	private int id;
	
	@Column(name = "passenger_name" ,length = 200)
	private String name;
	
	@Column(name = "mobile_number" ,length = 200)
	private String mobile;
	
	@Column(length = 200)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "travels_id")
	private VishwaWorldTravels vishwaWorldTravels;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int id, String name, String mobile, String email, VishwaWorldTravels vishwaWorldTravels) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.vishwaWorldTravels = vishwaWorldTravels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public VishwaWorldTravels getVishwaWorldTravels() {
		return vishwaWorldTravels;
	}

	public void setVishwaWorldTravels(VishwaWorldTravels vishwaWorldTravels) {
		this.vishwaWorldTravels = vishwaWorldTravels;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", vishwaWorldTravels=" + vishwaWorldTravels + "]";
	}
	
}
