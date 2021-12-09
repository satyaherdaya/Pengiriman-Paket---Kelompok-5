package model;

import entity.KurirEntity;
import java.util.ArrayList;
import java.sql.*;

public class KurirModel extends AbstractClass{
    public ArrayList<KurirEntity> getKurir(){
        ArrayList<KurirEntity> dataKurir = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kurir";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                KurirEntity kurir = new KurirEntity();
                kurir.setId(rs.getInt("id"));
                kurir.setNama(rs.getString("nama"));
                kurir.setAlamat(rs.getString("alamat"));
                kurir.setNoTelp(rs.getString("noTelp"));
                kurir.loginKurir.setUsername(rs.getString("username"));
                kurir.loginKurir.setPassword(rs.getString("password"));
                dataKurir.add(kurir);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return dataKurir;
    }
    
    public ArrayList<KurirEntity> getKurir(int id){
        ArrayList<KurirEntity> arrayListUser = new ArrayList();
        try{
            sql = "SELECT * FROM kurir where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                KurirEntity UserEntity = new KurirEntity();
                UserEntity.setId(rs.getInt("id"));
                UserEntity.setNama(rs.getString("nama"));
                UserEntity.setAlamat(rs.getString("alamat"));
                UserEntity.loginKurir.setUsername(rs.getString("username"));
                UserEntity.loginKurir.setPassword(rs.getString("password"));
                arrayListUser.add(UserEntity);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return arrayListUser;        
    }
    
    public int insertKurir(String nama,String alamat,String noTelp,String username,String password){
        try{
            sql = "INSERT INTO kurir(nama,alamat,noTelp,username,password) values(?,?,?,?,?)";
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
    
    public int updateBiodataKurir(int id,String nama,String alamat,String noTelp){
        try{
            sql = "UPDATE kurir SET nama=?, alamat=?, noTelp=?, password=?, WHERE id=?";
            PreparedStatement stmt07351 = conn.prepareStatement(sql);
            stmt07351.setString(id, nama);
            stmt07351.setString(id, alamat);
            stmt07351.setString(id, noTelp);
            return stmt07351.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int updatePassKurir(int id,String password){
        try{
            sql = "UPDATE kurir SET password=?, WHERE id=?";
            PreparedStatement stmt07351 = conn.prepareStatement(sql);
            stmt07351.setString(id, password);
            return stmt07351.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();;
            return -1;
        }
    }
    
    public int deleteKurir(int id){
        try{
            sql = "DELETE FROM kurir WHERE id=?";
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
}
