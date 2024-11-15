NoSuchBeanDefinitionException: No qualifying bean - this is the exception we are getting.

Monolithic Application
It is the traditional way of building the application
All the functionalities of the project if exists in a single code base it is known as monolithic application
It is deployed as one single unit

Drawbacks of monolithic application
- It becomes too large in size with time
- Even for a small change we need to redeploy whole application
- Even if a portion of the app is not working, whole application create issue.
- Scaling up/down is difficult and costly
- Difficult to adopt new technologies well suited for a particular functionality

In order to overcome these problems, we can divide our application into multiple small services based on the business
Such style of application development is know as microservice applications
Each microservice must perform one single focused job
Each microservice is developed and deployed independently on seperate hardware
Scaling up/down a specific microservice is possible
Change is one microservice need redeployment of only that microservice, Other microservices are unaffected
We are free to choose appropriate technology for each microservice
