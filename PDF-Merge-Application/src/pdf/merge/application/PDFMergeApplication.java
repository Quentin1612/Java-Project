/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import pdf.merge.application.DTO.MainWindow;
import pdf.merge.application.DAL.ConfigProperties;

/**
 * 
 * @author Quentin
 */
public class PDFMergeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // si le répertoire n'a pas été créé
        File directory = new File("DossierBilans");
        if(!directory.exists()) {
            // on crée le répertoire
            directory.mkdir();
        }
        
        // instanciation du fichier de config
        ConfigProperties configProperties = new ConfigProperties();
        Properties prop = new Properties();
        // récupération du fichier de config
        String fileName = "DossierProperties/config.properties";
        File myConfig = new File(fileName);
        FileOutputStream output = null;
        
        String folderPath = System.getProperty("user.dir") + fileName;
        
        // on vérifie si le dossier de config a été créé
        if(!configProperties.isFolderCreated()) {
            configProperties.createFolder();
            try {
                // création du fichier de config
                myConfig.createNewFile();
                
                output = new FileOutputStream(myConfig, false);
                
                // on crée les properties du fichier
                prop.setProperty("generatedPDFFilePath", System.getProperty("user.dir") + "\\DossierBilans");
                prop.setProperty("isTextOnTopActivated", "false");
                prop.setProperty("isTextOnBottomActivated", "false");
                prop.setProperty("headerContent", "null");
                prop.setProperty("footerContent", "null");
                
                prop.store(output, null);
            } catch (IOException e) {
                System.out.println("Erreur : " + e);
            }
        }
        
        // ouverture de la fenêtre principale
        MainWindow fenetre = new MainWindow();
    }
}
