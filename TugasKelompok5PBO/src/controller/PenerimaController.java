package controller;

import entity.PenerimaEntity;
import java.util.List;

public class PenerimaController implements AmbilSatuData<PenerimaEntity>{
    public int insertPenerima(PenerimaEntity penerima){
        return AllObjModel.penerimaModel.insertPenerima(penerima);
    }
    
    @Override
    public List<PenerimaEntity> ambilSatuData(int id){
        return AllObjModel.penerimaModel.ambilSatuData(id);
    }
    
    public PenerimaEntity getPenerima(int id){
        return AllObjModel.penerimaModel.getPenerimaEntity(id);
    }
    
    public int getIdPenerima(PenerimaEntity penerima){
        return AllObjModel.penerimaModel.getIdPenerima(penerima);
    }
}
