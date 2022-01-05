package model;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.PengirimEntity;
import entity.ResiEntity;
import java.util.ArrayList;
import java.sql.*;

public class ResiModel extends AbstractClass{
    private PengirimModel pengirimModel = new PengirimModel();
    private PenerimaModel penerimaModel = new PenerimaModel();
    private PaketModel paketModel = new PaketModel();
    
    public int insert(ResiEntity resi){
        sql = "INSERT INTO resi(pengirim,penerima,paket,tanggalBerangkat) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,resi.getPengirim().getId());
            ps.setInt(2,resi.getPenerima().getId());
            ps.setInt(3,resi.getPaket().getId());
            ps.setString(4,resi.getWaktuBerangkat());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public ArrayList<ResiEntity> getResibyPengirim(int id){
        ArrayList<ResiEntity> dataPaket = new ArrayList();
        try{
            sql = "SELECT * FROM resi WHERE pembeli in (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dataPaket.add(new ResiEntity(rs.getInt("id"),pengirimModel.getPengririmEntity(rs.getInt("pengirim")), penerimaModel.getPenerimaEntity(rs.getInt("penerima")),paketModel.getPaketEntity(rs.getInt("paket")), rs.getString("waktiBerangkat"), rs.getInt("status")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }
    
    public ArrayList<ResiEntity> getResi(){
        ArrayList<ResiEntity> dataPaket = new ArrayList();
        
        try{
            sql = "SELECT * FROM resi";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                dataPaket.add(new ResiEntity(rs.getInt("id"),pengirimModel.getPengririmEntity(rs.getInt("pengirim")), penerimaModel.getPenerimaEntity(rs.getInt("penerima")),paketModel.getPaketEntity(rs.getInt("paket")), rs.getString("waktiBerangkat"), rs.getInt("status")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataPaket;
    }
}
