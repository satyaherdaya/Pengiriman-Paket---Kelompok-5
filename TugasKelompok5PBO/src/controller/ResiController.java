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
    public ArrayList<ResiEntity> getData(int id){
        return AllObjModel.resiModel.getResi(id);
    }
    
    public ArrayList<ResiEntity> getData(){
        return AllObjModel.resiModel.getResi();
    }
    
    public DefaultTableModel dataResi(){
        DefaultTableModel listDataResi = new DefaultTableModel();
        Object[] kolom = {"ID","ID PENGIRIM","NAMA PENGIRIM","ALAMAT PENGIRIM","NO TELP PENGIRIM","ID PENERIMA","NAMA PENERIMA","ALAMAT PENERIMA","NO TELP PENERIMA","ID PAKET","NAMA PAKET","BERAT PAKET","WAKTU BERANGKAT","STATUS"};
        listDataResi.setColumnIdentifiers(kolom);
        
        int sizeSatya = getData().size();
        for(int iSatya = 0;iSatya<sizeSatya;iSatya++){
            Object[] data = new Object[14];
            data[0] = AllObjModel.resiModel.getResi().get(iSatya).getId();
            data[1] = AllObjModel.resiModel.getResi().get(iSatya).getPengirim().getId();
            data[2] = AllObjModel.resiModel.getResi().get(iSatya).getPengirim().getNama();
            data[3] = AllObjModel.resiModel.getResi().get(iSatya).getPengirim().getAlamat();
            data[4] = AllObjModel.resiModel.getResi().get(iSatya).getPengirim().getNoTelp();
            data[5] = AllObjModel.resiModel.getResi().get(iSatya).getPenerima().getId();
            data[6] = AllObjModel.resiModel.getResi().get(iSatya).getPenerima().getNama();
            data[7] = AllObjModel.resiModel.getResi().get(iSatya).getPenerima().getAlamat();
            data[8] = AllObjModel.resiModel.getResi().get(iSatya).getPenerima().getNoTelp();
            data[9] = AllObjModel.resiModel.getResi().get(iSatya).getPaket().getId();
            data[10] = AllObjModel.resiModel.getResi().get(iSatya).getPaket().getNamaPaket();
            data[11] = AllObjModel.resiModel.getResi().get(iSatya).getPaket().getBeratPaket();
            data[12] = AllObjModel.resiModel.getResi().get(iSatya).getWaktuBerangkat();
            data[13] = AllObjModel.resiModel.getResi().get(iSatya).getStatus();
            listDataResi.addRow(data);
        }
        return listDataResi;
    }
}
