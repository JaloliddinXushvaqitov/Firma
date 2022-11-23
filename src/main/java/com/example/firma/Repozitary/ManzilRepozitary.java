package com.example.firma.Repozitary;

import com.example.firma.Entite.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManzilRepozitary extends JpaRepository<Manzil,Integer> {
}
