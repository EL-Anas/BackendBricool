package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends MongoRepository<Compte,String> {
    public Compte findCompteById(String id);
}
