package entity;

public class KurirEntity extends PendudukEntity{
    public LoginEntity loginKurir;
    
    public KurirEntity(){
    }

    public KurirEntity(LoginEntity lobinEntity, int id, String nama, String alamat, String noTelp,LoginEntity loginKurir) {
        super(id, nama, alamat, noTelp);
        this.loginKurir = loginKurir;
    }
}
