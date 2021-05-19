//##############################################################################
//  Creates a generic error window with 2 strings, 1 for error title and 2 for
//  error details. 
//   
//
//  AUTHOR: Michael Dillon Sparks
//##############################################################################
package javaguiapp;

public class ErrorWindow extends javax.swing.JFrame {

    String title;
    String message;
    public ErrorWindow(String title, String message) {
        this.title = title;
        this.message = message;
        initComponents();
        jLabel1.setText(title);
        mySQLInfoLabel.setText(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mySQLInfoLabel = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mySQLInfoLabel.setColumns(20);
        mySQLInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mySQLInfoLabel.setLineWrap(true);
        mySQLInfoLabel.setRows(5);
        mySQLInfoLabel.setText("ERROR: ");
        mySQLInfoLabel.setWrapStyleWord(true);
        mySQLInfoLabel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(mySQLInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(mySQLInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea mySQLInfoLabel;
    // End of variables declaration//GEN-END:variables
}
