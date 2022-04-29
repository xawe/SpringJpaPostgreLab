package com.example.postgresdemo.DataTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.repository.QuestionRepository;

@Service
public class CreateQuestions202204291714 extends Base{
	
	@Autowired
	private QuestionRepository repo;
	
	public CreateQuestions202204291714() {
		this.setDataName("CreateQuestions202204291714");
		this.setDescription("Modelo de criação de questão 2");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		super.rollback();
	}

	
}
