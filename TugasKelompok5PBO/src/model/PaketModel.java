package model;

import entity.PaketEntity;
import java.sql.*;
import java.util.ArrayList;

public class PaketModel extends AbstractClass{
    
    public int insert(PaketEntity paket){
        sql = "INSERT INTO paket(namaBarang,beratBarang) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paket.getNamaPaket());
            ps.setInt(2, paket.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public ArrayList<PaketEntity> getPaket(int id){
        ArrayList<PaketEntity> dataPaket = new ArrayList();
        
        try{
            sql = "SELECT * FROM paket WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PaketEntity paket = new PaketEntity();
                paket.setId(rs.getInt("id"));
                paket.setNamaPaket(rs.getString("namaBarang"));
                paket.setBeratPaket(rs.getInt("beratPaket"));                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }

}
