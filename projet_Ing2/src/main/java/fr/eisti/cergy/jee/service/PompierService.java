package fr.eisti.cergy.jee.service;

import java.util.List;

 

import fr.eisti.cergy.jee.model.Pompier;

public interface PompierService {

	public Long save (Pompier pompier) throws Exception ;
	
	List<Pompier> getAll();
 
	Pompier getByIdPompier(Long idPompier) throws Exception;
	
	int updateId (Long idPompier);
	
  	//int updateDesig (String desigPompier, Long idPompier); 

   void delete(Pompier pompier); 
}
