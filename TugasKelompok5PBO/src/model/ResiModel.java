package model;

import entity.ResiEntity;
import java.util.ArrayList;
import java.sql.*;

public class ResiModel extends AbstractClass{
    public int insert(ResiEntity resi){
        sql = "INSERT INTO resi(pengirim,penerima,paket,tanggalBerangkat,estimasiSampai) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,resi.getPenduduk().getId());
            ps.setInt(2,resi.getPenerima().getId());
            ps.setInt(3,resi.getPaket().getId());
            ps.setString(4,resi.getWaktuBerangkat());
            ps.setString(5,resi.getWaktuSampai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public ArrayList<ResiEntity> getResi(int id){
        ArrayList<ResiEntity> dataPaket = new ArrayList();
        
        try{
            sql = "SELECT * FROM paket WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ResiEntity resi = new ResiEntity();
                resi.setId(rs.getInt("id"));
                resi.getPenduduk().setId(rs.getInt("pengirim"));
                resi.getPenerima().setId(rs.getInt("penerima"));
                resi.getPaket().setId(rs.getInt("noTelpPenerima"));
                resi.setWaktuBerangkat(rs.getString("tanggalBerangkat"));
                resi.setWaktuSampai(rs.getString("estimasiSampai"));
                resi.setStatus(rs.getInt("status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }
}
