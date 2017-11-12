  //====================================================
//    THIS CLASS IS FOR CALCULATING KILOMETER VALUES FROM  MILES
//===================================================
package com.cellulant.services;

import com.cellulant.domain.Mileage;
import com.cellulant.soapclient.Lengths;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul Msegeya
 */
@Component
@Service
public class CellulantMileageMockedService {

    //====================================================
    //     DEPENDENCY INJECTION POINT
    //===================================================
    @Autowired
    private CellulantConversionService cellulantConversionService;
    
    
    @Autowired
    private DateAndTimeConversionService dateAndTimeConversionService;

    @Autowired
    private MileageService mileageService;

    //====================================================
    //     CLASS COMPONENT VARIABLES
    //===================================================
    private ArrayList mileages;
    private Mileage mileage;
    private Long initializedLong;
    private Date inputDate;

    public List<Mileage> retrieveMockMileageData() {
        mileages = new ArrayList();

        System.out.println("================================================================");
        System.out.println("    BEGIN  CONVERTING MILES TO KILOMETERS FROM WEBSERVICE       ");
        System.out.println("================================================================");
        for (Long i = 0L; i < 10L; initializedLong = i = i + 1L) {
            mileage = new Mileage();
            mileage.setLength_id(i);
            mileage.setMiles(cellulantConversionService.calculateMiles(i));
            mileage.setKilometers(new CellulantSoapClientService().retriveKilometers(cellulantConversionService.doubleConversion(cellulantConversionService.calculateMiles(i)).doubleValue(), Lengths.MILES, Lengths.KILOMETERS));
            //mileage.setDate_modified(dateAndTimeConversionService.getTimestampInMilliseconds(inputDate));
     
            mileages.add(mileage);
            //initializedLong = i;
        }

        System.out.println("================================================================");
        System.out.println("    END  CONVERTING MILES TO KILOMETERS FROM WEBSERVICE         ");
        System.out.println("================================================================");

        return mileages;
    }

}
