package entity;

public class AdminEntity extends PendudukEntity{
    public LoginEntity loginAdmin;
    
    public AdminEntity(){
    }

    public AdminEntity(LoginEntity loginAdmin, int id, String nama, String alamat, String noTelp){
        super(id, nama, alamat, noTelp);
        this.loginAdmin = loginAdmin;
    }
}
