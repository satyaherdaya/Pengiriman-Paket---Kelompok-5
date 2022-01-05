package controller;

import java.util.ArrayList;
import entity.AdminEntity;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
    
    public int updateNama(int id, String nama){
        return AllObjModel.adminModel.updateNamaAdmin(id, nama);
    }
    
    public int updateAlamat(int id, String alamat){
        return AllObjModel.adminModel.updateAlamatAdmin(id, alamat);
    }
    
    public int updateNoTelp(int id, String noTelp){
        return AllObjModel.adminModel.updateNoTelpAdmin(id, noTelp);
    }
    
    public int delete(int id){
        return AllObjModel.adminModel.deleteAdmin(id);
    }
    
    public int cekLogin(String username, String password){
        return AllObjModel.adminModel.cekLogin(username, password);
    }
    
    public int verifResi(int id){
        return AllObjModel.adminModel.verifResi(id);
    }
    
    public DefaultTableModel dataAdmin(){
        DefaultTableModel listDataAdmin = new DefaultTableModel();
        Object[] kolom = {"ID","NAMA","ALAMAT","NO TELP"};
        listDataAdmin.setColumnIdentifiers(kolom);
        
        int size = getData().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[14];
            data[0] = AllObjModel.adminModel.getAdmin().get(i).getId();
            data[1] = AllObjModel.adminModel.getAdmin().get(i).getNama();
            data[2] = AllObjModel.adminModel.getAdmin().get(i).getAlamat();
            data[3] = AllObjModel.adminModel.getAdmin().get(i).getNoTelp();
            listDataAdmin.addRow(data);
        }
        return listDataAdmin;
    }
}
