package com.example.postgresdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.model.Question;


public interface QuestionService {
	public String createQuestion(String txt);
	
	public Page<Question> findAllQuestions(Pageable pageable);
	
	public int countTotalQuestions();
}
