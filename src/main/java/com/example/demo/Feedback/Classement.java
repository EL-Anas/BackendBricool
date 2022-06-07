package com.example.demo.Feedback;

import com.example.demo.Compte;
import com.example.demo.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recommandation")
public class Classement {
    @Autowired
    private CompteRepository ur;
    @Autowired
    private EvaluationRepository rr;
    public List<Compte> getuserd(){
        List<Compte> users = ur.findAll();
        System.out.println(users);
        return users;
    }
    public RatingAvg getrec(String idutilisateur){
        RatingAvg r = new RatingAvg();
        r.setUtilisatuer(ur.findCompteById(idutilisateur));
        int [] ratings =new int[5];
        for(int i = 0 ; i<5;i++) {
            ratings[i] = rr.countByIdEvalueEqualsAndNoteEquals(idutilisateur, i+1);
            System.out.println(ratings[i]);
        }
        if(ratings[0]+ratings[1]+ratings[2]+ratings[3]+ratings[4]>0) {
            double avg = (double)(ratings[0] + 2 * ratings[1] + 3 * ratings[2] + 4 * ratings[3] + 5 * ratings[4]) / (double) (ratings[0] + ratings[1] + ratings[2] + ratings[3] + ratings[4]);
            r.setCount(ratings[0] + ratings[1] + ratings[2] + ratings[3] + ratings[4]);
            r.setRating(avg);
            r.setNotefinale((0.1 * ratings[0] + 2 * 0.3* ratings[1] + 3 * 0.5 *ratings[2] + 4 *0.75 * ratings[3] + 5 * 2 *ratings[4]));
            return r;
        }
        r.setCount(0);
        r.setRating(0.0);
        r.setNotefinale(0.0);
        return r;


    }
    @GetMapping("Recommand")
    public List<RatingAvg> recommand(){
        List<Compte> utilisateurs = ur.findAll();
        List<RatingAvg> res=new ArrayList<>();
        List<RatingAvg> ratings= new ArrayList<>();
        List<String> s=new ArrayList<>();
        //avoir l'evaluation global por chaque utlisateur
        for(Compte u: utilisateurs){
            RatingAvg ratingAvg = getrec(u.getId()) ;
            ratings.add(ratingAvg);
        }
        System.out.println(ratings);
        ratings.sort(new Comparateureval());
        Collections.reverse(ratings);
        System.out.println(ratings);
        return ratings;
    }

}

class Comparateureval implements Comparator<RatingAvg> {

    // override the compare() method
    public int compare(RatingAvg s1, RatingAvg s2)
    {
        if (s1.getNotefinale() == s2.getNotefinale())
            return 0;
        else if (s1.getNotefinale() > s2.getNotefinale())
            return 1;
        else
            return -1;
    }
}