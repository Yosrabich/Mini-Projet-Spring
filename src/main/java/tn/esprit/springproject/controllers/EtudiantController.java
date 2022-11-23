package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EtudiantRepository;

import tn.esprit.springproject.services.EtudiantService;

import java.util.List;
@CrossOrigin(origins = "*")

@Tag(name = "EtudiantController")
@AllArgsConstructor
@RestController
@RequestMapping("Etudiant")
public class EtudiantController {
    EtudiantService etudiantService;
    EtudiantRepository etudiantRepository;
    @Operation(description ="AjouterEtudiant")
    @PostMapping("/AjouterEtudiant")
    Etudiant ajouterEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }
    @Operation(description ="ModifierEtudiant")
    @PutMapping("/ModifierEtudiant")
  Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);

    }
    @Operation(description ="AfficherAllEtudiants")
    @GetMapping("/AfficherAllEtudiants")
    List<Etudiant> retrieveAllEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }
    @Operation(description ="AfficherEtudiant")
    @GetMapping("/AfficherEtudiantById/{id}")
    Etudiant getEtudiantById(@PathVariable int id){
        return etudiantService.retrieveEtudiant(id);
    }
    @Operation(description ="DeleteEtudiant")
    @DeleteMapping("/DeleteEtudiant/{id}")
    void deleteEtudiant(@PathVariable int id){
        etudiantService.deleteEtudiant(id);
    }
    @Operation(description ="assignEtudiantToDepartement")
    @PutMapping("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable int etudiantId,@PathVariable int departementId) {
        etudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }
    @Operation(description ="addAndAssignEtudiantToEquipeAndContract")
    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @Operation(description ="AfficherEtudiant")
    @GetMapping("/AfficherEtudiant/{nom}/{prenom}")
    Etudiant findByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom){
        return etudiantService.findByNomAndPrenom(nom,prenom);
    }

@Operation(description ="AfficherEtudiantByDepartement")
  @GetMapping("/AfficherEtudiantByDepartement/{idDepart}")
List<Etudiant>getEtudiantsByDepartement(@PathVariable int idDepart){
        return etudiantService.getEtudiantsByDepartement(idDepart);
}
    @Operation(description =" nombreEtudiantsByDepartement")
    @GetMapping("/nombreEtudiantsByDepartement/{idDepart}")
    Integer nombreEtudiantsByDepartement(@PathVariable int idDepart){
        return etudiantService.nombreEtudiantsByDepartement(idDepart);
    }
}