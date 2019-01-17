package com.ur.project.HotelApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazwa;

    @ManyToOne
    @JoinColumn(name = "miasto_id")
    private Miasto miasto;

    public Miasto getMiasto() {
        return miasto;
    }

    public void setMiasto(Miasto miasto) {
        this.miasto = miasto;
    }

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
