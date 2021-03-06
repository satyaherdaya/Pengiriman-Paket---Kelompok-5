package controller;

import entity.PaketEntity;
import java.util.List;

public class PaketController implements AmbilSatuData<PaketEntity>{
    public void insertData(PaketEntity paket){
        AllObjModel.paketModel.insert(paket);
    }
    
    @Override
    public List<PaketEntity> ambilSatuData(int id){
        return AllObjModel.paketModel.ambilSatuData(id);
    }
    
    public PaketEntity getPaket(int id){
        return AllObjModel.paketModel.getPaketEntity(id);
    }
    
    public int getIdPaket(String namaPaket){
        return AllObjModel.paketModel.getIdPaket(namaPaket);
    }
}
