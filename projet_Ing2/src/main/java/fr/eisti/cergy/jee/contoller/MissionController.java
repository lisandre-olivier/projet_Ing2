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

import fr.eisti.cergy.jee.model.Mission;
import fr.eisti.cergy.jee.service.MissionService;
 
@Controller("missionController")
public class MissionController {
	
	private final Logger logger = LoggerFactory.getLogger(MissionController.class);

 
	@Autowired
	MissionService missionService;
 

@RequestMapping(value = "/mission/listAll", method = RequestMethod.GET)
	protected ModelAndView showAllMissions() throws Exception {
		/*
		 * Lancement du Service et recupeation donnees en base
		 */
		List<Mission> listeMissions = missionService.getAll();

		/*
		 * Envoi Vue + Modele MVC pour Affichage donnees vue
		 */
		return new ModelAndView("/mission/showAllMissions", "missions", listeMissions);
	}

	 	@RequestMapping(value = "/mission/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {
	        model.addAttribute("missions", missionService.getAll());
	        return "/mission/showAllMissions"; // Afficher la page showAllMissions.jsp qui se trouve sous /mission
	        
	    }

	    @RequestMapping(value = "/mission/get/{id}" , method = RequestMethod.GET)
	    public String get(@PathVariable Long id, Model model) throws Exception {
	        model.addAttribute("missionToShow", missionService.getByIdMission(id));
	        return "/mission/showMission"; // Afficher la page showMission.jsp qui se trouve sous /mission
	    }
	    
	    
	    @RequestMapping(value = "/mission/save", method = RequestMethod.POST)
	    public String saveOrUpdate(@ModelAttribute("missionForm") Mission mission, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	    	try {
				
			
			Long idMission = missionService.save(mission);

	    	
	    	if(  mission.getIdMission()!=null){
				redirectAttributes.addFlashAttribute("typeAlert", "info");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Mission dont ID : "+mission.getIdMission()+" a été mis à jour.");

			}else{
				redirectAttributes.addFlashAttribute("typeAlert", "success");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Nouveau Mission a été enregsitrée avec ID : "+idMission);
			}
	    	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/mission/listAll";
	    }
	    

 
	    @RequestMapping("/mission/update/{id}")
	    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	        Mission mission = missionService.getByIdMission(id);
	        model.addAttribute("missionForm", mission);
	        return "/mission/addUpdateMission";
	    }
 
}
