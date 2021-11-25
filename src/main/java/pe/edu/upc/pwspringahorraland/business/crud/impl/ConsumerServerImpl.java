package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.ConsumerService;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.TypeUser;
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
	@Override
	public List<Consumer> list() {
		return consumerRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
	}
	@Override
	public Integer insert(Consumer consumer) {
		int rpta = consumerRepository.FindConsumerExists(consumer.getDni());
		if (rpta == 0) {
			TypeUser typeuser = new TypeUser();
			typeuser.setType("ROLE_CONSUMIDOR");
			List<TypeUser>typeusers = new ArrayList<TypeUser>();
			typeusers.add(typeuser);
			consumer.getUsers().setTypeUsers(typeusers);
			consumerRepository.save(consumer);
		}
		return rpta;
	}


}
