package com.cellulant;

import com.cellulant.domain.Mileage;
import com.cellulant.repository.MileageRepository;
import com.cellulant.services.CellulantMileageMockedService;
import com.cellulant.services.DateAndTimeConversionService;
import com.cellulant.services.MileageService;
import com.cellulant.services.PdfReportGenerationService;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    @Autowired
    private DateAndTimeConversionService dateAndTimeConversionService;

    @Autowired
    private CellulantMileageMockedService cellulantMileageMockedService;

    @Autowired
    private MileageRepository mileageRepository;

    @Autowired
    private ApplicationBootrapComponet applicationBootrapComponet;

    @Autowired
    private MileageService mileageService;

    @Autowired
    private PdfReportGenerationService pdfReportGenerationService;

    private List<Mileage> mileages;

    public Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings)
            throws Exception {
        cellulantAppMultiRecordsDatabaseOperations();
        generateCellulantPdfReport();

    }

    /**
     * This methods creates H2 Database table , prepares data , fetches
     * kilometer data from webservice and then inserts them to the database
     * table called mileage The script is found in
     * src/main/resources/sql-scripts folder
     */
    private void cellulantAppMultiRecordsDatabaseOperations() {
        mileageRepository.createTable();

        LOG.info("=========  BEFORE INSERTING MILEAGE DATA  ============");
        LOG.log(Level.INFO, " FOUND {0} RECORDS", mileageService.findAll().size());

        mileages = mileageService.retrieveMockMileageData();
        mileages.stream().map((mileageRealData) -> {

            LOG.log(Level.INFO, "mileage  object \n  lengthid={0}miles ={1} kilometers ={2}date_modified={3}", new Object[]{mileageRealData.getLength_id(), mileageRealData.getMiles(), mileageRealData.getKilometers(), mileageRealData.getDate_modified()});
            return mileageRealData;
        }).forEach((mileageRealData) -> {

            mileageService.save(mileageRealData);
        });
        LOG.info("=========  AFTER INSERTING MILEAGE DATA  ============");
        LOG.log(Level.INFO, " FOUND {0} RECORDS", mileageService.findAll().size());
        Date input=new Date();
        Timestamp timestamp=dateAndTimeConversionService.getTimestamp(input);
        mileageService.updateTimeStamp(timestamp);
        mileageService.findAll();
    }

    private void cellulantAppSingleRecordsDatabaseOperations() {
        Mileage mileage = new Mileage();
        mileage.setKilometers("9");
        mileage.setLength_id(100L);
        mileage.setMiles("89");
        //mileage.setDate_modified(Timestamp.from(Instant.now()));
        mileageRepository.createTable();
        LOG.info("saving data to database");
        mileageService.save(mileage);
    }

    /**
     * This method will retrieves saved data from database an write them in Pdf
     * file using Pdf service component autowired above Everythinhg is Abstra
     * ted in the pdfReportGenerationService component
     */
    private void generateCellulantPdfReport() throws FileNotFoundException {
        LOG.info("=========  GENERATING CELLULANT PDF REPORT   ============");
        String dest = "src/main/resources/CellurantPdfReport.pdf";
        pdfReportGenerationService.generatePdfFile(dest);

    }
}
