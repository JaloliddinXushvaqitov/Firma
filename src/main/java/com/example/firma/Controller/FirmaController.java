package com.example.firma.Controller;

import com.example.firma.DTO.APIResponse;
import com.example.firma.DTO.Firma_Dto;
import com.example.firma.Entite.Firma;
import com.example.firma.Entite.Manzil;
import com.example.firma.Service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Firma")
public class FirmaController {
    @Autowired
    FirmaService firmaService;
    @PostMapping("/firmapost")
    public HttpEntity<?> Postfirm(@RequestBody Firma_Dto firma_dto){
        APIResponse apiResponse=firmaService.Postfirm(firma_dto);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("Taxrirlash/{id}")
    public HttpEntity<?>taxrirlsh(@PathVariable Integer id,@RequestBody Firma_Dto firma_dto){
        APIResponse apiResponse=firmaService.taxrirlash(id,firma_dto);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqish")
    public HttpEntity<?> oqish(@RequestBody Firma_Dto firma_dto){
        APIResponse apiResponse=firmaService.oqish(firma_dto);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqish/{id}")
    public HttpEntity<?> oqish(@PathVariable Integer id){
        APIResponse apiResponse=firmaService.oqishID(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?>Delete(@PathVariable Integer id){
        APIResponse apiResponse=firmaService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
}
