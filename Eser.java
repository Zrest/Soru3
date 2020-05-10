package com.example.sehirtanitmakonya42;

public class Eser {
    int id;
    String Eser_ad;
    String Eser_tarih;
    String Eser_aciklama;
    String Eser_resim;

    public Eser(int id, String eser_ad, String eser_tarih, String eser_aciklama, String eser_resim) {
        this.id = id;
        Eser_ad = eser_ad;
        Eser_tarih = eser_tarih;
        Eser_aciklama = eser_aciklama;
        Eser_resim = eser_resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEser_ad() {
        return Eser_ad;
    }

    public void setEser_ad(String eser_ad) {
        Eser_ad = eser_ad;
    }

    public String getEser_tarih() {
        return Eser_tarih;
    }

    public void setEser_tarih(String eser_tarih) {
        Eser_tarih = eser_tarih;
    }

    public String getEser_aciklama() {
        return Eser_aciklama;
    }

    public void setEser_aciklama(String eser_aciklama) {
        Eser_aciklama = eser_aciklama;
    }

    public String getEser_resim() {
        return Eser_resim;
    }

    public void setEser_resim(String eser_resim) {
        Eser_resim = eser_resim;
    }
}
