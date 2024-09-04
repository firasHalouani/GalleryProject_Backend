package com.example.artbackend.Service;

import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Repository.AtelierRepository;
import com.example.artbackend.Repository.SousAtelierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtelierService {
    @Autowired
    AtelierRepository AR;

    @Autowired
    SousAtelierRepository SR;

public void AddAtelier(Atelier atelier){
    AR.save(atelier);
}
public void AddSousAtelier(SousAtelier atelier){
    SR.save(atelier);
}
public void DeleteSousAtelier(SousAtelier atelier){
    SR.delete(atelier);
}

public void DeleteAtelier(Atelier atelier){
    AR.delete(atelier);
}


    public List<Atelier> GetAllAtelier(){
        return  AR.findAll();
    }


    public List<SousAtelier> GetAllSousAtelier(int id ){
        return  SR.findByAtelier_Id( id );}






}
