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
    
    public int insert(String nama, String alamat, String noTelp, String username, String password){    
        return AllObjModel.adminModel.insertAdmin(nama, alamat, noTelp, username, password);
    }
    
    public int updatePassword(int id, String password){
        return AllObjModel.adminModel.updatePassAdmin(id, password);
    }
    
    public int delete(int id){
        return AllObjModel.adminModel.deleteAdmin(id);
    }
    
    public int cekLogin(String username, String password){
        return AllObjModel.adminModel.cekLogin(username, password);
    }
}
