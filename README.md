# Rest API for Reservation

## 1. Environment
* java 1.8
* Spring boot 
* maven

## 2. How to run.
* No external server required to deploy this application. this has come up embedded tomcat(Sprint Boot). just need to run java/jar file

### 2.1 From IDE
* import/checkout given zip/war file in to IDE(Intellij/eclipse)
* make sure all maven dependencies are download
* Right click and click "Run as java Application" the file locate at org.telepathy.reservation.ServicesStarter
 refer sample image at /images/Run_1.png
 
### 2.2 From commandpromt.
 * set JAVA_HOME & Path in system environment variables
 * fat jar is attached in the /src/test/resources/jarFile folder
 * download and keep it in folder wher you want to run
 * run command (reffer image at /images/cmdRun.png)
 
   ``` 
   java -jar reservation-master-0.0.1-SNAPSHOT.jar
   
   ```
 
## 3. How to check available REST APIs
* this project is embedded with ** swagger-ui(post man tool not required) **
* once Spring boot app is up and running, you can click ** [URL](http://localhost:8080/swagger-ui.html)  ** . * if you are not able open swagger-ui in your default browser. copy "http://localhost:8080/swagger-ui.html" hit this in google chrome browser. *
* you will all available APIs in swagger-ui
* refer sample image for all APIs at /images/API*.png

## 4. Exception handling
Exception is handled at global level using Spring feature ``` @ControllerAdvice ``` . any exceptions in application will be handled by AppExceptionHandler and return proper/valid response to user(response to REST api), hiding all internal server errors and sending meaningful message to user.
refer more at ``` org.telepathy.reservation.exception.AppExceptionHandler ```

## 5. Test
Integration test available at ```org.telepathy.reservation.controller.integrationtest.RoomServiceControllerIT```  . you can play around. it will internally start the server and assert required fields.
