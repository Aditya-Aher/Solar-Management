package com.example.demo.restapi.service;

import com.example.demo.restapi.entity.Visit;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfGenerationService {

    public byte[] generateVisitPdf(Visit visit) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);


        Document document = new Document(pdf);


        document.add(new Paragraph("Visit Report").setFontSize(18));


        Table table = new Table(2); 
        table.addCell(new Cell().add(new Paragraph("Consumer Name")));
        table.addCell(new Cell().add(new Paragraph(visit.getConsumerName())));
        
        table.addCell(new Cell().add(new Paragraph("Consumer Number")));
        table.addCell(new Cell().add(new Paragraph(visit.getConsumerNumber())));

        table.addCell(new Cell().add(new Paragraph("SubCD Status")));
        table.addCell(new Cell().add(new Paragraph(visit.getSubcdStatus())));

        table.addCell(new Cell().add(new Paragraph("Installation Status")));
        table.addCell(new Cell().add(new Paragraph(visit.getInstallationStatus())));

        table.addCell(new Cell().add(new Paragraph("Reason Not Done")));
        table.addCell(new Cell().add(new Paragraph(visit.getReasonNotDone() != null ? visit.getReasonNotDone() : "N/A")));

        table.addCell(new Cell().add(new Paragraph("Queries")));
        table.addCell(new Cell().add(new Paragraph(visit.getQueries() != null ? visit.getQueries() : "N/A")));

        
        document.add(table);

      
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
    
    public byte[] generateVisitListPdf(List<Visit> visits) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();


        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("List of Consumer Visits").setTextAlignment(TextAlignment.CENTER));

   
        Table table = new Table(5);

        // Add table headers
        table.addCell(new Cell().add(new Paragraph("ID")));
        table.addCell(new Cell().add(new Paragraph("Consumer Name")));
        table.addCell(new Cell().add(new Paragraph("Consumer Number")));
        table.addCell(new Cell().add(new Paragraph("SubCD Status")));
        table.addCell(new Cell().add(new Paragraph("Installation Status")));


        for (Visit visit : visits) {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(visit.getId()))));
            table.addCell(new Cell().add(new Paragraph(visit.getConsumerName())));
            table.addCell(new Cell().add(new Paragraph(visit.getConsumerNumber())));
            table.addCell(new Cell().add(new Paragraph(visit.getSubcdStatus())));
            table.addCell(new Cell().add(new Paragraph(visit.getInstallationStatus())));
        }


        document.add(table);

 
        document.close();

        return baos.toByteArray();
    }
}
