package com.cellulant.services;

import com.cellulant.domain.Mileage;
import com.cellulant.soapclient.LengthUnit;
import com.cellulant.soapclient.LengthUnitSoap;
import com.cellulant.soapclient.Lengths;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Paul Msegeya
 */
//================================================================
//     SOAP CLIENT COMPONENT FOR CONVERTING MILES TO KILOMETERS
//================================================================
@Service
@Component
public class CellulantSoapClientService {

    private static final Logger LOG = Logger.getLogger(CellulantSoapClientService.class.getName());

    private double result;
    private List<Mileage> mileages;
    private static final String KILOMETER_UNIT = "Kilometers";
    private static final String MILES_UNIT = "Miles";

    public CellulantSoapClientService() {
    }

    public String retriveKilometers(double lengthValue, Lengths fromLengthUnit, Lengths toLengthUnit) {
        try {
            LengthUnit service = new LengthUnit();
            LengthUnitSoap port = service.getLengthUnitSoap12();
            result = port.changeLengthUnit(lengthValue, fromLengthUnit, toLengthUnit);
//            System.out.println("================================================================");
//            System.out.println("    BEGIN  CONVERTING MILES TO KILOMETERS FROM WEBSERVICE            ");
//            System.out.println("================================================================");

            if (lengthValue == 0.0) {
                System.out.println(lengthValue + "0" + "  " + MILES_UNIT + "  it\'s Equivalent   " + KILOMETER_UNIT + "=" + result + "00000" + " ");
            } else if (String.valueOf(result).length() > "0.000000".length()) {

                System.out.println(lengthValue + "  " + MILES_UNIT + "  it\'s Equivalent   " + KILOMETER_UNIT + "=" + String.valueOf(result).substring(0, 8) + " ");

            } else {
                System.out.println(lengthValue + "  " + MILES_UNIT + "  it\'s Equivalent   " + KILOMETER_UNIT + "=" + result + " ");

            }

//            System.out.println("================================================================");
//            System.out.println("      CONVERTING MILES TO KILOMETERS FROM WEBSERVICE            ");
//            System.out.println("================================================================");
        } catch (Exception localException) {
        }

        return String.valueOf(result);
    }

}
