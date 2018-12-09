package ie.gmit.sw.DS.ServiceSetup;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.DS.ServiceSetup.service.BookingCarService;
import ie.gmit.sw.DS.ServiceSetup.servicesImp.BookingCarServiceImp;

public class ServiceSetup {

	public static void main(String[] args) throws Exception {
		//Create an instance of a BookingCarServiceImp. As BookingCarServiceImp implements the BookingCarService
        //interface, it can be referred to as a BookingCarService type.
        BookingCarService bcs = new BookingCarServiceImp();
        
        //start the RMI registry on port 1099
        LocateRegistry.createRegistry(1099);
        
        //Binding our remote object to the registry with the human-readable name "BookingCarService"
        Naming.rebind("bookingCarService", bcs);
        
        //Print a message to standard output
        System.out.println("Server is already!");
	}

}
