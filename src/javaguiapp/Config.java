//##############################################################################
// This is the config file, this is intended to be the only file that has to be
// changed when the project location is changed. 
//  
//
//  AUTHOR: Michael Dillon Sparks
//##############################################################################
package javaguiapp;

public class Config {
//##############################################################################
//   Windows
//##############################################################################
    //User inputed Variables that change depending on the environment
    
    //Note: 4 backslashes are used because 1) java requires each backslash to be doubled and 2) R requires each backslash to be doubled, hence needed 1*2*2=4 backslashes
    
    //cache_amet: directory where run_info and outfput files will be stored
    public String cache_amet = "C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Documents\\\\NetBeansProjects\\\\JavaGUIApp\\\\cache";
    //amet_base: root direcroty of AMET software, should contain Run_analysis.R scripts folder
    public String amet_base = "C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Documents\\\\AMET-master";
    //mysql_config: config file for connecting to my SQL
    public String mysql_config = "C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Documents\\\\AMET-master\\\\configure\\\\amet-config.R";
    //rscript: links to rscript.exe
    public String rscript = "C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Documents\\\\R\\\\R-4.0.4\\\\bin\\\\rscript.exe";
    //pandoc: Links to pandoc binary file for plotly files
    public String pandoc = "C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Desktop\\\\pandoc-2.12";
    
    //run_analysis: links to run_analysis, must be single slashed and backslashed
    public String run_analysis = "C:/Users/Administrator/OneDrive/Profile/Documents/AMET-master/R_analysis_code/";
    
//##############################################################################
//   Linux
//##############################################################################
//    //User inputed Variables that change depending on the environment
//    
//    //Note: 4 backslashes are used because 1) java requires each backslash to be doubled and 2) R requires each backslash to be doubled, hence needed 1*2*2=4 backslashes
//    
//    //cache_amet: directory where run_info and outfput files will be stored
//    public String cache_amet = "/home/msparks/JavaGUIApp/cache";
//    //amet_base: root direcroty of AMET software, should contain Run_analysis.R scripts folder
//    public String amet_base = "/home/msparks/AMET-master";
//    //mysql_config: config file for connecting to my SQL
//    public String mysql_config = "/home/msparks/AMET-master/configure/amet-config.R";
//    //rscript: links to rscript.exe
//    public String rscript = "/usr/local/apps/R-3.6.0/intel-19.0/bin/R --no-save <";
//    //pandoc: Links to pandoc binary file for plotly files
//    public String pandoc = "/home/msparks/pandoc-2.12";
//    
//    //run_analysis: links to run_analysis, must be single slashed 
//    public String run_analysis = "/home/msparks/AMET-master/R_analysis_code/";
//    
//    
    //DB Info, do not include completed in public release 
    public String username = "msparks";
    public String password = "[5h#8!K5S*bv";
    public String conn = "jdbc:mysql://tesla.epa.gov:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
}
