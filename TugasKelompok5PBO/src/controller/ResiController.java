package controller;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.PengirimEntity;
import entity.ResiEntity;
import java.util.ArrayList;

public class ResiController {
    public void insertData(PengirimEntity penduduk,PenerimaEntity penerima, PaketEntity paket,String waktuBerangkat,String waktuSampai){
        AllObjModel.resiModel.insert(new ResiEntity(penduduk,penerima,paket,waktuBerangkat,waktuSampai));
    }
    public ArrayList<ResiEntity> getData(int id){
        return AllObjModel.resiModel.getResi(id);
    }
}
