/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.BLL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.awt.Desktop;

/**
 *
 * @author Quentin
 */
public class MergeFile {    
    public void mergeFiles(String absolutePath, String givenName, File[] fileList) throws FileNotFoundException, IOException {
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        // on ajoute tous els fichiers trouvés
        for(int i = 0; i < fileList.length; i++) {
            System.out.println(absolutePath + "\\" + fileList[i].getName());
            PDFmerger.addSource(absolutePath + "\\" + fileList[i].getName());
        }
        
        // si l'utilisateur n'a pas ajouté l'extension en saisisant le nom
        if(!givenName.endsWith(".pdf")) {
            givenName += ".pdf";
        }
        
        // si le répertoire n'a pas été créé
        File directory = new File("DossierBilans");
        if(!directory.exists()) {
            // on créée le répertoire
            directory.mkdir();
        }
        
        // on créée le nouveau path pour la création du fichier
        String newFilePath = "DossierBilans/" + givenName;           
        PDFmerger.setDestinationFileName(newFilePath);
        // on fusionne les fichiers PDF
        PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        
        // méthode d'ouverture du fichier fusionné
        loadFile(newFilePath);
    }
    
    public void loadFile(String lastPDFCreated) throws IOException {
        // on vérifie si le PC peut ouvrir le fichier
        if (Desktop.isDesktopSupported()) {
            final Desktop desktop = Desktop.getDesktop();
            try {
                // on ouvre le fichier créé avec Adobe Reader
                Desktop.getDesktop().open(new File(lastPDFCreated));
            } catch (Exception e) {
                System.out.println("Impossible d'ouvrir le fichier avec l'erreur : " + e);
            }
        }
    }
}
