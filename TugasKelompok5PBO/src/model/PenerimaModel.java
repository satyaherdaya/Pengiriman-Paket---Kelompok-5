package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.PenerimaEntity;
import java.util.List;

public class PenerimaModel extends AbstractClass{
    private String sql;
    private List<PenerimaEntity> dataPenerima = new ArrayList();
    
    public int insertPenerima(PenerimaEntity penerima){
        try{
            sql = "INSERT INTO penerima(nama,alamat,noTelp) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, penerima.getNama());
            stmt.setString(2, penerima.getAlamat());
            stmt.setString(3, penerima.getNoTelp());
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public List<PenerimaEntity> getPenerima(int id){
        List<PenerimaEntity> arrayListPenerima = new ArrayList();
        try{
            sql = "SELECT * FROM penerima where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                arrayListPenerima.add(new PenerimaEntity(rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp")));
            }
        }catch(SQLException eSatya){
            System.out.println(eSatya);
        }
        return arrayListPenerima;
    }
    
    public PenerimaEntity getPenerimaEntity(int id){
        try{
            sql = "SELECT * FROM pengguna where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PenerimaEntity penerima = new PenerimaEntity(rs.getInt("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("noTelp"));
                dataPenerima.add(penerima);
                return penerima;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
