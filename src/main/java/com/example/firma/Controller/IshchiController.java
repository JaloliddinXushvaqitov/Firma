package com.example.firma.Controller;

import com.example.firma.DTO.APIResponse;
import com.example.firma.DTO.IshchiDTo;
import com.example.firma.Entite.Ishchi;
import com.example.firma.Service.IshchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Ishchi")
public class IshchiController {
    @Autowired
    IshchiService ishchiService;
   @PutMapping("/Taxrirlshishchi/{id}")
    public HttpEntity<?>Taxrirlashid(@PathVariable Integer id,@RequestBody IshchiDTo ishchiDTo){
       APIResponse apiResponse=ishchiService.taxrirlashid(id,ishchiDTo);
       return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @PostMapping("/ishchiPost")
    public HttpEntity<?>IshchiPost(@RequestBody IshchiDTo ishchiDTo){
        APIResponse apiResponse=ishchiService.joylash(ishchiDTo);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }

    @GetMapping("/oqishishchi")
    public HttpEntity<?> oqishishchi(@RequestBody IshchiDTo ishchiDTo){
        APIResponse apiResponse=ishchiService.oqish(ishchiDTo);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqish/{id}")
    public HttpEntity<?> oqishid(@PathVariable Integer id){
        APIResponse apiResponse=ishchiService.oqishId(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteishchi/{id}")
    public HttpEntity<?>delete(@PathVariable Integer id){
        APIResponse apiResponse=ishchiService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
}
