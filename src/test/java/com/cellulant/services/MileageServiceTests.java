/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.services;

import com.cellulant.AbstractTest;
import com.cellulant.domain.Mileage;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Paul Msegeya
 */
@Transactional
public class MileageServiceTests extends AbstractTest {

    @Autowired
    private MileageService mileageService;

    @Autowired
    private DateAndTimeConversionService dateAndTimeConversionService;

    @Before
    public void setUp() {
        mileageService.evictCache();
    }

    @After
    public void tearDown() {
        // cleanup after each test
    }

    
    
    public void retrieveMockMileageData() {
        //return mileageService.retrieveMockMileageData();
    }

    @Test
    public void save() {
        Mileage mileage = new Mileage();
        mileage.setLength_id(1L);
        mileage.setKilometers("10");
        mileage.setMiles("200");
        mileageService.save(mileage);

        Assert.assertEquals("failure - expected value for id", new Long(1), mileage.getLength_id());

    }

    @Test
    public void findAll() {
        //return mileageService.findAll();
    }

}
