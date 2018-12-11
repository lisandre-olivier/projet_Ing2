package fr.eisti.cergy.jee.service;

import java.util.List;

 

import fr.eisti.cergy.jee.model.Mission;

public interface MissionService {

	public Long save (Mission mission) throws Exception ;
	
	List<Mission> getAll();
 
	Mission getByIdMission(Long idMission) throws Exception;
	
	int updateId (Long idMission);
	
  	//int updateLieu (String lieuMission, Long idMission); 

   
}
