package ie.gmit.sw;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.Model.BookingCar;

public interface BookingCarService extends Remote   {
	
	public List<BookingCar> getAll() throws RemoteException;
	public String getInfo(String userName,String carName) throws RemoteException;
	public void deleteInfo(String userName) throws RemoteException;
	public String createInfo(String userName, String carName, String address, String startDate, String endDate,
			BigDecimal cost) throws RemoteException;
	public String updateInfo(String userName, String carName, String address, String startDate, String endDate,
			BigDecimal cost) throws RemoteException;
	
//	public List<BookingCar> getAll() {
//		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		BookingCar bc1 = new BookingCar(1, "Mratin", "Mercedes-Benz", 10000, df.format(date));
//		List<BookingCar> list = new ArrayList<BookingCar>();
//		list.add(bc1);
//		return list;
//	}

}
