/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.daos;

import com.cellulant.domain.Mileage;
import com.cellulant.repository.MileageRepository;
import com.cellulant.services.CellulantMileageMockedService;
import com.cellulant.services.DateAndTimeConversionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Paul Msegeya
 */
@Component
public class MileageDao extends MileageRepository {

    private List<Mileage> mileages;

    private Boolean flag;

    //====================================================
    //     DEPENDENCY INJECTION POINT
    //===================================================
    @Autowired
    private CellulantMileageMockedService cellulantMileageMockedService;
    
        
   
    //====================================================
    //     CLASS COMPONENT VARIABLES DECLARATION
    //===================================================
    /**
     * Retrieves All Data from Mileage for Inserting them to Database This is
     * after Kilometers field been filed with data from the SoapClientService
     *
     * @return List<Mileage>
     */
    public List<Mileage> retrieveMockMileageData() {
        return cellulantMileageMockedService.retrieveMockMileageData();
    }

    /**
     * *
     *
     * This method Saves the Retrieved Data into Database
     *
     * @param mileage
     * @return
     */
    public Boolean save(Mileage mileage) {
        //Initialize Flag to False
        flag = Boolean.FALSE;

        // drop if table exists
        //dropTable();

        // create if table doesn't exist
        //createTable();

        //insert data into table created
        insert(mileage);

        //Set Flag to True when done inserting
        flag = Boolean.TRUE;

        return flag;
    }

    public Boolean populateTable() {
        mileages = retrieveMockMileageData();
        for (Mileage mileageData : mileages) {
            if (mileageData != null) {
                try {
                    // drop if table exists
                    dropTable();

                    // create if table doesn't exist
                    createTable();

                    //insert data into table created
                    insert(mileageData);

                    //Set Flag to True when done inserting
                    flag = Boolean.TRUE;
                } catch (Exception e) {
                    throw new NullPointerException(" Mileage Can not be Null ");
                }
            }

        }

        return flag;
    }

}
