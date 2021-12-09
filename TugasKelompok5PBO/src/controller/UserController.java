package controller;

import entity.UserEntity;
import java.util.ArrayList;

public class UserController{
    
    public ArrayList<UserEntity> getData(){
        return AllObjModel.userModel.getUser();
    }
    
    public ArrayList<UserEntity> getData(int id){
        return AllObjModel.userModel.getUser(id);
    }
    
    public void insert(String nama, String alamat, String noTelp, String username, String password){
        AllObjModel.userModel.insertUser(nama, alamat, noTelp, username, password);
    }
    
    public void updateBoidataUser(int id, String nama, String alamat, String noTelp){
        AllObjModel.userModel.updateBiodataUser(id, nama, alamat, noTelp);
    }
    
    public void updatePassUser(int id, String password){
        AllObjModel.userModel.updatePassUser(id, password);
    }
    
    public void delete(int id){
        AllObjModel.userModel.deleteUser(id);
    }
}
