Each microservice has its own database. 
This pattern is known as database per service

Challenges in implementing microservice
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