package com.ur.project.HotelApp.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String miasto;
    private String hotel;
    private String pokoj;
    private String lozka;
    private java.sql.Date odKiedy;
    private java.sql.Date doKiedy;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Rezerwacja() {
    }

    public Rezerwacja(String miasto, String hotel, String pokoj, String lozka, Date odKiedy, Date doKiedy) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public void setOdKiedy(Date odKiedy) {
        this.odKiedy = odKiedy;
    }

    public Date getDoKiedy() {
        return doKiedy;
    }

    public void setDoKiedy(Date doKiedy) {
        this.doKiedy = doKiedy;
    }
}
