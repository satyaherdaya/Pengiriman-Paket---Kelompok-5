package entity;

public class ResiEntity {
    protected int id;
    protected PaketEntity paket;
    protected int status;

    public ResiEntity() {
        this.status=StatusKirim.SELESAI;
    }
    
    public ResiEntity(PaketEntity paket) {
        this.id = paket.getId();
        this.paket = paket;
        this.status = paket.getStatus();
    }

    public int getId() {
        return id;
    }

    public PaketEntity getPaket() {
        return paket;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaket(PaketEntity paket) {
        this.paket = paket;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
