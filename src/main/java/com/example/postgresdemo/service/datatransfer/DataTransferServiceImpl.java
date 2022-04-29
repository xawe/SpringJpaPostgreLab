package com.example.postgresdemo.service.datatransfer;

import java.security.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.DataTransfer.Base;
import com.example.postgresdemo.DataTransfer.CreateData202204272205;
import com.example.postgresdemo.model.AutoData.DataEntity;
import com.example.postgresdemo.model.AutoData.DataEntityStatusEnum;

@Service
public class DataTransferServiceImpl implements DataTransferService{

	@Autowired
	private com.example.postgresdemo.repository.DataEntityRepository repo;
	
	@Autowired
	private CreateData202204272205 new202204272205;
	
	public void t() {
	
		//List<Base> factories = loadFactories();
		List<Base> factories = new ArrayList<Base>();
		factories.add(new202204272205);
		
		for (Base f : factories) {
			//Gravar novas classes de criação de dados, gerando assim massa para comando de execução
			Optional<DataEntity> dataEntity = getEntity(f.getDataName());
			if(dataEntity.isEmpty()) {
				//save data
				createDataEntity(f);				
			}
		}
		
		//listar todos os commandos que estão como pendentes
		List<DataEntity> entities = repo.findAll()
				.stream()
				.filter(entity -> entity.getStatus().equals(1))
				.toList();
				
		System.out.println(entities.size());
		
		//Executa cada item pendente
		for (Base factory : factories) {
			for (DataEntity dataEntity : entities) {
				if(dataEntity.getDataName().equals(factory.getDataName())) {
					factory.execute();
					factory.rollback();
				}
			}
		}
		
	}

	private void createDataEntity(Base f) {
		DataEntity d = new DataEntity();
		d.setCreatedAt(Date.from(Instant.now()));
		d.setDataName(f.getDataName());
		d.setDescription(f.getDescription());
		d.setStatus(DataEntityStatusEnum.PENDENTE.getStatus());
		repo.save(d);
	}
	
	private List<Base> loadFactories() {
		List<Base> fs = SpringFactoriesLoader.loadFactories(Base.class, null);        
        for (Base f : fs) {
			f.execute();
		}
        
        return fs;
	}
	
	private  Optional<DataEntity> getEntity(String key) {
		return repo.findById(key);		
	}
}
