package ie.gmit.sw.DS.ServiceSetup.servicesImp;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.DS.ServiceSetup.model.BookingCar;
import ie.gmit.sw.DS.ServiceSetup.service.BookingCarService;

public class BookingCarServiceImp extends UnicastRemoteObject implements BookingCarService {

	public BookingCarServiceImp() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;
	ArrayList<BookingCar> lbd;

	// load booking data
	public void loadBookingData() {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		lbd = new ArrayList<BookingCar>();
		lbd.add(new BookingCar("Martin", "Mercedes-Benz", 9000000, df.format(date)));
		lbd.add(new BookingCar("John", "Bavarian Motor Work", 900000, df.format(date)));
		lbd.add(new BookingCar("Mark", "SKODA", 8000000, df.format(date)));
		lbd.add(new BookingCar("Jim", "Mercedes-Benz", 2000000, df.format(date)));
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
