package ie.gmit.sw.Model;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class JAXBPO {
	public JAXBPO(){
	}
	
	public String marshalBooking(BookingCar booking) throws JAXBException
	{
		StringWriter stringWriter = new StringWriter();
		Marshaller xmlMarshaller;
		
		
			JAXBContext jaxb = JAXBContext.newInstance("ie.gmit.sw.Model");
			
			// Create the unmarshaller
			xmlMarshaller = jaxb.createMarshaller();
			
			// Marshall the booking object as XML
			xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			xmlMarshaller.marshal(booking, stringWriter);
		// Return the XML generated from the object as a string using our stringWriter
		return stringWriter.toString();
	}
	
	// Function to unmarshal the XML to a Java object(Booking)
		public BookingCar unmarshalBooking(String xml) throws JAXBException
		{
			System.out.println("XML RECEIVED BY POST MeTHOD: " +xml);
			StringReader stringReader = new StringReader(xml);
			Unmarshaller xmlUnmarshaller;
			
			BookingCar bookingToUnmarshal = null;
		
				JAXBContext jaxb = JAXBContext.newInstance("ie.gmit.sw.Model");
				
				// Create the unmarshaller
				xmlUnmarshaller = jaxb.createUnmarshaller();
				
				// Create a source to read in our XML to
				StreamSource src = new StreamSource(stringReader);
				
				// Using this source of XML, unmarshal the xml to a Booking object
				JAXBElement<BookingCar> bookingXMLElement = xmlUnmarshaller.unmarshal(src, BookingCar.class);
				bookingToUnmarshal = (BookingCar) bookingXMLElement.getValue();
				
					
			// Return the booking object we just unmarshalled
			return bookingToUnmarshal;
		}
}