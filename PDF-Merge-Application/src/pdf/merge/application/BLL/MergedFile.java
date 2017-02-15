/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.BLL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Quentin
 */
public class MergedFile {
    private String absolutePath;
    private File[] fileList;
    
    public String getAbsolutePath() {
        return this.absolutePath;
    }
    
    public void setAbsolutePath(String AbsolutePath) {
        this.absolutePath = AbsolutePath;
    }
    
    public File[] getFileList() {
        return fileList;
    }
    
    public void setFileList(File[] FileList) {
        this.fileList = FileList;
    }
    
    public MergedFile(String absolutePath, File[] fileList) throws FileNotFoundException, IOException {
        setAbsolutePath(absolutePath);
        setFileList(fileList);
    }
    
    public void mergeFiles() throws FileNotFoundException, IOException {
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        for(int i = 0; i < fileList.length; i++) {
            System.out.println(absolutePath + "\\" + fileList[i].getName());
            PDFmerger.addSource(absolutePath + "\\" + fileList[i].getName());
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String newFileName = "Bilan du " + dateFormat.format(date);
        
        File directory = new File("../DossierBilans");
        if(!directory.exists()) {
            try {
                directory.mkdir();
                PDDocument doc = new PDDocument();
                doc.addPage(new PDPage());
                doc.save(newFileName);
                doc.close();
            } catch (SecurityException e) {
                System.out.println("Impossible de créer le répertoire ...");
            }
        }
            
        PDFmerger.setDestinationFileName("../DossierBilans/");
        PDFmerger.mergeDocuments();
    }
}
