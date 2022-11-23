package com.example.firma.DTO;

import com.example.firma.Entite.Bolim;
import com.example.firma.Entite.Manzil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class Firma_Dto {

    private String firmaNomi;
    private String driktorNomi;
    private String viloyat;
    private String tuman;
    private String kocha;

}
