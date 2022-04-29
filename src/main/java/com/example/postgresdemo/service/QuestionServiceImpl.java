package com.example.postgresdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository repo;
	
	public String createQuestion(String txt) {
		return "The question is >> " + txt;
	}
	
	public Page<Question> findAllQuestions(Pageable pageable){
		return repo.findAll(pageable);
	}
	
	public int countTotalQuestions() {
		List<Question> lista = repo.findAll();
		
		return lista.size();
	}
	
}
