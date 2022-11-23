package com.example.firma.Repozitary;

import com.example.firma.Entite.Bolim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolimRepozitary extends JpaRepository<Bolim,Integer> {
}
