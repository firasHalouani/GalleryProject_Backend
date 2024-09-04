package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Formation")
@CrossOrigin(origins = "*") 

public class FormationController {
    @Autowired
    private FormationService formationService;

    @GetMapping("/GetFormation")
    public ResponseEntity<List<Formation>> GetFormation() {
        try {
            List<Formation> formations = formationService.GetAllFormation();
            return ResponseEntity.ok(formations);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Nouveau endpoint pour ajouter une formation
    @PostMapping("/AddFormation")
    public ResponseEntity<Formation> addFormation(@RequestBody Formation formation) {
        try {
            Formation savedFormation = formationService.saveFormation(formation);
            return ResponseEntity.ok(savedFormation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/DeletFormation/{id}")
    public ResponseEntity<Void> DeleteFormation(@PathVariable int id) {
        try {
            formationService.DeletFormation(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
