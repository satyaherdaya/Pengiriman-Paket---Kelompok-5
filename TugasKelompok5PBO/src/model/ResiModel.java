package model;

import entity.ResiEntity;
import java.util.ArrayList;
import java.sql.*;

public class ResiModel extends AbstractClass{
    public int insert(ResiEntity resi){
        sql = "INSERT INTO resi(id,namaPengirim,alamatPengirim,noTelpPengirim,namaPenerima,alamatPenerima,noTelpPenerima,tanggalBerangkat,estimasiSampai) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, resi.getId());
            ps.setString(2,resi.getPaket().getPenduduk().getNama());
            ps.setString(3,resi.getPaket().getPenduduk().getAlamat());
            ps.setString(4,resi.getPaket().getPenduduk().getNoTelp());
            ps.setString(5,resi.getPaket().getPenerima().getNama());
            ps.setString(6,resi.getPaket().getPenerima().getAlamat());
            ps.setString(7,resi.getPaket().getPenerima().getNoTelp());
            ps.setString(8,resi.getPaket().getWaktuBerangkat());
            ps.setString(9,resi.getPaket().getWaktuSampai());
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
                resi.getPaket().getPenduduk().setNama(rs.getString("namaPengirim"));
                resi.getPaket().getPenduduk().setAlamat(rs.getString("alamatPengirim"));
                resi.getPaket().getPenduduk().setNoTelp(rs.getString("noTelpPengirim"));
                resi.getPaket().getPenerima().setNama(rs.getString("namaPenerima"));
                resi.getPaket().getPenerima().setAlamat(rs.getString("alamatPenerima"));
                resi.getPaket().getPenerima().setNoTelp(rs.getString("noTelpPenerima"));
                resi.getPaket().setWaktuBerangkat(rs.getString("tanggalBerangkat"));
                resi.getPaket().setWaktuSampai(rs.getString("estimasiSampai"));
                resi.setStatus(rs.getInt("status"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }
}
