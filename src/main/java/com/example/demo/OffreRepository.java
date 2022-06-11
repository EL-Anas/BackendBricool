package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface OffreRepository extends MongoRepository<Offre,String> {
    public List<Offre> findByTitresaContainingAndDomaineContainingAndRegionContainingAndVilleContainingAndDatePContainingAndStatusAndUtilisateurIsNot(String titre, String domaine,String region, String ville, String date,String status,Compte compte);
    public List<Offre> findByUtilisateur(Compte compte);
    public Optional<Offre> findById(String id);
    List<Offre> findByEmployee(String id);
}

