package model;

import entity.UserEntity;
import java.util.ArrayList;
import java.sql.*;

public class UserModel extends AbstractClass{
    public ArrayList<UserEntity> getUser(){
        ArrayList<UserEntity> dataUser = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                UserEntity user = new UserEntity();
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setAlamat(rs.getString("alamat"));
                user.setNoTelp(rs.getString("noTelp"));
                user.getLoginUser().setUsername(rs.getString("username"));
                user.getLoginUser().setPassword(rs.getString("password"));
                dataUser.add(user);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return dataUser;
    }
    
    public ArrayList<UserEntity> getUser(int id){
        ArrayList<UserEntity> arrayListUser = new ArrayList();
        try{
            sql = "SELECT * FROM pengguna where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                UserEntity UserEntity = new UserEntity();
                UserEntity.setId(rs.getInt("id"));
                UserEntity.setNama(rs.getString("nama"));
                UserEntity.setAlamat(rs.getString("alamat"));
                UserEntity.getLoginUser().setUsername(rs.getString("username"));
                UserEntity.getLoginUser().setPassword(rs.getString("password"));
                UserEntity.setIdPaket(rs.getInt("paketId"));
                arrayListUser.add(UserEntity);
            }
        }catch(SQLException eSatya){
            System.out.println(eSatya);
        }
        return arrayListUser;        
    }
    
    public int insertUser(String nama,String alamat,String noTelp,String username,String password){
        try{
            sql = "INSERT INTO pengguna(nama,alamat,noTelp,username,password) values(?,?,?,?,?)";
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
    
    public int updateBiodataUser(int id,String nama,String alamat,String noTelp){
        try{
            sql = "UPDATE pengguna SET nama=?, alamat=?, noTelp=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setString(3, noTelp);
            stmt.setInt(4, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int updatePassUser(int id,String password){
        try{
            sql = "UPDATE pengguna SET password=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int deleteUser(int id){
        try{
            sql = "DELETE FROM pengguna WHERE id=?";
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
            sql = "SELECT * From pengguna WHERE username=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rsSatya = stmt.executeQuery();
            if(rsSatya.next()){
                cek = rsSatya.getInt("id");
                String namaSatya = rsSatya.getString("nama");
                System.out.println("Selamat Datang " + namaSatya);
            }else{
                cek=0;
            }
        }catch(SQLException eSatya){
            eSatya.printStackTrace();
        }
        return cek;
    }
}

