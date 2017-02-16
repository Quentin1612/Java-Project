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
import org.apache.pdfbox.io.MemoryUsageSetting;
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
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String newFilePath = "Bilan du " + dateFormat.format(date) + ".pdf";
        
        File directory = new File("DossierBilans");
        if(!directory.exists()) {
            directory.mkdir();
        }
        
        newFilePath = "DossierBilans/" + newFilePath;           
        PDFmerger.setDestinationFileName(newFilePath);
        PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
