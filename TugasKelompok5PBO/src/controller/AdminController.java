package controller;

import java.util.ArrayList;
import entity.AdminEntity;

public class AdminController{
    
    public ArrayList<AdminEntity> getData(){
        return AllObjModel.adminModel.getAdmin();
    }
    
    public ArrayList<AdminEntity> getData(int id){
        return AllObjModel.adminModel.getAdmin(id);
    }
    
    public void insert(String nama, String alamat, String noTelp, String username, String password){    
        AllObjModel.adminModel.insertAdmin(nama, alamat, noTelp, username, password);
    }
    
    public void updatePassword(int id, String password){
        AllObjModel.adminModel.updatePassAdmin(id, password);
    }
    
    public void delete(int id){
        AllObjModel.adminModel.deleteAdmin(id);
    }
}
