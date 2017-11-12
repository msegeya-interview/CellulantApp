package com.cellulant.utils;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Paul Msegeya
 */
@Component
@PropertySource({"classpath:application.properties"})
public class PdfUtil {

    private static final Logger LOGGER = Logger.getLogger(PdfUtil.class.getName());

    public PdfUtil() {
    }

    public PdfFont pdfFontHelvetica() throws IOException {
        PdfFont f = PdfFontFactory.createFont("Helvetica");

        return f;
    }

    public Cell getCell(String text, TextAlignment alignment) {
        Paragraph paragraph = (Paragraph) new Paragraph(text).setFixedLeading(0.0F).setMultipliedLeading(1.0F).setMarginLeft(2.0F);

        Cell cell = (Cell) ((Cell) ((Cell) new Cell().add(paragraph).setPadding(0.0F)).setVerticalAlignment(VerticalAlignment.MIDDLE)).setTextAlignment(alignment);

        return cell;
    }
}
