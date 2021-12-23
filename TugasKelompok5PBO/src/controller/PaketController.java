package controller;

import entity.PaketEntity;
import java.util.ArrayList;

public class PaketController {
    public void insertData(String namaBarang, int beratBarang){
        AllObjModel.paketModel.insert(new PaketEntity(namaBarang, beratBarang));
    }
    public ArrayList<PaketEntity> getData(int id){
        return AllObjModel.paketModel.getPaket(id);
    }
}
