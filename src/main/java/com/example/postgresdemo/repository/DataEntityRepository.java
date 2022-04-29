package com.example.postgresdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.AutoData.DataEntity;

public interface DataEntityRepository extends JpaRepository<DataEntity, String> {

}
