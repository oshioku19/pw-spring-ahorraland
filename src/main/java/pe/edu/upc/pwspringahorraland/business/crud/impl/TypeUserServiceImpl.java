package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pwspringahorraland.business.crud.TypeUserService;
import pe.edu.upc.pwspringahorraland.models.entity.TypeUser;
import pe.edu.upc.pwspringahorraland.models.repository.TypeUserRepository;


@Service
public class TypeUserServiceImpl implements TypeUserService{

	@Autowired
	private TypeUserRepository typeUserRepository;

	
	@Override
	public JpaRepository<TypeUser, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TypeUser> list() {
		return typeUserRepository.findAll();
	}


	@Override
	public Optional<TypeUser> Obtener(Integer idTypeUser) {
		return typeUserRepository.findById(idTypeUser);
	}


	@Override
	public void insert(TypeUser typeUser) {
		typeUserRepository.save(typeUser);
		
	}

}
