package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;


public class BookingCarServiceImp extends UnicastRemoteObject implements BookingCarService {

	private static final long serialVersionUID = 1L;
	List<BookingCar> lbd = new ArrayList<BookingCar>();

	public BookingCarServiceImp() throws RemoteException {
	}
	// initial booking data
	public void initialBookingData() {
		String date = DateTime.CURRENT_DATE;
		lbd.add(new BookingCar("Martin", "Mercedes-Benz", 9000000, date));
		lbd.add(new BookingCar("John", "Bavarian Motor Work", 900000, date));
		lbd.add(new BookingCar("Mark", "SKODA", 8000000, date));
		lbd.add(new BookingCar("Jim", "Mercedes-Benz", 2000000, date));
	}

	// getAll Information
	public List<BookingCar> getAll() throws RemoteException {
		for (BookingCar bc : lbd) {
			System.out.println(bc.toString());
		}
		return lbd;
	}

	//get the information
	public String getInfo(String userName, String carName) throws RemoteException {
		for (BookingCar bc : lbd) {
			if (bc.getUserName().equals(userName) && bc.getCarName().equals(carName)) {
				return lbd.toString();
			}
		}
		return "no info!";
	}

	//delete the information
	public String deleteInfo(String userName, String carName) throws RemoteException {
		for (BookingCar bc : lbd) {
			if (bc.getUserName().equals(userName) && bc.getCarName().equals(carName)) {
				lbd.remove(bc);
				return "delete seccessful!";
			}
		}
		return "failed~";
	}

	//create new order
	public String createInfo(String userName, String carName, double carCost, String date) throws RemoteException {
		lbd.add(new BookingCar(userName,carName,carCost,date));
		return "add order Seccessful!";
	}
	
	//update order
	public String updateInfo(String userName,String carName,double carCost,String date) throws RemoteException{
		
		return null;
		
	}

}
