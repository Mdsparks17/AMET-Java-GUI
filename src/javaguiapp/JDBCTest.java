package javaguiapp;

import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class JDBCTest { public static void main(String[] args) {   
    Test test = new Test();  
    test.run();  
}}

class Test {
    public void run() {
        String str = "and (";
        
        try {
//            System.out.println("1");
            Object obj = new JSONParser().parse(new FileReader("C:\\\\Users\\\\Administrator\\\\OneDrive\\\\Profile\\\\Documents\\\\NetBeansProjects\\\\JavaGUIApp\\\\cache" + "/" + "sites.Json"));
//            System.out.println("2");
            JSONObject jo = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jo.get("locations");
//            System.out.println("3");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext()) {
//                System.out.println(iterator.next().get("stat_id"));
                str += iterator.next().get("stat_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(str);
    }
        
        
//         try {
//            DBConnection db = new DBConnection();
//            db.getDBConnection();
//            db.query("USE amad_CMAQ_v53_Dev;");                
//            db.query("SELECT stat_id, num_stat_id, stat_name, network, co_network, state, city, start_date, end_date, lat, lon, elevation, landuse, loc_setting, county, timezone, GMT_Offset, near_road, country from site_metadata");
////            db.query("SHOW databases;");
//            ResultSet rs = db.getRS();
//            
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
//            while (rs.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",");
//                    String columnValue = rs.getString(i);
//                    System.out.print(columnValue);
//                      
//                    if (i > 1) str += ",";
//                    String comlumnValue = rs.getString(i);
//                    str += comlumnValue;
//                }
//                str += "\n";
//                System.out.print("\n");
//            }
//            db.closeDBConnection(); 
//        } catch (SQLException e) {
//             e.printStackTrace();
//        } catch (NullPointerException e) {
//             e.printStackTrace();
//        } 
//         
//        System.out.print(str);
//        
//        NewFile file = new NewFile(true, "./cache/data.csv");
//        file.openWriter();
//        file.writeTo(str);
//        file.closeWriter();
//    }
    
    public void stop() {
        
    }
}