/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import pdf.merge.application.BLL.MergeFile;

/**
 *
 * @author Quentin
 */
public class PDFNamePopUp extends JDialog {
    
    private String popUpTitle = "Saisissez le nom du fichier à générer :";
    
    public PDFNamePopUp(String absolutePath, File[] fileList) throws FileNotFoundException, IOException {
        // ouverture de la pop-up
        JOptionPane fileNamePopUp = new JOptionPane();
        String answer = fileNamePopUp.showInputDialog(null, popUpTitle, "", JOptionPane.QUESTION_MESSAGE);
        
        // appel de la méthode de fusion des PDF
        MergeFile newFile = new MergeFile();
        newFile.mergeFiles(absolutePath, answer, fileList);
    }
}
