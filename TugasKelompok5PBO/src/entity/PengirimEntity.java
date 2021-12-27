package entity;

public class PengirimEntity extends PendudukEntity{
    protected LoginEntity loginUser;

    public PengirimEntity(LoginEntity loginUser, int id, String nama, String alamat, String noTelp) {
        super(id, nama, alamat, noTelp);
        this.loginUser = loginUser;
    }

    public PengirimEntity(LoginEntity loginUser, String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
        this.loginUser = loginUser;
    }
    
    public PengirimEntity(String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
    }

    public LoginEntity getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginEntity loginUser) {
        this.loginUser = loginUser;
    }
}
