package model;

import entity.PaketEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaketModel extends KoneksiDataBase implements AmbilSatuData<PaketEntity>{
    private List<PaketEntity> dataPaket = new ArrayList();
    
    public int insert(PaketEntity paket){
        sql = "INSERT INTO paket(namaPaket,beratPaket) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paket.getNamaPaket());
            ps.setInt(2, paket.getBeratPaket());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Data Tidak Boleh Kosong");
            return -1;
        }
    }
    
    @Override
    public List<PaketEntity> ambilSatuData(int id){
        List<PaketEntity> dataPaket = new ArrayList();
        
        try{
            sql = "SELECT * FROM paket WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dataPaket.add(new PaketEntity(rs.getInt("id"),rs.getString("namaBarang"),rs.getInt("beratPaket")));
            }
        }catch(Exception e){
            System.out.println("Id Tidak Diemukan");
        }
        return dataPaket;
    }
    
    public PaketEntity getPaketEntity(int id){
        try{
            sql = "SELECT * FROM paket WHERE id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PaketEntity paket = new PaketEntity(rs.getInt("id"),rs.getString("namaPaket"),rs.getInt("beratPaket"));
                dataPaket.add(paket);
                return paket;
            }
        }catch(SQLException e){
            System.out.println("Id Paket Tidak Diemukan");
        }
        return null;
    }
    
    public int getIdPaket(String namaPaket){
        int cek=0;
        try{
            sql = "SELECT * FROM paket WHERE namaPaket=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaPaket);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                cek=rs.getInt("id");
            }
        }catch(SQLException e){
            System.out.println("Id Tidak Diemukan");
        }
        return cek;
    }
}
