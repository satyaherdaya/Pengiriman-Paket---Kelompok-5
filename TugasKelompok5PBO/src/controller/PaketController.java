package controller;

import entity.PaketEntity;
import java.util.ArrayList;
import java.util.List;

public class PaketController {
    public void insertData(PaketEntity paket){
        AllObjModel.paketModel.insert(paket);
    }
    public List<PaketEntity> getData(int id){
        return AllObjModel.paketModel.getPaket(id);
    }
}
