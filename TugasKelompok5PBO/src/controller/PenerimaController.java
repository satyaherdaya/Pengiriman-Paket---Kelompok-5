package controller;

import entity.PenerimaEntity;
import java.util.List;

public class PenerimaController {
    public int insertPenerima(PenerimaEntity penerima){
        return AllObjModel.penerimaModel.insertPenerima(penerima);
    }
    
    public List<PenerimaEntity> getPenerima(int id){
        return AllObjModel.penerimaModel.getPenerima(id);
    }
}
