/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application;

import java.io.FileNotFoundException;
import pdf.merge.application.DAL.InitializeProperties;
import pdf.merge.application.DTO.MainWindow;

/**
 * 
 * @author Quentin
 */
public class PDFMergeApplication {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // initialisation des properties
        InitializeProperties initialization = new InitializeProperties();
        initialization.Initialize();
        
        // ouverture de la fenêtre principale
        MainWindow fenetre = new MainWindow();
    }
}
