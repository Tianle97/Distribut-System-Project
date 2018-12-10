package ie.gmit.sw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import ie.gmit.sw.Model.BookingCar;


public class BookingCarServiceImp extends UnicastRemoteObject implements BookingCarService {

	private static final long serialVersionUID = 1L;
	List<BookingCar> lbd = new ArrayList<BookingCar>();
	
	
	public BookingCarServiceImp() throws RemoteException {
	}
	// initial booking data
	public void initialBookingData() throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.model");
		Marshaller m = jc.createMarshaller();
		//String date = DateTime.CURRENT_DATE;
		lbd.add(new BookingCar("Martin", "Mercedes-Benz","Galway","2013", "2015",new BigDecimal(90000)));
		lbd.add(new BookingCar("Mark", "Bavarian Motor Work","Galway","2013", "2019",new BigDecimal(100000)));
		lbd.add(new BookingCar("John", "SKODA","Athlone","2014", "2018",new BigDecimal(400000)));
		lbd.add(new BookingCar("Joe", "SKODA","Dublin","2010", "2015",new BigDecimal(10000)));
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(lbd, new FileWriter("order.xml"));
		
		File file = new File("order.xml");
		Unmarshaller um = jc.createUnmarshaller();
		StreamSource source1 = new StreamSource(file);
		JAXBElement<BookingCar> poElement1 = um.unmarshal(source1, BookingCar.class);
		BookingCar poFromXml = (BookingCar) poElement1.getValue();
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
		public void deleteInfo(String userName, String carName) throws RemoteException {
			for (BookingCar bc : lbd) {
				if (bc.getUserName().equals(userName) && bc.getCarName().equals(carName)) {
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
