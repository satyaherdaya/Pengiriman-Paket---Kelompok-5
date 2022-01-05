package controller;

import entity.PengirimEntity;
import entity.LoginEntity;
import java.util.ArrayList;
import java.util.List;

public class PengirirmController{
    
    public List<PengirimEntity> getData(){
        return AllObjModel.pengirimModel.getPengirim();
    }
    
    public List<PengirimEntity> getData(int id){
        return AllObjModel.pengirimModel.getPengirim(id);
    }
    
    public PengirimEntity getPengirim(int id){
        return AllObjModel.pengirimModel.getPengririmEntity(id);
    }
    
    public int insert(PengirimEntity pengirim){
        return AllObjModel.pengirimModel.insertUser(pengirim);
    }
    
    public int updateNamaUser(int id, String nama){
        return AllObjModel.pengirimModel.updateNamaUser(id, nama);
    }
    
    public int updateAlamatUser(int id, String alamat){
        return AllObjModel.pengirimModel.updateAlamatUser(id, alamat);
    }
    
    public int updateNoTelpUser(int id, String noTelp){
        return AllObjModel.pengirimModel.updateNoTelpUser(id, noTelp);
    }
    
    public int updatePassUser(int id, String password){
        return AllObjModel.pengirimModel.updatePassUser(id, password);
    }
    
    public int delete(int id){
        return AllObjModel.pengirimModel.deleteUser(id);
    }
    
    public int cekLogin(String username, String password){
        return AllObjModel.pengirimModel.cekLogin(username, password);
    }
}
