/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.merge.application.DTO;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import pdf.merge.application.DAL.PropertiesModel;

/**
 *
 * @author Quentin
 */
public class SettingsWindow extends javax.swing.JFrame {
    
    private String windowTitle = "Réglages";
    private String chooserDialogTitle = "Sélectionnez un dossier";
    
    String headerIsActivated = new PropertiesModel().getHeaderIsActivated();
    String footerIsActivated = new PropertiesModel().getFooterIsActivated();
    
    private PropertiesModel model = new PropertiesModel();

    /**
     * Creates new form PreferencesWindow
     */
    public SettingsWindow() {
        initComponents();
        this.setTitle(windowTitle);
        this.setSize(750, 500);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        FilePath.setText(model.getFilePath());
        
        if(model.getHeaderIsActivated().equals("true")) {
            AddHeader.setSelected(true);
            SetHeaderContent.setEnabled(true);
        } else {
            AddHeader.setSelected(false);
            SetHeaderContent.setEnabled(false);
        }
        if(model.getFooterIsActivated().equals("true")) {
            AddFooter.setSelected(true);
            SetFooterContent.setEnabled(true);
        } else {
            AddFooter.setSelected(false);
            SetFooterContent.setEnabled(false);
        }
        
        if(!model.getHeaderContent().equals("null")) {
            SetHeaderContent.setText(model.getHeaderContent());
        }
        if(!model.getFooterContent().equals("null")) {
            SetFooterContent.setText(model.getFooterContent());
        }
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        AddHeader = new javax.swing.JRadioButton();
        AddFooter = new javax.swing.JRadioButton();
        SetHeaderContent = new javax.swing.JTextField();
        SetHeaderLabel = new javax.swing.JLabel();
        SetFooterTitle = new javax.swing.JLabel();
        SetFooterContent = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        FilePath = new javax.swing.JTextField();
        FilesPathTitle = new javax.swing.JLabel();
        ChangeFilePath = new javax.swing.JButton();
        RecordSettings = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        AddHeader.setText("Ajouter une en-tête sur le PDF généré");
        AddHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddHeaderActionPerformed(evt);
            }
        });

        AddFooter.setText("Ajouter un pied de page sur le PDF généré");
        AddFooter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFooterActionPerformed(evt);
            }
        });

        SetHeaderContent.setEnabled(false);
        SetHeaderContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetHeaderContentActionPerformed(evt);
            }
        });

        SetHeaderLabel.setText("Contenu de l'en-tête :");

        SetFooterTitle.setText("Contenu du pied de page :");

        SetFooterContent.setEnabled(false);

        FilePath.setEnabled(false);

        FilesPathTitle.setText("Destination des fichiers PDF :");

        ChangeFilePath.setText("Modifier le chemin d'écriture");
        ChangeFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeFilePathActionPerformed(evt);
            }
        });

        RecordSettings.setText("Enregistrer les modifications");
        RecordSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordSettingsActionPerformed(evt);
            }
        });

        CancelBtn.setText("Annuler");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FilePath)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ChangeFilePath)
                                        .addGap(0, 238, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(CancelBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RecordSettings))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SetHeaderContent))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FilesPathTitle)
                            .addComponent(AddFooter)
                            .addComponent(AddHeader)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SetFooterTitle)
                                    .addComponent(SetHeaderLabel))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SetFooterContent)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(FilesPathTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangeFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetHeaderLabel)
                .addGap(8, 8, 8)
                .addComponent(SetHeaderContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddFooter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetFooterTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetFooterContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordSettings)
                    .addComponent(CancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeFilePathActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Desktop"));
        chooser.setDialogTitle(chooserDialogTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FilePath.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_ChangeFilePathActionPerformed

    private void AddHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddHeaderActionPerformed
        if(headerIsActivated.equals("true")) {
            SetHeaderContent.setEnabled(false);
            headerIsActivated = "false";
        } else {
            SetHeaderContent.setEnabled(true);
            headerIsActivated = "true";
        }
    }//GEN-LAST:event_AddHeaderActionPerformed

    private void AddFooterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFooterActionPerformed
        if(footerIsActivated.equals("true")) {
            SetFooterContent.setEnabled(false);
            footerIsActivated = "false";
        } else {
            SetFooterContent.setEnabled(true);
            footerIsActivated = "true";
        }
    }//GEN-LAST:event_AddFooterActionPerformed

    private void SetHeaderContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetHeaderContentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetHeaderContentActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void RecordSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordSettingsActionPerformed
        model.setProperties(FilePath.getText(), AddHeader.isSelected(), AddFooter.isSelected(), SetHeaderContent.getText(), SetFooterContent.getText());
        System.out.println("add header : " + AddHeader.isSelected());
        System.out.println("add footer : " + AddFooter.isSelected());
        this.setVisible(false);
    }//GEN-LAST:event_RecordSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AddFooter;
    private javax.swing.JRadioButton AddHeader;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton ChangeFilePath;
    private javax.swing.JTextField FilePath;
    private javax.swing.JLabel FilesPathTitle;
    private javax.swing.JButton RecordSettings;
    private javax.swing.JTextField SetFooterContent;
    private javax.swing.JLabel SetFooterTitle;
    private javax.swing.JTextField SetHeaderContent;
    private javax.swing.JLabel SetHeaderLabel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
