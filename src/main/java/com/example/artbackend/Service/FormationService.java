package com.example.artbackend.Service;

import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    @Autowired
    private FormationRepository FR;

     public List<Formation> GetAllFormation(){
         return  FR.findAll();
     }

    // Nouvelle méthode pour ajouter une formation
    public Formation saveFormation(Formation formation) {
        return FR.save(formation);
    }
    public void DeletFormation(int  id ){
         FR.deleteById(id);
    }



}
