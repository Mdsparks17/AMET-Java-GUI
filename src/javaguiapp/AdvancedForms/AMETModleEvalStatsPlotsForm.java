/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguiapp.AdvancedForms;

import javaguiapp.AMETForm;

/**
 *
 * @author Mdspa
 */
public class AMETModleEvalStatsPlotsForm extends javax.swing.JFrame {

    /**
     * Creates new form AMETModleEvalStatsPlotsForm
     */
    AMETForm form;
    public AMETModleEvalStatsPlotsForm(AMETForm form) {
        this.form = form;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        boxPlotOptionsLabel = new javax.swing.JLabel();
        includeWhiskersCheckBox = new javax.swing.JCheckBox();
        includeRangeCheckBox = new javax.swing.JCheckBox();
        includeMedianLinesCheckBox = new javax.swing.JCheckBox();
        subtractMeanCheckBox = new javax.swing.JCheckBox();
        overlapBoxesCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        StackedBarchartOptionsLabel = new javax.swing.JLabel();
        includeCSNFRMCheckBox = new javax.swing.JCheckBox();
        useMedianCheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        timeSeriesPlotOptionsLabel = new javax.swing.JLabel();
        chooseAveragingLabel = new javax.swing.JTextArea();
        chooseAveragingComboBox = new javax.swing.JComboBox<>();
        includeLegendCheckBox = new javax.swing.JCheckBox();
        includePointsCheckBox = new javax.swing.JCheckBox();
        includeBiasCheckBox = new javax.swing.JCheckBox();
        includeRMSECheckBox = new javax.swing.JCheckBox();
        includeCorrelationCheckBox = new javax.swing.JCheckBox();
        subtractPeriodCheckBox = new javax.swing.JCheckBox();
        specifyMinimumLabel = new javax.swing.JTextArea();
        specifyMinimumTextField = new javax.swing.JTextField();
        specifyTimeCheckBox = new javax.swing.JTextArea();
        specifyTimeTextArea = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        scatterPlotoptionsLabel = new javax.swing.JLabel();
        includeRunInfoCheckBox = new javax.swing.JCheckBox();
        includeZeroPrecipitationCheckBox = new javax.swing.JCheckBox();
        includeZeroPrecipitationLabel = new javax.swing.JTextArea();
        includeValidObservationsCheckBox = new javax.swing.JCheckBox();
        observeValidObservationsLabel = new javax.swing.JTextArea();
        minCompleteLabel = new javax.swing.JTextArea();
        minCompleteTextField = new javax.swing.JTextField();
        minObservationsLabel = new javax.swing.JTextArea();
        minObservationsTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        boxPlotOptionsLabel.setText("Box Plot Options");
        boxPlotOptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        includeWhiskersCheckBox.setText(" Include whiskers on boxplot ");

        includeRangeCheckBox.setSelected(true);
        includeRangeCheckBox.setText(" Include 25-75% quartile ranges on boxplot ");

        includeMedianLinesCheckBox.setText(" Include median lines on boxplot ");

        subtractMeanCheckBox.setText(" Subtract mean from Hourly Boxplot or Spatial Plot scripts ");

        overlapBoxesCheckBox.setText(" Overlap boxes in GGplot box plot ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overlapBoxesCheckBox)
                    .addComponent(subtractMeanCheckBox)
                    .addComponent(includeRangeCheckBox)
                    .addComponent(includeWhiskersCheckBox)
                    .addComponent(boxPlotOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(includeMedianLinesCheckBox))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boxPlotOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeWhiskersCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeRangeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeMedianLinesCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtractMeanCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overlapBoxesCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StackedBarchartOptionsLabel.setText("Stacked Barchart Options");
        StackedBarchartOptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        includeCSNFRMCheckBox.setSelected(true);
        includeCSNFRMCheckBox.setText(" Include CSN FRM adjustment ");

        useMedianCheckBox.setText(" Use median instead of mean ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(StackedBarchartOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 121, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(includeCSNFRMCheckBox)
                    .addComponent(useMedianCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(StackedBarchartOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(includeCSNFRMCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(useMedianCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timeSeriesPlotOptionsLabel.setText("Time Series Plot Options");
        timeSeriesPlotOptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        chooseAveragingLabel.setColumns(20);
        chooseAveragingLabel.setEditable(false);
        chooseAveragingLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        chooseAveragingLabel.setLineWrap(true);
        chooseAveragingLabel.setRows(5);
        chooseAveragingLabel.setText("Choose which averaging function to plot on the time series (note that the sum option averages the domain-wide sum by the number of sites)");
        chooseAveragingLabel.setWrapStyleWord(true);
        chooseAveragingLabel.setOpaque(false);

        chooseAveragingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mean", "medium", "sum" }));

        includeLegendCheckBox.setSelected(true);
        includeLegendCheckBox.setText(" Include legend on time series plots ");

        includePointsCheckBox.setSelected(true);
        includePointsCheckBox.setText(" Include points on time series plots ");

        includeBiasCheckBox.setSelected(true);
        includeBiasCheckBox.setText(" Include bias on interactive time series plots ");

        includeRMSECheckBox.setText(" Include RMSE on interactive time series plots ");

        includeCorrelationCheckBox.setText(" Include Correlation on interactive time series plots ");

        subtractPeriodCheckBox.setText(" Subtract period mean from time series plots ");

        specifyMinimumLabel.setColumns(20);
        specifyMinimumLabel.setEditable(false);
        specifyMinimumLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        specifyMinimumLabel.setLineWrap(true);
        specifyMinimumLabel.setRows(5);
        specifyMinimumLabel.setText("Specify minimum limit on number of records per time unit (e.g. day) to include");
        specifyMinimumLabel.setWrapStyleWord(true);
        specifyMinimumLabel.setOpaque(false);

        specifyMinimumTextField.setText("0");
        specifyMinimumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specifyMinimumTextFieldActionPerformed(evt);
            }
        });

        specifyTimeCheckBox.setColumns(20);
        specifyTimeCheckBox.setEditable(false);
        specifyTimeCheckBox.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        specifyTimeCheckBox.setLineWrap(true);
        specifyTimeCheckBox.setRows(5);
        specifyTimeCheckBox.setText("Specify time series line widths");
        specifyTimeCheckBox.setWrapStyleWord(true);
        specifyTimeCheckBox.setOpaque(false);

        specifyTimeTextArea.setText("1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(specifyMinimumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(specifyTimeTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(specifyTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(timeSeriesPlotOptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtractPeriodCheckBox)
                            .addComponent(includeCorrelationCheckBox)
                            .addComponent(includeRMSECheckBox)
                            .addComponent(includeBiasCheckBox)
                            .addComponent(includePointsCheckBox)
                            .addComponent(includeLegendCheckBox)
                            .addComponent(chooseAveragingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specifyMinimumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseAveragingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(timeSeriesPlotOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseAveragingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseAveragingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(includeLegendCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includePointsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeBiasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeRMSECheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeCorrelationCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtractPeriodCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(specifyMinimumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specifyMinimumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(specifyTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specifyTimeTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scatterPlotoptionsLabel.setText("Scatter Plot Options");
        scatterPlotoptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        includeRunInfoCheckBox.setSelected(true);
        includeRunInfoCheckBox.setText(" Include run info text on plots");

        includeZeroPrecipitationCheckBox.setToolTipText("");

        includeZeroPrecipitationLabel.setEditable(false);
        includeZeroPrecipitationLabel.setColumns(20);
        includeZeroPrecipitationLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        includeZeroPrecipitationLabel.setLineWrap(true);
        includeZeroPrecipitationLabel.setRows(5);
        includeZeroPrecipitationLabel.setText("Do not include zero precipitation observations in analysis. Only use when precipitation data are available (e.g. NAPD, AIRMON)");
        includeZeroPrecipitationLabel.setWrapStyleWord(true);
        includeZeroPrecipitationLabel.setOpaque(false);

        includeValidObservationsCheckBox.setSelected(true);
        includeValidObservationsCheckBox.setToolTipText("");

        observeValidObservationsLabel.setColumns(20);
        observeValidObservationsLabel.setEditable(false);
        observeValidObservationsLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        observeValidObservationsLabel.setLineWrap(true);
        observeValidObservationsLabel.setRows(5);
        observeValidObservationsLabel.setText("Include only and all valid observations in the analysis based on availabel valid codes (obs w/ missing valid codes are considered valid). Currently applies to only NADP, MDN and AMON networks. ");
        observeValidObservationsLabel.setWrapStyleWord(true);
        observeValidObservationsLabel.setOpaque(false);

        minCompleteLabel.setColumns(20);
        minCompleteLabel.setEditable(false);
        minCompleteLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        minCompleteLabel.setLineWrap(true);
        minCompleteLabel.setRows(5);
        minCompleteLabel.setText("Enter minimum completeness (as a %) for site specific calculations (e.g. at least 3 of 4 obs = 75%). Note that this criteria does not apply to bulk domain computed statistics, only site specific calculations .");
        minCompleteLabel.setWrapStyleWord(true);
        minCompleteLabel.setOpaque(false);

        minCompleteTextField.setText("75");

        minObservationsLabel.setColumns(20);
        minObservationsLabel.setEditable(false);
        minObservationsLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        minObservationsLabel.setLineWrap(true);
        minObservationsLabel.setRows(5);
        minObservationsLabel.setText(" Enter minimum number of observations required for site statistics calculations (default is set at 1 which would include all sites that meet the completeness criteria above)");
        minObservationsLabel.setWrapStyleWord(true);
        minObservationsLabel.setOpaque(false);

        minObservationsTextField.setText("1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(includeZeroPrecipitationCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(includeZeroPrecipitationLabel))
                    .addComponent(includeRunInfoCheckBox)
                    .addComponent(scatterPlotoptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(includeValidObservationsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(observeValidObservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(minCompleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(minCompleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(minObservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(minObservationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scatterPlotoptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(includeRunInfoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(includeZeroPrecipitationCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(includeZeroPrecipitationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(includeValidObservationsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observeValidObservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(minCompleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minCompleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minObservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minObservationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(cancelButton))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        form.run_info_text = form.checkBoxFormat(includeRunInfoCheckBox);
        form.zeroprecip = form.checkBoxFormat(includeZeroPrecipitationCheckBox);
        form.all_valid = form.checkBoxFormat(includeValidObservationsCheckBox);
        form.coverage_limit = form.numFormat(minCompleteTextField.getText());
        form.num_obs_limit = form.numFormat(minObservationsTextField.getText());
        form.inc_whiskers = form.checkBoxFormat(includeWhiskersCheckBox);
        form.inc_ranges = form.checkBoxFormat(includeRangeCheckBox);
        form.inc_median_lines = form.checkBoxFormat(includeMedianLinesCheckBox);
        form.remove_mean = form.checkBoxFormat(subtractMeanCheckBox);
        form.overlap_boxes = form.checkBoxFormat(overlapBoxesCheckBox);
        form.inc_FRM_adj = form.checkBoxFormat(includeCSNFRMCheckBox);
        form.use_median = form.checkBoxFormat(useMedianCheckBox);
        form.avg_func_name = form.textFormat(chooseAveragingComboBox.getSelectedItem().toString());
        form.avg_func = form.textFormat(chooseAveragingComboBox.getSelectedItem().toString());
        form.inc_legend = form.checkBoxFormat(includeLegendCheckBox);
        form.inc_points = form.checkBoxFormat(includePointsCheckBox);
        form.inc_bias = form.checkBoxFormat(includeBiasCheckBox);
        form.inc_rmse = form.checkBoxFormat(includeRMSECheckBox);
        form.inc_corr = form.checkBoxFormat(includeCorrelationCheckBox);
        form.use_var_mean = form.checkBoxFormat(subtractPeriodCheckBox);
        form.obs_per_day_limit = form.numFormat(specifyMinimumTextField.getText());
        form.line_width = form.textFormat(specifyTimeTextArea.getText());
        setVisible(false);
        dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void specifyMinimumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specifyMinimumTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specifyMinimumTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StackedBarchartOptionsLabel;
    private javax.swing.JLabel boxPlotOptionsLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> chooseAveragingComboBox;
    private javax.swing.JTextArea chooseAveragingLabel;
    private javax.swing.JCheckBox includeBiasCheckBox;
    private javax.swing.JCheckBox includeCSNFRMCheckBox;
    private javax.swing.JCheckBox includeCorrelationCheckBox;
    private javax.swing.JCheckBox includeLegendCheckBox;
    private javax.swing.JCheckBox includeMedianLinesCheckBox;
    private javax.swing.JCheckBox includePointsCheckBox;
    private javax.swing.JCheckBox includeRMSECheckBox;
    private javax.swing.JCheckBox includeRangeCheckBox;
    private javax.swing.JCheckBox includeRunInfoCheckBox;
    private javax.swing.JCheckBox includeValidObservationsCheckBox;
    private javax.swing.JCheckBox includeWhiskersCheckBox;
    private javax.swing.JCheckBox includeZeroPrecipitationCheckBox;
    private javax.swing.JTextArea includeZeroPrecipitationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea minCompleteLabel;
    private javax.swing.JTextField minCompleteTextField;
    private javax.swing.JTextArea minObservationsLabel;
    private javax.swing.JTextField minObservationsTextField;
    private javax.swing.JTextArea observeValidObservationsLabel;
    private javax.swing.JCheckBox overlapBoxesCheckBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel scatterPlotoptionsLabel;
    private javax.swing.JTextArea specifyMinimumLabel;
    private javax.swing.JTextField specifyMinimumTextField;
    private javax.swing.JTextArea specifyTimeCheckBox;
    private javax.swing.JTextField specifyTimeTextArea;
    private javax.swing.JCheckBox subtractMeanCheckBox;
    private javax.swing.JCheckBox subtractPeriodCheckBox;
    private javax.swing.JLabel timeSeriesPlotOptionsLabel;
    private javax.swing.JCheckBox useMedianCheckBox;
    // End of variables declaration//GEN-END:variables
}
