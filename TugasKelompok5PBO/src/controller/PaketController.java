package controller;

import entity.PaketEntity;
import java.util.ArrayList;
import java.util.List;

public class PaketController {
    public void insertData(String namaBarang, int beratBarang){
        AllObjModel.paketModel.insert(new PaketEntity(namaBarang, beratBarang));
    }
    public List<PaketEntity> getData(int id){
        return AllObjModel.paketModel.getPaket(id);
    }
}
