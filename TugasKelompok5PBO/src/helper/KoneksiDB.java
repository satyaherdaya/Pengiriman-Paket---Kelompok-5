package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    public static Connection getKoneksi(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pengirimanbarang_db";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.out.println("Gagal Terhubung Dengan Database");
        }
        return conn;
    }
}
