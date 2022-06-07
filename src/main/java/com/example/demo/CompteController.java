package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;
    @CrossOrigin
    @PostMapping( "/register")
    public String creerCompte(@RequestBody Compte compte){
        List<Compte> lcompte=compteRepository.findAll();
        for(Compte x:lcompte){
            if(x.getEmail().equals(compte.getEmail())) return "fail";
        }
        compteRepository.save(compte);
        return compte.getId();
    }
    @CrossOrigin
    @PostMapping( "/auth")
    public String SeConnecter(@RequestBody Compte compte){
        List<Compte> lcompte=compteRepository.findAll();
        for(Compte x:lcompte){
            if(compte.equals(x)) return x.getId();
        }
        return "fail";
    }

    @CrossOrigin
    @PostMapping("/login")
    public Connexion getConnexion(@RequestBody Compte compte){
        List<Compte> lcompte=compteRepository.findAll();
        for(Compte x:lcompte){
            if(compte.equals(x)) return new Connexion(x.getId(),"true",x.getNom(),x.getPrenom());
        }
        return new Connexion("","false","","");
    }
    @CrossOrigin
    @GetMapping("/login/{id}")
    public Compte getCompte(@PathVariable String id) {
        return compteRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @CrossOrigin
    @GetMapping("/verify/{email}")
    public String verifymail(@PathVariable String email) {
        List<Compte> lcompte=compteRepository.findAll();
        for(Compte x:lcompte){
            if(x.getEmail().equals(email)) return"{\"exist\":\"true\"}";
        }
        return"{\"exist\":\"false\"}";
    }
    @CrossOrigin
    @GetMapping("/GetAllCompte")
    public List<Compte> getAllCompte (){
        return compteRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/GetCompte/{Id}")
    public Optional<Compte> getCompteById(@PathVariable("Id") String id){
        return compteRepository.findById(id);
    }

    @CrossOrigin
    @GetMapping("/getNom")
    public String getNameById(@RequestParam("Id") String id){
        List<Compte> comptes = compteRepository.findAll();
        for (Compte c : comptes){
            if(c.getId().equals(id)){
                return c.getNom();
            }
        }
        return "fail";
    }


}




