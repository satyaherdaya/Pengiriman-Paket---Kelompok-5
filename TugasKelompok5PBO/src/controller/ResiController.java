package controller;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.PengirimEntity;
import entity.ResiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ResiController implements AmbilSatuData<ResiEntity>{
    public void insertData(PengirimEntity penduduk,PenerimaEntity penerima, PaketEntity paket,String waktuBerangkat){
        AllObjModel.resiModel.insert(new ResiEntity(penduduk,penerima,paket,waktuBerangkat));
    }
    
    @Override
    public ArrayList<ResiEntity> ambilSatuData(int id){
        return AllObjModel.resiModel.ambilSatuData(id);
    }
    
    public ArrayList<ResiEntity> getData(){
        return AllObjModel.resiModel.getResi();
    }
    
    public DefaultTableModel dataResi(){
        return AllObjModel.resiModel.dataResi();
    }
    
    public DefaultTableModel dataResi(int id){
        return AllObjModel.resiModel.dataResi(id);
    }
}
