Each microservice has its own database. 
This pattern is known as database per service

Challenges in implementing microservice
To address the challenges in implementing microservices there are design patterns
Spring offers Spring Cloud as a solution to these common patterns which help to build microservices quickly
Ex: Making REST Call - OpenFeign
1. As each microservice is deployed independently it is very common that they want to communicate with each other
2. The most common way is to make a rest call
3. Making REST call is not only time consuming but also error prone.
4. So to make REST calls declarative, we use a library known as "OpenFeign"
5. It is very common to scale up/down hence we expect load balancing to do that we must not hardcode ip and port in the url


Steps to use OpenFeign:
1. Add the dependency 
2. Create an interface
3. Annotate the interface with @FeignClient
4. Add appropriate attributes with the annotation
5. Declare a method in the interface
	a. make sure the method is annotated with the same annotation of the remote method we want to invoke.
	b. make sure method method signature matches to remote method we want to invoke
6. Enable feign client

Service Registry and Discovery
1.Hard coding of port is bad choice as it does not allow load balancing. So we use service registry.
2.Instead of ip and port one microservice should talk to other microservice using 
3.Unique logical name associated with each microservice
4.The idea is each microservice registers itself with the unique name with service registry
5.The other microservice would discover with that unique name
6.One of the most popular implementation of service registry and discovery is Eureka.

Steps for Eureka server:
1. Create a new spring boot project
2. Add appropriate dependency - eureka service
3. Change the server port to 8761 (Not Mandate but recommended)
4. Enable eureka server
5. Run the application and test it by typing url in the browser - http://localhost:8761

Steps for Eureka Client:
1. Add eureka client dependency in each microservice
2. Add following property to give unique name to microservice
   - spring.application.name