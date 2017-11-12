

APPLICATION BASIC INFORMATION 


1. USES H2 IN MEMORY DATABASE

2. USES MAVEN FOR DEPENDENCY MANAGAMENT

3. USES SPRING FRAMEWORK / SPRING BOOT 

4. YOU MUST HAVE INTERNET TO RUN THE PROGRAM

5. APPLICATION LOG IS FOUND IN  src/main/resources/application.log





DO THE FOLLOWING TO RUN THE APPLICATION FROM SOURCE CODES PROVIDED


1. Extract thE Source coded in your prefered Directory , lets say your  Desktop if

 a. [i]  Linux 

          cd  /home/<username>/Desktop/cellulantApp
    
    [ii] Mac 
         
            cd  /Users/<username>/Desktop/cellulantApp

    [iii] Windows
   
             cd  C:\Users\<username>\Desktop/cellulantApp



 b. Running Application from Source Code using Maven

     mvn spring-boot:run



c. Building using maven use command


 [1]   mvn clean install 

  
    then find your build distribution package  here  in the target folder 


    [i]  Linux
    
    /home/<username>/Desktop/CellulantApp/target/CellulantApp.zip


    [ii] Mac

    /Users/usenamer/Desktop/CellulantApp/target/CellulantApp.zip


    [iii] Windows

    C:\Users\<username>/Desktop/CellulantApp/target/CellulantApp.zip




    [2]  Unzip the folder and Run the following command in from the unziped file location in lib folder


     [i] if mac or Linux

     java -jar CellulantApp/lib/cellulantApp-0.1.0.jar


     [ii] if windows

      java -jar CellulantApp\lib\cellulantApp-0.1.0.jar




NOTE :


   YOU CAN ALSO OPEN APPLICATION ON NETBEANS WITH SPRINGBOOT PLUGIN INSTALLED AND MAVEN THEN

   RUN as java application

   com.cellulant.Application.java



   


    
  


