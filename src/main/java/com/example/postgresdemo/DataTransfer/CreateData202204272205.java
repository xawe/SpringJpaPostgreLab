package com.example.postgresdemo.DataTransfer;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;

@Service
public class CreateData202204272205 extends Base {

	@Autowired
	private QuestionRepository repo;
	
	public CreateData202204272205() {
		this.setDataName("CreateData_270420222205");
		this.setDescription("Criação de modelo teste");
	}
	
	@Override
	public void execute() {
		System.out.println("Hello Execute From " + this.getDataName() + " --- " + this.getDescription());
		
		Question q = getQuestionData();		
		Question response = repo.save(q);
		System.out.println("Identificador criado ::: " + response.getId());	
	}

	
	
	@Override
	public void rollback() {
		Question q = getQuestionData();
		List<Question> result = repo.findByTitleContaining(q.getTitle());
		repo.deleteAll(result);		
		
		System.out.println("Question delete");		
	}
	
	private Question getQuestionData() {
		Question q = new Question();
		q.setCreatedAt(Date.from(Instant.now()));
		q.setDescription("Descrição Base 01");
		q.setTitle("Titulo teste");
		return q;
	}
	
}