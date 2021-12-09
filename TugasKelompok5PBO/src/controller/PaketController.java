package controller;

import entity.PaketEntity;
import entity.PenerimaEntity;
import entity.UserEntity;
import java.util.ArrayList;

public class PaketController {
    public void insertData(UserEntity penduduk,PenerimaEntity penerima,String waktuBerangkat,String waktuSampai){
        AllObjModel.paketModel.insert(new PaketEntity(penduduk,penerima,waktuBerangkat,waktuSampai));
    }
    public ArrayList<PaketEntity> getData(int id){
        return AllObjModel.paketModel.getPaket(id);
    }
}
