package model;

import entity.AdminEntity;
import java.util.ArrayList;
import java.sql.*;

public class AdminModel extends AbstractClass{
    public ArrayList<AdminEntity> getAdmin(){
        ArrayList<AdminEntity> dataAdmin = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                AdminEntity admin = new AdminEntity();
                admin.setId(rs.getInt("id"));
                admin.setNama(rs.getString("nama"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setNoTelp(rs.getString("noTelp"));
                admin.loginAdmin.setUsername(rs.getString("username"));
                admin.loginAdmin.setPassword(rs.getString("password"));
                dataAdmin.add(admin);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return dataAdmin;
    }
    
    public ArrayList<AdminEntity> getAdmin(int id){
        ArrayList<AdminEntity> dataAdmin = new ArrayList<>();
        try{
            sql = "SELECT * FROM admin where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                AdminEntity admin = new AdminEntity();
                admin.setId(rs.getInt("id"));
                admin.setNama(rs.getString("nama"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setNoTelp(rs.getString("noTelp"));
                admin.loginAdmin.setUsername(rs.getString("username"));
                admin.loginAdmin.setPassword(rs.getString("password"));
                dataAdmin.add(admin);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return dataAdmin;
    }
    
    public int insertAdmin(String nama,String alamat,String noTelp,String username,String password){
        try{
            sql = "INSERT INTO admin(nama,alamat,noTelp,username,password) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, noTelp);
            stmt.setString(4, username);
            stmt.setString(5, password);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int deleteAdmin(int id){
        try{
            sql = "DELETE FROM admin WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int cekLogin(String username, String password) {
        int cek = 0;
        try{
            sql = "SELECT * From kurir WHERE username=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            }else{
                cek=0;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cek;
    }
    
    
    public int updatePassAdmin(int id, String password){
        try{
            sql = "UPDATE admin SET password=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
