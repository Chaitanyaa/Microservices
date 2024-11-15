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
   
API Gateway
1. It is used to route any calls to any of the microservice
2. Used to implement common functionalities such as logging security

Steps to use API Gateway
1. Create a new spring boot project
2. Add discovery client dependency and gateway dependency
3. Change this port to 80(Not mandate but recommended port)
4. Add appropriate properties in application properties

Circuit breaker
1. As it is very common, microservices communicate by making a rest calls.
2. if any of the microservices having issue, that can lead to cascading failures
because of service unavailability, timeout, network issue.
3. We must make sure that our system is resilient to all such failures
4. To exactly do this, there is a pattern know as circuit breaker
5. Spring cloud offers solution to this pattern using a library known as resilience4j.

A circuit can be in following states.
1. Closed - this is a default state and desirable state during this state rest calls are allowed
2. Open - this is not desirable state, circuit moves to this state because of some issue.
rest calls are not allowed during this state
3. Half open state - During this state less no. of rest calls are allowed.

Steps to use resilience4j as circuit breaker
1. Add dependency
2. Write appropriate porps in application.properties
3. Annotate method making a rest call with @CircuitBreaker
4. Define fallback method
   a. Make sure signature of fallback method must match with the method
   annotated with circuit breaker
   b. Make sure fallback method accepts one additional argument of type throwable
   
Note:
1. In older versions of spring cloud hystrix was used as circuit breaker.
2. In older versions of spring cloud zuul was used API Gateway.
3. In older versions of spring cloud ribbon was used for load balancing.
4. These are now known as legacy libraries and no more supported.

Each microservice has lot of configuration information which can be repeated in other microservice
We need different configuration infor for diff env - prod,dev,qa
Writing these information repe

Steps to use Config Server:
.
.

Note: We must specify central location for configuration information
you can either store in git repo or local file system.
4.Enable config server
5.By default config assumes git as central location for configuration information 

While configuration server is running, it reads configuration information from central location
and expose that information to all the microservices via rest endpoints.

In order for a microservice to be able to fetch configuration information from config server 
that microservice must act as client to config server 
Steps for config client 
1. Add config client dependency.

Want microservices to read config changes dynamically
1. Add springboot actuator dependency in each of the microservices
2. Expose refresh endpoint
3. A class where we are injecting the property must be annotated with RefreshScope
4. If after the properties changed,hit following endpoint using POST method
	- http://localhost/microservicename/actuator/refresh

There are multiple microservices possible and each microservice has multiple configuration information
if we want to update configuration information for all the microservices,we have to hit multiple refresh endpoints to all the microservices
it is impractical to hit multiple endpoints, 
we need one single endpoints which updates all the microservices at once
to exactly do this, spring cloud offers spring cloud bus
Spring cloud bus links multiple microservices with light weight message broker
it is used to broadcast configuration changes
it uses AMQP protocol (Advanced messaging queuing protocol)
Steps:
1. Add cloud bus starter AMQP and actuator dependency in config server and in each of the microservice
2. Expose busrefresh endpoint

Note: In old versions the endpoint was bus-refresh, it is now busrefresh
3. Install rabbitMQ
4. Add properties for rabbitMQ credentials
5. Hit post request to following endpoint http://localhost/config-server/actuator/busrefresh





