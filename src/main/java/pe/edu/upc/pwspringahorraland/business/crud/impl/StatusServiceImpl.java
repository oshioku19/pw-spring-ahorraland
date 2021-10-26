package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.StatusService;
import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.models.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository statusRepository;
	
	
	@Override
	public JpaRepository<Status, Integer> getJpaRepository() {
		return statusRepository;
	}


	@Override
	public List<Status>findByName(String name) throws Exception {		
		return statusRepository.findByName(name);
	}
	
}

