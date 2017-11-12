package com.cellulant.services;

import com.cellulant.domain.Mileage;
import com.cellulant.utils.PdfUtil;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Paul Msegeya
 */

@Component
@Service
public class PdfReportGenerationService {
//====================================================
//     DEPENDENCY INJECTION POINT
//===================================================

    @Autowired
    private MileageService mileageService;
    @Autowired
    private PdfUtil pdfUtil;

//====================================================
//     CLASS SERVICE VARIABLES
//===================================================
    private final String lengthHeader = "LengthId";
    private final String milesHeader = "Miles";
    private final String kilometersHeader = "Kilometers";
    private final String dateModifiedHeader = "DateModified";

    private final int columnWidths = 4;
    private final Table table = new Table(4);
    private List<Mileage> mileages;

    public PdfReportGenerationService() {
    }

    /**
     * This method generated Pdf File with data found in the database
     * @param dest
     * @throws FileNotFoundException 
     */
    public void generatePdfFile(String dest) throws FileNotFoundException {
        //mileages = new MileageService().retrieveMockMileageData();  // From Mocked Data

        mileages = mileageService.findAll();   // From Database

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        Throwable localThrowable3 = null;
        try {
            table.addCell((Cell) ((Cell) new Cell(1, 1).add("LengthId").setBold()).setFontSize(8.0F));
            table.addCell((Cell) ((Cell) new Cell(1, 1).add("Miles").setBold()).setFontSize(8.0F));
            table.addCell((Cell) ((Cell) new Cell(1, 1).add("Kilometers").setBold()).setFontSize(8.0F));
            table.addCell((Cell) ((Cell) new Cell(1, 1).add("DateModified").setBold()).setFontSize(8.0F));

            for (Mileage mileage : mileages) {
                if (mileage.getLength_id() == null) {
                    table.addCell("");
                } else {
                    table.addCell(new PdfUtil().getCell(String.valueOf(mileage.getLength_id()), TextAlignment.CENTER));
                }

                if (mileage.getMiles() == null) {
                    table.addCell("");
                } else {
                    table.addCell(new PdfUtil().getCell(String.valueOf(mileage.getMiles()), TextAlignment.CENTER));
                }
                if (mileage.getKilometers() == null) {
                    table.addCell("");
                } else {
                    table.addCell(new PdfUtil().getCell(String.valueOf(mileage.getKilometers()), TextAlignment.CENTER));
                }

                if (mileage.getDate_modified() == null) {
                    table.addCell("");
                } else {
                    table.addCell(new PdfUtil().getCell(String.valueOf(mileage.getDate_modified()), TextAlignment.CENTER));
                }
            }

            doc.add(table);
        } catch (Throwable localThrowable5) {
            localThrowable3 = localThrowable5;
            throw localThrowable5;

        } finally {

            if (doc != null) {
                if (localThrowable3 != null) {
                    try {
                        doc.close();
                    } catch (Throwable localThrowable2) {
                        localThrowable3.addSuppressed(localThrowable2);
                    }
                } else {
                    doc.close();
                }
            }
        }
    }

}
