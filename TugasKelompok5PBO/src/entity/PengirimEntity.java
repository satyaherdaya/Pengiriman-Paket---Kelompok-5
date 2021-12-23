package entity;

public class PengirimEntity extends PendudukEntity{
    protected LoginEntity loginUser;
    protected int idPaket;
    protected int resiId;
    
    public PengirimEntity() {
    }

    public PengirimEntity(LoginEntity loginUser, String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
        this.loginUser = loginUser;
    }

    public LoginEntity getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginEntity loginUser) {
        this.loginUser = loginUser;
    }

    public int getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(int idPaket) {
        this.idPaket = idPaket;
    }

    public int getResiId() {
        return resiId;
    }

    public void setResiId(int resiId) {
        this.resiId = resiId;
    }
}
