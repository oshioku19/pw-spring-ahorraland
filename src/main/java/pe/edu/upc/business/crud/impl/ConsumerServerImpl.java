package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.ConsumerService;
import pe.edu.upc.model.entity.Consumer;
import pe.edu.upc.model.repository.ConsumerRepository;

@Service
public class ConsumerServerImpl implements ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;
	@Override
	public JpaRepository<Consumer, Integer> getJpaRepository() {
		return consumerRepository;
	}
	@Override
	public List<Consumer> findByNName(String name) throws Exception {
		return consumerRepository.findByNName(name);
	}
	@Override
	public List<Consumer> findByNLastname(String lastName) throws Exception {
		return consumerRepository.findByNLastname(lastName);
	}

}
