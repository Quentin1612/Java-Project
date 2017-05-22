/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.BLL;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Quentin
 */
public class PDFWriter {
    private PDDocument document = null;
    private PDPageTree allPages = null;
    private PDPage page = null;
    private final PDFont font = PDType1Font.TIMES_ROMAN;
    private final float fontSize = 15.0f; 
    private PDPageContentStream contentStream = null;
    
    public PDFWriter(File file, String filePath, Boolean headerActivated, Boolean footerActivated, String headerContent, String footerContent) {
        try {
            // récupération du fichier à modifier
            document = PDDocument.load(file);
            // récupération de l'ensemble des pages du PDF généré en amont
            allPages = document.getDocumentCatalog().getPages();
            
            // on boucle sur le nombre de pages du PDF
            for(int i = 0; i < allPages.getCount(); i++) {
                // on récupère la première page
                page = (PDPage) allPages.get(i);
                contentStream = new PDPageContentStream(document, page, true, true,true);
                // début de l'écriture
                contentStream.beginText();
                contentStream.setFont(font, fontSize);
                
                // si le header doit être écrit, ou le footer ou les deux
                if(headerActivated && footerActivated) {
                    // on se positionne sur le PDF
                    contentStream.moveTextPositionByAmount(5, 580);
                    // on écrit sur le contenu enregistré pour le header
                    contentStream.drawString(headerContent);
                    contentStream.moveTextPositionByAmount(5, -550);
                    contentStream.drawString(footerContent);
                } else if(headerActivated) {
                    contentStream.moveTextPositionByAmount(5, 580);
                    contentStream.drawString(headerContent);
                } else {
                    contentStream.moveTextPositionByAmount(5, -550);
                    contentStream.drawString(footerContent);
                }
                
                // fin du processus d'écriture + fermeture
                contentStream.endText();
                contentStream.close();
            }
            // on écrase le fichier enregistré précédemment
            document.save(filePath);
        } catch(IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
