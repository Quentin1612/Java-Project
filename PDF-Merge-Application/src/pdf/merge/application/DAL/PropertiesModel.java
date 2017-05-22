/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Quentin
 */
public class PropertiesModel {
    private Properties prop = new Properties();
    private String fileName = "DossierProperties/config.properties";
    private File myConfig = new File(fileName);
    private FileOutputStream output = null;
    
    public void setProperties(String filePath, Boolean headerIsActivated, Boolean footerIsActivated, String headerContent, String footerContent) {
        try {
            // récupération du fichier de config
            InputStream file = new FileInputStream(myConfig);
            output = new FileOutputStream(myConfig, false);
            // chargement des properties
            prop.load(file);
            
            // on ajoute les properties au fichier
            prop.setProperty("generatedPDFFilePath", filePath);
            prop.setProperty("isTextOnTopActivated", headerIsActivated.toString());
            prop.setProperty("isTextOnBottomActivated", footerIsActivated.toString());
            prop.setProperty("headerContent", headerContent);
            prop.setProperty("footerContent", footerContent);
            // enregistrement des properties dans le fichier
            prop.store(output, null);
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
        }
    }
    
    public String getFilePath() {
        try {
            // récupération du fichier de config
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("generatedPDFFilePath");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    // méthode qui vérifie si la fonctionnalité d'ajout d'un header est activé
    public String getHeaderIsActivated() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("isTextOnTopActivated");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    // méthode qui vérifie si la fonctionnalité d'ajout d'un header est activé
    public String getFooterIsActivated() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("isTextOnBottomActivated");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    // méthode de récupération du contenu pour le Header
    public String getHeaderContent() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("headerContent");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    // méthode de récupération du contenu du Footer
    public String getFooterContent() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("footerContent");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
}
