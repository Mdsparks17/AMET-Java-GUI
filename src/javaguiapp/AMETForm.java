//##############################################################################
//  This is the main GUI form that manages the creation of run_info.r variables,
//  the dynamic execution of r_analysis scripts, and displaying the r_analysis
//  outputs. 
//
//  AUTHOR: Michael Dillon Sparks
//##############################################################################

//TIPS for Navigating this program:
//For Netbeans IDE, te command for automatically compressing all chunks of code is <ctrl shift +>, this is very useful for evaluating the work flow
//The design can be found by clicking the "Design" tab above, this give you a visual demo and a drag and drop interface to edit what the user sees
//The key to seeing how information flows is by looking at runProgramButtonActionPerformed(), as it calls the main functions of the program
//For any questions, try contacting mdsparks17@gmail.com

package javaguiapp;

import javaguiapp.AdvancedForms.SpatialPlotOptionsForm;
import javaguiapp.AdvancedForms.SoccergoalBugleForm;
import javaguiapp.AdvancedForms.ScatterPlotOptionsForm;
import javaguiapp.AdvancedForms.OverlayFileOptionsForm;
import javaguiapp.AdvancedForms.GeographicCriteriaForm;
import javaguiapp.AdvancedForms.CustomMySQLQueryForm;
import javaguiapp.AdvancedForms.AdvancedSpeciesForm;
import javaguiapp.AdvancedForms.AMETPlotAxisOptionsForm;
import javaguiapp.AdvancedForms.AMETModleEvalStatsPlotsForm;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class AMETForm extends javax.swing.JFrame {    
    Config config = new Config();

    //Variable instantiation and setting default values
    public String run_program = "";
    public String query = "\"\""; 
    public String dbase = "\"\""; 
    public String run_name1 = "\"\""; 
    public String run_name2 = "\"\""; 
    public String run_name3 = "\"\""; 
    public String run_name4 = "\"\""; 
    public String run_name5 = "\"\""; 
    public String run_name6 = "\"\""; 
    public String run_name7 = "\"\""; 
    public String species_in = "\"\""; 
    public String custom_species = "\"\""; 
    public String custom_species_name = "\"\""; 
    public String custom_units = "\"\""; 
    public String inc_csn = "\"\""; 
    public String inc_improve = "\"\""; 
    public String inc_castnet = "\"\""; 
    public String inc_castnet_hr = "\"\""; 
    public String inc_castnet_daily = "\"\""; 
    public String inc_castnet_drydep = "\"\"";
    public String inc_capmon = "\"\""; 
    public String inc_naps = "\"\""; 
    public String inc_naps_daily_o3 = "\"\""; 
    public String inc_nadp = "\"\"";
    public String inc_airmon_dep = "\"\"";
    public String inc_amon = "\"\""; 
    public String inc_aqs_hourly = "\"\""; 
    public String inc_aqs_daily_o3 = "\"\"";
    public String inc_aqs_daily = "\"\"";
    public String inc_aqs_daily_oaqps = "\"\"";
    public String inc_aqs_daily_pm = "\"\""; 
    public String inc_search = "\"\"";
    public String inc_search_daily = "\"\""; 
    public String inc_aeronet = "\"\"";
    public String inc_fluxnet = "\"\"";
    public String inc_noaa_esrl_o3 = "\"\"";
    public String inc_toar = "\"\""; 
    public String inc_mdn = "\"\""; 
    public String inc_tox = "\"\"";
    public String inc_mod = "\"\"";
    public String inc_admn = "\"\"";
    public String inc_aganet = "\"\""; 
    public String inc_airbase_hourly = "\"\""; 
    public String inc_airbase_daily = "\"\""; 
    public String inc_aurn_hourly = "\"\""; 
    public String inc_aurn_daily = "\"\""; 
    public String inc_emep_hourly = "\"\""; 
    public String inc_emep_daily = "\"\""; 
    public String inc_emep_daily_o3 = "\"\""; 
    public String inc_calnex = "\"\""; 
    public String inc_soas = "\"\""; 
    public String inc_special = "\"\""; 
    public String dates = "\"\""; 
    public String averaging = "\"n\""; 
    public String site = "\"\"";
    public String state = "\"\"";
    public String rpo = "\"\"";
    public String pca = "\"\"";
    public String clim_reg = "\"\"";
    public String world_reg = "\"\"";
    public String loc_setting = "\"\"";
    public String conf_line = "\"\"";
    public String pca_flag = "\"\"";
    public String bin_by_mod = "\"\"";
    public String inc_error = "\"\"";
    public String trend_line = "\"y\"";
    public int coverage_limit = 75;
    public String all_valid = "\"y\"";
    public String all_valid_amon = "\"\"";
    public String aggregate_data = "\"\"";
    public int num_obs_limit = 1;
    public String soccerplot_opt = "1";
    public String overlay_opt = "1"; 
    public String png_res = "300";
    public String x_axis_min = "NULL";
    public String x_axis_max = "NULL";
    public String y_axis_min = "NULL";
    public String y_axis_max = "NULL";
    public String nmb_max = "NULL";
    public String nme_max = "NULL";
    public String mb_max = "NULL";
    public String me_min = "NULL";
    public String me_max = "NULL";
    public String rmse_min = "NULL";
    public String rmse_max = "NULL";
    public String nmb_int = "NULL";
    public String nme_int = "NULL";
    public String bias_y_axis_min = "NULL";
    public String bias_y_axis_max = "NULL";
    public String density_zlim = "NULL";
    public String num_dens_bins = "NULL";
    public String max_limit = "70";
    public String x_label_angle = "0";
    public String inc_ranges = "\"y\"";
    public String inc_whiskers = "\"\"";
    public String inc_median_lines = "\"\"";
    public String remove_mean = "\"\"";
    public String overlap_boxes = "\"\"";
    public String avg_func = "mean";
    public String avg_func_name = "\"mean\"";
    public String stat_func = "\"\"";
    public String line_width = "\"1\"";
    public String custom_title = "\"\"";
    public String map_leg_size = "\"\"";
    public String stat_file = "\"\"";
    public String num_ints = "NULL";
    public String perc_error_max = "NULL";
    public String abs_error_max = "NULL";
    public String perc_range_min = "NULL";
    public String perc_range_max = "NULL";
    public String abs_range_min = "NULL";
    public String abs_range_max = "NULL";
    public String diff_range_min = "NULL";
    public String diff_range_max = "NULL";
    public String rmse_range_max = "NULL";
    public String hist_max = "NULL";
    public String quantile_min = "0.001";
    public String quantile_max = "0.999";
    public String symbsizfac = "1";
    public String plot_radius = "0";
    public String outlier_radius = "20"; 
    public String fill_opacity = "0.8";
    public String remove_negatives = "\"y\"";
    public String use_avg_stats = "\"\"";
    public String common_sites = "\"y\"";
    public String inc_legend = "\"y\"";
    public String inc_points = "\"y\"";
    public String inc_bias = "\"y\"";
    public String inc_rmse = "\"\"";
    public String inc_corr = "\"\"";
    public String use_var_mean = "\"\"";
    public String plot_cor = "\"\"";
    public String inc_FRM_adj = "\"y\"";
    public String use_median = "\"\"";
    public String stats_flags = "c(\"\",\"\",\"\",\"y\",\"\",\"\",\"\",\"y\",\"y\",\"\",\"\",\"\",\"\",\"\",\"\",\"y\",\"y\",\"\",\"\")";
    public String run_info_text = "\"y\"";
    public String png_from_html = "\"\"";
    public String plot_colors = "c(\"grey60\",\"red\",\"blue\",\"green4\",\"yellow3\",\"orange2\",\"brown\",\"purple\")";
    public String plot_colors2 = "c(\"grey60\",\"red\",\"blue\",\"green4\",\"yellow3\",\"orange2\",\"brown\",\"purple\")";
    public String plot_symbols = "c(16,17,15,18,11,8,4)";
    public String year_start = "\"\"";
    public String year_end = "\"\"";
    public String month_start = "\"\"";
    public String month_end = "\"\"";
    public String day_start = "\"\"";
    public String day_end = "\"\"";
    public String greyscale = "\"\"";
    public String inc_counties = "\"y\"";
    public int obs_per_day_limit = 0;
    public String figdir = "\"\"";
    public String map_type = "1";
    public String img_height = "\"NULL\"";
    public String img_width = "\"NULL\"";
    public String discovaq = "\"\"";
    public String site_id = "\"\"";
    public String start_hour = "\"\"";
    public String end_hour = "\"\"";
    public String season = "\"\"";
    public String month = "\"\"";
    public String poCode = "\"\"";
    public String lat1 = "";
    public String lat2 = "";
    public String lon1 = "";
    public String lon2 = "";
    public String zeroprecip = "\"\"";
    public String pid = "\"\"";
    public String ametptype = "\"\"";
    
    //file naming info
    public String project_id = "";
    public String species = "";
    public String pidx = "";
    
    //check helper variable
    public boolean isNetworkSelectedTemp = false;
    public boolean isNetworkSelected = false;
    public boolean gSiteSelector = false;
    
    //site selector
    public File siteFile;
    
    
//##############################################################################
//   MAIN FUNCTIONS 
//##############################################################################
    //creates a new AMETForm
    public AMETForm() {
        //Sets up how the aplication looks
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           errorWindow("Graphics Error1", "There was a problem with loading the 'look and feel' component.");
        }
        catch (ClassNotFoundException e) {
           errorWindow("Graphics Error2", "There was a problem with loading the 'look and feel' component.");
        }
        catch (InstantiationException e) {
           errorWindow("Graphics Error3", "There was a problem with loading the 'look and feel' component.");
        }
        catch (IllegalAccessException e) {
           errorWindow("Graphics Error4", "There was a problem with loading the 'look and feel' component.");
        }
        
        //Create the AMET Form
        initComponents();
        
        //Sets format for dates in the date picker
        DatePickerSettings startDateSettings = new DatePickerSettings();
        DatePickerSettings endDateSettings = new DatePickerSettings();
        startDateSettings.setFormatForDatesCommonEra("yyyy/MM/dd");
        endDateSettings.setFormatForDatesCommonEra("yyyy/MM/dd");
        startDatePicker.setSettings(startDateSettings);
        endDatePicker.setSettings(endDateSettings);
        
        //MYSQL query that populates the list of databases
        try {
            DBConnection db = new DBConnection();
            db.getDBConnection();
            
            db.query("SHOW databases;");
            ResultSet rs = db.getRS();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    databaseSpecificationComboBox.addItem(columnValue);
                }
            }
            db.closeDBConnection(); 
        } catch (SQLException e) {
            errorWindow("SQL Exception", "This error typically occurs when the application is not getting any info from the database. This could be because it cannot find the database on the network, the login credintials were incorrect, or the path to the database was incorrect.");
        } catch (NullPointerException e) {
            errorWindow("SQL/Null Pointer Exception", "This error typically occurs when the application is not getting any info from the database. This could be because it cannot find the database on the network, the login credintials were incorrect, or the path to the database was incorrect.");
        } 
    }
    
    //Saves and formats variables
    public void saveVariables() {
        figdir = "\"" + config.cache_amet + "\"";
        dbase = databaseSpecificationComboBox.getSelectedItem().toString();
        run_name1 = textFormat(projectComboBox1.getSelectedItem().toString());
        run_name2 = textFormat(projectComboBox2.getSelectedItem().toString());
        run_name3 = textFormat(projectComboBox3.getSelectedItem().toString());
        run_name4 = textFormat(projectComboBox4.getSelectedItem().toString());
        run_name5 = textFormat(projectComboBox5.getSelectedItem().toString());
        run_name6 = textFormat(projectComboBox6.getSelectedItem().toString());
        run_name7 = textFormat(projectComboBox7.getSelectedItem().toString());
        species_in = textFormat(speciesComboBox.getSelectedItem().toString());
        species = speciesComboBox.getSelectedItem().toString();
        isNetworkSelectedTemp = false; //sets temp false
        inc_csn = checkBoxFormat(csnCheckBox);
        inc_improve = checkBoxFormat(improveCheckBox);
        inc_castnet = checkBoxFormat(castnetCheckBox);
        inc_castnet_hr = checkBoxFormat(castnetHourlyCheckBox);
        inc_castnet_daily = checkBoxFormat(castnetDailyCheckBox);
        inc_castnet_drydep = checkBoxFormat(castnetDryDepCheckBox);
        inc_capmon = checkBoxFormat(capmonCheckBox);
        inc_naps = checkBoxFormat(napsHourlyCheckBox);
        inc_naps_daily_o3 = checkBoxFormat(napsDailyO3CheckBox);
        inc_nadp = checkBoxFormat(nadpCheckBox);
        inc_airmon_dep = checkBoxFormat(airmonCheckBox);
        inc_amon = checkBoxFormat(amonCheckBox);
        inc_aqs_hourly = checkBoxFormat(aqsHourlyCheckBox);
        inc_aqs_daily_o3 = checkBoxFormat(aqsDailyO3CheckBox);
        inc_aqs_daily = checkBoxFormat(aqsDailyCheckBox);
        inc_aqs_daily_oaqps = checkBoxFormat(aqsDailyOAQPSO3CheckBox);
        inc_aqs_daily_pm = checkBoxFormat(aqsDailyCheckBox);
        inc_search = checkBoxFormat(searchHourlyCheckBox);
        inc_search_daily = checkBoxFormat(searchDailyCheckBox);
        inc_aeronet = checkBoxFormat(aeronetCheckBox);
        inc_fluxnet = checkBoxFormat(fluxnetCheckBox);
        inc_noaa_esrl_o3 = checkBoxFormat(noaaESRLCheckBox);
        inc_toar = checkBoxFormat(toarCheckBox);
        inc_mdn = checkBoxFormat(mdnCheckBox);
        inc_tox = checkBoxFormat(toxicsHAPsCheckBox);
        inc_mod = checkBoxFormat(model_modelCheckBox);
        inc_admn = checkBoxFormat(admnCheckBox);
        inc_aganet = checkBoxFormat(aganetCheckBox);
        inc_airbase_hourly = checkBoxFormat(airbaseHourlyCheckBox);
        inc_airbase_daily = checkBoxFormat(airbaseDailyCheckBox);
        inc_aurn_hourly = checkBoxFormat(aurnHourlyCheckBox);
        inc_aurn_daily = checkBoxFormat(aurnDailyCheckBox);
        inc_emep_hourly = checkBoxFormat(emepHourlyCheckBox);
        inc_emep_daily = checkBoxFormat(emepDailyCheckBox);
        inc_emep_daily_o3 = checkBoxFormat(emepDailyO3CheckBox);
        inc_calnex = checkBoxFormat(calnexCheckBox);
        inc_soas = checkBoxFormat(soasCheckBox);
        inc_special = checkBoxFormat(specialCheckBox);
        isNetworkSelected = isNetworkSelectedTemp; //saves temp value, using this instead of a check function is much faster
        discovaq = textFormat(discoverWindowsComboBox.getSelectedItem().toString());
        averaging = textFormat(temporalAveragingComboBox.getSelectedItem().toString());
        clim_reg = textFormat(climateRegionComboBox.getSelectedItem().toString());
        world_reg = textFormat(worldRegionComboBox.getSelectedItem().toString());
        aggregate_data = checkBoxFormat(aggrigateDataCheckBox);
        custom_title = textFormat(customTitleTextField.getText());
        png_from_html = checkBoxFormat(staticPNGCheckBox);
        dates = "\"" + year_start + month_start + day_start + " to " + year_end + month_end + day_end + "\"";  
        start_hour = textFormat(startHourComboBox.getSelectedItem().toString());
        end_hour = textFormat(endHourComboBox.getSelectedItem().toString());
        season = textFormat(seasonalAnalysisComboBox.getSelectedItem().toString());
        month = textFormat(monthlyAnalysisComboBox.getSelectedItem().toString());
        poCode = textFormat(POCodeComboBox.getSelectedItem().toString());
        species_in = textFormat(speciesComboBox.getSelectedItem().toString());
        

        //state formatting
        state = stateComboBox.getSelectedItem().toString();
        if (state.equals("Include all states")) {
            state = "\"All\"";
        } else {
            state = "'" + state + "'";
        }
        
        //RPO formatting
        if (RPOComboBox.getSelectedItem().toString().equals("None")) {
            rpo = "\"None\"";
        } else {
            rpo = textFormat(RPOComboBox.getSelectedItem().toString());
        }
        
        //PCA formatting
        if (PCAComboBox.getSelectedItem().toString().equals("None")) {
            pca = "\"None\"";
        } else {
            pca = textFormat(PCAComboBox.getSelectedItem().toString());
        }
        
        //png_res formatting
        png_res = textFormat(pngPlotQualityComboBox.getSelectedItem().toString());
        switch(png_res) {
            case "Low":
                png_res = "150";
                break;
            case "Medium":
                png_res = "300";
                break;
            case "High":
                png_res = "600";
                break;  
            default:
                png_res = "300";
                break;
        }
        
        //Remove negatives formatting
        remove_negatives = negativeValuesComboBox.getSelectedItem().toString();
        switch(remove_negatives) {
            case "Yes":
                remove_negatives = "\"y\"";
                break;
            case "No":
                remove_negatives = "\"n\'";
        }
        
        //Temporal averagiong formatting
        averaging = temporalAveragingComboBox.getSelectedItem().toString();
        switch(averaging) {
            case "None":
                averaging = "\"n\"";
                break;
            case "Hour of Day Average":
                averaging = "\"h\"";
                break;
            case "Daily Average":
                averaging = "\"d\"";
                break;
            case "Monthly Average":
                averaging = "\"m\"";
                break;
            case "Year/Month Average":
                averaging = "\"ym\"";
                break;
            case "Seasonal Average":
                averaging = "\"s\"";
                break;
            case "Annual Average":
                averaging = "\"a\"";
                break;
            case "Entire Period Average":
                averaging = "\"e\"";
                break;
            case "Day of Week":
                averaging = "\"dow\"";
                break;
        }
        
        //Date formatting
        String sd = startDatePicker.getDateStringOrEmptyString();
        String ed = endDatePicker.getDateStringOrEmptyString();
        if (!sd.equals("")) {
            year_start = sd.substring(0, 4);
            month_start = sd.substring(5, 7);
            day_start = sd.substring(8, 10);
        }
        if (!ed.equals("")) {
            year_end = ed.substring(0, 4);
            month_end  = ed.substring(5, 7);
            day_end  = ed.substring(8, 10);
        }    
        
        //Image height and width formatting
        if (img_height.equals("NULL")) { heightTextField.getText();
        } else { img_height = textFormat(heightTextField.getText());}
        
        if (img_width.equals("NULL")) { widthTextField.getText();
        } else { img_width = textFormat(widthTextField.getText());}
        
        
        //Site ID formatting
        if (textFormat(siteIDTextField.getText()).equals("\"\"")) {
            site_id = "\"All\"";
        } else {
            site_id = textFormat(siteIDTextField.getText());
        }
        
        //Generate a random pid
        Random rand = new Random();
        pidx = String.valueOf(rand.nextInt(1000000));
        pid = "\"" + pidx + "\"";
        
        //ametptype formatting, details if PNGs are produced
        if (PNGCheckBox.isSelected()) {
            ametptype = "\"both\"";
        } 
        
//        inc_valid_amon; //does not exist?
//        stat_func; //does not exist?
//        map_leg_size; //does not exist?
//        aqs_co_network; //not hooked up/doesnt exist?
//        near_road; //not hooked up/doesnt exist?

        //Helper functions
        programFormat();
        queryFormat();
    }
    
    //Checks variables for common errors
    public boolean checkVariables() {
        boolean hasError = false;
        String error = "You must provide a response for the following fields: ";
        //Check if database is selected
        if (dbase.equals("Choose a Database")) { error = error + "\n- Database"; hasError = true; }
        //Check if project is selected
        if (project_id.equals("<Select a Database First>") || project_id.isEmpty() || project_id.equals("Choose a Project")) { error = error + "\n- Project"; hasError = true; }
        //Check if species is selected
        if (species.equals("<Select a Project First>") || species.equals("Choose a Species")) { error = error + "\n- Species"; hasError = true; }
        //Check if a network is selected
        if (!isNetworkSelected) { error = error + "\n- Network"; hasError = true; }
        //Check if program is selected
        if (run_program.equals("Choose AMET Script to Execute") || run_program.isEmpty()) { error = error + "\n- Program"; hasError = true; }
       
        //Check if time is conflicting
        
        if (hasError) {
            errorWindow("Input Error", error);
            return true;
        } else {
            return false;
        }
    }
    
    //Creates run_info.r file used by r scripts
    public void createRunInfo() {
        System.out.println(config.cache_amet + "/" + "run_info.R");
        NewFile file = new NewFile(true, config.cache_amet + "/" + "run_info.R");
        file.openWriter();
        file.writeTo(""
                + "### Indicate this as a MET database query ###\n"
                + "Met_query<- \"F\"\n"
                + "### Use MySQL database for queries\n"
                + "AMET_DB<- \"T\"\n"
                + "#### Main Database Query String ###\n"
                + "query<-\"" + query + "\"\n"
                + "### Process ID number ###\n"
                + "pid<-" + pid + "\n"
                + "### Database Name ###\n"
                + "dbase<-\"" + dbase + "\"\n"
                + "### Parameter Occurrence (PO) Code ###\n"
                + "POCode<-" + "\"\"\n"
                + "### Directory to write figures ###\n"
                + "figdir<-" + figdir + "\n"
                + "### Use only common sites among mulitple simulations ###\n"
                + "common_sites<-" + common_sites + "\n"
                + "### Species ###\n"
                + "species_in<-" + species_in + "\n"
                + "custom_species<-" + custom_species_name + "\n"
                + "custom_species_name<-" + custom_species_name + "\n"
                + "custom_units<-" + custom_units + "\n"
                + "### Project ID Name 1 ###\n"
                + "run_name1<-" + run_name1 + "\n"
                + "### Additional Run Names (used for model-to-model comparisons) ###\n"
                + "run_name2<-" + run_name2 + "\n"
                + "run_name3<-" + run_name2 + "\n"
                + "run_name4<-" + run_name2 + "\n"
                + "run_name5<-" + run_name2 + "\n"
                + "run_name6<-" + run_name2 + "\n"
                + "run_name7<-" + run_name2 + "\n"
                + "### Array of Observation Network Flags ###\n"
                + "#inc_networks<-\n"
                + "inc_csn<-" + inc_csn + "\n"
                + "inc_improve<-" + inc_improve + "\n"
                + "inc_castnet<-" + inc_castnet + "\n"
                + "inc_castnet_hr<-" + inc_castnet_hr + "\n"
                + "inc_castnet_daily<-" + inc_castnet_daily + "\n"
                + "inc_castnet_drydep<-" + inc_castnet_drydep + "\n"
                + "inc_capmon<-" + inc_capmon + "\n"
                + "inc_naps<-" + inc_naps + "\n"
                + "inc_naps_daily_o3<-" + inc_naps_daily_o3 + "\n"
                + "inc_nadp<-" + inc_nadp + "\n"
                + "inc_airmon_dep<-" + inc_airmon_dep + "\n"
                + "inc_amon<-" + inc_amon + "\n"
                + "inc_aqs_hourly<-" + inc_aqs_hourly + "\n"
                + "inc_aqs_daily_O3<-" + inc_aqs_daily_o3 + "\n"
                + "inc_aqs_daily<-" + inc_aqs_daily + "\n"
                + "inc_aqs_daily_pm<-" + inc_aqs_daily_pm + "\n"
                + "inc_search<-" + inc_search + "\n"
                + "inc_search_daily<-" + inc_search_daily + "\n"
                + "inc_aeronet<-" + inc_aeronet + "\n"
                + "inc_fluxnet<-" + inc_fluxnet + "\n"
                + "inc_noaa_esrl_o3<-" + inc_noaa_esrl_o3 + "\n"
                + "inc_toar<-" + inc_toar + "\n"
                + "inc_mdn<-" + inc_mdn + "\n"
                + "inc_tox<-" + inc_tox + "\n"
                + "inc_mod<-" + inc_mod + "\n"
                + "## European Networks ##\n"
                + "inc_admn<-" + inc_admn + "\n"
                + "inc_aganet<-" + inc_aganet + "\n"
                + "inc_airbase_hourly<-" + inc_airbase_hourly + "\n"
                + "inc_airbase_daily<-" + inc_airbase_daily + "\n"
                + "inc_aurn_hourly<-" + inc_aurn_hourly + "\n"
                + "inc_aurn_daily<-" + inc_aurn_daily + "\n"
                + "inc_emep_hourly<-" + inc_emep_hourly + "\n"
                + "inc_emep_daily<-" + inc_emep_daily + "\n"
                + "inc_emep_daily_o3<-" + inc_emep_daily_o3 + "\n"
                + "inc_namn<-" + "\"\"" + "\n" //this doesnt exist????
                + "## Campaigns ##\n"
                + "inc_calnex<-" + inc_calnex + "\n"
                + "inc_soas<-" + inc_soas + "\n"
                + "inc_special<-" + inc_special + "\n"
                + "### Universal Plot Options ###\n"
                + "dates<-" + dates + "\n"
                + "custom_title<-" + custom_title + "\n"
                + "png_from_html<-" + png_from_html + "\n"
                + "png_res<-" + png_res + "\n"
                + "x_label_angle<-" + x_label_angle + "\n"
                + "### Plotly Options ###\n"
                + "img_height<-" + img_height + "\n"
                + "img_width<-" + img_width + "\n"
                + "### Flag for Time Averaging ###\n"
                + "averaging<-" + averaging + "\n"
                + "remove_negatives<-" + remove_negatives + "\n"
                + "use_avg_stats<-" + use_avg_stats + "\n"
                + "aggregate_data<-" + aggregate_data + "\n"
                + "merge_statid_POC<-\"y\"\n"
                + "### Time Series Plot Options ###\n"
                + "inc_legend<-" + inc_legend + "\n"
                + "inc_points<-" + inc_points + "\n"
                + "inc_bias<-" + inc_bias + "\n"
                + "inc_rmse<-" + inc_rmse + "\n"
                + "inc_corr<-" + inc_corr + "\n"
                + "use_var_mean<-" + use_var_mean + "\n"
                + "obs_per_day_limit<-" + obs_per_day_limit + "\n"
                + "avg_func<-" + avg_func + "\n"
                + "avg_func_name<-" + avg_func_name + "\n"
                + "line_width<-" + line_width + "\n"
                + "### Kelly Plot Options ###\n"
                + "nmb_max<-" + nmb_max + "\n"
                + "nme_max<-" + nme_max + "\n"
                + "mb_max<-" + mb_max + "\n"
                + "me_min<-" + me_min + "\n"
                + "me_max<-" + me_max + "\n"
                + "rmse_min<-" + rmse_min + "\n"
                + "rmse_max<-" + rmse_max + "\n"
                + "nmb_int<-" + nmb_int + "\n"
                + "nme_int<-" + nme_int + "\n"
                + "### Unique color ranges for some plots ###\n"
                + "color_ranges<-\"n\"\n" //does not exist??
                + "### Monitoring Sites to Include ###\n"
                + "site<-" + site_id + "\n"
                + "### States to Include ###\n"
                + "state<-" + state + "\n"
                + "### Regional Planning Organizations to Include ###\n"
                + "rpo<-" + rpo + "\n"
                + "### Priciple Component Analysis (PCA) Region ###\n"
                + "pca<-" + pca + "\n"
                + "### Climate Region ###\n"
                + "clim_reg<-" + clim_reg + "\n"
                + "### Binned Plot Options ###\n"
                + "pca_flag<-" + pca_flag + "\n"
                + "bin_by_mod<-" + bin_by_mod + "\n"
                + "inc_error<-" + inc_error + "\n"
                + "### Landuse Category\n"
                + "loc_setting<-" + loc_setting + "\n"
                + "### Flag to Include or Remove Zero Precipitation Observations ###\n"
                + "zeroprecip<-" + zeroprecip + "\n" 
                + "### Numerical Limit for Data Completeness as minimum number of required observations (used when calulating site statistics or averages)###\n"
                + "coverage_limit<-" + coverage_limit + "\n"
                + "all_valid<-" + all_valid + "\n"
                + "all_valid_amon<-" + all_valid_amon + "\n"
                + "### Numerical Limit for Data Completeness as minimum number of required observations (used when calulating site statistics or averages)###\n"
                + "num_obs_limit<-" + num_obs_limit + "\n"
                + "### Flag for Soccer and Bugle Plots Setting NMB/NME or FB/FE ###\n"
                + "soccerplot_opt<-" + soccerplot_opt + "\n"
                + "### Flag for PAVE Overlay; 1=hourly, 2=daily ###\n"
                + "overlay_opt<-" + overlay_opt + "\n"
                + "### Flags for Confidence Lines to Plot on Scatterplots ###\n"
                + "conf_line<-" + conf_line + "\n"
                + "trend_line<-" + trend_line + "\n"
                + "### Scatterplot x and y axes limits ###\n"
                + "x_axis_min<-" + x_axis_min + "\n"
                + "x_axis_max<-" + x_axis_max + "\n"
                + "y_axis_min<-" + y_axis_min + "\n"
                + "y_axis_max<-" + y_axis_max + "\n"
                + "bias_y_axis_min<-" + bias_y_axis_min + "\n"
                + "bias_y_axis_max<-" + bias_y_axis_max + "\n"
                + "density_zlim<-" + density_zlim + "\n"
                + "num_dens_bins<-" + num_dens_bins + "\n"
                + "max_limit<-" + max_limit + "\n"
                + "### Hourly Boxplot Options ###\n"
                + "inc_whiskers<-" + inc_whiskers + "\n"
                + "inc_ranges<-" + inc_ranges + "\n"
                + "inc_median_lines<-" + inc_median_lines + "\n"
                + "remove_mean<-" + remove_mean + "\n"
                + "overlap_boxes<-" + overlap_boxes + "\n"
                + "### File containing list of stations created dynamically by the user ###\n"
                + "stat_file<-" + stat_file + "\n"
                + "### Spatial Plot Options ###\n"
                + "symbsizfac<-" + symbsizfac + "\n"
                + "plot_radius<-" + plot_radius + "\n"
                + "outlier_radius<-" + outlier_radius + "\n"
                + "fill_opacity<-" + fill_opacity + "\n"
                + "num_ints<-" + num_ints + "\n"
                + "perc_error_max<-" + perc_error_max + "\n"
                + "abs_error_max<-" + abs_error_max + "\n"
                + "rmse_range_max<-" + rmse_range_max + "\n"
                + "perc_range_min<-" + perc_range_min + "\n"
                + "perc_range_max<-" + perc_range_max + "\n"
                + "abs_range_min<-" + abs_range_min + "\n"
                + "abs_range_max<-" + abs_range_max + "\n"
                + "diff_range_min<-" + diff_range_min + "\n"
                + "diff_range_max<-" + diff_range_max + "\n"
                + "greyscale <-" + greyscale + "\n"
                + "inc_counties <-" + inc_counties + "\n"
                + "hist_max<-" + hist_max + "\n"
                + "map_type<-" + map_type + "\n"
                + "quantile_min<-" + quantile_min + "\n"
                + "quantile_max<-" + quantile_max + "\n"
                + "### Stacked Bar Charts Options ###\n"
                + "inc_FRM_adj<-" + inc_FRM_adj + "\n"
                + "use_median<-" + use_median + "\n"
                + "### Array of flags for which statistics to include on scatter plots ###\n"
                + "stats_flags<-" + stats_flags + "\n"
                + "### Flag to include run info text on plots ###\n"
                + "run_info_text<-" + run_info_text + "\n"
                + "### Set Scatter Plot Symbols and Colors ###\n"
                + "plot_colors<-" + plot_colors + "\n"
                + "plot_colors2<-" + plot_colors2 + "\n"
                + "plot_symbols<-" + plot_symbols + "\n"
//                + "plot_chars<-" + plot_chars + "\n"
                + "### Start and End Year/Month ###\n"
                + "year_start<-" + year_start + "\n"
                + "year_end<-" + year_end + "\n"
                + "month_start<-" + month_start + "\n"
                + "month_end<-" + month_end + "\n"
                + "day_start<-" + day_start + "\n"
                + "day_end<-" + day_end + "\n"
                + "start_date <- as.integer(paste(year_start,sprintf(\"%02d\",month_start),sprintf(\"%02d\",day_start),sep=\"\"))\n" //TODO: ask about these
                + "end_date   <- as.integer(paste(year_end,sprintf(\"%02d\",month_end),sprintf(\"%02d\",day_end),sep=\"\"))\n"
                + "#############################\n"
                + "### Setup Networks Arrays ###\n"
                + "#############################\n"
                + "network_names <- NULL\n"
                + "network_label <- NULL\n"
                + "if (inc_improve == \"y\") {\n"
                + "   network_names <- c(network_names,\"IMPROVE\")\n"
                + "   network_label <- c(network_label,\"IMPROVE\")\n"
                + "}\n"
                + "if (inc_csn == \"y\") {\n"
                + "   network_names <- c(network_names,\"CSN\")\n"
                + "   network_label <- c(network_label,\"CSN\")\n"
                + "}\n"
                + "if (inc_castnet == \"y\") {\n"
                + "   network_names <- c(network_names,\"CASTNET\")\n"
                + "   network_label <- c(network_label,\"CASTNET\")\n"
                + "}\n"
                + "if (inc_castnet_hr == \"y\") {\n"
                + "   network_names <- c(network_names,\"CASTNET_Hourly\")\n"
                + "   network_label <- c(network_label,\"CASTNET\")\n"
                + "}\n"
                + "if (inc_castnet_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"CASTNET_Daily\")\n"
                + "   network_label <- c(network_label,\"CASTNET\")\n"
                + "}\n"
                + "if (inc_castnet_drydep == \"y\") {\n"
                + "   network_names <- c(network_names,\"CASTNET_Drydep\")\n"
                + "   network_label <- c(network_label,\"CASTNET\")\n"
                + "}\n"
                + "if (inc_capmon == \"y\") {\n"
                + "   network_names <- c(network_names,\"CAPMON\")\n"
                + "   network_label <- c(network_label,\"CAPMON\")\n"
                + "}\n"
                + "if (inc_naps == \"y\") {\n"
                + "   network_names <- c(network_names,\"NAPS\")\n"
                + "   network_label <- c(network_label,\"NAPS\")\n"
                + "}\n"
                + "if (inc_naps_daily_o3 == \"y\") {\n"
                + "   network_names <- c(network_names,\"NAPS_Daily_O3\")\n"
                + "   network_label <- c(network_label,\"NAPS Daily\")\n"
                + "}\n"
                + "if (inc_nadp == \"y\") {\n"
                + "   network_names <- c(network_names,\"NADP\")\n"
                + "   network_label <- c(network_label,\"NADP\")\n"
                + "}\n"
                + "if (inc_airmon_dep == \"y\") {\n"
                + "   network_names <- c(network_names,\"AIRMON\")\n"
                + "   network_label <- c(network_label,\"AIRMON\")\n"
                + "}\n"
                + "if (inc_amon == \"y\") {\n"
                + "   network_names <- c(network_names,\"AMON\")\n"
                + "   network_label <- c(network_label,\"AMON\")\n"
                + "}\n"
                + "if (inc_aqs_hourly == \"y\") {\n"
                + "   network_names <- c(network_names,\"AQS_Hourly\")\n"
                + "   network_label <- c(network_label,\"AQS_Hourly\")\n"
                + "}\n"
                + "if (inc_aqs_daily_O3 == \"y\") {\n"
                + "   network_names <- c(network_names,\"AQS_Daily_O3\")\n"
                + "   network_label <- c(network_label,\"AQS_Daily\")\n"
                + "}\n"
                + "if (inc_aqs_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"AQS_Daily\")\n"
                + "   network_label <- c(network_label,\"AQS_Daily\")\n"
                + "}\n"
                + "if (inc_aqs_daily_pm == \"y\") {\n"
                + "   network_names <- c(network_names,\"AQS_Daily_PM\")\n"
                + "   network_label <- c(network_label,\"AQS_Daily\")\n"
                + "}\n"
                + "if (inc_search == \"y\") {\n"
                + "   network_names <- c(network_names,\"SEARCH\")\n"
                + "   network_label <- c(network_label,\"SEARCH\")\n"
                + "}\n"
                + "if (inc_search_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"SEARCH_Daily\")\n"
                + "   network_label <- c(network_label,\"SEARCH_Daily\")\n"
                + "}\n"
                + "if (inc_aeronet == \"y\") {\n"
                + "   network_names <- c(network_names,\"AERONET\")\n"
                + "   network_label <- c(network_label,\"AERONET\")\n"
                + "}\n"
                + "if (inc_fluxnet == \"y\") {\n"
                + "   network_names <- c(network_names,\"FLUXNET\")\n"
                + "   network_label <- c(network_label,\"FluxNet\")\n"
                + "}\n"
                + "if (inc_noaa_esrl_o3 == \"y\") {\n"
                + "   network_names <- c(network_names,\"NOAA_ESRL_O3\")\n"
                + "   network_label <- c(network_label,\"NOAA ESRL\")\n"
                + "}\n"
                + "if (inc_toar == \"y\") {\n"
                + "   network_names <- c(network_names,\"TOAR\")\n"
                + "   network_label <- c(network_label,\"TOAR\")\n"
                + "}\n"
                + "if (inc_mdn == \"y\") {\n"
                + "   network_names <- c(network_names,\"MDN\")\n"
                + "   network_label <- c(network_label,\"MDN\")\n"
                + "}\n"
                + "if (inc_tox == \"y\") {\n"
                + "   network_names <- c(network_names,\"Toxics\")\n"
                + "   network_label <- c(network_label,\"Toxics\")\n"
                + "}\n"
                + "if (inc_mod == \"y\") {\n"
                + "   network_names <- c(network_names,\"Model_Model\")\n"
                + "   network_label <- c(network_label,\"Mod v. Mod\")\n"
                + "}\n"
                + "if (inc_admn == \"y\") {\n"
                + "   network_names <- c(network_names,\"ADMN\")\n"
                + "   network_label <- c(network_label,\"ADMN\")\n"
                + "}\n"
                + "if (inc_aganet == \"y\") {\n"
                + "   network_names <- c(network_names,\"AGANET\")\n"
                + "   network_label <- c(network_label,\"AGANET\")\n"
                + "}\n"
                + "if (inc_airbase_hourly == \"y\") {\n"
                + "   network_names <- c(network_names,\"AirBase_Hourly\")\n"
                + "   network_label <- c(network_label,\"AirBase\")\n"
                + "}\n"
                + "if (inc_airbase_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"AirBase_Daily\")\n"
                + "   network_label <- c(network_label,\"AirBase\")\n"
                + "}\n"
                + "if (inc_aurn_hourly == \"y\") {\n"
                + "   network_names <- c(network_names,\"AURN_Hourly\")\n"
                + "   network_label <- c(network_label,\"AURN\")\n"
                + "}\n"
                + "if (inc_aurn_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"AURN_Daily\")\n"
                + "   network_label <- c(network_label,\"AURN\")\n"
                + "}\n"
                + "if (inc_emep_hourly == \"y\") {\n"
                + "   network_names <- c(network_names,\"EMEP_Hourly\")\n"
                + "   network_label <- c(network_label,\"EMEP\")\n"
                + "}\n"
                + "if (inc_emep_daily == \"y\") {\n"
                + "   network_names <- c(network_names,\"EMEP_Daily\")\n"
                + "   network_label <- c(network_label,\"EMEP\")\n"
                + "}\n"
                + "if (inc_calnex == \"y\") {\n"
                + "   network_names <- c(network_names,\"CALNEX\")\n"
                + "   network_label <- c(network_label,\"CALNEX\")\n"
                + "}\n"
                + "if (inc_soas == \"y\") {\n"
                + "   network_names <- c(network_names,\"SOAS\")\n"
                + "   network_label <- c(network_label,\"SOAS\")\n"
                + "}\n"
                + "if (inc_special == \"y\") {\n"
                + "   network_names <- c(network_names,\"Special\")\n"
                + "   network_label <- c(network_label,\"Special\")\n" 
                + "}\n"
                + "\n"
                + "\n"
                + "species <- unlist(strsplit(species_in,\",\"))\n"
                + "species <- gsub(\"_ob\",\"\",species)\n"
                + "total_networks<-length(network_names)\n"
                + "network1 <-network_names[[1]]\n"
                + "ametptype <-" + ametptype +"\n"
        );
        file.closeWriter();
    }
    
    //Dynamically executes the r scripts
    public void executeProgram() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        //Command executed in the windows cmd prompt
        
            Process p = null;
            String os = System.getProperty("os.name").toLowerCase();
            System.out.println(os);
            if (os.contains("win")) {
                try {
                    p = Runtime.getRuntime().exec("cmd /c"
                            + "set AMETBASE=" + config.amet_base + "&& "
                            + "set AMETRINPUT=" + config.cache_amet + "\\run_info.R&& "
                            + "set AMET_OUT=" + config.cache_amet + "&& "
                            + "set MYSQL_CONFIG=" + config.mysql_config + "&& "
                            + "set RSTUDIO_PANDOC=" + config.pandoc + "&& "
                            + config.rscript + " " + config.run_analysis + run_program
                    );
                    //error message
                    StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
                    //output message
                    StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "OUTPUT");

                    errorGobbler.start();
                    outputGobbler.start();

                    //any error?
                    int exitVal = p.waitFor();
                    System.out.println("ExitValue: " + exitVal);
                    
                } catch (IOException e) {
                    errorWindow("IOExcpetion", "There was a problem in running R_analysis_code through the command prompt. This is usually a problem caused by incorect paths in the config file"); 
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                
            } else {
                try {
                    System.out.println("linux");
                    p = Runtime.getRuntime().exec(new String[]{"csh","-c",""
                            + "setenv AMETBASE " + config.amet_base + "&& "
                            + "setenv AMETRINPUT " + config.cache_amet + "/run_info.R&& "
                            + "setenv AMET_OUT " + config.cache_amet + "&& "
                            + "setenv MYSQL_CONFIG " + config.mysql_config + "&& "
                            + "setenv RSTUDIO_PANDOC " + config.pandoc + "&& "
                            + config.rscript + " " + config.run_analysis + run_program
                    });
                } catch (IOException e) {
                    errorWindow("IOExcpetion", "There was a problem in running R_analysis_code through the command prompt. This is usually a problem caused by incorect paths in the config file"); 
                }
            }
            
            System.out.println("Command Pushed");
            
            
            
            //Prints cmd output if failed
//        try {
//            p.waitFor();
//            final int exitValue = p.waitFor();
//            if (exitValue == 0)
//                System.out.println("Successfully executed the command: ");
//            else {
//                System.out.println("Failed to execute the following command: due to the following error(s):");
//                try (final BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
//                    String line;
//                    if ((line = b.readLine()) != null)
//                        System.out.println(line);
//                } catch (final IOException e) {
//                    e.printStackTrace();
//                }                
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        System.out.println("End Execute Program");
        
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    //Displays the output
    public void outputWindow() {
        String prefix =  config.cache_amet + "/" + project_id + "_" + species + "_" + pidx + "_";
        String prefix2 = config.cache_amet + "/" + project_id + "_" + pidx + "_";
        OutputWindow output = new OutputWindow(this);
        
        System.out.println(run_program);
        System.out.println(prefix);
        System.out.println(prefix2);
        
        switch(run_program) {
//Scatterplot 
            case "AQ_Scatterplot.R": //Multiple Networks Model/Ob Scatterplot (select stats only)
                output.newFile(prefix + "scatterplot.pdf", "Mod/Ob Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot.png", "Mod/Ob Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_ggplot.R": //GGPlot Scatterplot (multi network, single run)
                output.newFile(prefix + "scatterplot_ggplot.pdf", "Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_ggplot.png", "Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot_ggplot.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_plotly.R": //Interactive Multiple Network Scatterplot
                output.newFile(prefix + "scatterplot.html", "Mod/Ob Scatterplot (HTML)");
                output.newFile(prefix + "scatterplot.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_multisim_plotly.R": //Interactive Multiple Simulation Scatterplot
                output.newFile(prefix + "scatterplot_multi.html", "Mod/Ob Scatterplot (HTML)");
                output.newFile(prefix + "scatterplot_multi.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_single.R": //Single Network Model/Ob Scatterplot (includes all stats)
                output.newFile(prefix + "scatterplot_single.pdf", "Mod/Ob Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_single.png", "Mod/Ob Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot_single.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_density.R": //Density Scatterplot (single run, single network)
                output.newFile(prefix + "scatterplot_density.pdf", "Mod/Ob Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_density.png", "Mod/Ob Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot_density.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_density_ggplot.R": //GGPlot Density Scatterplot (single run, single network)
                output.newFile(prefix + "scatterplot_density_ggplot.pdf", "Mod/Ob Scatterplot (PDF)</a>");
                output.newFile(prefix + "scatterplot_density_ggplot.png", "Mod/Ob Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot_density_ggplot.csv", "Scatterplot Data (CSV");
                break;
            case "AQ_Scatterplot_mtom.R": //Model/Model Scatterplot (multiple networks)
                output.newFile(prefix + "scatterplot_mtom.pdf", "Model/Model Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_mtom.png", "Model/Model Scatterplot (PNG)");
                break;
            case "AQ_Scatterplot_mtom_density.R": //Model/Model Density Scatterplot (single network)
                output.newFile(prefix + "scatterplot_mtom_density.pdf", "MtoM Density Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_mtom_density.png", "MtoM Density Scatterplot (PNG)");
                break;
            case "AQ_Scatterplot_percentiles.R": //Scatterplot of Percentiles (single network, single run)
                output.newFile(prefix + "scatterplot_percentiles.pdf", "Percentile Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_percentiles.png", "Percentile Scatterplot (PNG)");
                break;
            case "AQ_Scatterplot_skill.R": //Ozone Skill Scatterplot (single network, mult runs)
                output.newFile(prefix + "scatterplot_skill.pdf", "Skill Plot (PDF)");
                output.newFile(prefix + "scatterplot_skill.png", "Skill Plot (PNG)");
                output.newFile(prefix + "scatterplot_skill.csv", "Skill Plot Data (CSV)");
                break;
            case "AQ_Scatterplot_bins.R": //Binned MB &amp; RMSE Scatterplots (single net., mult. run)
                output.newFile(prefix + "scatterplot_bins.png", "Mean Bias Plot (PNG)");
                output.newFile(prefix + "scatterplot_bins.pdf", "Mean Bias Plot (PDF)");
                output.newFile(prefix + "scatterplot_bins.csv", "Raw Data File (CSV)");
                break;
            case "AQ_Scatterplot_bins_plotly.R": //Interactive Binned Plot (single net., mult. run)
                output.newFile(prefix + "scatterplot_bins.html", "Binned Plot (HTML)");
                output.newFile(prefix + "scatterplot_bins.csv", "Raw Data File (CSV)");
                break;
            case "AQ_Scatterplot_multi.R": //Multi Simulation Scatter plot (single network, mult runs)
                output.newFile(prefix + "scatterplot.pdf", "Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot.png", "Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot.csv", "Scatterplot Data (CSV)");
                break;
            case "AQ_Scatterplot_soil.R": //Soil Scatter plot (single network, mult runs)
                output.newFile(prefix + "scatterplot_soil.pdf", "Model/Ob Soil Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_soil.png", "Model/Ob Soil Scatterplot (PNG)");
                break;
//TimeSeries Plots
            case "AQ_Timeseries.R": //Time-Series Plot (single network, multiple sites averages)
                output.newFile(prefix + "bias_timeseries.pdf", "Time Series Plot (PDF)(Bias)");
                output.newFile(prefix + "rmse_timeseries.pdf", "Time Series Plot (PDF)(RMSE)");
                output.newFile(prefix + "corr_timeseries.pdf", "Time Series Plot (PDF)(Corr)");
                output.newFile(prefix + "bias_timeseries.png", "Time Series Plot (PNG)(Bias)");
                output.newFile(prefix + "rmse_timeseries.png", "Time Series Plot (PNG)(RMSE)");
                output.newFile(prefix + "corr_timeseries.png", "Time Series Plot (PNG)(Corr)");
                output.newFile(prefix + "timeseries.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_dygraph.R": //Dygraph Time-series Plot
                output.newFile(prefix + "timeseries_dygraph.html", "Time Series (HTML)");
                output.newFile(prefix + "timeseries_dygraph.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_plotly.R": //Plotly Multi-simulation Timeseries
                output.newFile(prefix + "timeseries.html", "Time Series (HTML)");
                output.newFile(prefix + "timeseries.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_networks_plotly.R": //Plotly Multi-network Timeseries
                output.newFile(prefix + "timeseries.html", "Time Series (HTML)");
                output.newFile(prefix + "timeseries.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_multi_networks.R": //Multi-Network Time-series Plot (mult. net., single run
                output.newFile(prefix + "timeseries.pdf", "Timeseries Plot (PDF)");
                output.newFile(prefix + "timeseries.png", "Timeseries Plot (PNG)");
                output.newFile(prefix + "timeseries.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_multi_species.R": //Multi-Species Time-series Plot (mult. species, single run)
                output.newFile(prefix2 + "timeseries.pdf", "Timeseries Plot (PDF)");
                output.newFile(prefix2 + "timeseries.png", "Timeseries Plot (PNG)");
                output.newFile(prefix2 + "timeseries.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Timeseries_MtoM.R": //Model-to-Model Time-series Plot (single net., multi run)
                output.newFile(prefix + "timeseries_mtom.pdf", "Timeseries Plot (PDF)");
                output.newFile(prefix + "timeseries_mtom.png", "Timeseries Plot (PNG)");
                output.newFile(prefix + "timeseries_mtom.csv", "Timeseries Data (CSV)");
                break;
            case "AQ_Monthly_Stat_Plot.R": //Year-long Monthly Statistics Plot (single network)
                output.newFile(prefix + "plot1.pdf", "Obs/Mod Plot (PDF)");
                output.newFile(prefix + "plot1.png", "Obs/Mod Plot (PNG)");
                output.newFile(prefix + "stats.csv", "Monthly Stat File (CSV)");
                output.newFile(prefix + "stats_plot1.pdf", "NMB/NME/Corr Plot (PDF)");
                output.newFile(prefix + "stats_plot1.png", "NMB/NME/Corr Plot (PNG)");
                output.newFile(prefix + "stats_plot2.pdf", "MdnB/MdnE/RMSE Plot (PDF)");
                output.newFile(prefix + "stats_plot2.png", "MdnB/MdnE/RMSE Plot (PNG)");
                break;
//Spatial Plots
            case "AQ_Stats_Plots.R": //Species Statistics and Spatial Plots (multi networks)
                output.newFile(prefix + "stats.csv", "CSV Domain Wide Statistics File");
                output.newFile(prefix + "sites_stats.csv", "CSV Site Specific Statistics File");
                output.newFile(prefix + "hourly_stats.csv", "CSV Hourly Specific Statistics File");
                output.newFile(prefix + "stats_data.csv", "Raw Query Data (CSV)");
                output.newFile(prefix + "stats_plots.zip", "Zip File Containing All Files");
                break;
//            case "AQ_Stats_Plots.R":
//                output.newFile(prefix + "stats_plot_NMB.png", "NMB (PNG)");
//                output.newFile(prefix + "stats_plot_NME.png", "NME (PNG)");
//                output.newFile(prefix + "stats_plot_MB.png", "MB (PNG)");
//                output.newFile(prefix + "stats_plot_ME.png", "ME (PNG)");
//                output.newFile(prefix + "stats_plot_FB.png", "FB (PNG)");
//                output.newFile(prefix + "stats_plot_FE.png", "FE (PNG)");
//                output.newFile(prefix + "stats_plot_RMSE.png", "RMSE (PNG)");
//                output.newFile(prefix + "stats_plot_Corr.png", "Corr (PNG)");
//                output.newFile(prefix + "stats_plot_NMB.pdf", "NMB (PDF)");
//                output.newFile(prefix + "stats_plot_NME.pdf", "NME (PDF)");
//                output.newFile(prefix + "stats_plot_MB.pdf", "MB (PDF)");
//                output.newFile(prefix + "stats_plot_ME.pdf", "ME (PDF)");
//                output.newFile(prefix + "stats_plot_FB.pdf", "FB (PDF)");
//                output.newFile(prefix + "stats_plot_FE.pdf", "FE (PDF)");
//                output.newFile(prefix + "stats_plot_RMSE.pdf", "RMSE (PDF)");
//                output.newFile(prefix + "stats_plot_Corr.pdf", "Corr (PDF)");
//                break;
            case "AQ_Stats_Plots_leaflet.R": //Interactive Species Statistics and Spatial Plots (multi networks)
                output.newFile(prefix + "stats.csv", "LINK to CSV Domain Wide Statistics File");
                output.newFile(prefix + "sites_stats.csv", "LINK to CSV Site Specific Statistics File");
                output.newFile(prefix + "stats_data.csv", "LINK to Raw Query Data (CSV)");
                output.newFile(prefix + "stats_plots.zip", "LINK to Zip File Containing All Files (.zip)");
                break;
            case "AQ_Plot_Spatial.R": //Spatial Plot (multi networks)
                output.newFile(prefix + "spatialplot_obs.png", "Obs (PNG)");
                output.newFile(prefix + "spatialplot_mod.png", "Model (PNG)");
                output.newFile(prefix + "spatialplot_diff.png", "Difference (PNG)");
                output.newFile(prefix + "spatialplot_ratio.png", "Ratio (PNG)");
                output.newFile(prefix + "spatialplot_obs.pdf", "Obs (PDF)");
                output.newFile(prefix + "spatialplot_mod.pdf", "Model (PDF)");
                output.newFile(prefix + "spatialplot_diff.pdf", "Difference (PDF)");
                output.newFile(prefix + "spatialplot_ratio.pdf", "Ratio (PDF)");
                break;
            case "AQ_Plot_Spatial_leaflet.R": //Interactive Spatial Plot (multi networks)
                output.newFile(prefix + "spatialplot_obs.html", "Obs (html)");
                output.newFile(prefix + "spatialplot_mod.html", "Mod (html)");
                output.newFile(prefix + "spatialplot_diff.html", "Diff (html)");
                break;
            case "AQ_Plot_Spatial_MtoM.R": //Model/Model Diff Spatial Plot (multi network, multi run)
                output.newFile(prefix + "spatialplot_MtoM_Diff_Avg.png", "MtoM Diff Avg Plot (PNG)");
                output.newFile(prefix + "spatialplot_MtoM_Diff_Max.png", "MtoM Diff Max Plot (PNG)");
                output.newFile(prefix + "spatialplot_MtoM_Diff_Min.png", "MtoM Diff Min Plot (PNG)");
                output.newFile(prefix + "spatialplot_MtoM_Diff_Avg.pdf", "MtoM Diff Avg Plot (PDF)");
                output.newFile(prefix + "spatialplot_MtoM_Diff_Max.pdf", "MtoM Diff Max Plot (PDF)");
                output.newFile(prefix + "spatialplot_MtoM_Diff_Min.pdf", "MtoM Diff Min Plot (PDF)");
                break;
            case "AQ_Plot_Spatial_MtoM_leaflet.R": //Interactive Model/Model Diff Spatial Plot (multi network, multi run)
                output.newFile(prefix + "spatialplot_mtom_diff_avg.html", "MtoM Avg Plot");
                output.newFile(prefix + "spatialplot_mtom_diff_max.html", "MtoM Max Plot");
                output.newFile(prefix + "spatialplot_mtom_diff_min.html", "MtoM Min Plot");
                break;
            case "AQ_Plot_Spatial_MtoM_Species.R": //Model/Model Species Diff Spatial Plot (multi network, multi run)
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_avg.png", "Avg Diff (PNG)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_max.png", "Max Diff (PNG)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_min.png", "Min Diff (PNG)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_perc.png", "Percent Diff (PNG)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_avg.pdf", "Avg Diff (PDF)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_max.pdf", "Max Diff (PDF)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_min.pdf", "Min Diff (PDF)");
                output.newFile(prefix2 + "spatialplot_mtom_species_diff_perc.pdf", "Percent Diff (PDF)");
                break;
            case "AQ_Plot_Spatial_Diff.R": //Spatial Plot of Bias/Error Difference (multi network, multi run)
                output.newFile(prefix + "spatial_plot_Bias_1.png", "Run 1 Bias Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Bias_1.pdf", "Run 1 Bias Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Error_1.png", "Run 1 Error Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Error_1.pdf", "Run 1 Error Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Bias_2.png", "Run 2 Bias Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Bias_2.pdf", "Run 2 Bias Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Error_2.png", "Run 2 Error Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Error_2.pdf", "Run 2 Error Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Bias_Diff.png", "Bias Difference Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Bias_Diff.pdf", "Bias Difference Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Error_Diff.png", "Error Difference Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Error_Diff.pdf", "Error Difference Plot (PDF)");
                output.newFile(prefix + "spatial_plot_Bias_Diff_Hist.png", "Bias Diff Hist Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Error_Diff_Hist.png", "Error Diff Hist Plot (PNG)");
                output.newFile(prefix + "spatial_plot_Error_Diff_Hist.pdf", "Error Diff Hist Plot (PDF)");
                output.newFile(prefix + "spatial_plot_diff.csv", "Plot Data File (CSV)");
                break;
            case "AQ_Plot_Spatial_Diff_leaflet.R": //Interactive Spatial Plot of Bias/Error Difference (multi networks)
                output.newFile(prefix + "spatialplot_bias_1.html", "Bias1");
                output.newFile(prefix + "spatialplot_bias_2.html", "Bias2");
                output.newFile(prefix + "spatialplot_bias_diff.html", "Bias Diff");
                output.newFile(prefix + "spatialplot_error_1.html", "Error1");
                output.newFile(prefix + "spatialplot_error_2.html", "Error2");
                output.newFile(prefix + "spatialplot_error_diff.html", "Error Diff");
                break;
            case "AQ_Plot_Spatial_Ratio.R": //Ratio Spatial Plot to total PM2.5 (multi network, multi run)
                output.newFile(prefix + "spatialplot_ratio_obs.png", "Obs Spatial Plot (PNG)");
                output.newFile(prefix + "spatialplot_ratio_mod.png", "Model Spatial Plot (PNG)");
                output.newFile(prefix + "spatialplot_ratio_diff.png", "Difference Plot (PNG)");
                output.newFile(prefix + "spatialplot_ratio_obs.pdf", "Obs Spatial Plot (PDF)");
                output.newFile(prefix + "spatialplot_ratio_mod.pdf", "Model Spatial Plot (PDF)");
                output.newFile(prefix + "spatialplot_ratio_diff.pdf", "Difference Plot (PDF)");
                break;
//Box Plots
            case "AQ_Boxplot.R": //Boxplot (single network, multi run)
                output.newFile(prefix + "boxplot_all.png", "Boxplot (PNG)");
                output.newFile(prefix + "boxplot_all.pdf", "Boxplot (PDF)");
                output.newFile(prefix + "boxplot_bias.png", "Bias Boxplot (PNG)");
                output.newFile(prefix + "boxplot_bias.pdf", "Bias Boxplot (PDF)");
                output.newFile(prefix + "boxplot_norm_bias.png", "Normalized Bias Boxplot (PNG)");
                output.newFile(prefix + "boxplot_norm_bias.pdf", "Normalized Bias Boxplot (PDF)");
                break;
            case "AQ_Boxplot_ggplot.R": //GGPlot Boxplot (single network, multi run)
                output.newFile(prefix + "boxplot_ggplot.png", "Boxplot (PNG)");
                output.newFile(prefix + "boxplot_ggplot.pdf", "Boxplot (PDF)");
                output.newFile(prefix + "boxplot_bias_ggplot.png", "Bias Boxplot (PNG)");
                output.newFile(prefix + "boxplot_bias_ggplot.pdf", "Bias Boxplot (PDF)");
                break;
            case "AQ_Boxplot_plotly.R": //Plotly Boxplot (single network, multi run)
                output.newFile(prefix + "boxplot.html", "Boxplot (HTML)");
                output.newFile(prefix + "boxplot_bias.html", "Bias Boxplot (HTML)");
                output.newFile(prefix + "boxplot_nmb.html", "NMB Boxplot (HTML)");
                output.newFile(prefix + "boxplot.csv", "Data (CSV)");
                break;
            case "AQ_Boxplot_DofW.R": //Day of Week Boxplot (single network, multiple runs)
                output.newFile(prefix + "boxplot_dow.pdf", "Day of Week Boxplot (PDF)");
                output.newFile(prefix + "boxplot_dow.png", "Day of Week Boxplot (PNG)");
                break;
            case "AQ_Boxplot_Hourly.R": //Hourly Boxplot (single network, multiple runs)
                output.newFile(prefix + "boxplot_hourly.pdf", "Boxplot (PDF format)");
                output.newFile(prefix + "boxplot_hourly.png", "Boxplot (PNG format)");
                output.newFile(prefix2 + "boxplot_data.csv", "Median Data (CSV format)");
                break;
            case "AQ_Boxplot_MDA8.R": //8hr Average Boxplot (single network, hourly data, can be slow)
                output.newFile(prefix + "boxplot_MDA8.pdf", "MDA8 Boxplot (PDF)");
                output.newFile(prefix + "boxplot_MDA8.png", "MDA8 Boxplot (PNG)");
                break;
            
            case "AQ_Boxplot_Roselle.R": //Roselle Boxplot (single network, multiple simulations)
                output.newFile(prefix + "boxplot_roselle.png", "Roselle Boxplot (PNG)");
                output.newFile(prefix + "boxplot_bias_roselle.png", "Roselle Boxplot Bias (PNG)");
                output.newFile(prefix + "boxplot_roselle.pdf", "Roselle Boxplot (PDF)");
                output.newFile(prefix + "boxplot_bias_roselle.pdf", "Roselle Boxplot Bias (PDF)");
                break;
            case "AQ_Stacked_Barplot.R": //PM2.5 Stacked Bar Plot (CSN or IMPROVE, multi run)
                output.newFile(prefix2 + "stacked_barplot.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_AE6.R": //PM2.5 Stacked Bar Plot AE6 (CSN or IMPROVE, multi run)
                output.newFile(prefix2 + "stacked_barplot_AE6.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_AE6.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_AE6.csv", "Barplot Data (CSV");
                break;
            case "AQ_Stacked_Barplot_AE6_plotly.R": //Interactive Stacked Bar Plot
                output.newFile(prefix2 + "stacked_barplot_AE6.html", "Stacked Barplot (HTML)");
                output.newFile(prefix2 + "stacked_barplot_AE6_data.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_AE6_ggplot.R": //GGPlot Stacked Bar Plot
                output.newFile(prefix2 + "stacked_barplot_AE6_ggplot.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_AE6_ggplot.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_AE6_data_ggplot.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_AE6_ts.R": //Stacked Bar Plot Time Series
                output.newFile(prefix2 + "stacked_barplot_AE6_ts.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_AE6_ts.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_AE6_ts.html", "Stacked Barplot (HTML)");
                output.newFile(prefix2 + "stacked_barplot_AE6_data_ts.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_soil.R": //Soil Stacked Bar Plot (CSN or IMPROVE,multi run)
                output.newFile(prefix2 + "stacked_barplot_soil.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_soil.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_soil.csv", "Barplot Data (CSV)");
                break; 
            case "AQ_Stacked_Barplot_soil_multi.R": //Soil Stacked Bar Plot Multi (CSN and IMPROVE,single run)
                output.newFile(prefix2 + "stacked_barplot_soil.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_soil.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_soil.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_panel.R": //Multi-Panel Stacked Bar Plot (full year data required)
                output.newFile(prefix2 + "stacked_barplot_panel.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_panel.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_panel.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_panel_AE6.R": //Multi-Panel Stacked Bar Plot AE6 (full year data)
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.csv", "Barplot Data (CSV)");
                break;
            case "AQ_Stacked_Barplot_panel_AE6_multi.R": //Multi-Panel, Mulit Run Stacked Bar Plot AE6 (full year data)
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.png", "Stacked Barplot (PNG)");
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.pdf", "Stacked Barplot (PDF)");
                output.newFile(prefix2 + "stacked_barplot_panel_AE6.csv", "Barplot Data (CSV)");
                break;
//MISC Scripts
            case "AQ_Kellyplot.R": //Kelly Plot (single species, single network, full year data)
                output.newFile(prefix + "Kellyplot_NMB.png", "NMB (PNG)");
                output.newFile(prefix + "Kellyplot_NME.png", "NME (PNG)");
                output.newFile(prefix + "Kellyplot_MB.png", "MB (PNG)");
                output.newFile(prefix + "Kellyplot_ME.png", "ME (PNG)");
                output.newFile(prefix + "Kellyplot_RMSE.png", "RMSE (PNG)");
                output.newFile(prefix + "Kellyplot_Corr.png", "Corr (PNG)");
                output.newFile(prefix + "Kellyplot_NMB.pdf", "NMB (PDF)");
                output.newFile(prefix + "Kellyplot_NME.pdf", "NME (PDF)");
                output.newFile(prefix + "Kellyplot_MB.pdf", "MB (PDF)");
                output.newFile(prefix + "Kellyplot_ME.pdf", "ME (PDF)");
                output.newFile(prefix + "Kellyplot_RMSE.pdf", "RMSE (PDF)");
                output.newFile(prefix + "Kellyplot_Corr.pdf", "Corr (PDF)");
                break;
            case "AQ_Kellyplot_multisim.R": //Multisim Kelly Plot (single species, single network, multi sim)
                output.newFile(prefix + "Kellyplot_multi_NMB.png", "NMB (PNG)");
                output.newFile(prefix + "Kellyplot_multi_NME.png", "NME (PNG)");
                output.newFile(prefix + "Kellyplot_multi_MB.png", "MB (PNG)");
                output.newFile(prefix + "Kellyplot_multi_ME.png", "ME (PNG)");
                output.newFile(prefix + "Kellyplot_multi_RMSE.png", "RMSE (PNG)");
                output.newFile(prefix + "Kellyplot_multi_Corr.png", "Corr (PNG)");
                output.newFile(prefix + "Kellyplot_multi_NMB.pdf", "NMB (PDF)");
                output.newFile(prefix + "Kellyplot_multi_NME.pdf", "NME (PDF)");
                output.newFile(prefix + "Kellyplot_multi_MB.pdf", "MB (PDF)");
                output.newFile(prefix + "Kellyplot_multi_ME.pdf", "ME (PDF)");
                output.newFile(prefix + "Kellyplot_multi_FB.pdf", "FB (PDF)");
                output.newFile(prefix + "Kellyplot_multi_FE.pdf", "FE (PDF)");
                output.newFile(prefix + "Kellyplot_multi_RMSE.pdf", "RMSE (PDF)");
                output.newFile(prefix + "Kellyplot_multi_Corr.pdf", "Corr (PDF)");
                break;
            case "AQ_Stats.R": //Species Statistics (multi species, single network)
                output.newFile(prefix2 + "rawdata.csv", "Raw Network Data (CSV)");
                break;
            case "AQ_Raw_Data.R": //Create raw data csv file (single network, single simulation)
                output.newFile(prefix2 + "rawdata.csv", "Raw Network Data (CSV)");
                break;
            case "AQ_Soccerplot.R": //Soccergoal plot (multiple networks)
                output.newFile(prefix2 + "soccerplot.png", "Soccergoal Plot (PNG)");
                output.newFile(prefix2 + "soccerplot.pdf", "Soccergoal Plot (PDF)");
                break; 
            case "AQ_Bugleplot.R": //"Bugle" plot (multiple networks)
                output.newFile(prefix + "bugle_plot_bias.png", "Bugle Plot Bias (PNG)");
                output.newFile(prefix + "bugle_plot_error.png", "Bugle Plot Error (PNG)");
                output.newFile(prefix + "bugle_plot_error.pdf", "Bugle Plot Error (PDF)");
                break;
            case "AQ_Histogram.R": //Histogram (single network/species only)
                output.newFile(prefix + "histogram.pdf", "Histogram (PDF)");
                output.newFile(prefix + "histogram_bias.R", "Bias (PDF)");
                break;
            case "AQ_Temporal_Plots.R": //CDF, Q-Q, Taylor Plots (single network, multi run)
                output.newFile(prefix + "ecdf.pdf", "ECDF (PDF)");
                output.newFile(prefix + "qq.pdf", "QQ (PDF)");     
                break;
//Expiramental Scripts
            case "AQ_Overlay_File.R": //Create PAVE/VERDI Obs Overlay File (hourly/daily data only)
                output.newFile(prefix2 + "overlay.ncf", "PAVE Obs Overlay File (IOAPI file)");
                break;
            case "AQ_Scatterplot_log.R": //Log-Log Model/Ob Scatterplot (multiple networks)
                output.newFile(prefix + "scatterplot_log.pdf", "Model/Ob Log-Log Scatterplot (PDF)");
                output.newFile(prefix + "scatterplot_log.png", "Model/Ob Log-Log Scatterplot (PNG)");
                output.newFile(prefix + "scatterplot_log.csv", "Scatterplot Data (CSV File)");
                break;
            case "AQ_Spectral_Analysis.R": //Spectral Analysis (single network, single run, experimental)
                output.newFile(prefix + "spectrum.png", "(PNG)");
                output.newFile(prefix + "spectrum.pdf", "(PDF)");
                output.newFile(prefix + "spectrum_all.pdf", "(PDF)");
                break;
//            case "AQ_Plot_Spatial_Ratio.R": //PM Ratio Spatial Plot (multi network, single run)
//                //TODO
//                output.newFile(prefix + "", "");
//                break;
            default:
               errorWindow("Program does not exist", "Cannot generate output in outputWindow() method");
               output.dispose();
        }
        output.checkIfSuccess();
        output.setVisible(true);
    }
    
    
//##############################################################################
//    HELPER FUNCTIONS
//##############################################################################
    //Returns <""> for R if empty, e;se returns value
    public String checkBoxFormat(javax.swing.JCheckBox checkBox) {
        if (checkBox.isSelected()) {
            isNetworkSelectedTemp = true;
            return "\"y\""; //read as return ""y""
        } else {
            return "\"\"";
        }
    }
    
    //Returns <""> for R if empty, else returns value
    public String textFormat(String str){
        if (str.equals("") || str.equals(" ") || str.equals("None")) {
            return "\"\"";
        } else {
            return "\"" + str + "\"";
        }
    }
    
    //Returns 0 is empty, else returns value
    public int numFormat(String str) {
        try {
            return Integer.parseInt(str);
        } catch(Exception e) {
            return 0;
        }
    }
    
    //Returns NULL if empty, else returns value
    public String numNullFormat(String str) {
        if (str.isEmpty() || str.equals(" ") || str == null) {
            return "NULL";
        } else {
            return str;
        }
    }
    
    //assigning program names values to run_program combo box fields
    private void programFormat() {
        String str = programComboBox.getSelectedItem().toString();
        switch(str) {
            //Scatter Plots
            case "Multiple Networks Model/Ob Scatterplot (select stats only)":
                run_program = "AQ_Scatterplot.R";
                break;
            case "GGPlot Scatterplot (multi network, single run)":
                run_program = "AQ_Scatterplot_ggplot.R";
                break;
            case "Interactive Multiple Network Scatterplot":
                run_program = "AQ_Scatterplot_plotly.R";
                break;
            case "Interactive Multiple Simulation Scatterplot":
                run_program = "AQ_Scatterplot_multisim_plotly.R";
                break;
            case "Single Network Model/Ob Scatterplot (includes all stats)":
                run_program = "AQ_Scatterplot_single.R";
                break;
            case "Density Scatterplot (single run, single network)":
                run_program = "AQ_Scatterplot_density.R";
                break;
            case "GGPlot Density Scatterplot (single run, single network)":
                run_program = "AQ_Scatterplot_density_ggplot.R";
                break;
            case "Model/Model Scatterplot (multiple networks)":
                run_program = "AQ_Scatterplot_mtom.R";
                break;
            case "Model/Model Density Scatterplot (single network)":
                run_program = "AQ_Scatterplot_mtom_density.R";
                break;
            case "Scatterplot of Percentiles (single network, single run)":
                run_program = "AQ_Scatterplot_percentiles.R";
                break;
            case "Ozone Skill Scatterplot (single network, mult runs)":
                run_program = "AQ_Scatterplot_skill.R";
                break;
            case "Binned MB &amp; RMSE Scatterplots (single net., mult. run)":
                run_program = "AQ_Scatterplot_bins.R";
                break;
            case "Interactive Binned Plot (single net., mult. run)":
                run_program = "AQ_Scatterplot_bins_plotly.R";
                break;
            case "Multi Simulation Scatter plot (single network, mult runs)":
                run_program = "AQ_Scatterplot_multi.R";
                break;
            case "Soil Scatter plot (single network, mult runs)":
                run_program = "AQ_Scatterplot_soil.R";
                break;
            //Time-series plots
            case "Time-Series Plot (single network, multiple sites averages)":
                run_program = "AQ_Timeseries.R";
                break;
            case "Dygraph Time-series Plot":
                run_program = "AQ_Timeseries_dygraph.R";
                break;
            case "Plotly Multi-simulation Timeseries":
                run_program = "AQ_Timeseries_plotly.R";
                break;
            case "Plotly Multi-network Timeseries":
                run_program = "AQ_Timeseries_networks_plotly.R";
                break;
            case "Multi-Network Time-series Plot (mult. net., single run)":
                run_program = "AQ_Timeseries_multi_networks.R";
                break;
            case "Multi-Species Time-series Plot (mult. species, single run)":
                run_program = "AQ_Timeseries_multi_species.R";
                break;
            case "Model-to-Model Time-series Plot (single net., multi run)":
                run_program = "AQ_Timeseries_MtoM.R";
                break;
            case "Year-long Monthly Statistics Plot (single network)":
                run_program = "AQ_Monthly_Stat_Plot.R";
                break;
            //Spatial Plots
            case "Species Statistics and Spatial Plots (multi networks)":
                run_program = "AQ_Stats_Plots.R";
                break;
            case "Interactive Species Statistics and Spatial Plots (multi networks)":
                run_program = "AQ_Stats_Plots_leaflet.R";
                break;
            case "Spatial Plot (multi networks)":
                run_program = "AQ_Plot_Spatial.R";
                break;
            case "Interactive Spatial Plot (multi networks)":
                run_program = "AQ_Plot_Spatial_leaflet.R";
                break;
            case "Model/Model Diff Spatial Plot (multi network, multi run)":
                run_program = "AQ_Plot_Spatial_MtoM.R";
                break;
            case "Interactive Model/Model Diff Spatial Plot (multi network, multi run)":
                run_program = "AQ_Plot_Spatial_MtoM_leaflet.R";
                break;
            case "Model/Model Species Diff Spatial Plot (multi network, multi run)":
                run_program = "AQ_Plot_Spatial_MtoM_Species.R";
                break;
            case "Spatial Plot of Bias/Error Difference (multi network, multi run)":
                run_program = "AQ_Plot_Spatial_Diff.R";
                break;
            case "Interactive Spatial Plot of Bias/Error Difference (multi networks)":
                run_program = "AQ_Plot_Spatial_Diff_leaflet.R";
                break;
            case "Ratio Spatial Plot to total PM2.5 (multi network, multi run)":
                run_program = "AQ_Plot_Spatial_Ratio.R";
                break;
            //Boxplot
            case "Boxplot (single network, multi run)":
                run_program = "AQ_Boxplot.R";
                break;
            case "GGPlot Boxplot (single network, multi run)":
                run_program = "AQ_Boxplot_ggplot.R";
                break;
            case "Plotly Boxplot (single network, multi run)":
                run_program = "AQ_Boxplot_plotly.R";
                break;
            case "Day of Week Boxplot (single network, multiple runs)":
                run_program = "AQ_Boxplot_DofW.R";
                break;
            case "Hourly Boxplot (single network, multiple runs)":
                run_program = "AQ_Boxplot_Hourly.R";
                break;
            case "8hr Average Boxplot (single network, hourly data, can be slow)":
                run_program = "AQ_Boxplot_MDA8.R";
                break;
            case "Roselle Boxplot (single network, multiple simulations)":
                run_program = "AQ_Boxplot_Roselle.R";
                break;
            //Stacked Bar Plots
            case "PM2.5 Stacked Bar Plot (CSN or IMPROVE, multi run)":
                run_program = "AQ_Stacked_Barplot.R";
                break;
            case "PM2.5 Stacked Bar Plot AE6 (CSN or IMPROVE, multi run)":
                run_program = "AQ_Stacked_Barplot_AE6.R";
                break;
            case "Interactive Stacked Bar Plot":
                run_program = "AQ_Stacked_Barplot_AE6_plotly.R";
                break;
            case "GGPlot Stacked Bar Plot":
                run_program = "AQ_Stacked_Barplot_AE6_ggplot.R";
                break;
            case "Stacked Bar Plot Time Series":
                run_program = "AQ_Stacked_Barplot_AE6_ts.R";
                break;
            case "Soil Stacked Bar Plot (CSN or IMPROVE,multi run)":
                run_program = "AQ_Stacked_Barplot_soil.R";
                break;
            case "Soil Stacked Bar Plot Multi (CSN and IMPROVE,single run)":
                run_program = "AQ_Stacked_Barplot_soil_multi.R";
                break;
            case "Multi-Panel Stacked Bar Plot (full year data required)":
                run_program = "AQ_Stacked_Barplot_panel.R";
                break;
            case "Multi-Panel Stacked Bar Plot AE6 (full year data)":
                run_program = "AQ_Stacked_Barplot_panel_AE6.R";
                break;
            case "Multi-Panel, Mulit Run Stacked Bar Plot AE6 (full year data)":
                run_program = "AQ_Stacked_Barplot_panel_AE6_multi.R";
                break;
            //Misc Plots
            case "Kelly Plot (single species, single network, full year data)":
                run_program = "AQ_Kellyplot.R";
                break;
            case "Multisim Kelly Plot (single species, single network, multi sim)":
                run_program = "AQ_Kellyplot_multisim.R";
                break;
            case "Species Statistics (multi species, single network)":
                run_program = "AQ_Stats.R";
                break;
            case "Create raw data csv file (single network, single simulation)":
                run_program = "AQ_Raw_Data.R";
                break;
            case "\"Soccergoal\" plot (multiple networks)":
                run_program = "AQ_Soccerplot.R";
                break;
            case "\"Bugle\" plot (multiple networks)":
                run_program = "AQ_Bugleplot.R";
                break;
            case "Histogram (single network/species only)":
                run_program = "AQ_Histogram.R";
                break;
            case "CDF, Q-Q, Taylor Plots (single network, multi run)":
                run_program = "AQ_Temporal_Plots.R";
                break;
            //Expiramental
            case "Create PAVE/VERDI Obs Overlay File (hourly/daily data only)":
                run_program = "AQ_Overlay_File.R";
                break;
            case "Log-Log Model/Ob Scatterplot (multiple networks)":
                run_program = "AQ_Scatterplot_log.R";
                break;
            case "Spectral Analysis (single network, single run, experimental)":
                run_program = "AQ_Spectral_Analysis.R";
                break;
            case "PM Ratio Spatial Plot (multi network, single run)":
                run_program = "AQ_Plot_Spatial_Ratio.R";
                break;
            default:
                
        }
    }
    
    //assigning values to hour feilds
    private String hourFormat(String str) {
        String hour = "";
        switch(str) {
            case "\"12AM\"":
                hour = "00";
                break;
            case "\"1AM\"":
                hour = "01";
                break;
            case "\"2AM\"":
                hour = "02";
                break;
            case "\"3AM\"":
                hour = "03";
                break;
            case "\"4AM\"":
                hour = "04";
                break;
            case "\"5AM\"":
                hour = "05";
                break;
            case "\"6AM\"":
                hour = "06";
                break;
            case "\"7AM\"":
                hour = "07";
                break;
            case "\"8AM\"":
                hour = "08";
                break;
            case "\"9AM\"":
                hour = "09";
                break;
            case "\"10AM\"":
                hour = "10";
                break;
            case "\"11AM\"":
                hour = "11";
                break;
            case "\"12PM\"":
                hour = "12";
                break;
            case "\"1PM\"":
                hour = "13";
                break;
            case "\"2PM\"14":
                hour = "";
                break;
            case "\"3PM\"":
                hour = "15";
                break;
            case "\"4PM\"":
                hour = "16";
                break;
            case "\"5PM\"":
                hour = "17";
                break;
            case "\"6PM\"":
                hour = "18";
                break;
            case "\"7PM\"":
                hour = "19";
                break;
            case "\"8PM\"":
                hour = "20";
                break;
            case "\"9PM\"":
                hour = "21";
                break;
            case "\"10PM\"":
                hour = "22";
                break;
            case "\"11PM\"":
                hour = "23";
                break;
            default:
                break;
        }
        return hour;
    }

    //general error window call
    private void errorWindow(String title, String message) {
        ErrorWindow ew = new ErrorWindow(title, message);
        ew.setVisible(true);
    }

    //generates my sql query with parameters
    private void queryFormat() {
        String str = " and s.stat_id=d.stat_id";
        //states
        if (!state.equals("\"All\"")) { 
            str = str + " and s.state=" + state;
        }
        //TODO
        //zeroprecip
//        if (zeroprecip.equals("\"\"")) { str = str + " and d.precip_ob > 0";}
        //inc_valid
//        if (inc_valid.equals("\"y\"")) { str = + " and d.valid_code != ' '"; }
        //inc_valid_amon
        //RPO
        switch(rpo) {
            case "\"VISTAS\"":
                str = str + " and (s.state='AL' or s.state='FL' or s.state='GA' or s.state='KY' or s.state='MS' or s.state='NC' or s.state='SC' or s.state='TN' or s.state='VA' or s.state='WV')";
                break;
            case "\"CENRAP\"":
                str = str + " and (s.state='NE' or s.state='KS' or s.state='OK' or s.state='TX' or s.state='MN' or s.state='IA' or s.state='MO' or s.state='AR' or s.state='LA')";
                break;
            case "\"MANE=VU\"":
                str = str + " and (s.state='CT' or s.state='DE' or s.state='DC' or s.state='ME' or s.state='MD' or s.state='MA' or s.state='NH' or s.state='NJ' or s.state='NY' or s.state='PA' or s.state='RI' or s.state='VT')";
                break;
            case "\"LADCO\"":
                str = str + " and (s.state='IL' or s.state='IN' or s.state='MI' or s.state='OH' or s.state='WI')";
                break;
            case "\"WRAP\"":
                str = str + " and (s.state='AK' or s.state='CA' or s.state='OR' or s.state='WA' or s.state='AZ' or s.state='NM' or s.state='CO' or s.state='UT' or s.state='WY' or s.state='SD' or s.state='ND' or s.state='MT' or s.state='ID' or s.state='NV')";
                break;
            default:
                break;
        }
        //PCA
        switch(pca) {
            case "\"Northeast (Ozone)\"":
                str = str + " and (s.state='ME' or s.state='NH' or s.state='VT' or s.state='MA' or s.state='NY' or s.state='NJ' or s.state='MD' or s.state='DE' or s.state='CT' or s.state='RI' or s.state='PA' or s.state='DC')";
                break;
            case "\"Great Lakes (Ozone)\"":
                str = str + " and (s.state='MI' or s.state='IL' or s.state='OH' or s.state='IN' or s.state='WI')";
                break;
            case "\"Mid-Atlantic (Ozone)\"":
                str = str + " and (s.state='WV' or s.state='KY' or s.state='TN' or s.state='VA' or s.state='NC' or s.state='SC' or s.state='GA' or s.state='AL')";
                break;
            case "\"Southwest (Ozone)\"":
                str = str + " and (s.state='LA' or s.state='MS' or s.state='MO' or s.state='TX' or s.state='OK')";
                break;
            case "\"Northeast (Aerosols)\"":
                str = str + " and (s.state='ME' or s.state='NH' or s.state='VT' or s.state='MA' or s.state='NY' or s.state='NJ' or s.state='MD' or s.state='DE' or s.state='CT' or s.state='RI' or s.state='PA' or s.state='DC' or s.state='VA' or s.state='WV')";
                break;
            case "\"Great Lakes (Aerosols)\"":
                str = str + " and (s.state='OH' or s.state='MI' or s.state='IN' or s.state='IL' or s.state='WI')";
                break;
            case "\"Southeast (Aerosols)\"":
                str = str + " and (s.state='NC' or s.state='SC' or s.state='GA' or s.state='FL')";
                break;
            case "\"Lower Midwest (Aerosols)\"":
                str = str + " and (s.state='KY' or s.state='TN' or s.state='MS' or s.state='AL' or s.state='LA' or s.state='MO' or s.state='OK' or s.state='AR')";
                break;
            case "\"West (Aerosols)\"":
                //TODO: set up West
                break;
            default:
                break;
        }
        //Climate Regions
        switch(clim_reg) {
            case "\"Central\"":
                str = str + " and (s.state='IL' or s.state='IN' or s.state='KY' or s.state='MO' or s.state='OH' or s.state='TN' or s.state='WV')";
                break;
            case "\"East-North Central\"":
                str = str + " and (s.state='IA' or s.state='MI' or s.state='MN' or s.state='WI')";
                break;
            case "\"Northeast\"":
                str = str + " and (s.state='CT' or s.state='DE' or s.state='ME' or s.state='MD' or s.state='MA' or s.state='NH' or s.state='NJ' or s.state='NY' or s.state='PA' or s.state='RI' or s.state='VT')";
                break;
            case "\"Northwest\"":
                str = str + " and (s.state='ID' or s.state='OR' or s.state='WA')";
                break;
            case "\"South\"":
                str = str + " and (s.state='AR' or s.state='KS' or s.state='LA' or s.state='MS' or s.state='OK' or s.state='TX')";
                break;
            case "\"Southeast\"":
                str = str + " and (s.state='AL' or s.state='FL' or s.state='GA' or s.state='SC' or s.state='NC' or s.state='VA')";
                break;
            case "\"Southwest\"":
                str = str + " and (s.state='AZ' or s.state='CO' or s.state='NM' or s.state='UT')";
                break;
            case "\"West\"":
                str = str + " and (s.state='CA' or s.state='NV')";
                break;
            case "\"West-North Central\"":
                str = str + " and (s.state='MT' or s.state='NE' or s.state='ND' or s.state='SD' or s.state='WY')";
                break;
            default:
                break;
        }
        //DISCOVER-AQ REGIONS
        switch(discovaq) {
            case "\"4-km Window\"":
                str = str + " and (d.stat_id='Appalac005' or d.stat_id='Billeri011' or d.stat_id='Brookha017' or d.stat_id='CCNY032' or d.stat_id='COVE_SE041' or d.stat_id='Dayton043' or d.stat_id='DRAGON_044' or d.stat_id='DRAGON_045' or d.stat_id='DRAGON_046' or d.stat_id='DRAGON_047' or d.stat_i"
                        + "d='DRAGON_048' or d.stat_id='DRAGON_050' or d.stat_id='DRAGON_051' or d.stat_id='DRAGON_052' or d.stat_id='DRAGON_053' or d.stat_id='DRAGON_054' or d.stat_id='DRAGON_055' or d.stat_id='DRAGON_057' or d.stat_id='DRAGON_058' or d.stat_id='DRAGON_059' or d.stat_id='DRAGON_06"
                        + "1' or d.stat_id='DRAGON_063' or d.stat_id='DRAGON_065' or d.stat_id='DRAGON_068' or d.stat_id='DRAGON_069' or d.stat_id='DRAGON_070' or d.stat_id='DRAGON_071' or d.stat_id='DRAGON_072' or d.stat_id='DRAGON_073' or d.stat_id='DRAGON_074' or d.stat_id='DRAGON_078' or d.stat"
                        + "_id='DRAGON_080' or d.stat_id='DRAGON_082' or d.stat_id='DRAGON_083' or d.stat_id='DRAGON_084' or d.stat_id='DRAGON_086' or d.stat_id='DRAGON_087' or d.stat_id='DRAGON_088' or d.stat_id='DRAGON_090' or d.stat_id='DRAGON_093' or d.stat_id='DRAGON_096' or d.stat_id='DRAGON_"
                        + "097' or d.stat_id='DRAGON_098' or d.stat_id='DRAGON_099' or d.stat_id='Easton_101' or d.stat_id='Egbert102' or d.stat_id='Georgia115' or d.stat_id='GSFC118' or d.stat_id='Harvard122' or d.stat_id='LISCO140' or d.stat_id='SERC187' or d.stat_id='Toronto207' or d.stat_id='UM"
                        + "BC215' or d.stat_id='Wallops223' or d.stat_id='090010017' or d.stat_id='090011123' or d.stat_id='090013007' or d.stat_id='090019003' or d.stat_id='090031003' or d.stat_id='090050005' or d.stat_id='090070007' or d.stat_id='090090027' or d.stat_id='090093002' or d.stat_id='"
                        + "090110124' or d.stat_id='090131001' or d.stat_id='100010002' or d.stat_id='100031007' or d.stat_id='100031010' or d.stat_id='100031013' or d.stat_id='100032004' or d.stat_id='100051002' or d.stat_id='100051003' or d.stat_id='110010041' or d.stat_id='110010043' or d.stat_i"
                        + "d='130550001' or d.stat_id='130590002' or d.stat_id='130670003' or d.stat_id='130730001' or d.stat_id='130850001' or d.stat_id='130890002' or d.stat_id='130970004' or d.stat_id='131210055' or d.stat_id='131350002' or d.stat_id='132130003' or d.stat_id='132230003' or d.sta"
                        + "t_id='132450091' or d.stat_id='132470001' or d.stat_id='210130002' or d.stat_id='210131002' or d.stat_id='210190017' or d.stat_id='210373002' or d.stat_id='210430500' or d.stat_id='210670012' or d.stat_id='210890007' or d.stat_id='211130001' or d.stat_id='211930003' or d."
                        + "stat_id='211950002' or d.stat_id='211990003' or d.stat_id='240030014' or d.stat_id='240051007' or d.stat_id='240053001' or d.stat_id='240090011' or d.stat_id='240130001' or d.stat_id='240150003' or d.stat_id='240170010' or d.stat_id='240210037' or d.stat_id='240230002' or"
                        + " d.stat_id='240251001' or d.stat_id='240259001' or d.stat_id='240290002' or d.stat_id='240313001' or d.stat_id='240330030' or d.stat_id='240338003' or d.stat_id='240430009' or d.stat_id='245100054' or d.stat_id='250010002' or d.stat_id='250034002' or d.stat_id='250051002'"
                        + " or d.stat_id='250070001' or d.stat_id='250092006' or d.stat_id='250095005' or d.stat_id='250130008' or d.stat_id='250150103' or d.stat_id='250154002' or d.stat_id='250170009' or d.stat_id='250171102' or d.stat_id='250213003' or d.stat_id='250250041' or d.stat_id='2502500"
                        + "42' or d.stat_id='250270015' or d.stat_id='250270024' or d.stat_id='260490021' or d.stat_id='260492001' or d.stat_id='260630007' or d.stat_id='260910007' or d.stat_id='260990009' or d.stat_id='260991003' or d.stat_id='261250001' or d.stat_id='261470005' or d.stat_id='2616"
                        + "10008' or d.stat_id='261630001' or d.stat_id='261630019' or d.stat_id='330050007' or d.stat_id='330111011' or d.stat_id='330115001' or d.stat_id='340010006' or d.stat_id='340030006' or d.stat_id='340071001' or d.stat_id='340110007' or d.stat_id='340130003' or d.stat_id='3"
                        + "40150002' or d.stat_id='340170006' or d.stat_id='340190001' or d.stat_id='340210005' or d.stat_id='340230011' or d.stat_id='340250005' or d.stat_id='340273001' or d.stat_id='340290006' or d.stat_id='340315001' or d.stat_id='360010012' or d.stat_id='360050133' or d.stat_id"
                        + "='360130006' or d.stat_id='360130011' or d.stat_id='360150003' or d.stat_id='360270007' or d.stat_id='360290002' or d.stat_id='360410005' or d.stat_id='360430005' or d.stat_id='360530006' or d.stat_id='360551007' or d.stat_id='360610135' or d.stat_id='360631006' or d.stat"
                        + "_id='360650004' or d.stat_id='360671015' or d.stat_id='360715001' or d.stat_id='360750003' or d.stat_id='360790005' or d.stat_id='360810124' or d.stat_id='360830004' or d.stat_id='360850067' or d.stat_id='360870005' or d.stat_id='360910004' or d.stat_id='361010003' or d.s"
                        + "tat_id='361030002' or d.stat_id='361030004' or d.stat_id='361030009' or d.stat_id='361111005' or d.stat_id='361173001' or d.stat_id='361192004' or d.stat_id='370030004' or d.stat_id='370110002' or d.stat_id='370210030' or d.stat_id='370270003' or d.stat_id='370330001' or "
                        + "d.stat_id='370370004' or d.stat_id='370510008' or d.stat_id='370511003' or d.stat_id='370590003' or d.stat_id='370630015' or d.stat_id='370650099' or d.stat_id='370670022' or d.stat_id='370670028' or d.stat_id='370670030' or d.stat_id='370671008' or d.stat_id='370690001' "
                        + "or d.stat_id='370750001' or d.stat_id='370770001' or d.stat_id='370810013' or d.stat_id='370870035' or d.stat_id='370870036' or d.stat_id='370990005' or d.stat_id='371010002' or d.stat_id='371070004' or d.stat_id='371090004' or d.stat_id='371170001' or d.stat_id='37119004"
                        + "1' or d.stat_id='371191005' or d.stat_id='371191009' or d.stat_id='371290002' or d.stat_id='371450003' or d.stat_id='371470006' or d.stat_id='371570099' or d.stat_id='371590021' or d.stat_id='371590022' or d.stat_id='371730002' or d.stat_id='371790003' or d.stat_id='37183"
                        + "0014' or d.stat_id='371830016' or d.stat_id='371990004' or d.stat_id='390030009' or d.stat_id='390071001' or d.stat_id='390090004' or d.stat_id='390170004' or d.stat_id='390170018' or d.stat_id='390230001' or d.stat_id='390230003' or d.stat_id='390250022' or d.stat_id='39"
                        + "0271002' or d.stat_id='390350034' or d.stat_id='390350060' or d.stat_id='390350064' or d.stat_id='390355002' or d.stat_id='390410002' or d.stat_id='390490029' or d.stat_id='390490037' or d.stat_id='390490081' or d.stat_id='390550004' or d.stat_id='390570006' or d.stat_id="
                        + "'390610006' or d.stat_id='390610040' or d.stat_id='390810017' or d.stat_id='390830002' or d.stat_id='390850003' or d.stat_id='390850007' or d.stat_id='390870011' or d.stat_id='390870012' or d.stat_id='390890005' or d.stat_id='390930018' or d.stat_id='390950024' or d.stat_"
                        + "id='390950027' or d.stat_id='390950034' or d.stat_id='390970007' or d.stat_id='390990013' or d.stat_id='391030004' or d.stat_id='391090005' or d.stat_id='391130037' or d.stat_id='391331001' or d.stat_id='391510016' or d.stat_id='391510022' or d.stat_id='391514005' or d.st"
                        + "at_id='391530020' or d.stat_id='391550009' or d.stat_id='391550011' or d.stat_id='391650007' or d.stat_id='391670004' or d.stat_id='391730003' or d.stat_id='420010002' or d.stat_id='420030008' or d.stat_id='420030010' or d.stat_id='420030067' or d.stat_id='420031005' or d"
                        + ".stat_id='420050001' or d.stat_id='420070002' or d.stat_id='420070005' or d.stat_id='420070014' or d.stat_id='420110006' or d.stat_id='420110011' or d.stat_id='420130801' or d.stat_id='420170012' or d.stat_id='420210011' or d.stat_id='420270100' or d.stat_id='420290100' o"
                        + "r d.stat_id='420334000' or d.stat_id='420430401' or d.stat_id='420431100' or d.stat_id='420450002' or d.stat_id='420490003' or d.stat_id='420550001' or d.stat_id='420590002' or d.stat_id='420630004' or d.stat_id='420690101' or d.stat_id='420692006' or d.stat_id='420710007"
                        + "' or d.stat_id='420710012' or d.stat_id='420730015' or d.stat_id='420770004' or d.stat_id='420791100' or d.stat_id='420791101' or d.stat_id='420810100' or d.stat_id='420850100' or d.stat_id='420890002' or d.stat_id='420910013' or d.stat_id='420950025' or d.stat_id='420958"
                        + "000' or d.stat_id='420990301' or d.stat_id='421010004' or d.stat_id='421010024' or d.stat_id='421174000' or d.stat_id='421250005' or d.stat_id='421250200' or d.stat_id='421255001' or d.stat_id='421290006' or d.stat_id='421290008' or d.stat_id='421330008' or d.stat_id='421"
                        + "330011' or d.stat_id='440030002' or d.stat_id='440071010' or d.stat_id='440090007' or d.stat_id='450010001' or d.stat_id='450030003' or d.stat_id='450070005' or d.stat_id='450150002' or d.stat_id='450190046' or d.stat_id='450210002' or d.stat_id='450250001' or d.stat_id='"
                        + "450310003' or d.stat_id='450370001' or d.stat_id='450450016' or d.stat_id='450451003' or d.stat_id='450730001' or d.stat_id='450770002' or d.stat_id='450790007' or d.stat_id='450790021' or d.stat_id='450791001' or d.stat_id='450830009' or d.stat_id='450910006' or d.stat_i"
                        + "d='470010101' or d.stat_id='470090101' or d.stat_id='470090102' or d.stat_id='470651011' or d.stat_id='470654003' or d.stat_id='470890002' or d.stat_id='470930021' or d.stat_id='470931020' or d.stat_id='471050109' or d.stat_id='471210104' or d.stat_id='471550101' or d.sta"
                        + "t_id='471550102' or d.stat_id='471632002' or d.stat_id='471632003' or d.stat_id='500030004' or d.stat_id='510030001' or d.stat_id='510130020' or d.stat_id='510330001' or d.stat_id='510360002' or d.stat_id='510410004' or d.stat_id='510590030' or d.stat_id='510610002' or d."
                        + "stat_id='510690010' or d.stat_id='510850003' or d.stat_id='510870014' or d.stat_id='511071005' or d.stat_id='511130003' or d.stat_id='511390004' or d.stat_id='511530009' or d.stat_id='511611004' or d.stat_id='511630003' or d.stat_id='511650003' or d.stat_id='511790001' or"
                        + " d.stat_id='511970002' or d.stat_id='515100009' or d.stat_id='518000004' or d.stat_id='518000005' or d.stat_id='540030003' or d.stat_id='540110006' or d.stat_id='540250003' or d.stat_id='540291004' or d.stat_id='540390010' or d.stat_id='540610003' or d.stat_id='540690010'"
                        + " or d.stat_id='541071002' or d.stat_id='090010010' or d.stat_id='090013005' or d.stat_id='090032006' or d.stat_id='090091123' or d.stat_id='090092123' or d.stat_id='090113002' or d.stat_id='100010003' or d.stat_id='100031003' or d.stat_id='100031012' or d.stat_id='1100100"
                        + "42' or d.stat_id='130630091' or d.stat_id='130670004' or d.stat_id='130892001' or d.stat_id='131150003' or d.stat_id='131210032' or d.stat_id='131210039' or d.stat_id='131390003' or d.stat_id='132450005' or d.stat_id='132950002' or d.stat_id='210190002' or d.stat_id='2106"
                        + "70014' or d.stat_id='211510003' or d.stat_id='240031003' or d.stat_id='240330025' or d.stat_id='245100006' or d.stat_id='245100007' or d.stat_id='245100008' or d.stat_id='245100040' or d.stat_id='250035001' or d.stat_id='250051004' or d.stat_id='250096001' or d.stat_id='2"
                        + "50130016' or d.stat_id='250132009' or d.stat_id='250230004' or d.stat_id='250250002' or d.stat_id='250250027' or d.stat_id='250250043' or d.stat_id='250270016' or d.stat_id='250270023' or d.stat_id='261150005' or d.stat_id='261630005' or d.stat_id='261630015' or d.stat_id"
                        + "='261630016' or d.stat_id='261630025' or d.stat_id='261630033' or d.stat_id='261630036' or d.stat_id='261630038' or d.stat_id='261630039' or d.stat_id='330111015' or d.stat_id='330150018' or d.stat_id='340011006' or d.stat_id='340030003' or d.stat_id='340070009' or d.stat"
                        + "_id='340071007' or d.stat_id='340150004' or d.stat_id='340171003' or d.stat_id='340172002' or d.stat_id='340210008' or d.stat_id='340218001' or d.stat_id='340230006' or d.stat_id='340270004' or d.stat_id='340292002' or d.stat_id='340310005' or d.stat_id='340390004' or d.s"
                        + "tat_id='340390006' or d.stat_id='340392003' or d.stat_id='340410006' or d.stat_id='340410007' or d.stat_id='360010005' or d.stat_id='360050080' or d.stat_id='360290005' or d.stat_id='360470122' or d.stat_id='360590008' or d.stat_id='360610079' or d.stat_id='360610128' or "
                        + "d.stat_id='360610134' or d.stat_id='360632008' or d.stat_id='360710002' or d.stat_id='360850055' or d.stat_id='361191002' or d.stat_id='370010002' or d.stat_id='370210034' or d.stat_id='370350004' or d.stat_id='370510009' or d.stat_id='370570002' or d.stat_id='370610002' "
                        + "or d.stat_id='370650004' or d.stat_id='370710016' or d.stat_id='370810014' or d.stat_id='370870012' or d.stat_id='370990006' or d.stat_id='371110004' or d.stat_id='371190003' or d.stat_id='371190042' or d.stat_id='371190043' or d.stat_id='371210001' or d.stat_id='37123000"
                        + "1' or d.stat_id='371550005' or d.stat_id='371830020' or d.stat_id='371890003' or d.stat_id='371910005' or d.stat_id='390090003' or d.stat_id='390170003' or d.stat_id='390170015' or d.stat_id='390170016' or d.stat_id='390230005' or d.stat_id='390290020' or d.stat_id='39029"
                        + "0022' or d.stat_id='390350038' or d.stat_id='390350045' or d.stat_id='390350065' or d.stat_id='390351002' or d.stat_id='390490024' or d.stat_id='390490025' or d.stat_id='390570005' or d.stat_id='390610014' or d.stat_id='390610042' or d.stat_id='390615001' or d.stat_id='39"
                        + "0810001' or d.stat_id='390811001' or d.stat_id='390851001' or d.stat_id='390933002' or d.stat_id='390950026' or d.stat_id='390950028' or d.stat_id='390990005' or d.stat_id='390990006' or d.stat_id='390990014' or d.stat_id='391130032' or d.stat_id='391137001' or d.stat_id="
                        + "'391330002' or d.stat_id='391450013' or d.stat_id='391450019' or d.stat_id='391510017' or d.stat_id='391510020' or d.stat_id='391530017' or d.stat_id='391530023' or d.stat_id='391550005' or d.stat_id='391550006' or d.stat_id='420030002' or d.stat_id='420030064' or d.stat_"
                        + "id='420030092' or d.stat_id='420030093' or d.stat_id='420031008' or d.stat_id='420031301' or d.stat_id='420033007' or d.stat_id='420410101' or d.stat_id='420950027' or d.stat_id='421010047' or d.stat_id='421010055' or d.stat_id='421010057' or d.stat_id='421010449' or d.st"
                        + "at_id='421010649' or d.stat_id='421011002' or d.stat_id='440070022' or d.stat_id='440070026' or d.stat_id='440070027' or d.stat_id='440070028' or d.stat_id='450190048' or d.stat_id='450410003' or d.stat_id='450450009' or d.stat_id='450450015' or d.stat_id='450630008' or d"
                        + ".stat_id='450790019' or d.stat_id='470090011' or d.stat_id='470110103' or d.stat_id='470111002' or d.stat_id='470650006' or d.stat_id='470650031' or d.stat_id='470654002' or d.stat_id='470930028' or d.stat_id='470931013' or d.stat_id='470931017' or d.stat_id='471050108' o"
                        + "r d.stat_id='471070101' or d.stat_id='471071002' or d.stat_id='471450004' or d.stat_id='471450103' or d.stat_id='471451001' or d.stat_id='471631007' or d.stat_id='471730105' or d.stat_id='510350001' or d.stat_id='510410003' or d.stat_id='510470002' or d.stat_id='510870015"
                        + "' or d.stat_id='511010003' or d.stat_id='511870004' or d.stat_id='515100020' or d.stat_id='515200006' or d.stat_id='516300004' or d.stat_id='516500008' or d.stat_id='516700010' or d.stat_id='516800015' or d.stat_id='517100024' or d.stat_id='517700011' or d.stat_id='517700"
                        + "015' or d.stat_id='517750011' or d.stat_id='518100008' or d.stat_id='518400002' or d.stat_id='540090005' or d.stat_id='540391005' or d.stat_id='540490006' or d.stat_id='540511002' or d.stat_id='540810002' or d.stat_id='090010012' or d.stat_id='100031008' or d.stat_id='110"
                        + "010023' or d.stat_id='131210048' or d.stat_id='250094005' or d.stat_id='250250040' or d.stat_id='330110020' or d.stat_id='340131003' or d.stat_id='340171002' or d.stat_id='340390003' or d.stat_id='360050112' or d.stat_id='360050113' or d.stat_id='360291013' or d.stat_id='"
                        + "360291014' or d.stat_id='360470052' or d.stat_id='360470118' or d.stat_id='360470121' or d.stat_id='360590005' or d.stat_id='360652001' or d.stat_id='360670017' or d.stat_id='360810120' or d.stat_id='360850111' or d.stat_id='370130151' or d.stat_id='370670023' or d.stat_i"
                        + "d='371290006' or d.stat_id='390010001' or d.stat_id='390133002' or d.stat_id='390350051' or d.stat_id='390350053' or d.stat_id='390490005' or d.stat_id='390490034' or d.stat_id='390610021' or d.stat_id='390810018' or d.stat_id='390810020' or d.stat_id='390850006' or d.sta"
                        + "t_id='390951003' or d.stat_id='391051001' or d.stat_id='391130028' or d.stat_id='391130034' or d.stat_id='391150004' or d.stat_id='391450020' or d.stat_id='391450021' or d.stat_id='391450022' or d.stat_id='391530022' or d.stat_id='391570006' or d.stat_id='420010001' or d."
                        + "stat_id='420030003' or d.stat_id='420030031' or d.stat_id='420030038' or d.stat_id='420033006' or d.stat_id='420037004' or d.stat_id='420951000' or d.stat_id='421230004' or d.stat_id='440070012' or d.stat_id='450430011' or d.stat_id='450430012' or d.stat_id='450630009' or"
                        + " d.stat_id='450630010' or d.stat_id='450770003' or d.stat_id='470110102' or d.stat_id='471450104' or d.stat_id='471453009' or d.stat_id='471630007' or d.stat_id='471730107' or d.stat_id='517600024' or d.stat_id='540090007' or d.stat_id='540090011' or d.stat_id='540290005'"
                        + " or d.stat_id='540290007' or d.stat_id='540290008' or d.stat_id='540290009' or d.stat_id='540290015' or d.stat_id='540990004' or d.stat_id='540990005' or d.stat_id='ABT147' or d.stat_id='ANA115' or d.stat_id='ARE128' or d.stat_id='BEL116' or d.stat_id='BFT142' or d.stat_i"
                        + "d='BWR139' or d.stat_id='CAT175' or d.stat_id='CDR119' or d.stat_id='CKT136' or d.stat_id='CND125' or d.stat_id='COW137' or d.stat_id='CTH110' or d.stat_id='DCP114' or d.stat_id='EGB181' or d.stat_id='GRS420' or d.stat_id='KEF112' or d.stat_id='LRL117' or d.stat_id='MKG11"
                        + "3' or d.stat_id='PAR107' or d.stat_id='PED108' or d.stat_id='PNF126' or d.stat_id='PSU106' or d.stat_id='QAK172' or d.stat_id='SHN418' or d.stat_id='SPD111' or d.stat_id='UVL124' or d.stat_id='VPI120' or d.stat_id='WSP144' or d.stat_id='130590001' or d.stat_id='540390011'"
                        + " or d.stat_id='BRIG1' or d.stat_id='CACO1' or d.stat_id='COHU1' or d.stat_id='DOSO1' or d.stat_id='EGBE1' or d.stat_id='FRRE1' or d.stat_id='GRSM1' or d.stat_id='JARI1' or d.stat_id='LIGO1' or d.stat_id='LYBR1' or d.stat_id='MAVI1' or d.stat_id='MOMO1' or d.stat_id='PACK1"
                        + "' or d.stat_id='QUCI1' or d.stat_id='QURE1' or d.stat_id='ROMA1' or d.stat_id='SHEN1' or d.stat_id='SHRO1' or d.stat_id='SWAN1' or d.stat_id='WASH1' or d.stat_id='CT15' or d.stat_id='KY22' or d.stat_id='KY35' or d.stat_id='MA01' or d.stat_id='MA08' or d.stat_id='MD07' or "
                        + "d.stat_id='MD08' or d.stat_id='MD13' or d.stat_id='MD15' or d.stat_id='MD18' or d.stat_id='MD99' or d.stat_id='MI51' or d.stat_id='MI52' or d.stat_id='NC03' or d.stat_id='NC06' or d.stat_id='NC25' or d.stat_id='NC29' or d.stat_id='NC34' or d.stat_id='NC35' or d.stat_id='N"
                        + "C36' or d.stat_id='NC41' or d.stat_id='NC45' or d.stat_id='NJ00' or d.stat_id='NJ99' or d.stat_id='NY01' or d.stat_id='NY08' or d.stat_id='NY10' or d.stat_id='NY52' or d.stat_id='NY68' or d.stat_id='NY96' or d.stat_id='NY99' or d.stat_id='OH17' or d.stat_id='OH49' or d.st"
                        + "at_id='OH54' or d.stat_id='OH71' or d.stat_id='PA00' or d.stat_id='PA15' or d.stat_id='PA18' or d.stat_id='PA29' or d.stat_id='PA42' or d.stat_id='PA47' or d.stat_id='PA72' or d.stat_id='SC05' or d.stat_id='SC06' or d.stat_id='TN00' or d.stat_id='TN04' or d.stat_id='TN11'"
                        + " or d.stat_id='VA00' or d.stat_id='VA13' or d.stat_id='VA24' or d.stat_id='VA28' or d.stat_id='VA98' or d.stat_id='VA99' or d.stat_id='VT01' or d.stat_id='WV04' or d.stat_id='WV05' or d.stat_id='WV18')  ";
                break;
            case "\"1-km Window\"":
               str = str + " and (d.stat_id='DRAGON_164' or d.stat_id='DRAGON_165' or d.stat_id='DRAGON_167'or d.stat_id='DRAGON_168' or d.stat_id='DRAGON_169' or d.stat_id='DRAGON_171' or d.stat_id='DRAGON_172' or d.stat_id='DRAGON_173' or d.stat_id='DRAGON_174' or d.stat_id='DRAGON_175' or d.stat"
                       + "_id='DRAGON_176' or d.stat_id='DRAGON_178' or d.stat_id='DRAGON_180' or d.stat_id='DRAGON_181' or d.stat_id='DRAGON_183' or d.stat_id='DRAGON_185' or d.stat_id='DRAGON_187' or d.stat_id='DRAGON_190' or d.stat_id='DRAGON_191' or d.stat_id='DRAGON_192' or d.stat_id='DRAGON_1"
                       + "93' or d.stat_id='DRAGON_194' or d.stat_id='DRAGON_195' or d.stat_id='DRAGON_196' or d.stat_id='DRAGON_207' or d.stat_id='DRAGON_216' or d.stat_id='DRAGON_219' or d.stat_id='DRAGON_224' or d.stat_id='DRAGON_225' or d.stat_id='DRAGON_230' or d.stat_id='DRAGON_231' or d.stat"
                       + "_id='DRAGON_234' or d.stat_id='DRAGON_237' or d.stat_id='DRAGON_243' or d.stat_id='DRAGON_250' or d.stat_id='DRAGON_252' or d.stat_id='DRAGON_253' or d.stat_id='Easton_260' or d.stat_id='GSFC303' or d.stat_id='SERC592' or d.stat_id='UMBC680' or d.stat_id='Wallops696' or d."
                       + "stat_id='100010002' or d.stat_id='100010003' or d.stat_id='100031003' or d.stat_id='100031007' or d.stat_id='100031008' or d.stat_id='100031012' or d.stat_id='100032004' or d.stat_id='100051002' or d.stat_id='110010041' or d.stat_id='110010042' or d.stat_id='110010043' or "
                       + "d.stat_id='240031003' or d.stat_id='240051007' or d.stat_id='240053001' or d.stat_id='240150003' or d.stat_id='240251001' or d.stat_id='240290002' or d.stat_id='240313001' or d.stat_id='240330025' or d.stat_id='240330030' or d.stat_id='240338003' or d.stat_id='240430009' o"
                       + "r d.stat_id='245100006' or d.stat_id='245100007' or d.stat_id='245100008' or d.stat_id='245100040' or d.stat_id='340070009' or d.stat_id='340071007' or d.stat_id='340110007' or d.stat_id='340150004' or d.stat_id='420010001' or d.stat_id='420290100' or d.stat_id='420410101'"
                       + " or d.stat_id='420430401' or d.stat_id='420450002' or d.stat_id='420710007' or d.stat_id='420750100' or d.stat_id='420910013' or d.stat_id='421010004' or d.stat_id='421010014' or d.stat_id='421010047' or d.stat_id='421010055' or d.stat_id='421010057' or d.stat_id='42101006"
                       + "3' or d.stat_id='421010449' or d.stat_id='421010649' or d.stat_id='421011002' or d.stat_id='421330008' or d.stat_id='510030001' or d.stat_id='510130020' or d.stat_id='510330001' or d.stat_id='510470002' or d.stat_id='510590030' or d.stat_id='510690010' or d.stat_id='510870"
                       + "014' or d.stat_id='510870015' or d.stat_id='511010003' or d.stat_id='511071005' or d.stat_id='511130003' or d.stat_id='511870004' or d.stat_id='515100009' or d.stat_id='515100020' or d.stat_id='516300004' or d.stat_id='518400002' or d.stat_id='540030003' or d.stat_id='1000"
                       + "31010' or d.stat_id='100031013' or d.stat_id='100051003' or d.stat_id='240030014' or d.stat_id='240090011' or d.stat_id='240130001' or d.stat_id='240170010' or d.stat_id='240199991' or d.stat_id='240210037' or d.stat_id='240259001' or d.stat_id='240339991' or d.stat_id='24"
                       + "5100054' or d.stat_id='340071001' or d.stat_id='340150002' or d.stat_id='420010002' or d.stat_id='420019991' or d.stat_id='420431100' or d.stat_id='420550001' or d.stat_id='420710012' or d.stat_id='420990301' or d.stat_id='421010024' or d.stat_id='421330011' or d.stat_id='"
                       + "510610002' or d.stat_id='510850003' or d.stat_id='511530009' or d.stat_id='511790001' or d.stat_id='110010023' or d.stat_id='517600024' or d.stat_id='ARE128' or d.stat_id='BEL116' or d.stat_id='BWR139' or d.stat_id='SHN418' or d.stat_id='SHEN1' or d.stat_id='WASH1' or d.st"
                       + "at_id='MD07' or d.stat_id='MD13' or d.stat_id='MD15' or d.stat_id='MD18' or d.stat_id='MD99' or d.stat_id='PA00' or d.stat_id='PA47' or d.stat_id='VA00' or d.stat_id='VA28' or d.stat_id='VA98' ) ";
               break;
            case "\"2-km Window SJV\"":
                str = str + " and (d.stat_id = '060010007' or d.stat_id = '060010009' or d.stat_id = '060010011' or d.stat_id = '060050002' or d.stat_id = '060070007' or d.stat_id = '060070008' or d.stat_id = '060090001' or d.stat_id = '060111002' or d.stat_id = '060130002' or d.stat_id = '06013100"
                        + "2' or d.stat_id = '060131004' or d.stat_id = '060170010' or d.stat_id = '060190007' or d.stat_id = '060190011' or d.stat_id = '060190242' or d.stat_id = '060192009' or d.stat_id = '060194001' or d.stat_id = '060195001' or d.stat_id = '060210003' or d.stat_id = '060290007'"
                        + " or d.stat_id = '060290008' or d.stat_id = '060290011' or d.stat_id = '060290014' or d.stat_id = '060290232' or d.stat_id = '060292012' or d.stat_id = '060295002' or d.stat_id = '060296001' or d.stat_id = '060310500' or d.stat_id = '060311004' or d.stat_id = '060333001' o"
                        + "r d.stat_id = '060370002' or d.stat_id = '060370016' or d.stat_id = '060370113' or d.stat_id = '060371002' or d.stat_id = '060371103' or d.stat_id = '060371201' or d.stat_id = '060371302' or d.stat_id = '060371602' or d.stat_id = '060371701' or d.stat_id = '060374002' or "
                        + "d.stat_id = '060374006' or d.stat_id = '060375005' or d.stat_id = '060376012' or d.stat_id = '060379033' or d.stat_id = '060390004' or d.stat_id = '060390500' or d.stat_id = '060392010' or d.stat_id = '060410001' or d.stat_id = '060430003' or d.stat_id = '060470003' or d."
                        + "stat_id = '060530002' or d.stat_id = '060530008' or d.stat_id = '060531003' or d.stat_id = '060550003' or d.stat_id = '060570005' or d.stat_id = '060590007' or d.stat_id = '060591003' or d.stat_id = '060592022' or d.stat_id = '060595001' or d.stat_id = '060610003' or d.st"
                        + "at_id = '060610004' or d.stat_id = '060610006' or d.stat_id = '060612002' or d.stat_id = '060658001' or d.stat_id = '060658005' or d.stat_id = '060659001' or d.stat_id = '060670002' or d.stat_id = '060670006' or d.stat_id = '060670010' or d.stat_id = '060670011' or d.stat"
                        + "_id = '060670012' or d.stat_id = '060670014' or d.stat_id = '060675003' or d.stat_id = '060690002' or d.stat_id = '060690003' or d.stat_id = '060710012' or d.stat_id = '060711004' or d.stat_id = '060712002' or d.stat_id = '060750005' or d.stat_id = '060771002' or d.stat_i"
                        + "d = '060773005' or d.stat_id = '060790005' or d.stat_id = '060792006' or d.stat_id = '060793001' or d.stat_id = '060794002' or d.stat_id = '060798001' or d.stat_id = '060798005' or d.stat_id = '060798006' or d.stat_id = '060811001' or d.stat_id = '060830008' or d.stat_id "
                        + "= '060830011' or d.stat_id = '060831008' or d.stat_id = '060831013' or d.stat_id = '060831014' or d.stat_id = '060831018' or d.stat_id = '060831021' or d.stat_id = '060831025' or d.stat_id = '060832004' or d.stat_id = '060832011' or d.stat_id = '060833001' or d.stat_id = "
                        + "'060834003' or d.stat_id = '060850005' or d.stat_id = '060852009' or d.stat_id = '060870007' or d.stat_id = '060871003' or d.stat_id = '060890004' or d.stat_id = '060890007' or d.stat_id = '060890009' or d.stat_id = '060893003' or d.stat_id = '060950004' or d.stat_id = '0"
                        + "60953003' or d.stat_id = '060970003' or d.stat_id = '060971003' or d.stat_id = '060990005' or d.stat_id = '060990006' or d.stat_id = '061010003' or d.stat_id = '061030005' or d.stat_id = '061070006' or d.stat_id = '061070009' or d.stat_id = '061072002' or d.stat_id = '061"
                        + "072010' or d.stat_id = '061090005' or d.stat_id = '061110007' or d.stat_id = '061110009' or d.stat_id = '061111004' or d.stat_id = '061112002' or d.stat_id = '061113001' or d.stat_id = '061130004' or d.stat_id = '061131003' or d.stat_id = '320310016' or d.stat_id = '32031"
                        + "0020' or d.stat_id = '320310025' or d.stat_id = '320311005' or d.stat_id = '320312002' or d.stat_id = '320312009' or d.stat_id = '060130006' or d.stat_id = '060131001' or d.stat_id = '060132001' or d.stat_id = '060195025' or d.stat_id = '060290016' or d.stat_id = '0602900"
                        + "17' or d.stat_id = '060310004' or d.stat_id = '060374004' or d.stat_id = '060410004' or d.stat_id = '060431001' or d.stat_id = '060472510' or d.stat_id = '060510001' or d.stat_id = '060510005' or d.stat_id = '060510011' or d.stat_id = '060571001' or d.stat_id = '060610002"
                        + "' or d.stat_id = '060631006' or d.stat_id = '060631009' or d.stat_id = '060650003' or d.stat_id = '060651003' or d.stat_id = '060670284' or d.stat_id = '060674001' or d.stat_id = '060710025' or d.stat_id = '060773010' or d.stat_id = '060890008' or d.stat_id = '060953001' "
                        + "or d.stat_id = '060970001' or d.stat_id = '060970002' or d.stat_id = '060973002' or d.stat_id = '061030002' or d.stat_id = '061050002' or d.stat_id = '061132001' or d.stat_id = '060012005' or d.stat_id = '060072002' or d.stat_id = '060074001' or d.stat_id = '060110007' or"
                        + " d.stat_id = '060132007' or d.stat_id = '060170011' or d.stat_id = '060192008' or d.stat_id = '060271023' or d.stat_id = '060271028' or d.stat_id = '060292009' or d.stat_id = '060333010' or d.stat_id = '060333011' or d.stat_id = '060333012' or d.stat_id = '060410003' or d"
                        + ".stat_id = '060631007' or d.stat_id = '060670007' or d.stat_id = '060772010' or d.stat_id = '060792004' or d.stat_id = '060792007' or d.stat_id = '060831020' or d.stat_id = '060831022' or d.stat_id = '060831033' or d.stat_id = '060831037' or d.stat_id = '060850002' or d.s"
                        + "tat_id = '061030006'or d.stat_id = '061073000' or d.stat_id = '061110008' or d.stat_id = '320310022' or d.stat_id = '320310030' or d.stat_id = '320311026' or d.stat_id = '320312010' or d.stat_id = 'LAV410' or d.stat_id = 'PIN414' or d.stat_id = 'SEK430' or d.stat_id = 'YO"
                        + "S204' or d.stat_id = 'YOS404' or d.stat_id = 'BLIS1' or d.stat_id = 'DOME1' or d.stat_id = 'FRES1' or d.stat_id = 'HOOV1' or d.stat_id = 'KAIS1' or d.stat_id = 'LAVO1' or d.stat_id = 'PINN1' or d.stat_id = 'PORE1' or d.stat_id = 'RAFA1' or d.stat_id = 'SAGA1' or d.stat_id"
                        + " = 'SEQU1' or d.stat_id = 'TRIN1' or d.stat_id = 'YOSE1' ) ";
                break;
            default:
                break;
        }
        
        if (gSiteSelector) {
            try {
                str += gSiteSelector();
            } catch(Exception e) {
                //do nothing
            }
        }
        
        //site_id or stat_id
        if (!site_id.equals("\"All\"")) {
            str = str + " and d.stat_id='" + site_id + "'";
            
            String site_id_str = " ";
            //TODO: ask wyatt
        }
        //date
        String sd = year_start + month_start + day_start;
        String ed = year_end + month_end + day_end;
        str = str + " and d.ob_dates BETWEEN " + sd + " and " + ed + " and d.ob_datee BETWEEN " + sd +  " and " + ed + "";
        //hour
        if (!start_hour.equals("\"\"") && !end_hour.equals("\"\"")) {
            str = str + " and (d.ob_hour >= " + hourFormat(start_hour) + " and d.ob_hour <= " + hourFormat(end_hour) + ")";
        } else {
            str = str + " and (d.ob_hour >= 00 and d.ob_hour <= 23)";
        }
        //Season
        switch(season) {
            case "\"Winter (Dec,Jan,Feb)\"":
                str = str + " and (month = 12 or month = 1 or month = 2)";
                str = str + " and (month(d.ob_dates) = 12 or month(d.ob_dates) = 1 or month(d.ob_dates = 2))";
                break;
            case "\"Spring (Mar,Apr,May)\"":
                str = str + " and (month = 3 or month = 4 or month = 5)";
                str = str + " and (month(d.ob_dates) = 3 or month(d.ob_dates) = 4 or month(d.ob_dates = 5))";
                break;
            case "\"Summer (Jun,Jul,Aug)\"":
                str = str + " and (month = 6 or month = 7 or month = 8)";
                str = str + " and (month(d.ob_dates) = 6 or month(d.ob_dates) = 7 or month(d.ob_dates = 8))";
                break;
            case "\"Autumn (Sep,Oct,Nov)\"":
                str = str + " and (month = 9 or month = 10 or month = 11)";
                str = str + " and (month(d.ob_dates) = 9 or month(d.ob_dates) = 10 or month(d.ob_dates = 11))";
                break;
            default:
                break;
        }
        //Month
        switch(month) {
            case "\"Jan\"":
                str = str + " and month = \"01\"";
                break;
            case "\"Feb\"":
                str = str + " and month = \"02\"";
                break;
            case "\"Mar\"":
                str = str + " and month = \"03\"";
                break;
            case "\"Apr\"":
                str = str + " and month = \"04\"";
                break;
            case "\"May\"":
                str = str + " and month = \"05\"";
                break;
            case "\"Jun\"":
                str = str + " and month = \"06\"";
                break;
            case "\"Jul\"":
                str = str + " and month = \"07\"";
                break;
            case "\"Aug\"":
                str = str + " and month = \"08\"";
                break;
            case "\"Sep\"":
                str = str + " and month = \"09\"";
                break;
            case "\"Oct\"":
                str = str + " and month = \"10\"";
                break;
            case "\"Nov\"":
                str = str + " and month = \"11\"";
                break;
            case "\"Dec\"":
                str = str + " and month = \"12\"";
                break;
        }
        //POcode
        if (!poCode.equals("\"All\"")) {
            str = str + " and POCode = " + poCode;
        }
        //Geographic-Based Criterion
        if (!lat1.equals("") && !lat2.equals("")) {
            str = str + " and d.lat BETWEEN $lat1 and $lat2";
        }
        if (!lon1.equals("") && !lon2.equals("")) {
            str = str + " and d.lon BETWEEN $lon1 and $lon2";
        }
        switch(loc_setting) {
            case "\"Rural\"":
                str = str + " and s.loc_setting=\'RURAL'";
                break;
            case "\"Suburban\"":
                str = str + " and s.loc_setting=\'SUBURBAN'";
                break;
            case "\"Urban\"":
                str = str + " and s.loc_setting=\'URBAN AND CENTER CITY'";
                break;
        }
        
        query = str;
    }
    
    private String gSiteSelector() throws Exception {
        String str = " and (";
        
        //from CSV
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(siteFile));
            while((line = br.readLine()) != null) {
                String[] info = line.split(",");
                str += "d.stat_id='" +  info[0] + "' or ";
//                System.out.println(info[0]);
                
            }
            str += "d.stat_id='none')";
        } catch(Exception e) {
            str = "";
            e.printStackTrace();
        }
        return str;
    }
    

//##############################################################################
//    JSWING AUTO-GENERATED CODE : DO NOT EDIT DIRECTLY
//##############################################################################
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        databaseProjectPanel = new javax.swing.JPanel();
        databaseSpecificationComboBox = new javax.swing.JComboBox<>();
        projectComboBox1 = new javax.swing.JComboBox<>();
        databaseSpecificationLabel = new javax.swing.JLabel();
        projectModelRunSpecificationLabel = new javax.swing.JLabel();
        projectModelRunSpecificationLabel1 = new javax.swing.JLabel();
        projectComboBox2 = new javax.swing.JComboBox<>();
        projectComboBox3 = new javax.swing.JComboBox<>();
        projectComboBox4 = new javax.swing.JComboBox<>();
        projectComboBox5 = new javax.swing.JComboBox<>();
        projectComboBox6 = new javax.swing.JComboBox<>();
        projectComboBox7 = new javax.swing.JComboBox<>();
        projectDetailsLabel = new javax.swing.JLabel();
        projectDetailsTextBox = new javax.swing.JTextArea();
        regionAreaPanel = new javax.swing.JPanel();
        PCALabel = new javax.swing.JLabel();
        stateInfoLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox<>();
        RPOInfoLabel = new javax.swing.JLabel();
        RPOComboBox = new javax.swing.JComboBox<>();
        RPOLabel = new javax.swing.JLabel();
        PCAInfoLabel = new javax.swing.JLabel();
        worldRegionsLabel = new javax.swing.JLabel();
        PCAComboBox = new javax.swing.JComboBox<>();
        climateRegionInfoLabel = new javax.swing.JLabel();
        ClimateRegionLabel = new javax.swing.JLabel();
        climateRegionComboBox = new javax.swing.JComboBox<>();
        worldRegionInfoLabel = new javax.swing.JLabel();
        discoverWindowsLabel = new javax.swing.JLabel();
        siteIDPanel = new javax.swing.JPanel();
        ozonePCALink = new javax.swing.JLabel();
        siteIDTextField = new javax.swing.JTextField();
        siteIDLoadInfoLabel = new javax.swing.JTextArea();
        siteIDInfoLabel = new javax.swing.JTextArea();
        siteIDLoadTextField = new javax.swing.JTextField();
        soccergoalBugleButton1 = new javax.swing.JButton();
        siteIDLabel1 = new javax.swing.JLabel();
        aerosolPCALink = new javax.swing.JLabel();
        worldRegionComboBox = new javax.swing.JComboBox<>();
        discoverWindowsComboBox = new javax.swing.JComboBox<>();
        networkSpeciesPanel = new javax.swing.JPanel();
        AQObservationNetworkLabel = new javax.swing.JLabel();
        AQObservationNetworkInfoLabel = new javax.swing.JLabel();
        AQObservationsNetworksPanel = new javax.swing.JPanel();
        improveCheckBox = new javax.swing.JCheckBox();
        csnCheckBox = new javax.swing.JCheckBox();
        castnetCheckBox = new javax.swing.JCheckBox();
        castnetHourlyCheckBox = new javax.swing.JCheckBox();
        castnetDailyCheckBox = new javax.swing.JCheckBox();
        castnetDryDepCheckBox = new javax.swing.JCheckBox();
        capmonCheckBox = new javax.swing.JCheckBox();
        napsHourlyCheckBox = new javax.swing.JCheckBox();
        napsDailyO3CheckBox = new javax.swing.JCheckBox();
        nadpCheckBox = new javax.swing.JCheckBox();
        amonCheckBox = new javax.swing.JCheckBox();
        airmonCheckBox = new javax.swing.JCheckBox();
        aqsHourlyCheckBox = new javax.swing.JCheckBox();
        aqsDailyO3CheckBox = new javax.swing.JCheckBox();
        aqsDailyCheckBox = new javax.swing.JCheckBox();
        aqsDailyOAQPSO3CheckBox = new javax.swing.JCheckBox();
        aqsDailyO3OldnameCheckBox = new javax.swing.JCheckBox();
        aqsDailyOldNameCheckBox = new javax.swing.JCheckBox();
        searchHourlyCheckBox = new javax.swing.JCheckBox();
        searchDailyCheckBox = new javax.swing.JCheckBox();
        aeronetCheckBox = new javax.swing.JCheckBox();
        fluxnetCheckBox = new javax.swing.JCheckBox();
        noaaESRLCheckBox = new javax.swing.JCheckBox();
        toarCheckBox = new javax.swing.JCheckBox();
        mdnCheckBox = new javax.swing.JCheckBox();
        toxicsHAPsCheckBox = new javax.swing.JCheckBox();
        model_modelCheckBox = new javax.swing.JCheckBox();
        europeanNetworksPanel = new javax.swing.JPanel();
        admnCheckBox = new javax.swing.JCheckBox();
        aganetCheckBox = new javax.swing.JCheckBox();
        airbaseHourlyCheckBox = new javax.swing.JCheckBox();
        airbaseDailyCheckBox = new javax.swing.JCheckBox();
        aurnHourlyCheckBox = new javax.swing.JCheckBox();
        aurnDailyCheckBox = new javax.swing.JCheckBox();
        emepHourlyCheckBox = new javax.swing.JCheckBox();
        emepDailyCheckBox = new javax.swing.JCheckBox();
        emepDailyO3CheckBox = new javax.swing.JCheckBox();
        campaignsPanel = new javax.swing.JPanel();
        campainsLabel = new javax.swing.JLabel();
        calnexCheckBox = new javax.swing.JCheckBox();
        soasCheckBox = new javax.swing.JCheckBox();
        specialCheckBox = new javax.swing.JCheckBox();
        speciesPanel = new javax.swing.JPanel();
        speciesToPlotLabel = new javax.swing.JLabel();
        speciesComboBox = new javax.swing.JComboBox<>();
        advancedSpeciesButton = new javax.swing.JButton();
        europeanNetworksLabel = new javax.swing.JLabel();
        europeanNetworksInfoLabel = new javax.swing.JLabel();
        dateTimePanel = new javax.swing.JPanel();
        dateRangeLabel = new javax.swing.JLabel();
        hourRangeLabel = new javax.swing.JLabel();
        hourRangeInfoLabel = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        startDateLabel = new javax.swing.JLabel();
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        endDatelabel = new javax.swing.JLabel();
        endDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        jPanel16 = new javax.swing.JPanel();
        startHourLabel = new javax.swing.JLabel();
        startHourComboBox = new javax.swing.JComboBox<>();
        endHourLabel = new javax.swing.JLabel();
        endHourComboBox = new javax.swing.JComboBox<>();
        seasonalAnalysisLabel = new javax.swing.JLabel();
        seasonalAnalysisInfoLabel = new javax.swing.JTextArea();
        seasonalAnalysisComboBox = new javax.swing.JComboBox<>();
        monthlyAnalysisLabel = new javax.swing.JLabel();
        monthlyAnalysisInfoLabel = new javax.swing.JTextArea();
        monthlyAnalysisComboBox = new javax.swing.JComboBox<>();
        miscPanel = new javax.swing.JPanel();
        POCodeLabel = new javax.swing.JLabel();
        POCodeComboBox = new javax.swing.JComboBox<>();
        negativeValuesInfoLabel = new javax.swing.JTextArea();
        negativeValuesLabel = new javax.swing.JLabel();
        POCodeInfoLabel = new javax.swing.JTextArea();
        negativeValuesComboBox = new javax.swing.JComboBox<>();
        aggrgateDataLabel = new javax.swing.JLabel();
        aggrigateDataCheckBox = new javax.swing.JCheckBox();
        temporalAveragingInfoLabel = new javax.swing.JTextArea();
        temporalAveragingLabel = new javax.swing.JLabel();
        aggregateDataInfoLabel = new javax.swing.JTextArea();
        temporalAveragingComboBox = new javax.swing.JComboBox<>();
        programPanel = new javax.swing.JPanel();
        pngPlotQualityLabel = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox<>();
        programToRunInfoLabel = new javax.swing.JTextArea();
        programToRunLabel = new javax.swing.JLabel();
        customTitleTextField = new javax.swing.JTextField();
        customTitleLabel = new javax.swing.JLabel();
        plotlyImageSizeInfoLabel = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        heightLabel = new javax.swing.JLabel();
        widthLabel = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        widthTextField = new javax.swing.JTextField();
        plotlyImageSizeLabel = new javax.swing.JLabel();
        pngPlotQualityComboBox = new javax.swing.JComboBox<>();
        pngPlotQualityInfoLabel = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        advancedPlotSpcificationlabel = new javax.swing.JLabel();
        soccergoalBugleButton = new javax.swing.JButton();
        ametPlotAxisVutton = new javax.swing.JButton();
        scatterPlotButton = new javax.swing.JButton();
        amertModelEvalStatsPlotsbutton = new javax.swing.JButton();
        overlayFileButton = new javax.swing.JButton();
        customSQLQueryButton = new javax.swing.JButton();
        customSQLQueryLabel = new javax.swing.JLabel();
        spacialPlotButton = new javax.swing.JButton();
        customSQLQueryButton1 = new javax.swing.JButton();
        customSQLQueryLabel1 = new javax.swing.JLabel();
        runProgramButton1 = new javax.swing.JButton();
        PNGCheckBox = new javax.swing.JCheckBox();
        staticPNGCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        databaseSpecificationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a Database" }));
        databaseSpecificationComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                databaseSpecificationComboBoxItemStateChanged(evt);
            }
        });

        projectComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] { new ComboItem("sample", "<Select a Database First>") }));
        projectComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                projectComboBox1ItemStateChanged(evt);
            }
        });
        projectComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectComboBox1ActionPerformed(evt);
            }
        });

        databaseSpecificationLabel.setText("Database Specification");
        databaseSpecificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        projectModelRunSpecificationLabel.setText("Project/Model Run Specification");
        projectModelRunSpecificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        projectModelRunSpecificationLabel1.setText("Additional Project IDs:");
        projectModelRunSpecificationLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        projectComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        projectComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        projectComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        projectComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        projectComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        projectComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        projectDetailsLabel.setText("Project Details");
        projectDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        projectDetailsTextBox.setColumns(20);
        projectDetailsTextBox.setEditable(false);
        projectDetailsTextBox.setLineWrap(true);
        projectDetailsTextBox.setRows(5);
        projectDetailsTextBox.setText("-");
        projectDetailsTextBox.setWrapStyleWord(true);
        projectDetailsTextBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        projectDetailsTextBox.setOpaque(false);

        javax.swing.GroupLayout databaseProjectPanelLayout = new javax.swing.GroupLayout(databaseProjectPanel);
        databaseProjectPanel.setLayout(databaseProjectPanelLayout);
        databaseProjectPanelLayout.setHorizontalGroup(
            databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseProjectPanelLayout.createSequentialGroup()
                .addGroup(databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(projectComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(databaseProjectPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(databaseSpecificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(projectModelRunSpecificationLabel)
                                    .addComponent(projectModelRunSpecificationLabel1)
                                    .addComponent(databaseSpecificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(databaseProjectPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(projectDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(databaseProjectPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(projectDetailsTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        databaseProjectPanelLayout.setVerticalGroup(
            databaseProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseProjectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(databaseSpecificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databaseSpecificationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectModelRunSpecificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectModelRunSpecificationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectDetailsTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Database/Project", databaseProjectPanel);

        PCALabel.setText("Principal Component Analysis (PCA) Regions");
        PCALabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        stateInfoLabel.setText("Isolate an evaluation dataset by state");

        stateLabel.setText("State");
        stateLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Include all states", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "IllinoisIndiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "MontanaNebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "PennsylvaniaRhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));

        RPOInfoLabel.setText("Isolate an evaulation dataset by a regional planning organization");

        RPOComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "VISTAS", "CENRAP", "MANE-VU", "LADCO", "WRAP" }));

        RPOLabel.setText("Regional Planning Organizations (RPO) Regions");
        RPOLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        PCAInfoLabel.setText("Isolate an evaluation dataset by a regional planning organization");

        worldRegionsLabel.setText("World Regions");
        worldRegionsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        PCAComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Northeast (Ozone)", "Great Lakes (Ozone)", "Mid-Atlantic (Ozone)", "Southwest (Ozone)", "Northeast (Aerosols)", "Great Lakes (Aerosols)", "Southeast (Aerosols)", "Lower Midwest (Aerosols)", "West (Aerosols)" }));

        climateRegionInfoLabel.setText("Isolate an evaluation dataset by region");

        ClimateRegionLabel.setText("Climate Regions");
        ClimateRegionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        climateRegionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Central", "East-North Central", "Northeast", "Northwest", "South", "Southeast", "Southwest", "West", "West-North Central" }));

        worldRegionInfoLabel.setText("Isolate an evaulation dataset by Continent");

        discoverWindowsLabel.setText("Discover-AQ 4-km and 1-km Windows");
        discoverWindowsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        ozonePCALink.setText("Map of Ozone PCA Regions");
        ozonePCALink.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ozonePCALink.setForeground(new java.awt.Color(51, 51, 255));
        ozonePCALink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ozonePCALinkMouseClicked(evt);
            }
        });

        siteIDLoadInfoLabel.setColumns(20);
        siteIDLoadInfoLabel.setEditable(false);
        siteIDLoadInfoLabel.setLineWrap(true);
        siteIDLoadInfoLabel.setRows(5);
        siteIDLoadInfoLabel.setText("To load a custom site file, enter the location and name of the file below. The format should be the sams as this example. You must also enter \"Load_File\" as the site name in the top box.");
        siteIDLoadInfoLabel.setWrapStyleWord(true);
        siteIDLoadInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        siteIDLoadInfoLabel.setOpaque(false);

        siteIDInfoLabel.setColumns(20);
        siteIDInfoLabel.setEditable(false);
        siteIDInfoLabel.setLineWrap(true);
        siteIDInfoLabel.setRows(5);
        siteIDInfoLabel.setText("Go here to interactivly choose a single observation station or manually enter an id (e.g. WASH1). Interactive choosing does not work for AQ sites. For time series plot, if Site ID is left blank, all stations for each network will be used.");
        siteIDInfoLabel.setWrapStyleWord(true);
        siteIDInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        siteIDInfoLabel.setOpaque(false);

        soccergoalBugleButton1.setText("Geography Criteria");
        soccergoalBugleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geographyCriteriaActionPerformed(evt);
            }
        });

        siteIDLabel1.setText("Site ID");
        siteIDLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        aerosolPCALink.setText("Map of Aerosol PCA Regions");
        aerosolPCALink.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        aerosolPCALink.setForeground(new java.awt.Color(51, 51, 255));
        aerosolPCALink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aerosolPCALinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout siteIDPanelLayout = new javax.swing.GroupLayout(siteIDPanel);
        siteIDPanel.setLayout(siteIDPanelLayout);
        siteIDPanelLayout.setHorizontalGroup(
            siteIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siteIDPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siteIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siteIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siteIDLoadInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siteIDInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siteIDLoadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soccergoalBugleButton1)
                    .addComponent(ozonePCALink, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aerosolPCALink, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(siteIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(siteIDPanelLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(siteIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );
        siteIDPanelLayout.setVerticalGroup(
            siteIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siteIDPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(siteIDInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siteIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(siteIDLoadInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siteIDLoadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(soccergoalBugleButton1)
                .addGap(18, 18, 18)
                .addComponent(ozonePCALink, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aerosolPCALink, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(siteIDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(siteIDPanelLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(siteIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );

        worldRegionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "North America", "U.S. & Canada", "South America", "Europe", "Asia" }));

        discoverWindowsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "4-km Window", "1-km Window", "2-km Window SJV" }));

        javax.swing.GroupLayout regionAreaPanelLayout = new javax.swing.GroupLayout(regionAreaPanel);
        regionAreaPanel.setLayout(regionAreaPanelLayout);
        regionAreaPanelLayout.setHorizontalGroup(
            regionAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regionAreaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regionAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PCAInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(worldRegionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(PCAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(climateRegionInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(climateRegionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClimateRegionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(worldRegionInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discoverWindowsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCALabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(RPOComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RPOLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(RPOInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(worldRegionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discoverWindowsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(siteIDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        regionAreaPanelLayout.setVerticalGroup(
            regionAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regionAreaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stateInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RPOLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RPOInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RPOComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PCALabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PCAInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PCAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ClimateRegionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(climateRegionInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(climateRegionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(worldRegionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(worldRegionInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(worldRegionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(discoverWindowsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discoverWindowsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
            .addComponent(siteIDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Region/Area", regionAreaPanel);

        AQObservationNetworkLabel.setText("AQ Observation Networks");
        AQObservationNetworkLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        AQObservationNetworkInfoLabel.setText("Choose air quality monitoring networks to use");

        improveCheckBox.setText(" IMPROVE (e.g. SO4,NO3,PM2.5,EC,OC,TC) ");

        csnCheckBox.setText(" CSN (e.g. SO4,NO3,NH4,PM2.5,EC,OC,TC) ");

        castnetCheckBox.setText(" CASTNet (e.g. SO4,NO3,NH4,SO2,HNO3,TNO3) ");

        castnetHourlyCheckBox.setText(" CASTNet - Hourly (O3, RH, Precip, T, Solor Rad, WSPD, WDIR) ");

        castnetDailyCheckBox.setText(" CASTNet Daily (1-hr and 8-hr max O3) ");

        castnetDryDepCheckBox.setText(" CASTNet Dry Dep (SO4,NO3,NH4,HNO3,TNO3,O3,SO2) ");

        capmonCheckBox.setText(" CAPMoN (SO4,NO3,NH4,HNO3,TNO3,SO2) ");

        napsHourlyCheckBox.setText(" NAPS - Hourly (O3,NO,NO2,NOX,SO2,PM2.5,PM10) ");

        napsDailyO3CheckBox.setText(" NAPS - Daily O3 (1-hr and 8-hr max O3) ");

        nadpCheckBox.setText(" NADP (e.g. SO4,NO3,NH4,Precip, Cl Ion) ");

        amonCheckBox.setText(" AMON (NH3) ");

        airmonCheckBox.setText(" AIRMON (Deposition) (SO4,NO3,NH4,Precip) ");

        aqsHourlyCheckBox.setText(" AQS - Hourly (e.g. NO,NO2,NOx,NOy,SO2,CO,PM2.5,O3,etc.) ");

        aqsDailyO3CheckBox.setText(" AQS - Daily O3 (1-hr and 8-hr max O3) ");

        aqsDailyCheckBox.setText(" AQS - Daily (e.g. PM2.5,PM10, and PAMS species) ");

        aqsDailyOAQPSO3CheckBox.setText(" AQS - Daily OAQPS O3 (Various 8-hr max O3) ");

        aqsDailyO3OldnameCheckBox.setText(" AQS - Daily O3 (Old name) Old 1-hr and 8-hr max O3 network ");

        aqsDailyOldNameCheckBox.setText(" AQS - Daily (Old name) PM2.5,PM10, and PAMS species network ");

        searchHourlyCheckBox.setText(" SEARCH Hourly (e.g. O3,CO,SO2,NO,HNO3,etc.) ");

        searchDailyCheckBox.setText(" SEARCH Daily (Fine and Coarse Mode Species) ");

        aeronetCheckBox.setText(" AERONET (AOD: 340, 380, 440, 500, 675, 870, 1020, 1640) ");

        fluxnetCheckBox.setText(" FluxNet (Soil/Flux variables) ");

        noaaESRLCheckBox.setText(" NOAA ESRL (Hourly O3) ");

        toarCheckBox.setText(" TOAR (Daily O3 values) ");

        mdnCheckBox.setText(" MDN (Hg) ");

        toxicsHAPsCheckBox.setText(" Toxics / HAPs ");

        model_modelCheckBox.setText(" Model_Model ");

        javax.swing.GroupLayout AQObservationsNetworksPanelLayout = new javax.swing.GroupLayout(AQObservationsNetworksPanel);
        AQObservationsNetworksPanel.setLayout(AQObservationsNetworksPanelLayout);
        AQObservationsNetworksPanelLayout.setHorizontalGroup(
            AQObservationsNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AQObservationsNetworksPanelLayout.createSequentialGroup()
                .addGroup(AQObservationsNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(improveCheckBox)
                    .addComponent(csnCheckBox)
                    .addComponent(castnetCheckBox)
                    .addComponent(castnetHourlyCheckBox)
                    .addComponent(castnetDailyCheckBox)
                    .addComponent(castnetDryDepCheckBox)
                    .addComponent(capmonCheckBox)
                    .addComponent(napsHourlyCheckBox)
                    .addComponent(napsDailyO3CheckBox)
                    .addComponent(nadpCheckBox)
                    .addComponent(amonCheckBox)
                    .addComponent(airmonCheckBox)
                    .addComponent(aqsHourlyCheckBox)
                    .addComponent(aqsDailyO3CheckBox)
                    .addComponent(aqsDailyCheckBox)
                    .addComponent(aqsDailyOAQPSO3CheckBox)
                    .addComponent(aqsDailyO3OldnameCheckBox)
                    .addComponent(searchHourlyCheckBox)
                    .addComponent(searchDailyCheckBox)
                    .addComponent(aeronetCheckBox)
                    .addComponent(fluxnetCheckBox)
                    .addComponent(noaaESRLCheckBox)
                    .addComponent(toarCheckBox)
                    .addComponent(mdnCheckBox)
                    .addComponent(toxicsHAPsCheckBox)
                    .addComponent(model_modelCheckBox)
                    .addComponent(aqsDailyOldNameCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        AQObservationsNetworksPanelLayout.setVerticalGroup(
            AQObservationsNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AQObservationsNetworksPanelLayout.createSequentialGroup()
                .addComponent(improveCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csnCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(castnetCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(castnetHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(castnetDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(castnetDryDepCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capmonCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(napsHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(napsDailyO3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nadpCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amonCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airmonCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsDailyO3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsDailyOAQPSO3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsDailyO3OldnameCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aqsDailyOldNameCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aeronetCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fluxnetCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noaaESRLCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toarCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mdnCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toxicsHAPsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(model_modelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admnCheckBox.setText(" ADMN (SO4,NO3,NH4,Precip, Na Ion, Cl Ion)");

        aganetCheckBox.setText(" AGANET (HCl, NO2, NOY, SOX, HNO3, SO2, Cl, Na) ");

        airbaseHourlyCheckBox.setText(" AirBase_Hourly (NO, NO2, NOX, SO2, CO, PM2.5, PM10, O3) ");

        airbaseDailyCheckBox.setText(" AirBase_Daily (NO, NO2, NOX, SO2, CO, PM2.5, PM10, O3) ");

        aurnHourlyCheckBox.setText(" AURN_Hourly (NO, NO2, NOX, SO2, CO, PM2.5, PM10, O3) ");

        aurnDailyCheckBox.setText(" AURN_Daily (NO, NO2, NOX, SO2, CO, PM2.5, PM10, O3) ");

        emepHourlyCheckBox.setText(" EMEP - Hourly (NO, NO2, NOX, SO2, CO, PM2.5, PM10, O3) ");

        emepDailyCheckBox.setText(" EMEP - Daily (SO4, NO3, NH44, trace metals, PM2.5, PM10, O3) ");

        emepDailyO3CheckBox.setText(" EMEP - Daily O3 (1-rh and 8-hr max O3) ");

        campainsLabel.setText("Campains");
        campainsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        calnexCheckBox.setText(" CALNEX ");

        soasCheckBox.setText(" SOAS ");

        specialCheckBox.setText(" Special ");

        javax.swing.GroupLayout campaignsPanelLayout = new javax.swing.GroupLayout(campaignsPanel);
        campaignsPanel.setLayout(campaignsPanelLayout);
        campaignsPanelLayout.setHorizontalGroup(
            campaignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campaignsPanelLayout.createSequentialGroup()
                .addComponent(campainsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(campaignsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campaignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calnexCheckBox)
                    .addComponent(soasCheckBox)
                    .addComponent(specialCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        campaignsPanelLayout.setVerticalGroup(
            campaignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campaignsPanelLayout.createSequentialGroup()
                .addComponent(campainsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calnexCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soasCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        speciesToPlotLabel.setText("Species to Plot");
        speciesToPlotLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        speciesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select a Project First>" }));

        advancedSpeciesButton.setText("Advanced Species Settings");
        advancedSpeciesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedSpeciesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout speciesPanelLayout = new javax.swing.GroupLayout(speciesPanel);
        speciesPanel.setLayout(speciesPanelLayout);
        speciesPanelLayout.setHorizontalGroup(
            speciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(speciesPanelLayout.createSequentialGroup()
                .addGroup(speciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(speciesToPlotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, speciesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(speciesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(speciesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(advancedSpeciesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        speciesPanelLayout.setVerticalGroup(
            speciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(speciesPanelLayout.createSequentialGroup()
                .addComponent(speciesToPlotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(speciesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedSpeciesButton))
        );

        javax.swing.GroupLayout europeanNetworksPanelLayout = new javax.swing.GroupLayout(europeanNetworksPanel);
        europeanNetworksPanel.setLayout(europeanNetworksPanelLayout);
        europeanNetworksPanelLayout.setHorizontalGroup(
            europeanNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(europeanNetworksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(europeanNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admnCheckBox)
                    .addComponent(aganetCheckBox)
                    .addComponent(airbaseHourlyCheckBox)
                    .addComponent(airbaseDailyCheckBox)
                    .addComponent(aurnHourlyCheckBox)
                    .addComponent(aurnDailyCheckBox)
                    .addComponent(emepHourlyCheckBox)
                    .addComponent(emepDailyCheckBox)
                    .addComponent(emepDailyO3CheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(campaignsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(europeanNetworksPanelLayout.createSequentialGroup()
                .addComponent(speciesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        europeanNetworksPanelLayout.setVerticalGroup(
            europeanNetworksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(europeanNetworksPanelLayout.createSequentialGroup()
                .addComponent(admnCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aganetCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airbaseHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airbaseDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aurnHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aurnDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emepHourlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emepDailyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emepDailyO3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campaignsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(speciesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        europeanNetworksLabel.setText("European Networks");
        europeanNetworksLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        europeanNetworksInfoLabel.setText("Choose air quality monitoring networks to use");

        javax.swing.GroupLayout networkSpeciesPanelLayout = new javax.swing.GroupLayout(networkSpeciesPanel);
        networkSpeciesPanel.setLayout(networkSpeciesPanelLayout);
        networkSpeciesPanelLayout.setHorizontalGroup(
            networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, networkSpeciesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AQObservationNetworkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AQObservationNetworkInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AQObservationsNetworksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(europeanNetworksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(europeanNetworksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(europeanNetworksInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );
        networkSpeciesPanelLayout.setVerticalGroup(
            networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkSpeciesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AQObservationNetworkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(europeanNetworksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AQObservationNetworkInfoLabel)
                    .addComponent(europeanNetworksInfoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(networkSpeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AQObservationsNetworksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(europeanNetworksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Network/Species", networkSpeciesPanel);

        dateRangeLabel.setText("Set Date Range");
        dateRangeLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        hourRangeLabel.setText("Set Hour Range");
        hourRangeLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        hourRangeInfoLabel.setColumns(20);
        hourRangeInfoLabel.setEditable(false);
        hourRangeInfoLabel.setLineWrap(true);
        hourRangeInfoLabel.setRows(5);
        hourRangeInfoLabel.setText("Use this option to isolate a range of hours to include in the analysis. Hours are in LST. The default is to include all hours of the day in the analysis.");
        hourRangeInfoLabel.setWrapStyleWord(true);
        hourRangeInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        hourRangeInfoLabel.setOpaque(false);

        startDateLabel.setText("Start Date");

        endDatelabel.setText("End Date");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(startDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(endDatelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(startDateLabel)
                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(endDatelabel)
                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        startHourLabel.setText("Start Hour");

        startHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "12AM", "1AM", "2AM", "3AM", "4AM", "5AM", "6AM", "7AM", "8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM", "9PM", "10PM", "11PM" }));

        endHourLabel.setText("End Hour");

        endHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "12AM", "1AM", "2AM", "3AM", "4AM", "5AM", "6AM", "7AM", "8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM", "9PM", "10PM", "11PM" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(startHourLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endHourLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(startHourLabel)
                .addComponent(startHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(endHourLabel)
                .addComponent(endHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        seasonalAnalysisLabel.setText("Seasonal Analysis");
        seasonalAnalysisLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        seasonalAnalysisInfoLabel.setColumns(20);
        seasonalAnalysisInfoLabel.setEditable(false);
        seasonalAnalysisInfoLabel.setLineWrap(true);
        seasonalAnalysisInfoLabel.setRows(5);
        seasonalAnalysisInfoLabel.setText("Use this option to isolate evaluation data by a particular season of the year. When using this option, set the dates above to cover the entire season or year. All months in the season chosen must fall within the dates set above.\n\n");
        seasonalAnalysisInfoLabel.setWrapStyleWord(true);
        seasonalAnalysisInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        seasonalAnalysisInfoLabel.setOpaque(false);

        seasonalAnalysisComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Winter (Dec,Jan,Feb)", "Spring (Mar,Apr,May)", "Summer (Jun,Jul,Aug)", "Autumn (Sep,Oct,Nov)" }));

        monthlyAnalysisLabel.setText("Individual Monthly Analysis");
        monthlyAnalysisLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        monthlyAnalysisInfoLabel.setColumns(20);
        monthlyAnalysisInfoLabel.setEditable(false);
        monthlyAnalysisInfoLabel.setLineWrap(true);
        monthlyAnalysisInfoLabel.setRows(5);
        monthlyAnalysisInfoLabel.setText("Use this option to isolate a data set by an individual month of the year. When using this option, set the dates above to cover at least the entire month. It is preferrable to set the date range above to the whole year and then select an individual month from the list above.\n\n");
        monthlyAnalysisInfoLabel.setWrapStyleWord(true);
        monthlyAnalysisInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        monthlyAnalysisInfoLabel.setOpaque(false);

        monthlyAnalysisComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        POCodeLabel.setText("Select Parameter Occurrence (PO) Code");
        POCodeLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        POCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        negativeValuesInfoLabel.setColumns(20);
        negativeValuesInfoLabel.setEditable(false);
        negativeValuesInfoLabel.setLineWrap(true);
        negativeValuesInfoLabel.setRows(5);
        negativeValuesInfoLabel.setText("Select \"yes\" to remove negative values from the analysis. All values less than zero are removed from the analysis. Obviously this can be a problem when plotting species with acceptable negative values (e.g. temperature).");
        negativeValuesInfoLabel.setWrapStyleWord(true);
        negativeValuesInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        negativeValuesInfoLabel.setOpaque(false);

        negativeValuesLabel.setText("Remove negative Values");
        negativeValuesLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        POCodeInfoLabel.setColumns(20);
        POCodeInfoLabel.setEditable(false);
        POCodeInfoLabel.setLineWrap(true);
        POCodeInfoLabel.setRows(5);
        POCodeInfoLabel.setText("Use this option to isolate the data by a specific parameter occurence code. Most observations use a parameter occurence code of 1.\n");
        POCodeInfoLabel.setWrapStyleWord(true);
        POCodeInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        POCodeInfoLabel.setOpaque(false);

        negativeValuesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        aggrgateDataLabel.setText("Aggregate Data");
        aggrgateDataLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        aggrigateDataCheckBox.setText("Aggrigate Data");

        temporalAveragingInfoLabel.setColumns(20);
        temporalAveragingInfoLabel.setEditable(false);
        temporalAveragingInfoLabel.setLineWrap(true);
        temporalAveragingInfoLabel.setRows(5);
        temporalAveragingInfoLabel.setText("The default option is to use all available observations. Alternatively, monthly average values can be used for the analysis. Currently, this option really only applies to the various scatterplots that can be generated. Most of the programs that can be run use all the available pairs, and some programs require hourly data to be used.");
        temporalAveragingInfoLabel.setWrapStyleWord(true);
        temporalAveragingInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        temporalAveragingInfoLabel.setOpaque(false);

        temporalAveragingLabel.setText("Temporal Averaging");
        temporalAveragingLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        aggregateDataInfoLabel.setColumns(20);
        aggregateDataInfoLabel.setEditable(false);
        aggregateDataInfoLabel.setLineWrap(true);
        aggregateDataInfoLabel.setRows(5);
        aggregateDataInfoLabel.setText("Check this box to aggregate duplicate observations. This typically occurs when multiple measurements are reported for the same site and time period using different parameter occurance codes (POCs). Checking this box will average multiple observations into a single value. If unchecked, observations will not be averaged and each observation will be treated as entirely unique.");
        aggregateDataInfoLabel.setWrapStyleWord(true);
        aggregateDataInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        aggregateDataInfoLabel.setOpaque(false);

        temporalAveragingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Hour of Day Average", "Daily Average", "Monthly Average", "Year/Month Average", "Seasonal Average", "Annual Average", "Entire Period Average", "Day of Week" }));

        javax.swing.GroupLayout miscPanelLayout = new javax.swing.GroupLayout(miscPanel);
        miscPanel.setLayout(miscPanelLayout);
        miscPanelLayout.setHorizontalGroup(
            miscPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miscPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miscPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(negativeValuesInfoLabel)
                    .addComponent(POCodeInfoLabel)
                    .addComponent(temporalAveragingInfoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aggregateDataInfoLabel)
                    .addGroup(miscPanelLayout.createSequentialGroup()
                        .addGroup(miscPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(POCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(POCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(negativeValuesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aggrigateDataCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temporalAveragingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miscPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(miscPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(negativeValuesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aggrgateDataLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temporalAveragingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        miscPanelLayout.setVerticalGroup(
            miscPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miscPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(POCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(POCodeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(POCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(negativeValuesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(negativeValuesInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(negativeValuesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aggrgateDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aggregateDataInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aggrigateDataCheckBox)
                .addGap(18, 18, 18)
                .addComponent(temporalAveragingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temporalAveragingInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temporalAveragingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dateTimePanelLayout = new javax.swing.GroupLayout(dateTimePanel);
        dateTimePanel.setLayout(dateTimePanelLayout);
        dateTimePanelLayout.setHorizontalGroup(
            dateTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dateTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dateTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateRangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hourRangeLabel)
                        .addComponent(seasonalAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seasonalAnalysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthlyAnalysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthlyAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seasonalAnalysisInfoLabel)
                        .addComponent(monthlyAnalysisInfoLabel)
                        .addComponent(hourRangeInfoLabel))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(miscPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dateTimePanelLayout.setVerticalGroup(
            dateTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateRangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hourRangeLabel)
                .addGap(4, 4, 4)
                .addComponent(hourRangeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(seasonalAnalysisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seasonalAnalysisInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seasonalAnalysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(monthlyAnalysisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthlyAnalysisInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthlyAnalysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(miscPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Date/Time", dateTimePanel);

        pngPlotQualityLabel.setText("PNG Plot Quality");
        pngPlotQualityLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        programComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose AMET Script to Execute", "    - Scatter Plots -", "Multiple Networks Model/Ob Scatterplot (select stats only)", "GGPlot Scatterplot (multi network, single run)", "Interactive Multiple Network Scatterplot", "Interactive Multiple Simulation Scatterplot", "Single Network Model/Ob Scatterplot (includes all stats)", "Density Scatterplot (single run, single network)", "GGPlot Density Scatterplot (single run, single network)", "Model/Model Scatterplot (multiple networks)", "Model/Model Density Scatterplot (single network)", "Scatterplot of Percentiles (single network, single run)", "Ozone Skill Scatterplot (single network, mult runs)", "Binned MB &amp; RMSE Scatterplots (single net., mult. run)", "Interactive Binned Plot (single net., mult. run)", "Multi Simulation Scatter plot (single network, mult runs)", "Soil Scatter plot (single network, mult runs)", "    - Time Series Plots -", "Time-Series Plot (single network, multiple sites averages)", "Dygraph Time-series Plot", "Plotly Multi-simulation Timeseries", "Plotly Multi-network Timeseries", "Multi-Network Time-series Plot (mult. net., single run)", "Multi-Species Time-series Plot (mult. species, single run)", "Model-to-Model Time-series Plot (single net., multi run)", "Year-long Monthly Statistics Plot (single network)", "    - Spatial Plots -", "Species Statistics and Spatial Plots (multi networks)", "Interactive Species Statistics and Spatial Plots (multi networks)", "Spatial Plot (multi networks)", "Interactive Spatial Plot (multi networks)", "Model/Model Diff Spatial Plot (multi network, multi run)", "Interactive Model/Model Diff Spatial Plot (multi network, multi run)", "Model/Model Species Diff Spatial Plot (multi network, multi run)", "Spatial Plot of Bias/Error Difference (multi network, multi run)", "Interactive Spatial Plot of Bias/Error Difference (multi networks)", "Ratio Spatial Plot to total PM2.5 (multi network, multi run)", "    - Box Plots -", "Boxplot (single network, multi run)", "GGPlot Boxplot (single network, multi run)", "Plotly Boxplot (single network, multi run)", "Day of Week Boxplot (single network, multiple runs)", "Hourly Boxplot (single network, multiple runs)", "8hr Average Boxplot (single network, hourly data, can be slow)", "Roselle Boxplot (single network, multiple simulations)", "    - Stacked Bar Plots -", "PM2.5 Stacked Bar Plot (CSN or IMPROVE, multi run)", "PM2.5 Stacked Bar Plot AE6 (CSN or IMPROVE, multi run)", "Interactive Stacked Bar Plot", "GGPlot Stacked Bar Plot", "Stacked Bar Plot Time Series", "Soil Stacked Bar Plot (CSN or IMPROVE,multi run)", "Soil Stacked Bar Plot Multi (CSN and IMPROVE,single run)", "Multi-Panel Stacked Bar Plot (full year data required)", "Multi-Panel Stacked Bar Plot AE6 (full year data)", "Multi-Panel, Mulit Run Stacked Bar Plot AE6 (full year data)", "    - Misc Scripts -", "Kelly Plot (single species, single network, full year data)", "Multisim Kelly Plot (single species, single network, multi sim)", "Species Statistics (multi species, single network)", "Create raw data csv file (single network, single simulation)", "\"Soccergoal\" plot (multiple networks)", "\"Bugle\" plot (multiple networks)", "Histogram (single network/species only)", "CDF, Q-Q, Taylor Plots (single network, multi run)", "    - Experimental Scripts (may not work correctly) -", "Create PAVE/VERDI Obs Overlay File (hourly/daily data only)", "Log-Log Model/Ob Scatterplot (multiple networks)", "Spectral Analysis (single network, single run, experimental)", "PM Ratio Spatial Plot (multi network, single run)" }));

        programToRunInfoLabel.setColumns(20);
        programToRunInfoLabel.setEditable(false);
        programToRunInfoLabel.setLineWrap(true);
        programToRunInfoLabel.setRows(5);
        programToRunInfoLabel.setText("Choose which program to run to create specific stats and figures. Note that some programs require certain temporal data (e.g. hourly, monthly). For information regarding each of the programs, click here.\n\n");
        programToRunInfoLabel.setWrapStyleWord(true);
        programToRunInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        programToRunInfoLabel.setOpaque(false);

        programToRunLabel.setText("Choose Program to Run");
        programToRunLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        customTitleLabel.setText("Custom Title");
        customTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        plotlyImageSizeInfoLabel.setColumns(20);
        plotlyImageSizeInfoLabel.setEditable(false);
        plotlyImageSizeInfoLabel.setLineWrap(true);
        plotlyImageSizeInfoLabel.setRows(5);
        plotlyImageSizeInfoLabel.setText("Enter NULL for auto sizing. Enter height/width values (e.g. 900/1600) to export plot as a PNG file.");
        plotlyImageSizeInfoLabel.setWrapStyleWord(true);
        plotlyImageSizeInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        plotlyImageSizeInfoLabel.setOpaque(false);

        heightLabel.setText("Height");

        widthLabel.setText("Width");

        heightTextField.setText("900");

        widthTextField.setText("1600");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(heightLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(widthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(heightLabel)
                .addComponent(widthLabel)
                .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        plotlyImageSizeLabel.setText("Plotly Image Size");
        plotlyImageSizeLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        pngPlotQualityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));
        pngPlotQualityComboBox.setSelectedIndex(1);

        pngPlotQualityInfoLabel.setColumns(20);
        pngPlotQualityInfoLabel.setEditable(false);
        pngPlotQualityInfoLabel.setLineWrap(true);
        pngPlotQualityInfoLabel.setRows(5);
        pngPlotQualityInfoLabel.setText("Specify the image quality of the PNG plots produced. Lower quality images are smaller and load faster.");
        pngPlotQualityInfoLabel.setWrapStyleWord(true);
        pngPlotQualityInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        pngPlotQualityInfoLabel.setOpaque(false);

        advancedPlotSpcificationlabel.setText("Advanced Plot Specifications and Data Formatting");
        advancedPlotSpcificationlabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        soccergoalBugleButton.setText("Soccergoal/Bugle Plot Settings");
        soccergoalBugleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soccergoalBugleButtonActionPerformed(evt);
            }
        });

        ametPlotAxisVutton.setText("AMET Plots Axis Options");
        ametPlotAxisVutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ametPlotAxisVuttonActionPerformed(evt);
            }
        });

        scatterPlotButton.setText("Scatter Plot Options");
        scatterPlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scatterPlotButtonActionPerformed(evt);
            }
        });

        amertModelEvalStatsPlotsbutton.setText("AMET Model Eval Stats/Plots");
        amertModelEvalStatsPlotsbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amertModelEvalStatsPlotsbuttonActionPerformed(evt);
            }
        });

        overlayFileButton.setText("Overlay File Options");
        overlayFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overlayFileButtonActionPerformed(evt);
            }
        });

        customSQLQueryButton.setText("Custom SQL Query");
        customSQLQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customSQLQueryButtonActionPerformed(evt);
            }
        });

        customSQLQueryLabel.setText("Custom SQL Query");
        customSQLQueryLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        spacialPlotButton.setText("Spatial Plot Options");
        spacialPlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spacialPlotButtonActionPerformed(evt);
            }
        });

        customSQLQueryButton1.setText("Custom Site List");
        customSQLQueryButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customSQLQueryButton1ActionPerformed(evt);
            }
        });

        customSQLQueryLabel1.setText("Custom Site List");
        customSQLQueryLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advancedPlotSpcificationlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customSQLQueryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spacialPlotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customSQLQueryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(overlayFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amertModelEvalStatsPlotsbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scatterPlotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soccergoalBugleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ametPlotAxisVutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(customSQLQueryLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customSQLQueryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(advancedPlotSpcificationlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soccergoalBugleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ametPlotAxisVutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scatterPlotButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amertModelEvalStatsPlotsbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overlayFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spacialPlotButton)
                .addGap(54, 54, 54)
                .addComponent(customSQLQueryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customSQLQueryButton)
                .addGap(23, 23, 23)
                .addComponent(customSQLQueryLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customSQLQueryButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        runProgramButton1.setText("Run Program");
        runProgramButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runProgramButton1ActionPerformed(evt);
            }
        });

        PNGCheckBox.setText("Create PNG files (can be slow)");
        PNGCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNGCheckBoxActionPerformed(evt);
            }
        });

        staticPNGCheckBox.setText("Create static PNG files from HTML files (can be slow)");

        javax.swing.GroupLayout programPanelLayout = new javax.swing.GroupLayout(programPanel);
        programPanel.setLayout(programPanelLayout);
        programPanelLayout.setHorizontalGroup(
            programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programPanelLayout.createSequentialGroup()
                .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pngPlotQualityInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pngPlotQualityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programToRunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pngPlotQualityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plotlyImageSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programToRunInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(plotlyImageSizeInfoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(programComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customTitleTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(runProgramButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PNGCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(staticPNGCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        programPanelLayout.setVerticalGroup(
            programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(programToRunLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(programToRunInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(plotlyImageSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plotlyImageSizeInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PNGCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staticPNGCheckBox)
                .addGap(5, 5, 5)
                .addComponent(pngPlotQualityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pngPlotQualityInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pngPlotQualityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(runProgramButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Program", programPanel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//##############################################################################
//    LISTENER FUNCTIONS
//##############################################################################
    private void soccergoalBugleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soccergoalBugleButtonActionPerformed
        SoccergoalBugleForm sbForm = new SoccergoalBugleForm(this);
        sbForm.setVisible(true);
    }//GEN-LAST:event_soccergoalBugleButtonActionPerformed

    private void ametPlotAxisVuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ametPlotAxisVuttonActionPerformed
        AMETPlotAxisOptionsForm paoForm = new AMETPlotAxisOptionsForm(this);
        paoForm.setVisible(true);
    }//GEN-LAST:event_ametPlotAxisVuttonActionPerformed

    private void scatterPlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scatterPlotButtonActionPerformed
        ScatterPlotOptionsForm spoForm = new ScatterPlotOptionsForm(this);
        spoForm.setVisible(true);
    }//GEN-LAST:event_scatterPlotButtonActionPerformed

    private void amertModelEvalStatsPlotsbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amertModelEvalStatsPlotsbuttonActionPerformed
        AMETModleEvalStatsPlotsForm amespForm = new AMETModleEvalStatsPlotsForm(this);
        amespForm.setVisible(true);
    }//GEN-LAST:event_amertModelEvalStatsPlotsbuttonActionPerformed

    private void overlayFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overlayFileButtonActionPerformed
        OverlayFileOptionsForm ofoForm = new OverlayFileOptionsForm(this);
        ofoForm.setVisible(true);
    }//GEN-LAST:event_overlayFileButtonActionPerformed

    private void spacialPlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spacialPlotButtonActionPerformed
        SpatialPlotOptionsForm spoForm = new SpatialPlotOptionsForm(this);
        spoForm.setVisible(true);
    }//GEN-LAST:event_spacialPlotButtonActionPerformed

    private void customSQLQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customSQLQueryButtonActionPerformed
        CustomMySQLQueryForm csqlForm = new CustomMySQLQueryForm(this);
        csqlForm.setVisible(true);
    }//GEN-LAST:event_customSQLQueryButtonActionPerformed

    private void advancedSpeciesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedSpeciesButtonActionPerformed
        AdvancedSpeciesForm asForm = new AdvancedSpeciesForm(this);
        asForm.setVisible(true);
    }//GEN-LAST:event_advancedSpeciesButtonActionPerformed

    private void projectComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectComboBox1ActionPerformed

    }//GEN-LAST:event_projectComboBox1ActionPerformed

    private void geographyCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geographyCriteriaActionPerformed
        GeographicCriteriaForm gcForm = new GeographicCriteriaForm(this);
        gcForm.setVisible(true);
    }//GEN-LAST:event_geographyCriteriaActionPerformed

    private void ozonePCALinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ozonePCALinkMouseClicked
        try {
        File myFile = new File("./resources/Ozone_PCA_Regions.png");
        Desktop.getDesktop().open(myFile);
        } catch (IOException e) {
           
        }  
    }//GEN-LAST:event_ozonePCALinkMouseClicked

    private void aerosolPCALinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aerosolPCALinkMouseClicked
        try {
        File myFile = new File("./resources/Aerosol_PCA_Regions.png");
        Desktop.getDesktop().open(myFile);
        } catch (IOException e) {
           
        } 
    }//GEN-LAST:event_aerosolPCALinkMouseClicked

    private void runProgramButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runProgramButton1ActionPerformed
        saveVariables();
        if (!checkVariables()) {
            createRunInfo();
            System.out.println(query);
            executeProgram();
            outputWindow();
        }
    }//GEN-LAST:event_runProgramButton1ActionPerformed

    private void databaseSpecificationComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_databaseSpecificationComboBoxItemStateChanged
        //Check to see if database is selectable
        try {
            databaseSpecificationComboBox.getSelectedItem().toString();
        } catch (Exception e) {
            return;
        }

        //check to see if value has changed, issue with "ItemStateChange" calling twice
        if (dbase.equals(databaseSpecificationComboBox.getSelectedItem().toString())) { return; }
        
        //Populates project Combo Boxes
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        try {
            dbase = databaseSpecificationComboBox.getSelectedItem().toString();
        } catch (Exception e) {
            
        }
            
           
        if (!dbase.equals("Choose a database") || !dbase.equals("Query Failed")) {
            projectComboBox1.removeAllItems();
            projectComboBox2.removeAllItems();
            projectComboBox3.removeAllItems();
            projectComboBox4.removeAllItems();
            projectComboBox5.removeAllItems();
            projectComboBox6.removeAllItems();
            projectComboBox7.removeAllItems();
            try {
                DBConnection db = new DBConnection();
                db.getDBConnection();
                db.query("USE " + dbase + ";");
                db.query("SELECT proj_code, user_id, DATE_FORMAT(proj_date,'%m/%d/%Y'), proj_time, description FROM aq_project_log ORDER BY proj_code");
                ResultSet rs = db.getRS();
                ResultSetMetaData rsmd = rs.getMetaData();
                
                projectComboBox1.addItem(new ComboItem("Choose a Project", "Choose a Project"));
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                    String columnValue = rs.getString(1);
                    projectComboBox1.addItem(new ComboItem("Project ID: " + rs.getString(1) + ", User ID: " + rs.getString(2) + ", SetupDate: " + rs.getString(3), rs.getString(1) ));
                }

                projectComboBox2.addItem("");
                projectComboBox3.addItem("");
                projectComboBox4.addItem("");
                projectComboBox5.addItem("");
                projectComboBox6.addItem("");
                projectComboBox7.addItem("");

                for (int i = 1; i < projectComboBox1.getItemCount(); i++) {
                    projectComboBox2.addItem(projectComboBox1.getItemAt(i).toString());
                    projectComboBox3.addItem(projectComboBox1.getItemAt(i).toString());
                    projectComboBox4.addItem(projectComboBox1.getItemAt(i).toString());
                    projectComboBox5.addItem(projectComboBox1.getItemAt(i).toString());
                    projectComboBox6.addItem(projectComboBox1.getItemAt(i).toString());
                    projectComboBox7.addItem(projectComboBox1.getItemAt(i).toString());
                }

                db.closeDBConnection(); 

            } catch (SQLException e) {

            }
        }
        
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_databaseSpecificationComboBoxItemStateChanged

    private void projectComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_projectComboBox1ItemStateChanged
        //Check to see if project is selectable
        try {
            projectComboBox1.getSelectedItem().toString();
        } catch (Exception e) {
            return;
        }
        
        //check to see if value has changed, issue with "ItemStateChange" calling twice
        if (project_id.equals(projectComboBox1.getSelectedItem().toString())) { 
            return; 
        } else {
            project_id = projectComboBox1.getSelectedItem().toString();
        }
        
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                
        try {
            String database = databaseSpecificationComboBox.getSelectedItem().toString();
            DBConnection db = new DBConnection();
            db.getDBConnection();
            db.query("USE " + database + ";");
            db.query("SELECT proj_code,user_id,model,email,description,DATE_FORMAT(proj_date,'%m/%d/%Y'),proj_time,DATE_FORMAT(min_date,'%m/%d/%Y'),DATE_FORMAT(max_date,'%m/%d/%Y') FROM aq_project_log WHERE proj_code = '" + project_id + "';");
            ResultSet rs = db.getRS();
            
            while (rs.next()) {
                projectDetailsTextBox.setText( ""
                    + "Project ID: " + rs.getString(1) + "\n"
                    + "Owner: " + rs.getString(2) + "\n"
                    + "Model: " + rs.getString(3) + "\n"
                    + "Description: " + rs.getString(4) + "\n"
                    + "Project Creation Date: " + rs.getString(5) + "\n"
                    + "Earliest Record: " + rs.getString(8) + "\n"
                    + "Latest Record: " + rs.getString(9) + "\n"
                );
                //Save Project Dates
                year_start = rs.getString(8).substring(6, 10);
                month_start = rs.getString(8).substring(0, 2);
                day_start = rs.getString(8).substring(3, 5);

                year_end = rs.getString(9).substring(6, 10);
                month_end  = rs.getString(9).substring(0, 2);
                day_end  = rs.getString(9).substring(3, 5);
            }
            
            //Auto set the dates for the project
            startDatePicker.setText(year_start + "/" + month_start + "/" + day_start);
            endDatePicker.setText(year_end + "/" + month_end + "/" + day_end);
            
            
            db.closeDBConnection(); 
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query Failed");
        }
        
        //Populates species combo box
        try {
            DBConnection db = new DBConnection();
            db.getDBConnection();
            db.query("USE " + dbase + ";");
            db.query("SELECT COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='" + dbase + "' and TABLE_NAME='" + project_id + "' and COLUMN_NAME like '%_ob'order by COLUMN_NAME");

            ResultSet rs = db.getRS();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            speciesComboBox.removeAllItems();
            speciesComboBox.addItem("Choose a Species");
                while (rs.next()) {
                    String str = rs.getString(1);
                    str = str.replace("-", "_");
                    str = str.replace(".", "_");
                    str = str.replace("_ob", "");
                    speciesComboBox.addItem(str);
                }
        } catch (SQLException e) {
            errorWindow("SQLException", "Problem when trying to populate the species, table containing species possibly does not exist");
        }
        
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_projectComboBox1ItemStateChanged

    private void PNGCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNGCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PNGCheckBoxActionPerformed

    private void customSQLQueryButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customSQLQueryButton1ActionPerformed
        System.out.println("Selecting Root Directory");
        JFileChooser fc = new JFileChooser();
                    
        //sets the default location to where the jar is
        ProtectionDomain pd = AMETForm.class.getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        URL location = cs.getLocation();
        File startDir = new File(location.toString());
        fc.setCurrentDirectory(startDir);
        
        int returnVal = fc.showOpenDialog(this);
        
        siteFile = fc.getSelectedFile();
        gSiteSelector = true;
    }//GEN-LAST:event_customSQLQueryButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AQObservationNetworkInfoLabel;
    private javax.swing.JLabel AQObservationNetworkLabel;
    private javax.swing.JPanel AQObservationsNetworksPanel;
    private javax.swing.JLabel ClimateRegionLabel;
    private javax.swing.JComboBox<String> PCAComboBox;
    private javax.swing.JLabel PCAInfoLabel;
    private javax.swing.JLabel PCALabel;
    private javax.swing.JCheckBox PNGCheckBox;
    private javax.swing.JComboBox<String> POCodeComboBox;
    private javax.swing.JTextArea POCodeInfoLabel;
    private javax.swing.JLabel POCodeLabel;
    private javax.swing.JComboBox<String> RPOComboBox;
    private javax.swing.JLabel RPOInfoLabel;
    private javax.swing.JLabel RPOLabel;
    private javax.swing.JCheckBox admnCheckBox;
    private javax.swing.JLabel advancedPlotSpcificationlabel;
    private javax.swing.JButton advancedSpeciesButton;
    private javax.swing.JCheckBox aeronetCheckBox;
    private javax.swing.JLabel aerosolPCALink;
    private javax.swing.JCheckBox aganetCheckBox;
    private javax.swing.JTextArea aggregateDataInfoLabel;
    private javax.swing.JLabel aggrgateDataLabel;
    private javax.swing.JCheckBox aggrigateDataCheckBox;
    private javax.swing.JCheckBox airbaseDailyCheckBox;
    private javax.swing.JCheckBox airbaseHourlyCheckBox;
    private javax.swing.JCheckBox airmonCheckBox;
    private javax.swing.JButton amertModelEvalStatsPlotsbutton;
    private javax.swing.JButton ametPlotAxisVutton;
    private javax.swing.JCheckBox amonCheckBox;
    private javax.swing.JCheckBox aqsDailyCheckBox;
    private javax.swing.JCheckBox aqsDailyO3CheckBox;
    private javax.swing.JCheckBox aqsDailyO3OldnameCheckBox;
    private javax.swing.JCheckBox aqsDailyOAQPSO3CheckBox;
    private javax.swing.JCheckBox aqsDailyOldNameCheckBox;
    private javax.swing.JCheckBox aqsHourlyCheckBox;
    private javax.swing.JCheckBox aurnDailyCheckBox;
    private javax.swing.JCheckBox aurnHourlyCheckBox;
    private javax.swing.JCheckBox calnexCheckBox;
    private javax.swing.JPanel campaignsPanel;
    private javax.swing.JLabel campainsLabel;
    private javax.swing.JCheckBox capmonCheckBox;
    private javax.swing.JCheckBox castnetCheckBox;
    private javax.swing.JCheckBox castnetDailyCheckBox;
    private javax.swing.JCheckBox castnetDryDepCheckBox;
    private javax.swing.JCheckBox castnetHourlyCheckBox;
    private javax.swing.JComboBox<String> climateRegionComboBox;
    private javax.swing.JLabel climateRegionInfoLabel;
    private javax.swing.JCheckBox csnCheckBox;
    private javax.swing.JButton customSQLQueryButton;
    private javax.swing.JButton customSQLQueryButton1;
    private javax.swing.JLabel customSQLQueryLabel;
    private javax.swing.JLabel customSQLQueryLabel1;
    private javax.swing.JLabel customTitleLabel;
    private javax.swing.JTextField customTitleTextField;
    private javax.swing.JPanel databaseProjectPanel;
    private javax.swing.JComboBox<String> databaseSpecificationComboBox;
    private javax.swing.JLabel databaseSpecificationLabel;
    private javax.swing.JLabel dateRangeLabel;
    private javax.swing.JPanel dateTimePanel;
    private javax.swing.JComboBox<String> discoverWindowsComboBox;
    private javax.swing.JLabel discoverWindowsLabel;
    private javax.swing.JCheckBox emepDailyCheckBox;
    private javax.swing.JCheckBox emepDailyO3CheckBox;
    private javax.swing.JCheckBox emepHourlyCheckBox;
    private com.github.lgooddatepicker.components.DatePicker endDatePicker;
    private javax.swing.JLabel endDatelabel;
    private javax.swing.JComboBox<String> endHourComboBox;
    private javax.swing.JLabel endHourLabel;
    private javax.swing.JLabel europeanNetworksInfoLabel;
    private javax.swing.JLabel europeanNetworksLabel;
    private javax.swing.JPanel europeanNetworksPanel;
    private javax.swing.JCheckBox fluxnetCheckBox;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JTextArea hourRangeInfoLabel;
    private javax.swing.JLabel hourRangeLabel;
    private javax.swing.JCheckBox improveCheckBox;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox mdnCheckBox;
    private javax.swing.JPanel miscPanel;
    private javax.swing.JCheckBox model_modelCheckBox;
    private javax.swing.JComboBox<String> monthlyAnalysisComboBox;
    private javax.swing.JTextArea monthlyAnalysisInfoLabel;
    private javax.swing.JLabel monthlyAnalysisLabel;
    private javax.swing.JCheckBox nadpCheckBox;
    private javax.swing.JCheckBox napsDailyO3CheckBox;
    private javax.swing.JCheckBox napsHourlyCheckBox;
    private javax.swing.JComboBox<String> negativeValuesComboBox;
    private javax.swing.JTextArea negativeValuesInfoLabel;
    private javax.swing.JLabel negativeValuesLabel;
    private javax.swing.JPanel networkSpeciesPanel;
    private javax.swing.JCheckBox noaaESRLCheckBox;
    private javax.swing.JButton overlayFileButton;
    private javax.swing.JLabel ozonePCALink;
    private javax.swing.JTextArea plotlyImageSizeInfoLabel;
    private javax.swing.JLabel plotlyImageSizeLabel;
    private javax.swing.JComboBox<String> pngPlotQualityComboBox;
    private javax.swing.JTextArea pngPlotQualityInfoLabel;
    private javax.swing.JLabel pngPlotQualityLabel;
    private javax.swing.JComboBox<String> programComboBox;
    private javax.swing.JPanel programPanel;
    private javax.swing.JTextArea programToRunInfoLabel;
    private javax.swing.JLabel programToRunLabel;
    private javax.swing.JComboBox<ComboItem> projectComboBox1;
    private javax.swing.JComboBox<String> projectComboBox2;
    private javax.swing.JComboBox<String> projectComboBox3;
    private javax.swing.JComboBox<String> projectComboBox4;
    private javax.swing.JComboBox<String> projectComboBox5;
    private javax.swing.JComboBox<String> projectComboBox6;
    private javax.swing.JComboBox<String> projectComboBox7;
    private javax.swing.JLabel projectDetailsLabel;
    private javax.swing.JTextArea projectDetailsTextBox;
    private javax.swing.JLabel projectModelRunSpecificationLabel;
    private javax.swing.JLabel projectModelRunSpecificationLabel1;
    private javax.swing.JPanel regionAreaPanel;
    private javax.swing.JButton runProgramButton1;
    private javax.swing.JButton scatterPlotButton;
    private javax.swing.JCheckBox searchDailyCheckBox;
    private javax.swing.JCheckBox searchHourlyCheckBox;
    private javax.swing.JComboBox<String> seasonalAnalysisComboBox;
    private javax.swing.JTextArea seasonalAnalysisInfoLabel;
    private javax.swing.JLabel seasonalAnalysisLabel;
    private javax.swing.JTextArea siteIDInfoLabel;
    private javax.swing.JLabel siteIDLabel1;
    private javax.swing.JTextArea siteIDLoadInfoLabel;
    private javax.swing.JTextField siteIDLoadTextField;
    private javax.swing.JPanel siteIDPanel;
    private javax.swing.JTextField siteIDTextField;
    private javax.swing.JCheckBox soasCheckBox;
    private javax.swing.JButton soccergoalBugleButton;
    private javax.swing.JButton soccergoalBugleButton1;
    private javax.swing.JButton spacialPlotButton;
    private javax.swing.JCheckBox specialCheckBox;
    private javax.swing.JComboBox<String> speciesComboBox;
    private javax.swing.JPanel speciesPanel;
    private javax.swing.JLabel speciesToPlotLabel;
    private javax.swing.JLabel startDateLabel;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private javax.swing.JComboBox<String> startHourComboBox;
    private javax.swing.JLabel startHourLabel;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JLabel stateInfoLabel;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JCheckBox staticPNGCheckBox;
    private javax.swing.JComboBox<String> temporalAveragingComboBox;
    private javax.swing.JTextArea temporalAveragingInfoLabel;
    private javax.swing.JLabel temporalAveragingLabel;
    private javax.swing.JCheckBox toarCheckBox;
    private javax.swing.JCheckBox toxicsHAPsCheckBox;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    private javax.swing.JComboBox<String> worldRegionComboBox;
    private javax.swing.JLabel worldRegionInfoLabel;
    private javax.swing.JLabel worldRegionsLabel;
    // End of variables declaration//GEN-END:variables
}

//Class used for making combobox items contain a hidden value seperate from what appears in the GUI
class ComboItem {
    private String key;
    private String value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

//class to assist in outputing the console when running system.exec()
class StreamGobbler extends Thread
{
    InputStream is;
    String type;
    
    StreamGobbler(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
    }
    
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
                System.out.println(type + ">" + line);    
            } catch (IOException ioe)
              {
                ioe.printStackTrace();  
              }
    }
}
