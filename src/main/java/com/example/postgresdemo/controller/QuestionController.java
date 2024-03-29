package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Question;

import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    
    //@Autowired (required=false)
    @Autowired
    private QuestionService service;

    @GetMapping("/ping")
    public String getPing() {    	
    	//System.out.println(service.createQuestion("Its my question"));
        //return questionRepository.findAll(pageable);
    	return "Pong!";
    }
    
    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {    	
    	System.out.println(service.createQuestion("Its my question"));
        //return questionRepository.findAll(pageable);
    	return service.findAllQuestions(pageable);
    }
    
    @GetMapping("/questions/total")
    public int getTotalQuestions() {    	
    	return service.countTotalQuestions();
    }
    // @GetMapping("/questions/bytitle/{title}")
    // public List<Question> getQuestionsByTitle(@PathVariable String title){
    //     return questionRepository.findByTitle(title);
    // }

    @GetMapping("/questions/bypartialtitle/{title}")
    public List<Question> getQuestionsByPartialTitle(@PathVariable String title){
        List<Question> d = questionRepository.findByTitleContaining(title);
        return d;
    }

    @PostMapping("/questions")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/questions/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody Question questionRequest) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    question.setTitle(questionRequest.getTitle());
                    question.setDescription(questionRequest.getDescription());
                    return questionRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }


    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }
}
