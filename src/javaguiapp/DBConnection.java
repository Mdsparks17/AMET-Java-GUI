package javaguiapp;

  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CONN = "";
    
    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    public void getDBConnection() throws SQLException {
        try {
            con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            System.out.println("-Connected to the Database-");
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("-Database Connection Failed-");
        }
    }
    
    public void closeDBConnection() throws SQLException {
        if(con != null && !con.isClosed()){
            con.close();
//            System.out.println("-Database Connection Closed-");
        }
    }
    
    public void query(String query) throws SQLException {
        try {
            rs = stmt.executeQuery(query);
//            System.out.println("-Executed Query-");
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("-Query Failed-");
        }
    }
    
    public void printRS() throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }
    }
    
    public ResultSet getRS() {
        return rs;
    }
    
//    public String[] getRSArray() throws SQLException {
//        return 
//    }
}
