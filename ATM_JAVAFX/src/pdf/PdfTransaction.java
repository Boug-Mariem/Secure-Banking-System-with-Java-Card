package pdf;
import java.io.IOException;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;


public class PdfTransaction {

    public static final String DEST = "Les Transactions.pdf";
    private Document document;
    
    public void transaction(packageLecteur.Lecteur.Transaction[] his) throws IOException {
        
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(DEST));
        document = new Document(pdfDocument);
        
        addCenteredText("Les Transactions:");
        addText("");
        addText("");
        int i =0;
        while(i<10 && his[i]!=null) {
        	addgrandText("Transaction: ");
        	addText("ID:      "+his[i].getid());
        	addText("Type:    "+his[i].getType());
        	addText("Montant: "+his[i].getmontant());
        	addText("------------------------------");
        	i++;
        }
        document.close();
    }

    private void addCenteredText(String text) {   
    	Color customColor = new DeviceRgb(255, 165, 0);
    	Paragraph paragraph = new Paragraph(text)
            .setFontSize(40)
            //.setFontColor(ColorConstants.RED);
            .setTextAlignment(TextAlignment.CENTER);
    	paragraph.setFontColor(customColor);
        // Ajoute le paragraphe au document
        document.add(paragraph);
    }
    
    private void addgrandText(String text) {
    	Color darkBlue = new DeviceRgb(0, 0, 139);
    	Paragraph paragraph = new Paragraph(text)
        		.setBold()
        		.setFontSize(20);
    	paragraph.setFontColor(darkBlue);
        // Ajoute le paragraphe au document
        document.add(paragraph);
    }


    private void addText(String text) {
        // Ajoute un paragraphe simple
        document.add(new Paragraph(text));
    }
 
}
