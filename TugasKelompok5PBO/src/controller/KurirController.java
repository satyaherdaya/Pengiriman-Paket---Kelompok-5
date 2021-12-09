package controller;

import entity.KurirEntity;
import java.util.ArrayList;
import java.util.Scanner;

public class KurirController{
    private static Scanner input = new Scanner(System.in);
    
    public ArrayList<KurirEntity> getData(){
        return AllObjModel.kurirModel.getKurir();
    }
    public ArrayList<KurirEntity> getData(int id){
        return AllObjModel.kurirModel.getKurir(id);
    }
    public void insertKurir(String nama, String alamat, String noTelp, String username, String password){
        AllObjModel.kurirModel.insertKurir(nama, alamat, noTelp, username, password);
    }
    
    public void updateBoidataKurir(int id, String nama, String alamat, String noTelp){
        AllObjModel.kurirModel.updateBiodataKurir(id, nama, alamat, noTelp);
    }
    
    public void updatePassKurir(int id, String password){
        AllObjModel.kurirModel.updatePassKurir(id, password);
    }
    
    public void delete(int id){
        AllObjModel.kurirModel.deleteKurir(id);
    }
    
    
}
