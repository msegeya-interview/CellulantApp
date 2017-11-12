/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  icode
 * Created: Nov 12, 2017
 */

mysql -uroot -pr00t00

CREATE DATABASE cellurantapp ;

CREATE TABLE mileage ( 
                     length_id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                     miles VARCHAR(30) NOT NULL, 
                     kilometers VARCHAR(50) , 
                     date_modified TIMESTAMP
 )


