package entity;

public class AdminEntity extends PendudukEntity{
    private LoginEntity loginAdmin;

    public AdminEntity(LoginEntity loginAdmin, int id, String nama, String alamat, String noTelp) {
        super(id, nama, alamat, noTelp);
        this.loginAdmin = loginAdmin;
    }
    
    public AdminEntity(LoginEntity loginAdmin, String nama, String alamat, String noTelp){
        super(nama, alamat, noTelp);
        this.loginAdmin = loginAdmin;
    }

    public LoginEntity getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(LoginEntity loginAdmin) {
        this.loginAdmin = loginAdmin;
    }
}
