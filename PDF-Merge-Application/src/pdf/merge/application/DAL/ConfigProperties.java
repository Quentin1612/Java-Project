/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.DAL;

import java.io.File;

/**
 *
 * @author Quentin
 */
public class ConfigProperties {
    private File directory = new File(new String("DossierProperties"));
    
    // on vérifie si le répertoire des properties existe
    public boolean isFolderCreated() {
        if(directory.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    // méthode de création du répertoire des properties
    public void createFolder() {
        directory.mkdir();
    }
}
