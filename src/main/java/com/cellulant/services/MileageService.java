package com.cellulant.services;

import com.cellulant.daos.MileageDao;
import com.cellulant.domain.Mileage;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul Msegeya
 */
//====================================================
//     CLASS SERVICE FOR ABSTRACTING
//===================================================
@Service
@Component
public class MileageService {

    private static final Logger LOG = Logger.getLogger(MileageService.class.getName());

//====================================================
//     DEPENDENCY INJECTION POINT
//===================================================
    @Autowired
    @Lazy
    private MileageDao mileageDao;

    @Autowired
    private DateAndTimeConversionService dateAndTimeConversionService;

    public MileageService() {
    }

    public List<Mileage> retrieveMockMileageData() {
        return mileageDao.retrieveMockMileageData();
    }

    public Boolean save(Mileage mileage) {
        return mileageDao.save(mileage);
    }

    public List<Mileage> findAll() {
        return mileageDao.findAll();
    }

    public Boolean populateTable() {

        return mileageDao.populateTable();
    }

    public void updateTimeStamp(Timestamp timestamp) {
        Date input = new Date();
        timestamp = dateAndTimeConversionService.getTimestamp(input);
        mileageDao.updateTimeStamp(timestamp);
    }

    @CacheEvict(
            value = "mileages",
            allEntries = true)
    public void evictCache() {
        LOG.info("> evictCache");
        LOG.info("< evictCache");
    }

}
