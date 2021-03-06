package ie.gmit.sw.REST;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import ie.gmit.sw.Model.BookingCar;
import ie.gmit.sw.Model.JAXBPO;
import ie.gmit.sw.RMIClient.BookingCarServiceImp;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookingSystem")
public class BookingResource extends JAXBPO {

	// BookingCarServiceImp bcsImp ;
	private BookingCarServiceImp bookingCarServiceImp;
	JAXBPO jaxb = new JAXBPO();

	// Constructor
	public BookingResource() throws RemoteException {
		bookingCarServiceImp = new BookingCarServiceImp();
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws RemoteException
	 */

	List<BookingCar> orders = new ArrayList<BookingCar>();

	@GET
	@Path("showAll")
	@Produces(MediaType.APPLICATION_XML)
	public List<BookingCar> getBookings() throws JAXBException, IOException {
		List<BookingCar> bookingCars = new ArrayList<BookingCar>();
		List<BookingCar> orders = new ArrayList<BookingCar>();

		bookingCars = bookingCarServiceImp.getAll();
		if (bookingCars.isEmpty()) {
			bookingCarServiceImp.initialBookingData();
		}
		bookingCars = bookingCarServiceImp.getAll();

		// Loop through all our bookCarOders and assign the variables from the
		for (BookingCar bc : bookingCars) {
			BookingCar booking = new BookingCar();

			booking.setUserName(bc.getUserName());
			booking.setCarName(bc.getCarName());
			booking.setAddress(bc.getAddress());
			booking.setStartDate(bc.getStartDate());
			booking.setEndDate(bc.getEndDate());

			orders.add(booking);

			
		}
		// Return the orders as XML
		return orders;
	}

	// Deletes orders through the user name
	@DELETE
	@Path("deleteBooking/{userName}")
	public void deleteOrders(@PathParam("userName") String userName) throws RemoteException {

		bookingCarServiceImp.deleteInfo(userName);
		System.out.println("Suceddful delete");
	}

	//Post Delete
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("deletePost")
	public String getBookingIDForDeletion(@FormParam("userName") String userName) throws RemoteException {
		String s = userName;

		deleteOrders(userName);

		return "Suceddful delete";
	}

	// Creates a bookingOrder
	@POST
	@Path("createOders")
	@Consumes(MediaType.APPLICATION_XML)
	public String createBooking(@FormParam("userName") String userName, @FormParam("carName") String carName,
			@FormParam("address") String address, @FormParam("startDate") String startDate,
			@FormParam("endDate") String endDate, @FormParam("cost") BigDecimal cost) throws RemoteException {

		BookingCar bookingCar = new BookingCar();

		bookingCar.setUserName(userName);
		bookingCar.setCarName(carName);
		bookingCar.setAddress(address);
		bookingCar.setStartDate(startDate);
		bookingCar.setEndDate(endDate);
		bookingCar.setCost(cost);

		bookingCarServiceImp.createInfo(userName, carName, address, startDate, endDate, cost);

		return "Successful to create!";
	}
}
