package ie.gmit.sw.RMIClient;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import ie.gmit.sw.Model.BookingCar;


public class BookingCarServiceImp extends UnicastRemoteObject implements BookingCarService {

	private static final long serialVersionUID = 1L;
	List<BookingCar> lbd = new ArrayList<BookingCar>();
	
	
	public BookingCarServiceImp() throws RemoteException {
	}
	// initial booking data
	public void initialBookingData() {
		
		//String date = DateTime.CURRENT_DATE;
		lbd.add(new BookingCar("Martin", "Mercedes-Benz","Galway","2013", "2015",new BigDecimal(90000)));
		lbd.add(new BookingCar("Mark", "Bavarian Motor Work","Galway","2013", "2019",new BigDecimal(100000)));
		lbd.add(new BookingCar("John", "SKODA","Athlone","2014", "2018",new BigDecimal(400000)));
		lbd.add(new BookingCar("Joe", "SKODA","Dublin","2010", "2015",new BigDecimal(10000)));
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
		public void deleteInfo(String userName) throws RemoteException {
			for (BookingCar bc : lbd) {
				if (bc.getUserName().equals(userName)) {
					lbd.remove(bc);
					System.out.println("delete seccessful!");
				}
			}
		}

		//create new order
		public String createInfo(String userName, String carName, String address, String startDate, String endDate,
				BigDecimal cost) throws RemoteException {
			lbd.add(new BookingCar(userName,carName,address,startDate,endDate,cost));
			return "add order Seccessful!";
		}
		
		//update order
		@Override
		public String updateInfo(String userName, String carName, String address, String startDate, String endDate,
				BigDecimal cost) throws RemoteException {
			return null;
		}
}
