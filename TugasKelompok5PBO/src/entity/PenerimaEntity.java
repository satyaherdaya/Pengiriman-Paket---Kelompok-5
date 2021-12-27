package entity;

public class PenerimaEntity extends PendudukEntity{

    public PenerimaEntity(int id, String nama, String alamat, String noTelp) {
        super(id, nama, alamat, noTelp);
    }
    
    public PenerimaEntity(String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
    }
}
