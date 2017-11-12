/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul Msegeya
 * 
 * This class is for Date Conversion Operations
 */
@Service
@Component
public class DateAndTimeConversionService {

    private Timestamp result;

    /**
     * Methods uses java.date.util  to get java.sql.Timestamp 
     * 
     *
     * @return 
     */
    public Timestamp getTimestamp(Date input) {
        input = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(input);
        cal.set(Calendar.MILLISECOND, 0);
        result = new java.sql.Timestamp(input.getTime());
        System.out.println(  " Timestamp from java.util.Date   javaUtilDate="+input +" is  given as  javaTimestampDate ="+result);
        System.out.println(new java.sql.Timestamp(cal.getTimeInMillis()));

        return result;
    }
    
    public Timestamp getTimestampInMilliseconds(Date input) {
        input = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(input);
        cal.set(Calendar.MILLISECOND, 0);
        result = new java.sql.Timestamp(cal.getTimeInMillis());
        System.out.println(  " Timestamp from java.util.Date   javaUtilDate="+input +" is  given as  javaTimestampDate ="+result);
        System.out.println( "Timestamp in milliseconds  ="+result);

        return result;
    }
}
