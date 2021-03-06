package entity;

class StatusKirim{
    public static final int SELESAI=1;
}

public class ResiEntity {
    private int id;
    private PengirimEntity pengirim;
    private PenerimaEntity penerima;
    private PaketEntity paket;
    private String estimasiSampai;
    private int status;


    public ResiEntity(PengirimEntity pengirim, PenerimaEntity penerima,PaketEntity paket, String waktuBerangkat) {
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.paket = paket;
        this.estimasiSampai = waktuBerangkat;
    }

    public ResiEntity(int id, PengirimEntity pengirim, PenerimaEntity penerima,PaketEntity paket, String estimasiSampai, int status) {
        this.id = id;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.paket = paket;
        this.estimasiSampai = estimasiSampai;
        this.status = status;
    }

    public ResiEntity(int id) {
        this.id=id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaketEntity getPaket() {
        return paket;
    }

    public void setPaket(PaketEntity paket) {
        this.paket = paket;
    }

    public PengirimEntity getPengirim() {
        return pengirim;
    }

    public void setPengirim(PengirimEntity pengirim) {
        this.pengirim = pengirim;
    }

    public PenerimaEntity getPenerima() {
        return penerima;
    }

    public void setPenerima(PenerimaEntity penerima) {
        this.penerima = penerima;
    }

    public String getWaktuBerangkat() {
        return estimasiSampai;
    }

    public void setWaktuBerangkat(String estimasiSampai) {
        this.estimasiSampai = estimasiSampai;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = StatusKirim.SELESAI;
    }
}