package ie.gmit.sw.Model;
import java.io.*;
import java.util.*;
import java.math.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;

public class JAXBPOExample {
	public static void main(String[] args) throws Exception{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(System.nanoTime()));
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);


		JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.Model");
		ObjectFactory objFactory = new ObjectFactory();

		BookingCar bc = objFactory.createBookingCar();
		bc.setBid("55522-BABA");
		bc.setOrderDate(date);

		Customer cus = new Customer();
		cus.setName("John Doe");
		cus.setCounty("Galway");
		cus.setGender("Male");
		cus.setAddress("Renmore");
		bc.setCustomer(cus);

		Vehicle v = new Vehicle();
		v.setCarBrand("SKODA");
		v.setColor("red");
		v.setYear("2012");
		bc.setVehicle(v);


		// Marshal the PurchaseOrder into XML
		System.out.println("\n\n######### XML Format #########");
		Marshaller m1 = jc.createMarshaller();
		m1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m1.marshal(bc, new FileWriter("order.xml"));
		m1.marshal(bc, System.out);


		//Unmarshal the XML into a PurchaseOrder Object
		File file1 = new File("order.xml");
		Unmarshaller um1 = jc.createUnmarshaller();
		StreamSource source1 = new StreamSource(file1);
		JAXBElement<BookingCar> bcElement1 = um1.unmarshal(source1, BookingCar.class);
		BookingCar bcFromXml = (BookingCar) bcElement1.getValue();
		System.out.println("\n\n######### XML Unmarshalling #########\n" + bcFromXml.getBid());
	}
}