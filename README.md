# Distribut-System-Project
level 8 Distribute System Project

### *Student Name : Tianle Shu*
### *Student ID : G00341565*
### *Lecturer : Dr Patrick Mannion*

<b> A RESTful Car Hire Booking System use the JAX-RS/Jersey, Java RMI and JAXB frameworks.<b/>
  

## *Introduction*
 *Use the JAX-RS/Jersey, Java RMI and JAXB frameworks to develop a simple Car Hire
Booking System. A Web Client page should provide users with the ability to Create/Modify/Update/Delete
bookings for a specific vehicle for a given set of dates. The Web Client will interact with a RESTful JAX-RS
Web Service for bookings which is deployed on Apache Tomcat Server. The RESTful Web Service will act as
a RMI client to a RMI Database Server which will handle persistence.*

+  system architecture:

![Project](https://github.com/Tianle97/Distribut-System-Project/blob/master/Project.jpeg?raw=true)

### *What is RMI ?*
REST is an architectural style which is based on web-standards and the HTTP protocol. This style was initially described by Roy Fielding in 2000. In a REST based architecture everything is a resource. A resource is accessed via a common interface based on the HTTP standard methods. In a REST based architecture you have a REST server which provides access to the resources. A REST client can access and modify the REST resources. <br/>
<br/>
Every resource should support the HTTP common operations. Resources are identified by global IDs (which are typically URIs).
<br/>
REST allows that resources have different representations, e.g., text, XML, JSON etc. The REST client can ask for a specific representation via the HTTP protocol (content negotiation).

### HTTP methods
The PUT, GET, POST and DELETE methods are typical used in REST based architectures. The following table gives an explanation of these operations.

+ GET defines a reading access of the resource without side-effects. The resource is never changed via a GET request, e.g., the request has no side effects (idempotent).

+ PUT creates a new resource. It must also be idempotent.

+ DELETE removes the resources. The operations are idempotent. They can get repeated without leading to different results.

+ POST updates an existing resource or creates a new resource.

### RESTFul web services
A RESTFul web services are based on HTTP methods and the concept of REST. A RESTFul web service defines the base URI for the services, the supported MIME-types (XML, text, JSON, user-defined, …​). It also defines the set of operations (POST, GET, PUT, DELETE) which are supported.

#### In this project I create 2 project one java project for RMIServer one for Maven Project for RESTful.
* **RMI** project BookingCarRMIServer contains:
  * ServiceSetup.java, RMIServer, get server instances & open the rmi registry (binding to localhost:1099).
  * BookingCarService.java, RMI interface, defines abstract methods.
  * BookingCarServiceImpl.java, RMI remote objects, implements all basic methods in the BookingCarService.
    * lookup(String s), sued for searching work from rmi BookingCar server.
    * initialBookingData(), load BookingData, shuold call this method once the server start.
    * getAll/getInfo/deleteInfo/createInfo/updateInfo, some methods for updating the entries of bookingCar.
* **Servlet** Project -- CarHireBookingSystem contains:
  * web.xml, deployment descriptor elements
  * index.jsp, the main page.
  * BookingCarService.java & BookingCarServiceImpl.java, the same content as the file in RMI project
  * RMIConnect.java for connect RMIServer.
  * JAXBPO.java is marshallering the object value to xml and xml to object.
The point of this exercise is to give you some “hands-on” programming experience with the key technologies
which are covered in this module (e.g. RESTful web services, Inter-Process Communication, Data
Externalisation). It is expected that you will conduct a significant amount of independent study on the specified
technologies as part of this project
* database-service.jar --> a jar file packaged from the rmi project.
* job-server.war --> a war file packaged from servlet project, which can deployee into tomcat server directly.
#### Run
## How to run?

please make sure 
* the **Tomcat** server is setup correctly before run this repository
* **java** environment is needed too

clone or download this repository
 1.use Eclipse etcto run the two projects alternatively. (do not forget to add Tomcat server, and connect to the project -- servlet projevt.)
dictionary-service.jar --> a jar file packaged from the rmi project.

job-server.war --> a war file packaged from servlet project, which can deployee into tomcat server directly.

  
  2.open browser and type http://localhost:8080 to the address bar.
* 1.copy file (job-server.war) to the webapp folder of Tomcat server, and start local tomcat server
    * for Linux: go to the bin directory of the Tomcat server, and type
      ```bash
      $ ./startup.sh
      ```
      to start the server.
    * for Windows: go to the bin directory of the Tomcat server, and type
      ```bash
      $ ./startup.bat
      ```
      to start the server.
  
  2.go to the folder which have dictionary-service.jar, open the terminal, type the command:
  ```bash
  $ java -cp ./database-service.jar ie.gmit.sw.ServiceSetup
  ```
  3.open browser and type http://localhost:8080 to the address bar.
