package com.example.postgresdemo.repository;

import java.util.List;

import com.example.postgresdemo.model.Question;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    //@Query(value="SELECT * FROM questions q WHERE q.title like %:keyword%", nativeQuery=true)
    //List<Question> findByQuestionTitle(String questionTitle);
    //List<Question> findByTitle(String Title);
    
    // @Bean
    // @Query(value="SELECT * FROM questions q WHERE q.title like %:keyword%")
    // List<Question> findByPartialTitle(String Title);

    // @Query("SELECT q.description FROM questions q WHERE q.title like :title") 
    //public Optional<Todo> findByTitleAndDescription(String title, String description);
    // @Query(
    //     value = "SELECT q.description FROM questions q WHERE  = :title AND t.description = :description", 
    //     nativeQuery=true
    // )
    //@Query(value ="SELECT q.description FROM questions q WHERE q.title LIKE %:t%;", nativeQuery = true)    
    List<Question> findByTitleContaining(String title);
}
