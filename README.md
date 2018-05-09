# MongoDB Reactive Stock Quote Service

  A service which consumes reactive service - [SpringWebfluxReactiveStockQuoteServiceApplication](https://github.com/mgorav/spring-webflux-reactive-service/blob/master/README.md) and
  store the data in MongoDB

#### Pre-requisite
1. Run reactive service - [SpringWebfluxReactiveStockQuoteServiceApplication](https://github.com/mgorav/spring-webflux-reactive-service/blob/master/README.md) 
2. Run MongoDB. I used MongoDB docker image as shown below:
   ```
        docker run -p 27017:27017 -d mongo
   ```
    
   

####Tech Stack
1. Jdk 1.8+ (NOT JDK 1.9 Flux & Mono are not used)
2. Spring BOOT 2.0.0.RELEASE (Spring 5.0.4 Webflux)
3. Lombok 1.16.20
4. MongoDB Latest Version using above mentioned docker command
5. Robo 3T (mongoDB client for testing)

