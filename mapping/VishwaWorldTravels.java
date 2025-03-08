package one.to.one.mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vishwa_world_travels")
public class VishwaWorldTravels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "travels_id" ,length = 200)
	private int id;
	
	@Column(name = "seat_number" ,length = 200)
	private int seatNumber;
	
	@Column(name = "bus_number" ,length = 200)
	private String busNumber;
	
	@OneToOne(mappedBy = "vishwaWorldTravels",cascade = CascadeType.ALL)  //for Bi directional mapping
	private Passenger passenger;

	public VishwaWorldTravels() {
		super();
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public VishwaWorldTravels(int id, int seatNumber, String busNumber, Passenger passenger) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.busNumber = busNumber;
		this.passenger = passenger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "VishwaWorldTravels [id=" + id + ", seatNumber=" + seatNumber + ", busNumber=" + busNumber
				+ ", passenger=" + passenger + "]";
	}
	
}
