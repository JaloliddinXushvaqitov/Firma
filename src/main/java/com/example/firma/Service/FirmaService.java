package com.example.firma.Service;

import com.example.firma.DTO.APIResponse;
import com.example.firma.DTO.Firma_Dto;
import com.example.firma.Entite.Firma;
import com.example.firma.Entite.Manzil;
import com.example.firma.Repozitary.FirmaRepozitary;
import com.example.firma.Repozitary.ManzilRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmaService {
    @Autowired
    FirmaRepozitary firmaRepozitary;
    @Autowired
    ManzilRepozitary manzilRepozitary;

    public APIResponse Postfirm(Firma_Dto firma_dto) {
        //Optional<Manzil> byId = manzilRepozitary.findById(firma_dto.getManzil().getId());
        //if (!byId.isPresent())return new APIResponse("manzil mavjud emas",false);
        Manzil manzil=new Manzil();
        manzil.setKocha(firma_dto.getKocha());
        manzil.setViloyat(firma_dto.getViloyat());
        manzil.setTuman(firma_dto.getTuman());
        Manzil save = manzilRepozitary.save(manzil);
        Firma firma=new Firma();
        firma.setFirmaNomi(firma_dto.getFirmaNomi());
        firma.setDriktorNomi(firma_dto.getDriktorNomi());
        firma.setManzil(save);
        firmaRepozitary.save(firma);
        return  new APIResponse("saqlandi",true);

    }

    public APIResponse taxrirlash(Integer id, Firma_Dto firma_dto) {
        Optional<Firma> byId = firmaRepozitary.findById(id);
         if(byId.isPresent()) {
             Manzil manzil=byId.get().getManzil();
             manzil.setViloyat(firma_dto.getViloyat());
             manzil.setKocha(firma_dto.getKocha());
             manzil.setTuman(firma_dto.getTuman());
             Manzil save = manzilRepozitary.save(manzil);
             Firma firma=byId.get();
             firma.setFirmaNomi(firma_dto.getFirmaNomi());
             firma_dto.setDriktorNomi(firma_dto.getDriktorNomi());
             firma.setManzil(save);
             firmaRepozitary.save(firma);
             return new APIResponse("MAlumot taxrirlandi",true);
         }
         return null;
    }
    public APIResponse oqish(Firma_Dto firma_dto) {
        List<Firma>All=firmaRepozitary.findAll();
        return new APIResponse(All.toString(),true);
    }

    public APIResponse oqishID(Integer id) {
        Optional<Firma> all=firmaRepozitary.findById(id);
        if(all.isPresent()) return new APIResponse(all.toString(),true);
        return new APIResponse("Malumot mavjud emas",false);
    }

    public APIResponse deleteid(Integer id) {
        Optional<Firma> delete = firmaRepozitary.findById(id);
        if (delete.isPresent()) {
            firmaRepozitary.deleteById(id);
            manzilRepozitary.deleteById(id);
            return new APIResponse("malumot ochirildi", true);
        }
        return new APIResponse("malumot mavjudmas", false);

    }
    }
