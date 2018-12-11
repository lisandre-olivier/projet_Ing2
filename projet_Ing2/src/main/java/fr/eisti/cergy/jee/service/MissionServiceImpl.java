package fr.eisti.cergy.jee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.eisti.cergy.jee.model.Mission;

@Service
@Transactional
public class MissionServiceImpl implements MissionService{

	@Autowired
	private MissionRepository missionRepository;

  
	
	 
	@Override
	public  Mission getByIdMission(Long idMission) throws Exception {
        return  (Mission) missionRepository.findByIdMission(idMission);

	}

 
	@Override
	public Long save(Mission mission) throws Exception {
		
		mission = missionRepository.save(mission);
		return mission.getIdMission();
	}




	 


	@Override
	public int updateId(Long idMission) {
		return missionRepository.updateIdMission(idMission);
	}


//	@Override
//	public int updateLieu(String lieuMission, Long idMission) {
//		return missionRepository.updateLieuMission(lieuMission, idMission) ;
//
//	}




	@Override
	public List<Mission> getAll() {
 		return (List<Mission>) missionRepository.findAll() ;
	}

	 

   
}
