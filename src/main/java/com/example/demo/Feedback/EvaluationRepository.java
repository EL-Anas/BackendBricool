package com.example.demo.Feedback;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends MongoRepository<Evaluation,String> {
    public List<Evaluation> findByIdEvalue(String idEvalue);
    public int countByIdEvalueEqualsAndNoteEquals(String id,int note);
}
