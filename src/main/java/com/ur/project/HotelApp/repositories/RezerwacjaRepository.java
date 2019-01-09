package com.ur.project.HotelApp.repositories;

import com.ur.project.HotelApp.model.Rezerwacja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Long> {
    public Rezerwacja save(Rezerwacja a);

}
