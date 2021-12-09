package model;

import entity.PaketEntity;
import entity.UserEntity;
import entity.PenerimaEntity;
import java.sql.*;
import java.util.ArrayList;

public class PaketModel extends AbstractClass{
    
    public int insert(PaketEntity paket){
        sql = "INSERT INTO paket(namaPengirim,alamatPengirim,noTelpPengirim,namaPenerima,alamatPenerima,noTelpPenerima,tanggalBerangkat,estimasiSampai) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,paket.getPenduduk().getNama());
            ps.setString(2,paket.getPenduduk().getAlamat());
            ps.setString(3,paket.getPenduduk().getNoTelp());
            ps.setString(4,paket.getPenerima().getNama());
            ps.setString(5,paket.getPenerima().getAlamat());
            ps.setString(6,paket.getPenerima().getNoTelp());
            ps.setString(7,paket.getWaktuBerangkat());
            ps.setString(8,paket.getWaktuSampai());
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
                UserEntity user = new UserEntity();
                paket.setId(rs.getInt("id"));
                paket.getPenduduk().setNama(rs.getString("namaPengirim"));
                paket.getPenduduk().setAlamat(rs.getString("alamatPengirim"));
                paket.getPenduduk().setNoTelp(rs.getString("noTelpPengirim"));
                paket.getPenerima().setNama(rs.getString("namaPenerima"));
                paket.getPenerima().setAlamat(rs.getString("alamatPenerima"));
                paket.getPenerima().setNoTelp(rs.getString("noTelpPenerima"));
                paket.setWaktuBerangkat(rs.getString("tanggalBerangkat"));
                paket.setWaktuSampai(rs.getString("estimasiSampai"));
                user.setIdPaket(paket.getId());
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }

}
