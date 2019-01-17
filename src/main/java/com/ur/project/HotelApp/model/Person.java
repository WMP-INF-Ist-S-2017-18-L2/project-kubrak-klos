package com.ur.project.HotelApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imie;
    private String nazwisko;
    private String email;
    private String nr_tel;

    @OneToMany(mappedBy = "person")
    private List<Rezerwacja> rezerwacja;

    public Person() {
    }

    public Person(String imie, String nazwisko, String email, String nr_tel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.nr_tel = nr_tel;
    }

    public List<Rezerwacja> getRezerwacja() {
        return rezerwacja;
    }

    public void setRezerwacja(List<Rezerwacja> rezerwacja) {
        this.rezerwacja = rezerwacja;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }
}
