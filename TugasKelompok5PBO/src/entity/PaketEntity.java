package entity;

class StatusKirim{
    public static final int SELESAI=1;
}

public class PaketEntity {
    private int id;
    private UserEntity penduduk;
    private PenerimaEntity penerima;
    private String waktuBerangkat;
    private String waktuSampai;
    private int status;

    public PaketEntity(){
        status = StatusKirim.SELESAI;
    }
    
    public PaketEntity(UserEntity penduduk, PenerimaEntity penerima, String waktuBerangkat, String waktuSampai) {
        this.penduduk = penduduk;
        this.penerima = penerima;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuSampai = waktuSampai;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getPenduduk() {
        return penduduk;
    }

    public void setPenduduk(UserEntity penduduk) {
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
