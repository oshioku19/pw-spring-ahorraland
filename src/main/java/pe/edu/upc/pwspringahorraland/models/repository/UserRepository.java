package pe.edu.upc.pwspringahorraland.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pwspringahorraland.models.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>
{
	
	@Transactional
	@Modifying
	@Query(value = "insert into typeuser (typeuser, user_id) VALUES (:typeuser, :user_id)", nativeQuery = true)
	public void insRol(@Param("typeuser") String authority, @Param("user_id") Integer user_id);
	
	public Users findByUsername(String username);
	
	@Query("select count(u.username) from Users u where u.username=:username")
	public int buscarUsername(@Param("username")String nombre);
	
}
