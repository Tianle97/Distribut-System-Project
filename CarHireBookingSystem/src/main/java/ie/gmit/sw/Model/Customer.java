package ie.gmit.sw.Model;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
	    "name",
	    "gender",
	    "county",
	    "address"
	})
public class Customer {
	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String gender;
	@XmlElement(required = true)
	protected String county;
	@XmlElement(required = true)
	protected String address;
}
