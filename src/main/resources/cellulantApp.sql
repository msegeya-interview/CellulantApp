
CREATE TABLE mileage ( 
                     length_id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                     miles VARCHAR(30) NOT NULL, 
                     kilometers VARCHAR(50) , 
                     date_modified TIMESTAMP
 )


CREATE TABLE mileage ( 
   id INT NOT NULL, 
   miles VARCHAR(50) NOT NULL, 
   kilometers VARCHAR(20) NOT NULL, 
   date_modified TIMESTAMP, 
);