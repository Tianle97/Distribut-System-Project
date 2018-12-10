package ie.gmit.sw.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.Model.BookingCar;

public interface RMIServer extends Remote {
	public List<BookingCar> getAll() throws RemoteException;

	public String getInfo(String userName, String carName) throws RemoteException;

	public String deleteInfo(String userName, String carName) throws RemoteException;

	public String createInfo(String userName, String carName, double carCost, String date) throws RemoteException;

	public String updateInfo(String userName, String carName, double carCost, String date) throws RemoteException;

}
