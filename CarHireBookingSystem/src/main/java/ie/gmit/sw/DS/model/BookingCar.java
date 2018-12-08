package ie.gmit.sw.DS.model;

import java.util.Date;

public class BookingCar {

	private long orderId;
	private String userName;
	private String carName;
	private double carCost;
	private Date date;

	public BookingCar() {
		super();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
