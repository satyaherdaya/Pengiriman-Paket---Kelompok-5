package controller;

import entity.PaketEntity;
import entity.ResiEntity;
import java.util.ArrayList;

public class ResiController {
    public void insertData(PaketEntity paket){
        AllObjModel.resiModel.insert(new ResiEntity(paket));
    }
    public ArrayList<ResiEntity> getData(int id){
        return AllObjModel.resiModel.getResi(id);
    }
}
