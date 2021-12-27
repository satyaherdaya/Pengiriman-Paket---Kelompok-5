package entity;

public class PaketEntity {
    private int id;
    private String namaPaket;
    private int beratPaket;

    public PaketEntity(int id, String namaPaket, int beratPaket) {
        this.id = id;
        this.namaPaket = namaPaket;
        this.beratPaket = beratPaket;
    }

    
    public PaketEntity(String namaPaket, int beratPaket) {
        this.namaPaket = namaPaket;
        this.beratPaket = beratPaket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }

    public int getBeratPaket() {
        return beratPaket;
    }

    public void setBeratPaket(int beratPaket) {
        this.beratPaket = beratPaket;
    }
    
    
}
