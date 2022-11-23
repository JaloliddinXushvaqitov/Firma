package com.example.firma.Service;

import com.example.firma.DTO.APIResponse;
import com.example.firma.DTO.BolimDTO;
import com.example.firma.Entite.Bolim;
import com.example.firma.Entite.Ishchi;
import com.example.firma.Repozitary.BolimRepozitary;
import com.example.firma.Repozitary.FirmaRepozitary;
import com.example.firma.Repozitary.IshchiRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BolimService {
    @Autowired
    BolimRepozitary bolimRepozitary;
    @Autowired
    IshchiRepozitary ishchiRepozitary;
 @Autowired
 FirmaRepozitary firmaRepozitary;
    public APIResponse postbolim(BolimDTO bolimDTO) {
      Bolim bolim=new Bolim();
      bolim.setNomi(bolimDTO.getNomi());
      bolim.setFirma(firmaRepozitary.findById(bolimDTO.getFirmaId()).get());
        bolimRepozitary.save(bolim);
      return new APIResponse("Malumot saqlandi",true);
    }

    public APIResponse taxrirput(Integer id, BolimDTO bolimDTO) {
        Optional<Bolim> bolimtaxrir=bolimRepozitary.findById(id);
        if(!bolimtaxrir.isPresent()) return new APIResponse("Bunday malumot mavjudmas",false);
        Bolim bolim=bolimtaxrir.get();
        bolim.setNomi(bolimDTO.getNomi());
        bolim.setFirma(firmaRepozitary.findById(bolimDTO.getFirmaId()).get());
        bolimRepozitary.save(bolim);
        return new APIResponse("Malumot taxrirlandi",true);
    }

    public APIResponse getmalumot() {
        List<Bolim> all=bolimRepozitary.findAll();
        return new APIResponse(all.toString(),true);
    }

    public APIResponse olishId(Integer id) {
        Optional<Bolim> all=bolimRepozitary.findById(id);
        if(all.isPresent()) return new APIResponse(all.toString(),true);
        return  new APIResponse("Malumot saqlanmadi",false);
    }

    public APIResponse deleteid(Integer id) {
        Optional<Bolim> deleteid=bolimRepozitary.findById(id);
        if(deleteid.isPresent()){
            bolimRepozitary.deleteById(id);
        }
        return new APIResponse("malumot ochirildi",true);
    }
}
