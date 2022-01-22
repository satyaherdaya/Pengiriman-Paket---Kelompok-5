package model;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.PengirimEntity;
import entity.ResiEntity;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ResiModel extends KoneksiDataBase implements AmbilSatuData<ResiEntity>{
    private PengirimModel pengirimModel = new PengirimModel();
    private PenerimaModel penerimaModel = new PenerimaModel();
    private PaketModel paketModel = new PaketModel();
    
    public int insert(ResiEntity resi){
        sql = "INSERT INTO resi(pengirim,penerima,paket,waktuBerangkat) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,resi.getPengirim().getId());
            ps.setInt(2,resi.getPenerima().getId());
            ps.setInt(3,resi.getPaket().getId());
            ps.setString(4,resi.getWaktuBerangkat());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Data salah");
            return -1;
        }
    }
    
    @Override
    public ArrayList<ResiEntity> ambilSatuData(int id){
        ArrayList<ResiEntity> dataPaket = new ArrayList();
        try{
            sql = "SELECT * FROM resi WHERE pengirim LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dataPaket.add(new ResiEntity(rs.getInt("id"),pengirimModel.getPengririmEntity(rs.getInt("pengirim")), penerimaModel.getPenerimaEntity(rs.getInt("penerima")),paketModel.getPaketEntity(rs.getInt("paket")), rs.getString("waktuBerangkat"), rs.getInt("status")));
            }
        }catch(Exception e){
            System.out.println("Id Resi Tidak Diemukan");
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
                dataPaket.add(new ResiEntity(rs.getInt("id"),pengirimModel.getPengririmEntity(rs.getInt("pengirim")), penerimaModel.getPenerimaEntity(rs.getInt("penerima")),paketModel.getPaketEntity(rs.getInt("paket")), rs.getString("waktuBerangkat"), rs.getInt("status")));
            }
        }catch(Exception e){
            System.out.println("Id Tidak Diemukan");
        }
        return dataPaket;
    }
    
    public DefaultTableModel dataResi(){
        DefaultTableModel listDataResi = new DefaultTableModel();
        Object[] kolom = {"ID","ID PENGIRIM","NAMA PENGIRIM","ALAMAT PENGIRIM","NO TELP PENGIRIM","ID PENERIMA","NAMA PENERIMA","ALAMAT PENERIMA","NO TELP PENERIMA","ID PAKET","NAMA PAKET","BERAT PAKET","ESTIMASI SAMPAI","STATUS"};
        listDataResi.setColumnIdentifiers(kolom);
        
        int size = getResi().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[14];
            data[0] = getResi().get(i).getId();
            data[1] = getResi().get(i).getPengirim().getId();
            data[2] = getResi().get(i).getPengirim().getNama();
            data[3] = getResi().get(i).getPengirim().getAlamat();
            data[4] = getResi().get(i).getPengirim().getNoTelp();
            data[5] = getResi().get(i).getPenerima().getId();
            data[6] = getResi().get(i).getPenerima().getNama();
            data[7] = getResi().get(i).getPenerima().getAlamat();
            data[8] = getResi().get(i).getPenerima().getNoTelp();
            data[9] = getResi().get(i).getPaket().getId();
            data[10] = getResi().get(i).getPaket().getNamaPaket();
            data[11] = getResi().get(i).getPaket().getBeratPaket();
            data[12] = getResi().get(i).getWaktuBerangkat();
            data[13] = getResi().get(i).getStatus();
            listDataResi.addRow(data);
        }
        return listDataResi;
    }
    
    public DefaultTableModel dataResi(int id){
        DefaultTableModel listDataResi = new DefaultTableModel();
        Object[] kolom = {"ID","ID PENGIRIM","NAMA PENGIRIM","ALAMAT PENGIRIM","NO TELP PENGIRIM","ID PENERIMA","NAMA PENERIMA","ALAMAT PENERIMA","NO TELP PENERIMA","ID PAKET","NAMA PAKET","BERAT PAKET","ESTIMASI SAMPAI","STATUS"};
        listDataResi.setColumnIdentifiers(kolom);
        
        int size = ambilSatuData(id).size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[14];
            data[0] = getResi().get(i).getId();
            data[1] = getResi().get(i).getPengirim().getId();
            data[2] = getResi().get(i).getPengirim().getNama();
            data[3] = getResi().get(i).getPengirim().getAlamat();
            data[4] = getResi().get(i).getPengirim().getNoTelp();
            data[5] = getResi().get(i).getPenerima().getId();
            data[6] = getResi().get(i).getPenerima().getNama();
            data[7] = getResi().get(i).getPenerima().getAlamat();
            data[8] = getResi().get(i).getPenerima().getNoTelp();
            data[9] = getResi().get(i).getPaket().getId();
            data[10] = getResi().get(i).getPaket().getNamaPaket();
            data[11] = getResi().get(i).getPaket().getBeratPaket();
            data[12] = getResi().get(i).getWaktuBerangkat();
            if(getResi().get(i).getStatus()==1){
                data[13] = "PAKET TERKIRIM";
            }else{
                data[13] = "PAKET SEDANG DI PROSES";
            }
            listDataResi.addRow(data);
        }
        return listDataResi;
    }
}
