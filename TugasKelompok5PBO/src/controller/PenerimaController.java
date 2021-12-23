package controller;

import entity.PenerimaEntity;

public class PenerimaController {
    public int insertPenerima(PenerimaEntity penerima){
        return AllObjModel.penerimaModel.insertPenerima(penerima);
    }
}
