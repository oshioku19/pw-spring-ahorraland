package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.repository.ConsumerRepository;

@Service
public class ConsumerServerImpl implements ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;
	@Override
	public JpaRepository<Consumer, Integer> getJpaRepository() {
		return consumerRepository;
	}
	@Override
	public List<Consumer> findByName(String name) throws Exception {
		return consumerRepository.findByName(name);
	}
	@Override
	public List<Consumer> findByLastName(String lastName) throws Exception {
		return consumerRepository.findByLastName(lastName);
	}

}
