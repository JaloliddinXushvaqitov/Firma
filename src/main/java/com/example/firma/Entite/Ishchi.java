package com.example.firma.Entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Ishchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ismi;
    private String telRaqam;
    private String email;

    @OneToOne
    Manzil manzil;
    @ManyToOne
    Bolim bolim;
}
