package com.cellulant.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Paul Msegeya
 */
//====================================================
//     CLASS COMPONENT FOR CONVERING LENGTHID TO MILES
//===================================================
@Service
@Component
public class CellulantConversionService {

    private static final Logger LOG = Logger.getLogger(CellulantConversionService.class.getName());

    public String calculateMiles(Long i) {
        String result = "";
        if (i != null) {
            result = String.valueOf(i * 10L);
            LOG.log(Level.INFO, "CONVERTED RESULT ={0}", result);
        } else {
            throw new NullPointerException("Provided Null value for varible i =" + i);
        }

        return result;
    }

    public Double doubleConversion(String input) {
        LOG.log(Level.INFO, "CONVERTED INPUT ={0}", input);
        return Double.valueOf(input);
    }
}
