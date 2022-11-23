package com.example.firma.Repozitary;

import com.example.firma.Entite.Firma;
import com.example.firma.Entite.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FirmaRepozitary extends JpaRepository<Firma,Integer> {
    boolean existsByManzil_Id(Integer manzil_id);
    Optional<Manzil> findByManzil_Id(Integer manzil_id);
}
