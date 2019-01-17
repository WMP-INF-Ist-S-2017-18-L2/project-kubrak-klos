package com.ur.project.HotelApp.repositories;

import com.ur.project.HotelApp.model.Hotel;
import com.ur.project.HotelApp.model.Miasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findHotelsByMiasto(Miasto nazwa);
}
