package com.example.artbackend.Controller;

import com.example.artbackend.Entities.*;
import com.example.artbackend.Repository.UtilisateurRepository;
import com.example.artbackend.Service.ServiceUtilisateur;
import jakarta.servlet.http.HttpServlet;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.Optional;

@RequestMapping("/Adhrent")
@RestController
public class AdhrenetController {
    @Autowired
    ServiceUtilisateur SU;
    @Autowired
    UtilisateurRepository AR;

    @PostMapping("/add")
    public ResponseEntity<HttpServlet> add(@RequestParam int id , @RequestBody adherent ad){
        try {
            Optional<Utilisateur> u = AR.findById(id);
            ad.setUtilisateur(u.get());
            SU.addadhrenet(ad );
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/GetEvents/{id}")
    public ResponseEntity<Evenement> getEvenement(@PathVariable int id ){
        try{
            Optional<Evenement> evenement = SU.getEvenement(id);
            if(evenement.isPresent()){
                return new ResponseEntity<>(evenement.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/GetSousAtelier/{id}")
    public ResponseEntity<SousAtelier> getSousatelier(@PathVariable int id ){
        try{
            Optional<SousAtelier> sousatelier = SU.getSousAtelier(id);
            if(sousatelier.isPresent()){
                return new ResponseEntity<>(sousatelier.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/GetFormation/{id}")
    public ResponseEntity<Formation> getFormation(@PathVariable int id ){
        try{
            Optional<Formation> formation = SU.getFormation(id);
            if(formation.isPresent()){
                return new ResponseEntity<>(formation.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
