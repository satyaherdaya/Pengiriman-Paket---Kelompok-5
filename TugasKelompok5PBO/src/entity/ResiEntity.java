package entity;

public class ResiEntity {
    protected int id;
    protected PaketEntity paket;
    private PengirimEntity penduduk;
    private PenerimaEntity penerima;
    private String waktuBerangkat;
    private String waktuSampai;
    private int status;

    public ResiEntity() {
        this.status=StatusKirim.SELESAI;
    }

    public ResiEntity(PengirimEntity penduduk, PenerimaEntity penerima,PaketEntity paket, String waktuBerangkat, String waktuSampai) {
        this.penduduk = penduduk;
        this.penerima = penerima;
        this.paket = paket;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuSampai = waktuSampai;
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

    public PengirimEntity getPenduduk() {
        return penduduk;
    }

    public void setPenduduk(PengirimEntity penduduk) {
        this.penduduk = penduduk;
    }

    public PenerimaEntity getPenerima() {
        return penerima;
    }

    public void setPenerima(PenerimaEntity penerima) {
        this.penerima = penerima;
    }

    public String getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public void setWaktuBerangkat(String waktuBerangkat) {
        this.waktuBerangkat = waktuBerangkat;
    }

    public String getWaktuSampai() {
        return waktuSampai;
    }

    public void setWaktuSampai(String waktuSampai) {
        this.waktuSampai = waktuSampai;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}