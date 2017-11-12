/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Paul Msegeya
 * Created: Nov 12, 2017
 */

CREATE USER 'cellurantappuser'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'cellurantappuser'@'localhost';
FLUSH PRIVILEGES;