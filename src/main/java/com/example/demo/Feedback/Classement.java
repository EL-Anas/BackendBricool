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
        return users;
    }
    public RatingAvg getrec(String idutilisateur){
        RatingAvg r = new RatingAvg();
        r.setUtilisateur(ur.findCompteById(idutilisateur));
        int [] ratings =new int[10];
        for(int i = 0 ; i<5;i++) {
            ratings[i*2] = rr.countByIdEvalueAndNote(r.getUtilisateur().getId(), ""+((double)(i*2+1)/2.0));
            ratings[i*2+1] = rr.countByIdEvalueAndNote(r.getUtilisateur().getId(), ""+(i+1));
        }
        if(ratings[0] + ratings[1] + ratings[2] + ratings[3] + ratings[4]+ratings[5] + ratings[6] + ratings[7] + ratings[8] + ratings[9]>0) {
            double avg = (0.5 * (double) ratings[0] + (double)ratings[1] + 1.5 * (double)ratings[2] + 2.0 * (double)ratings[3] + 2.5 * (double)ratings[4]+ 3.0 * (double)ratings[5]+ 3.5 * (double)ratings[6]+ 4.0 * (double)ratings[7]+ 4.5 * (double)ratings[8]+ 5.0 * (double)ratings[9])/(double) (ratings[0] + ratings[1] + ratings[2] + ratings[3] + ratings[4]+ratings[5] + ratings[6] + ratings[7] + ratings[8] + ratings[9]);
            r.setCount(ratings[0] + ratings[1] + ratings[2] + ratings[3] + ratings[4]);
            r.setRating(avg);
            r.setNotefinale((0.5*0.1 * ratings[0] + 0.15 * ratings[1] +1.5* 0.2 *ratings[2] + 2.0 * 0.3* ratings[3]+ 2.5 * 0.4* ratings[4] + 3.0 * 0.5 *ratings[5] +3.5 * 0.6 *ratings[6] + 4.0 *0.75 * ratings[7] + 4.5 *1.15 * ratings[8] + 5 * 2 *ratings[9]));
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
        ratings.sort(new Comparateureval());
        Collections.reverse(ratings);
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