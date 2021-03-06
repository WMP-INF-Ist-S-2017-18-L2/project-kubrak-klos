package com.ur.project.HotelApp.repositories;

import com.ur.project.HotelApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);
}
