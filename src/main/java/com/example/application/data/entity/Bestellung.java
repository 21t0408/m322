package com.example.application.data.entity;

public class Bestellung {
    private String pizza;
    private String preis;
    private String plz;
    private String ort;
    private String strasse;    
    private String hausNummer;
    private String lieferDatum;
    private String bezahlungsart;    

    public String getPizza() {
        return pizza;
    }
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    public String getPreis() {
        return preis;
    }
    public void setPreis(String preis) {
        this.preis = preis;
    }
    public String getPlz() {
        return plz;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }
    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }
    public String getHausNummer() {
        return hausNummer;
    }
    public void setHausNummer(String hausNummer) {
        this.hausNummer = hausNummer;
    }
    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public String getLieferDatum() {
        return lieferDatum;
    }
    public void setLieferDatum(String lieferDatum) {
        this.lieferDatum = lieferDatum;
    }
    public String getBezahlungsart() {
        return bezahlungsart;
    }
    public void setBezahlungsart(String bezahlungsart) {
        this.bezahlungsart = bezahlungsart;
    }
}
