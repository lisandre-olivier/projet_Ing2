package fr.eisti.cergy.jee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.eisti.cergy.jee.model.Pompier;

@Service
@Transactional
public class PompierServiceImpl implements PompierService{

	@Autowired
	private PompierRepository pompierRepository;

  
	
	 
	@Override
	public  Pompier getByIdPompier(Long idPompier) throws Exception {
        return  (Pompier) pompierRepository.findByIdPompier(idPompier);

	}

 
	@Override
	public Long save(Pompier pompier) throws Exception {
		
		pompier = pompierRepository.save(pompier);
		return pompier.getIdPompier();
	}




	 


	@Override
	public int updateId(Long idPompier) {
		return pompierRepository.updateIdPompier(idPompier);
	}


//	@Override
//	public int updateDesig(String desigPompier, Long idPompier) {
//		return pompierRepository.updateDesigPompier(desigPompier, idPompier) ;
//
//	}




	@Override
	public List<Pompier> getAll() {
 		return (List<Pompier>) pompierRepository.findAll() ;
	}

	public void delete(Pompier pompier) {
		pompierRepository.delete(pompier);
	}
   
}
