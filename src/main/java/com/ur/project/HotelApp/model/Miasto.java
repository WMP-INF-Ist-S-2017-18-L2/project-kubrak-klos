package com.ur.project.HotelApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Miasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazwa;

    @OneToMany(mappedBy = "miasto")
    private List<Hotel> hotel;

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public List<Hotel> getHotel() {
        return hotel;
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
