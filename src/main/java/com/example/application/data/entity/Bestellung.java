package com.example.application.data.entity;

import java.time.LocalDate;

public class Bestellung {
    private Pizza pizza;
    private String plz;
    private String ort;
    private String strasse;    
    private String hausNummer;
    private LocalDate lieferDatum;
    private String bezahlungsart;    

    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
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
    public LocalDate getLieferDatum() {
        return lieferDatum;
    }
    public void setLieferDatum(LocalDate lieferDatum) {
        this.lieferDatum = lieferDatum;
    }
    public String getBezahlungsart() {
        return bezahlungsart;
    }
    public void setBezahlungsart(String bezahlungsart) {
        this.bezahlungsart = bezahlungsart;
    }
}
