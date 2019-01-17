package com.ur.project.HotelApp.repositories;

import com.ur.project.HotelApp.model.Miasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiastoRepository extends JpaRepository<Miasto, Long> {
}
