package controller;

import entity.AdminEntity;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AdminController implements AmbilSatuData<AdminEntity>,HapusAkun{
    
    public List<AdminEntity> getData(){
        return AllObjModel.adminModel.getAllAdmin();
    }
    
    @Override
    public List<AdminEntity> ambilSatuData(int id){
        return AllObjModel.adminModel.ambilSatuData(id);
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
    
    @Override
    public int hapusAkun(int id){
        return AllObjModel.adminModel.hapusAkun(id);
    }
    
    public int cekLogin(String username, String password){
        return AllObjModel.adminModel.cekLogin(username, password);
    }
    
    public int verifResi(int id){
        return AllObjModel.adminModel.verifResi(id);
    }
    
    public DefaultTableModel dataAdmin(){
        return AllObjModel.adminModel.dataAdmin();
    }
}
