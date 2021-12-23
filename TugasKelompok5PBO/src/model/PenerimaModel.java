package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.PenerimaEntity;

public class PenerimaModel extends AbstractClass{
    private String sql;
    
    
    public int insertPenerima(PenerimaEntity penerima){
        try{
            sql = "INSERT INTO penerima(nama,alamat,noTelp) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, penerima.getNama());
            stmt.setString(2, penerima.getAlamat());
            stmt.setString(3, penerima.getNoTelp());;
            return stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public ArrayList<PenerimaEntity> getPenerima(int id){
        ArrayList<PenerimaEntity> arrayListPenerima = new ArrayList();
        try{
            sql = "SELECT * FROM penerima where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PenerimaEntity penerima = new PenerimaEntity();
                penerima.setId(rs.getInt("id"));
                penerima.setNama(rs.getString("nama"));
                penerima.setAlamat(rs.getString("alamat"));
                penerima.setNoTelp(rs.getString("noTelp"));
                arrayListPenerima.add(penerima);
            }
        }catch(SQLException eSatya){
            System.out.println(eSatya);
        }
        return arrayListPenerima;        
    }
}
