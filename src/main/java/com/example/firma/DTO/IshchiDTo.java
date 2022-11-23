package com.example.firma.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class IshchiDTo {
    private String ismi;
    private String telRaqam;
    private String email;

    private String viloyat;
    private String tuman;
    private String kocha;

    private Integer bolimid;
}
