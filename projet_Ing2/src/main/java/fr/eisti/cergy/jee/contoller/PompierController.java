package fr.eisti.cergy.jee.contoller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eisti.cergy.jee.model.Pompier;
import fr.eisti.cergy.jee.service.PompierService;
 
@Controller("pompierController")
public class PompierController {
	
	private final Logger logger = LoggerFactory.getLogger(PompierController.class);

 
	@Autowired
	PompierService pompierService;
 

@RequestMapping(value = "/pompier/listAll", method = RequestMethod.GET)
	protected ModelAndView showAllPompiers() throws Exception {
		/*
		 * Lancement du Service et recupeation donnees en base
		 */
		List<Pompier> listePompiers = pompierService.getAll();

		/*
		 * Envoi Vue + Modele MVC pour Affichage donnees vue
		 */
		return new ModelAndView("/pompier/showAllPompiers", "pompiers", listePompiers);
	}

	 	@RequestMapping(value = "/pompier/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {
	        model.addAttribute("pompiers", pompierService.getAll());
	        return "/pompier/showAllPompiers"; // Afficher la page showAllPompiers.jsp qui se trouve sous /pompier
	        
	    }

	    @RequestMapping(value = "/pompier/get/{id}" , method = RequestMethod.GET)
	    public String get(@PathVariable Long id, Model model) throws Exception {
	        model.addAttribute("pompierToShow", pompierService.getByIdPompier(id));
	        return "/pompier/showPompier"; // Afficher la page showPompier.jsp qui se trouve sous /pompier
	    }
	    
	    
	    @RequestMapping(value = "/pompier/save", method = RequestMethod.POST)
	    public String saveOrUpdate(@ModelAttribute("pompierForm") Pompier pompier, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	    	try {
				
			
			Long idPompier = pompierService.save(pompier);

	    	
	    	if(  pompier.getIdPompier()!=null){
				redirectAttributes.addFlashAttribute("typeAlert", "info");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Pompier dont ID : "+pompier.getIdPompier()+" a été mis à jour.");

			}else{
				redirectAttributes.addFlashAttribute("typeAlert", "success");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Nouveau Pompier a été enregsitrée avec ID : "+idPompier);
			}
	    	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/pompier/listAll";
	    }
	    

 
	    @RequestMapping("/pompier/update/{id}")
	    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	        Pompier pompier = pompierService.getByIdPompier(id);
	        model.addAttribute("pompierForm", pompier);
	        return "/pompier/addUpdatePompier";
	    }
	    
	    @RequestMapping("/pompier/delete/{id}") 
	    public String delete(@PathVariable Long id, Model model) throws Exception {
	    	Pompier pompier = pompierService.getByIdPompier(id);
	    	pompierService.delete(pompier);
			return "redirect:/pompier/listAll";	
	    }
 
}
