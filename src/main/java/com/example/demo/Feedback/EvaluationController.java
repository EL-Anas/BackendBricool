package com.example.demo.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EvaluationController {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @PostMapping("/eval")
    public void Evaluer(@RequestBody Evaluation evaluation){
       evaluationRepository.save(evaluation);
    }
    @GetMapping("/getEval/{Id}")
    public List<Evaluation> getEval(@PathVariable("Id") String id){
        return evaluationRepository.findByIdEvalue(id);
    }
}
