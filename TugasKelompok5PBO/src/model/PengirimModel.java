package model;

import entity.LoginEntity;
import entity.PengirimEntity;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class PengirimModel extends KoneksiDataBase implements AmbilSatuData<PengirimEntity>,MenghapusAkun{
    private List<PengirimEntity> dataPengirim = new ArrayList();
    
    public List<PengirimEntity> getAllPengirim(){
        List<PengirimEntity> dataUser = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                dataUser.add(new PengirimEntity(new LoginEntity(rs.getString("username"),rs.getString("password")),rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp")));
            }
        }catch(SQLException e){
            System.out.println("Tabel Tidak Diemukan");
        }
        return dataUser;
    }
    
    @Override
    public ArrayList<PengirimEntity> ambilSatuData(int id){
        ArrayList<PengirimEntity> arrayListUser = new ArrayList();
        try{
            sql = "SELECT * FROM pengguna where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                arrayListUser.add(new PengirimEntity(new LoginEntity(rs.getString("username"),rs.getString("password")),rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp")));
            }
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
        }
        return arrayListUser;        
    }
    
    public PengirimEntity getPengririmEntity(int id){
        try{
            sql = "SELECT * FROM pengguna where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PengirimEntity pengirim = new PengirimEntity(new LoginEntity(rs.getString("username"),rs.getString("password")),rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp"));
                dataPengirim.add(pengirim);
                return pengirim;
            }
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
        }
        return null;
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
            System.out.println("Tabel Tidak Diemukan");
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
            System.out.println("Id Tidak Diemukan");
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
            System.out.println("Id Tidak Diemukan");
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
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    public int updatePassUser(int id,String password){
        try{
            sql = "UPDATE pengguna SET password=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
            return -1;
        }
    }
    
    @Override
    public int hapusAkun(int id){
        try{
            sql = "DELETE FROM pengguna WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
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
        }catch(SQLException e){
            System.out.println("Akun Tidak Diemukan");
        }
        return cek;
    }
}

