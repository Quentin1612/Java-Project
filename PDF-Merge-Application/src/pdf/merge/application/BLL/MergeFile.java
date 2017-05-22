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
import pdf.merge.application.DAL.PropertiesModel;

/**
 *
 * @author Quentin
 */
public class MergeFile {
    private PDFWriter writer = null;
    private PropertiesModel properties = new PropertiesModel();
    private Boolean headerActivated = Boolean.valueOf(properties.getHeaderIsActivated());
    private Boolean footerActivated = Boolean.valueOf(properties.getFooterIsActivated());
    private String pathToRecordFile = properties.getFilePath();
    
    public void mergeFiles(String absolutePath, String givenName, File[] fileList) throws FileNotFoundException, IOException {
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        // on ajoute tous els fichiers trouvés
        for(int i = 0; i < fileList.length; i++) {
            PDFmerger.addSource(absolutePath + "\\" + fileList[i].getName());
        }
        
        // si l'utilisateur n'a pas ajouté l'extension en saisisant le nom
        if(!givenName.endsWith(".pdf")) {
            givenName += ".pdf";
        }
        
        // on crée le nouveau path pour la création du fichier
        String newFilePath = pathToRecordFile + "/" + givenName;           
        PDFmerger.setDestinationFileName(newFilePath);
        // on fusionne les fichiers PDF
        PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        
        // on vérifie si les options pour écrire sur le PDF ont été cochées
        if(headerActivated || footerActivated){
            // on instancie le writer
            writer = new PDFWriter(new File(newFilePath), newFilePath, headerActivated, footerActivated, properties.getHeaderContent(), properties.getFooterContent());
        }
        
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
