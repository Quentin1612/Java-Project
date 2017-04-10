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
    
    public String getFilePath() {
        try {
            InputStream file = new FileInputStream(myConfig);
            prop.load(file);
            return prop.getProperty("generatedPDFFilePath");
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
            return null;
        }
    }
    
    public void setFilePath(String value) {
        try {
            InputStream file = new FileInputStream(myConfig);
            output = new FileOutputStream(myConfig, false);
            prop.load(file);
            prop.setProperty("generatedPDFFilePath", value);
            prop.store(output, null);
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
        }
    }
    
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
    
    public void setHeaderContent(String value) {
        try {
            InputStream file = new FileInputStream(myConfig);
            output = new FileOutputStream(myConfig, false);
            prop.load(file);
            prop.setProperty("headerContent", value);
            prop.store(output, null);
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
        }
    }
    
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
    
    public void setFooterContent(String value) {
        try {
            InputStream file = new FileInputStream(myConfig);
            output = new FileOutputStream(myConfig, false);
            prop.load(file);
            prop.setProperty("footerContent", value);
            prop.store(output, null);
        } catch (IOException e) {
            System.out.println("Erreur : " + e);
        }
    }
}
