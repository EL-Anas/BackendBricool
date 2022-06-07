package com.example.demo;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offre")
public class OffreController {
    //Partie Api et requettes http
    @Autowired
    private OffreRepository offrerepository;

    @GetMapping("/get")
    public List<Offre> getAllOffre(@RequestParam("Titre") String titre,@RequestParam("Domaine") String domaine,@RequestParam("Region") String region,@RequestParam("Ville") String ville,@RequestParam("Date") String date,@RequestParam("id") String id) {
        String[] s=unaccentlowercase(titre).split(" ");
        List<Offre> s1;
        List<Offre> s2 = new ArrayList<>();
        for(String str: s){
            s1 = offrerepository.findByTitresaContainingAndDomaineContainingAndRegionContainingAndVilleContainingAndDatePContainingAndStatusAndUtilisateurIsNot(str,undefined(domaine),undefined(region),ville,date,"active",new Compte(id,null,null,null,null,null,null,null));
            for(Offre o: s1){
                Add(s2,o);
            }
        }
        return s2;
    }
    @GetMapping("/get3")
    public List<Offre> get3Offre(){
        List<Offre> s1;
        s1 =offrerepository.findAll();
        List<Offre> s2 = new ArrayList<>();
        s2.add(s1.get(1));
        s2.add(s1.get(2));
        s2.add(s1.get(3));
        return s2;
    }

    @GetMapping("/getuser")
    public List<Offre> offreu(@RequestParam("iduser") String id){
        List<Offre> offres;
        return offrerepository.findByUtilisateur(new Compte(id,null,null,null,null,null,null,null));
    }


    @PostMapping("/post")
    public Offre posteroffre(@RequestBody Offre offre){
        offre.setTitresa();
        System.out.println(offre);
        if(offre.getTitre().equals("") || offre.getDescription().equals("") || offre.getDomaine().equals("") || offre.getRegion().equals("") || offre.getVille().equals("")){
            return offre;
        }
        offrerepository.save(offre);
        return offre;
    }
    @CrossOrigin
    @GetMapping("/GetOffreEmp/{id}")
    public List<Offre>getOffersEmp(@PathVariable String id){
        List<Offre> loffre=offrerepository.findAll();
        List<Offre> roffre=new ArrayList<Offre>();
        for(Offre x:loffre){
            if(x.getUtilisateur().getId().equals(id)) roffre.add(x);
        }
        return roffre;
    }

    //Methodes de mise en formes
    public boolean Add(List<Offre> offres ,Offre offre){
        for(Offre o: offres){
            if(o.equals(offre)){
                return false;
            }
        }
        offres.add(offre);
        return true;
    }

    public String undefined(String s){
        if (s.equals("Toutes")) return "";
        return s;
    }
    public String unaccentlowercase(String s){
        String normalizedWord = Normalizer.normalize(s, Normalizer.Form.NFD);
        return normalizedWord.replaceAll("\\p{M}", "").toLowerCase();
    }

}

