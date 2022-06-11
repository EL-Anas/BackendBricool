package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/postulation")
public class PostulerController {

    @Autowired
    private PostulerRepository Postulerrepository;


    @PostMapping("/post")
    public Postuler PostulerprOffre(@RequestBody Postuler postulation){
        List<Postuler> Postulation = new ArrayList<Postuler>();
        Postulation.addAll(Postulerrepository.findAll());
        if (postulation.getDescription().equals("") || postulation.getDuree()==0.0 || postulation.getPrix()==0.0 || postulation.getEmployee().getId().equals("")){
            System.out.println(postulation);
            System.out.println("it is not valid");
            return postulation;
        }else if(Postulation.contains(postulation)){
            System.out.println("this is not valid you have already applied to that ");
            return postulation;
        }else{
            Postulerrepository.save(postulation);
            System.out.println(postulation);
            System.out.println("it is valid");
            return postulation;
        }

        }
    @CrossOrigin
    @GetMapping("/get/{id}")
    public List<Postuler> GetDemandeById(@PathVariable String id){
        return Postulerrepository.findByIdOffre(id);}




}
