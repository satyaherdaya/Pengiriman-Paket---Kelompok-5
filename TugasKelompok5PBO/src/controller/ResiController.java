package controller;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.PengirimEntity;
import entity.ResiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ResiController {
    public void insertData(PengirimEntity penduduk,PenerimaEntity penerima, PaketEntity paket,String waktuBerangkat){
        AllObjModel.resiModel.insert(new ResiEntity(penduduk,penerima,paket,waktuBerangkat));
    }
    public ArrayList<ResiEntity> getDatabyPengirim(int id){
        return AllObjModel.resiModel.getResibyPengirim(id);
    }
    
    public ArrayList<ResiEntity> getData(){
        return AllObjModel.resiModel.getResi();
    }
    
    public DefaultTableModel dataResi(){
        DefaultTableModel listDataResi = new DefaultTableModel();
        Object[] kolom = {"ID","ID PENGIRIM","NAMA PENGIRIM","ALAMAT PENGIRIM","NO TELP PENGIRIM","ID PENERIMA","NAMA PENERIMA","ALAMAT PENERIMA","NO TELP PENERIMA","ID PAKET","NAMA PAKET","BERAT PAKET","ESTIMASI SAMPAI","STATUS"};
        listDataResi.setColumnIdentifiers(kolom);
        
        int size = getData().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[14];
            data[0] = AllObjModel.resiModel.getResi().get(i).getId();
            data[1] = AllObjModel.resiModel.getResi().get(i).getPengirim().getId();
            data[2] = AllObjModel.resiModel.getResi().get(i).getPengirim().getNama();
            data[3] = AllObjModel.resiModel.getResi().get(i).getPengirim().getAlamat();
            data[4] = AllObjModel.resiModel.getResi().get(i).getPengirim().getNoTelp();
            data[5] = AllObjModel.resiModel.getResi().get(i).getPenerima().getId();
            data[6] = AllObjModel.resiModel.getResi().get(i).getPenerima().getNama();
            data[7] = AllObjModel.resiModel.getResi().get(i).getPenerima().getAlamat();
            data[8] = AllObjModel.resiModel.getResi().get(i).getPenerima().getNoTelp();
            data[9] = AllObjModel.resiModel.getResi().get(i).getPaket().getId();
            data[10] = AllObjModel.resiModel.getResi().get(i).getPaket().getNamaPaket();
            data[11] = AllObjModel.resiModel.getResi().get(i).getPaket().getBeratPaket();
            data[12] = AllObjModel.resiModel.getResi().get(i).getWaktuBerangkat();
            data[13] = AllObjModel.resiModel.getResi().get(i).getStatus();
            listDataResi.addRow(data);
        }
        return listDataResi;
    }
    
    public DefaultTableModel dataResi(int id){
        DefaultTableModel listDataResi = new DefaultTableModel();
        Object[] kolom = {"ID","ID PENGIRIM","NAMA PENGIRIM","ALAMAT PENGIRIM","NO TELP PENGIRIM","ID PENERIMA","NAMA PENERIMA","ALAMAT PENERIMA","NO TELP PENERIMA","ID PAKET","NAMA PAKET","BERAT PAKET","ESTIMASI SAMPAI","STATUS"};
        listDataResi.setColumnIdentifiers(kolom);
        
        int size = getDatabyPengirim(id).size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[14];
            data[0] = AllObjModel.resiModel.getResi().get(i).getId();
            data[1] = AllObjModel.resiModel.getResi().get(i).getPengirim().getId();
            data[2] = AllObjModel.resiModel.getResi().get(i).getPengirim().getNama();
            data[3] = AllObjModel.resiModel.getResi().get(i).getPengirim().getAlamat();
            data[4] = AllObjModel.resiModel.getResi().get(i).getPengirim().getNoTelp();
            data[5] = AllObjModel.resiModel.getResi().get(i).getPenerima().getId();
            data[6] = AllObjModel.resiModel.getResi().get(i).getPenerima().getNama();
            data[7] = AllObjModel.resiModel.getResi().get(i).getPenerima().getAlamat();
            data[8] = AllObjModel.resiModel.getResi().get(i).getPenerima().getNoTelp();
            data[9] = AllObjModel.resiModel.getResi().get(i).getPaket().getId();
            data[10] = AllObjModel.resiModel.getResi().get(i).getPaket().getNamaPaket();
            data[11] = AllObjModel.resiModel.getResi().get(i).getPaket().getBeratPaket();
            data[12] = AllObjModel.resiModel.getResi().get(i).getWaktuBerangkat();
            if(AllObjModel.resiModel.getResi().get(i).getStatus()==1){
                data[13] = "PAKET TERKIRIM";
            }else{
                data[13] = "PAKET SEDANG DI PROSES";
            }
            listDataResi.addRow(data);
        }
        return listDataResi;
    }
}
