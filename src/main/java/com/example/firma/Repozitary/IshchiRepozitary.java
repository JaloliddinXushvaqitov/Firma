package com.example.firma.Repozitary;

import com.example.firma.Entite.Ishchi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IshchiRepozitary extends JpaRepository<Ishchi,Integer>{
}
