/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.BLL;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Quentin
 */
public class FileFinder {
    public static File[] find (String path) {
        // récupération du fichier grâce au path
        File dir = new File(path);
        // on retourne la liste de fichiers pdf trouvés
        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".pdf");
            }
        } );
    }
}