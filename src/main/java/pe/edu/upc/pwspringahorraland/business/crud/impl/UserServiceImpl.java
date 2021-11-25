package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.pwspringahorraland.business.crud.UserService;
import pe.edu.upc.pwspringahorraland.models.entity.TypeUser;
import pe.edu.upc.pwspringahorraland.models.entity.Users;
import pe.edu.upc.pwspringahorraland.models.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<Users, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert_seller(Users u) {
		int rpta=userRepository.buscarUsername(u.getUsername());
		if(rpta == 0) {
		 TypeUser typeuser = new TypeUser();
		 typeuser.setType("ROLE_VENDEDOR");
		 List<TypeUser> typeusers=new ArrayList<>();
		 typeusers.add(typeuser);
		 u.setTypeUsers(typeusers);
		 userRepository.save(u);
		}
		return rpta;
	}

	@Override
	public Integer insert_consumer(Users u) {
		int rpta=userRepository.buscarUsername(u.getUsername());
		if(rpta==0) {
			TypeUser typeuser = new TypeUser();
			 typeuser.setType("ROLE_CONSUMIDOR");
			 List<TypeUser> typeusers=new ArrayList<>();
			 typeusers.add(typeuser);
			 u.setTypeUsers(typeusers);
			 userRepository.save(u);
		}
		return rpta;
	}
	@Override
	public Optional<Users> finById(int idUser) {
		return userRepository.findById(idUser);
	}


	@Override
	public List<Users> list() {
		return userRepository.findAll();
	}


	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}



}
