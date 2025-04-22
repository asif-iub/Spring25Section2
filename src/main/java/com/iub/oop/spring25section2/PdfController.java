package com.iub.oop.spring25section2;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfController
{
    @javafx.fxml.FXML
    private TextArea textArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generatePDF(ActionEvent actionEvent) throws FileNotFoundException {
//        PdfWriter writer = new PdfWriter("test.pdf");
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//        document.add(new Paragraph(textArea.getText()));
//        document.close();
        Document document = new Document();
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            final PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("openPDF.pdf"));

            // step 3: we open the document
            document.open();
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            // step 4: we add a paragraph to the document
            document.add(new Paragraph(textArea.getText()));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        // step 5: we close the document
        document.close();

    }
}