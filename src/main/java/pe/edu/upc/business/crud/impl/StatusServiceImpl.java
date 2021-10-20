package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.StatusService;
import pe.edu.upc.model.entity.Status;
import pe.edu.upc.model.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository statusRepository;
	
	
	@Override
	public JpaRepository<Status, Integer> getJpaRepository() {
		return statusRepository;
	}


	@Override
	public List<Status> findByNombreStatus(String nombrestatus) throws Exception {
		// TODO Auto-generated method stub
		return statusRepository.findByNombreStatus(nombrestatus);
	}
	
}

