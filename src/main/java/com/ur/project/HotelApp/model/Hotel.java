package com.ur.project.HotelApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue
    private long id;

    private String nazwa;

//    @ManyToOne
//    private List<Miasto> city;
//
//    public List<Miasto> getMiasto() {
//        return city;
//    }
//
//    public void setMiasto(List<Miasto> city) {
//        this.city = city;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
