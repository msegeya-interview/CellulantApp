package com.cellulant;

import com.cellulant.domain.Mileage;
import com.cellulant.services.MileageService;
import com.cellulant.services.PdfReportGenerationService;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBootrapComponet {

    private static final Logger LOG = Logger.getLogger(ApplicationBootrapComponet.class.getName());

    @Autowired
    private MileageService mileageService;

    @Autowired
    private PdfReportGenerationService pdfReportGenerationService;

    private List<Mileage> mileages;

    public ApplicationBootrapComponet() {
    }

    public void applicationEntryRunner() {
        String dest = "src/main/resources/FinalMileageReport.pdf";

        try {
            pdfReportGenerationService.generatePdfFile(dest);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApplicationBootrapComponet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //mileages = mileageService.retrieveMockMileageData();

//        for (Mileage mileage : mileages) {
//            LOG.info("  PERSISTING  DATA TO DATABASE");
//        }

        //mileageService.retrieveMileages();
    }
}
