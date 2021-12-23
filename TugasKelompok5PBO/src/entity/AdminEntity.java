package entity;

public class AdminEntity extends PendudukEntity{
    public LoginEntity loginAdmin;
    
    public AdminEntity(){
    }

    public AdminEntity(LoginEntity loginAdmin, String nama, String alamat, String noTelp){
        super(nama, alamat, noTelp);
        this.loginAdmin = loginAdmin;
    }
}
