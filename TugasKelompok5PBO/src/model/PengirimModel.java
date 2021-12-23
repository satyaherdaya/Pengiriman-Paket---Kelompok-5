package model;

import entity.PengirimEntity;
import java.util.ArrayList;
import java.sql.*;

public class PengirimModel extends AbstractClass{
    public ArrayList<PengirimEntity> getUser(){
        ArrayList<PengirimEntity> dataUser = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PengirimEntity user = new PengirimEntity();
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
    
    public ArrayList<PengirimEntity> getUser(int id){
        ArrayList<PengirimEntity> arrayListUser = new ArrayList();
        try{
            sql = "SELECT * FROM pengguna where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PengirimEntity user = new PengirimEntity();
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setAlamat(rs.getString("alamat"));
                user.setNoTelp(rs.getString("noTelp"));
                user.getLoginUser().setUsername(rs.getString("username"));
                user.getLoginUser().setPassword(rs.getString("password"));
                user.setIdPaket(rs.getInt("paketId"));
                arrayListUser.add(user);
            }
        }catch(SQLException eSatya){
            System.out.println(eSatya);
        }
        return arrayListUser;        
    }
    
    public int insertUser(PengirimEntity pengirim){
        try{
            sql = "INSERT INTO pengguna(nama,alamat,noTelp,username,password) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pengirim.getNama());
            stmt.setString(2, pengirim.getAlamat());
            stmt.setString(3, pengirim.getNoTelp());
            stmt.setString(4, pengirim.getLoginUser().getUsername());
            stmt.setString(5, pengirim.getLoginUser().getPassword());
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int updateNamaUser(int id,String nama){
        try{
            sql = "UPDATE pengguna SET nama=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int updateAlamatUser(int id,String alamat){
        try{
            sql = "UPDATE pengguna SET alamat=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alamat);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int updateNoTelpUser(int id,String noTelp){
        try{
            sql = "UPDATE pengguna SET noTelp=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, noTelp);
            stmt.setInt(2, id);
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

