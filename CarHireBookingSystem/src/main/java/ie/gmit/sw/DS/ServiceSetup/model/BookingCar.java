package ie.gmit.sw.DS.ServiceSetup.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingCar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402101439161282599L;
	private String userName;
	private String carName;
	private double carCost;
	private String date;

	public BookingCar() {
		super();
	}

	public BookingCar(String userName, String carName, double carCost, String date) {
		this.userName = userName;
		this.carName = carName;
		this.carCost = carCost;
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getCarCost() {
		return carCost;
	}

	public void setCarCost(double carCost) {
		this.carCost = carCost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
