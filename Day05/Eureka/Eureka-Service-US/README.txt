Eureka is an important and essential part of architecture
Hence we must take care of following 2 things
	i. Securing Eureka - The idea is eah microservice trying to register itself
	with eureka must first authenticatr itself. If authentication is successfull, thn
	only eureka allows microservice to register
	Steps:
	1. Add spring security dependency
	2. Write username and pass
	3. Should make the authentication basic from form based
	4. Each microservices must be passing credentials while trying to connect with eureka
	
form based used for web apps [user to app]
http basic used for webservices [app to app]