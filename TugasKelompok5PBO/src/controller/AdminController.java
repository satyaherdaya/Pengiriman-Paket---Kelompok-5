package controller;

import java.util.ArrayList;
import entity.AdminEntity;
import java.util.List;

public class AdminController{
    
    public List<AdminEntity> getData(){
        return AllObjModel.adminModel.getAdmin();
    }
    
    public List<AdminEntity> getData(int id){
        return AllObjModel.adminModel.getAdmin(id);
    }
    
    public int insert(AdminEntity admin){    
        return AllObjModel.adminModel.insertAdmin(admin);
    }
    
    public int updatePassword(int id, String password){
        return AllObjModel.adminModel.updatePassAdmin(id, password);
    }
    
    public int delete(String nama){
        return AllObjModel.adminModel.deleteAdmin(nama);
    }
    
    public int cekLogin(String username, String password){
        return AllObjModel.adminModel.cekLogin(username, password);
    }
    
    public int verifResi(int id){
        return AllObjModel.adminModel.verifResi(id);
    }
}
