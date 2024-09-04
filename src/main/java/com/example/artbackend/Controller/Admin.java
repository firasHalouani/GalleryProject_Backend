package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Artiste;
import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Entities.Tableau;
import com.example.artbackend.Service.AtelierService;
import com.example.artbackend.Service.TableauService;
import jakarta.servlet.http.HttpServlet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Admin")

public class Admin {
@Autowired
    TableauService  TS;
@Autowired
AtelierService AS;



//El modifier hiya nafsha el create juste zidha id mta3 entiter

@PostMapping("/createArtiste")
    public ResponseEntity<HttpServlet> createArtiste(@RequestBody Artiste a) {
        try {
            TS.createArtiste(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
@PostMapping("/createTableau")
    public ResponseEntity<HttpServlet> createArtiste(@RequestBody Tableau t) {
        try {
            TS.createTableau(t);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

@DeleteMapping("/DeletArtiste")
    public  ResponseEntity<HttpServlet> deleteArtiste(@RequestBody Artiste a) {
    try {
        TS.deleteArtiste(a);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e ){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
@DeleteMapping("/DeletTableau")
    public  ResponseEntity<HttpServlet> deleteArtiste(@RequestParam int id ) {
    try {
        TS.deleteTableau(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e ){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@PostMapping("/addAtelier")
    public ResponseEntity<HttpServlet> addAtelier(@RequestBody Atelier a) {
    try{
        AS.AddAtelier(a);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
@DeleteMapping("/DeleteAtelier")
    public ResponseEntity<HttpServlet> DeleteAtelier(@RequestBody Atelier a) {
        try{
            AS.DeleteAtelier(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSousAtelier")
    public ResponseEntity<HttpServlet> SousAtelier(@RequestBody SousAtelier a) {
    try{
        AS.AddSousAtelier(a);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
    @DeleteMapping("/DeleteSousAtelier")
    public ResponseEntity<HttpServlet> DeleteSousAtelier(@RequestBody SousAtelier a) {
    try{
        AS.DeleteSousAtelier(a);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}









}
