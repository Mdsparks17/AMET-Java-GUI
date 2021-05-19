//##############################################################################
//  Creates an output window with all of the created output files. 
//  
//   
//
//  AUTHOR: Michael Dillon Sparks
//##############################################################################
package javaguiapp;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OutputWindow extends javax.swing.JFrame {
    
    final Color COLOR_NORMAL = Color.BLUE;
    final Color COLOR_ACTIVE = new Color(102,52,102);

    int line = 0;
    javax.swing.JLabel[] labels = new javax.swing.JLabel[16];
    
    public OutputWindow(AMETForm form) {
        initComponents();
        queryInfoLabel.setText(form.query);
        programOutputLabel.setText("Program Output (" + form.run_program + ")");
        
        System.out.println(outLabel0.getText());
        labels[0] = outLabel0;
        labels[1] = outLabel1;
        labels[2] = outLabel2;
        labels[3] = outLabel3;
        labels[4] = outLabel4;
        labels[5] = outLabel5;
        labels[6] = outLabel6;
        labels[7] = outLabel7;
    }
    
    public void newFile(String link, String name) {
        //see if file was created
        File myFile = new File(link);
        if (myFile.exists()) {
            labels[line].setText(name);
            labels[line].setForeground(COLOR_NORMAL);


            labels[line].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    evt.getComponent().setForeground(COLOR_ACTIVE);
                    outputEvent(evt, link);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    evt.getComponent().setFont(new java.awt.Font("Tahoma", 2, 11));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    evt.getComponent().setFont(new java.awt.Font("Tahoma", 0, 11));
                }
            });
            line++;
        } else {
            System.out.println("File " + name + " not found!"); 
        }
    }
    
    public void checkIfSuccess() {
        if (outLabel0.getText().equals("-")) {
            outLabel0.setText("Error with creating the output files");
        }
    }
    
    private void outputEvent(java.awt.event.MouseEvent evt, String link) {
        System.out.println("clicked!");
        try {
            File myFile = new File(link);
            Desktop.getDesktop().open(myFile);
        } catch (IOException e) {
            System.out.println("File does not exist");
        }  
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        queryLabel = new javax.swing.JLabel();
        programOutputLabel = new javax.swing.JLabel();
        queryInfoLabel = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        outLabel0 = new javax.swing.JLabel();
        outLabel1 = new javax.swing.JLabel();
        outLabel3 = new javax.swing.JLabel();
        outLabel2 = new javax.swing.JLabel();
        outLabel5 = new javax.swing.JLabel();
        outLabel4 = new javax.swing.JLabel();
        outLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        outLabel7 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        queryLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        queryLabel.setText("Your MySQL Query");

        programOutputLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        programOutputLabel.setText("Program Output");

        queryInfoLabel.setEditable(false);
        queryInfoLabel.setColumns(20);
        queryInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        queryInfoLabel.setLineWrap(true);
        queryInfoLabel.setRows(5);
        queryInfoLabel.setText("Sample query text ");
        queryInfoLabel.setWrapStyleWord(true);
        queryInfoLabel.setOpaque(false);

        jLabel1.setText("jLabel1");

        outLabel0.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(programOutputLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(outLabel0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(outLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queryInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(queryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(programOutputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(outLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel outLabel0;
    private javax.swing.JLabel outLabel1;
    private javax.swing.JLabel outLabel2;
    private javax.swing.JLabel outLabel3;
    private javax.swing.JLabel outLabel4;
    private javax.swing.JLabel outLabel5;
    private javax.swing.JLabel outLabel6;
    private javax.swing.JLabel outLabel7;
    private javax.swing.JLabel programOutputLabel;
    private javax.swing.JTextArea queryInfoLabel;
    private javax.swing.JLabel queryLabel;
    // End of variables declaration//GEN-END:variables
}