package model;

import entity.AdminEntity;
import entity.LoginEntity;
import entity.ResiEntity;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class AdminModel extends KoneksiDataBase implements AmbilSatuData<AdminEntity>,MenghapusAkun{
    public List<AdminEntity> getAllAdmin(){
        List<AdminEntity> dataAdmin = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                dataAdmin.add(new AdminEntity(new LoginEntity(rs.getString("username"),rs.getString("password")),rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp")));
            }
        }catch(SQLException e){
            System.out.println("Tabel Tidak Ditemukan");
        }
        return dataAdmin;
    }
    
    @Override
    public List<AdminEntity> ambilSatuData(int id){
        List<AdminEntity> dataAdmin = new ArrayList<>();
        try{
            sql = "SELECT * FROM admin where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                dataAdmin.add(new AdminEntity(new LoginEntity(rs.getString("username"),rs.getString("password")),rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp")));
            }
        }catch(SQLException e){
            System.out.println("Id Tidak Ditemukan");
        }
        return dataAdmin;
    }
    
    public int insertAdmin(AdminEntity admin){
        try{
            sql = "INSERT INTO admin(nama,alamat,noTelp,username,password) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, admin.getNama());
            stmt.setString(2, admin.getAlamat());
            stmt.setString(3, admin.getNoTelp());
            stmt.setString(4, admin.getLoginAdmin().getUsername());
            stmt.setString(5, admin.getLoginAdmin().getPassword());
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Tabel Tidak Ditemukan");
            return -1;
        }
    }
    
    @Override
    public int hapusAkun(int id){
        try{
            sql = "DELETE FROM admin WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Ditemukan");
            return -1;
        }
    }
    
    public int cekLogin(String username, String password) {
        int cek = 0;
        try{
            sql = "SELECT * From admin WHERE username=? and password=?";
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
            System.out.println("Akun Tidak Ditemukan");
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
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    public int updateNamaAdmin(int id, String nama){
        try{
            sql = "UPDATE admin SET nama=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    public int updateAlamatAdmin(int id, String alamat){
        try{
            sql = "UPDATE admin SET alamat=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alamat);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    public int updateNoTelpAdmin(int id, String noTelp){
        try{
            sql = "UPDATE admin SET noTelp=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, noTelp);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    public int verifResi(int id){
        try{
            sql = "UPDATE resi SET status=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResiEntity resi = new ResiEntity();
            stmt.setInt(1, resi.getStatus());
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
}
