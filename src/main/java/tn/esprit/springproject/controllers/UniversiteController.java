package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.springproject.entities.Universite;

import tn.esprit.springproject.services.UniversiteService;

import java.util.List;
@Tag(name = "UniversiteController")
@AllArgsConstructor
@RestController
@RequestMapping("Universite")
public class UniversiteController {

    UniversiteService universiteService;
    @Operation(description ="AjouterUniversite")
    @PostMapping("/AjouterUniversite")
    Universite ajouterUniversite(@RequestBody Universite u){
        return universiteService.addUniversite(u);
    }
    @Operation(description ="ModifierUniversite")
    @PutMapping("/ModifierUniversite")
    Universite updateUniversite(@RequestBody Universite u){
        return universiteService.updateUniversite(u);

    }
    @Operation(description ="AfficherAllUniversities")
    @GetMapping("/AfficherAllUniversities")
    List<Universite> retrieveAllUniversities(){
        return universiteService.retrieveAllUniversities();
    }
    @Operation(description ="AfficherUniversite/")
    @GetMapping("/AfficherUniversite/{id}")
    Universite getUniversiteById(@PathVariable int id){
        return universiteService.retrieveUniversite(id);
    }
    @Operation(description ="DeleteUniversite")
    @DeleteMapping("/DeleteUniversite/{id}")
    void deleteUniversite(@PathVariable int id){
        universiteService.deleteUniversite(id);
    }
    @Operation(description ="assignUniversiteToDepartement")
    @PostMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    void assignUniversiteToDepartement(int idUniversite,int idDepartement){
        universiteService.assignUniversiteToDepartement(idUniversite,idDepartement);

    }
}