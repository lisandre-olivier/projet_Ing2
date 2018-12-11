package fr.eisti.cergy.jee.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import fr.eisti.cergy.jee.model.Pompier;


 

 
 
public interface PompierRepository extends Repository <Pompier, Long>{
	
 
	 Pompier findByIdPompier(Long idPompier);
	
	 
	List<Pompier> findAll();
	
	Pompier save (Pompier pompier);
	
	void delete(Pompier pompier);
		 
	@Modifying
	@Query("update Pompier u set u.idPompier = ?1")
	int updateIdPompier(Long idPompier);
	
//	@Modifying
//	@Query("update Pompier u set u.desigPompier = ?1  where u.idPompier = ?3")
//	int updateDesigPompier(String desigPompier, Long idPompier);

}