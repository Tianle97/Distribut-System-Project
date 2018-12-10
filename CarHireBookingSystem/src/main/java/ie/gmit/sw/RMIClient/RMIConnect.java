package ie.gmit.sw.RMIClient;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.BookingCar;

public class RMIConnect  {
	BookingCarService bcs;

	public RMIConnect() throws Exception{
		this.bcs = (BookingCarService) Naming.lookup("rmi://127.0.0.1:1099/bookingCarService");
	}
	
	public List<BookingCar> getAll() throws Exception {
		return bcs.getAll();
	}
}
