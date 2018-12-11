package fr.eisti.cergy.jee.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import fr.eisti.cergy.jee.model.Mission;


 

 
 
public interface MissionRepository extends Repository <Mission, Long>{
	
 
	 Mission findByIdMission(Long idMission);
	
	 
	List<Mission> findAll();
	
	Mission save (Mission mission);
	 
	@Modifying
	@Query("update Mission u set u.idMission = ?1")
	int updateIdMission(Long idMission);
	
//	@Modifying
//	@Query("update Mission u set u.lieuMission = ?1  where u.idMission = ?2")
//	int updateLieuMission(String lieuMission, Long idMission);

}