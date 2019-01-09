package com.ur.project.HotelApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Rezerwacja {

    @Id
    @GeneratedValue
    private long id;

    private String tytul;
    private String imie;
    private String nazwisko;
    private String email;
    private String miasto;
    private String hotel;
    private String pokoj;
    private String lozka;
    private java.sql.Date odKiedy;
    private java.sql.Date doKiedy;

    public Rezerwacja() {
    }

    public Rezerwacja(String tytul, String imie, String nazwisko, String email, String miasto, String hotel, String pokoj, String lozka, java.sql.Date odKiedy, java.sql.Date doKiedy) {
        this.tytul = tytul;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.miasto = miasto;
        this.hotel = hotel;
        this.pokoj = pokoj;
        this.lozka = lozka;
        this.odKiedy = odKiedy;
        this.doKiedy = doKiedy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getPokoj() {
        return pokoj;
    }

    public void setPokoj(String pokoj) {
        this.pokoj = pokoj;
    }

    public String getLozka() {
        return lozka;
    }

    public void setLozka(String lozka) {
        this.lozka = lozka;
    }

    public Date getOdKiedy() {
        return odKiedy;
    }

    public void setOdKiedy(java.sql.Date odKiedy) {
        this.odKiedy = odKiedy;
    }

    public Date getDoKiedy() {
        return doKiedy;
    }

    public void setDoKiedy(java.sql.Date doKiedy) {
        this.doKiedy = doKiedy;
    }
}
