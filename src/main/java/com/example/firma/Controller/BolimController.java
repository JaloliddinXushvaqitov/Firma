package com.example.firma.Controller;

import com.example.firma.DTO.APIResponse;
import com.example.firma.DTO.BolimDTO;
import com.example.firma.Service.BolimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Bolim")
public class BolimController {
    @Autowired
    BolimService bolimService;

    @PostMapping("/Postbolim")
    public HttpEntity<?>Postbolim(@RequestBody BolimDTO bolimDTO){
        APIResponse apiResponse=bolimService.postbolim(bolimDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/Putbolim/{id}")
    public HttpEntity<?>Taxrirlash(@PathVariable Integer id,@RequestBody BolimDTO bolimDTO){
        APIResponse apiResponse=bolimService.taxrirput(id,bolimDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/malumotGet")
    public HttpEntity<?> malumotget(){
        APIResponse apiResponse=bolimService.getmalumot();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @GetMapping("/getId/{id}")
    public HttpEntity<?>olishid(@PathVariable Integer id){
        APIResponse apiResponse=bolimService.olishId(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteid(@PathVariable Integer id){
        APIResponse apiResponse=bolimService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
