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


