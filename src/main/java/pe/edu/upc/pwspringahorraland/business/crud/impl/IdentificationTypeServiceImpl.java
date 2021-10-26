package pe.edu.upc.pwspringahorraland.business.crud.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.IdentificationTypeService;
import pe.edu.upc.pwspringahorraland.models.entity.IdentificationType;
import pe.edu.upc.pwspringahorraland.models.repository.IdentificationTypeRepository;

@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService {

	@Autowired
	private IdentificationTypeRepository identificationTypeRepository;
	@Override
	public JpaRepository<IdentificationType, Integer> getJpaRepository() {
		return identificationTypeRepository;
	}

}
