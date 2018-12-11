package fr.eisti.cergy.jee.contoller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.eisti.cergy.jee.model.Mission;
import fr.eisti.cergy.jee.model.Pompier;
import fr.eisti.cergy.jee.service.MissionService;
import fr.eisti.cergy.jee.service.PompierService;
 


 
 
@Controller 
@RequestMapping("/") //make all URL's through this controller relative to /index
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	PompierService pompierService;
	
	@Autowired
	MissionService missionService;
	
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String index(Map<String, Object> model) throws Exception {
	 
    return "index";
	}   
	
 
	/**************************************
	 * Gestion pompier
	 * **Nouveau pompier : /pompier/new
     * **Liser Tous : /pompier/listAll
	 ***************************************/	
	
		// show new Pompier form
		@RequestMapping(value = "/pompier/new", method = RequestMethod.GET)
		public String showNewPompier(Model model) {

			logger.debug(":::showNewPompier:::");

			Pompier pompier = new Pompier();
			
			model.addAttribute("pompierForm", pompier);

	 
			 return "/pompier/addUpdatePompier";

		}
		
		
		
		 // show list of All Pompier
			@RequestMapping({"/pompier/listAll","pompierList"})
			protected ModelAndView lisAllPompiers(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				/*
				 * Lancement du Service et récupération données en base
				 */
				List<Pompier> listePompiers = pompierService.getAll();

				/*
				 * Envoi Vue + Modèle MVC pour Affichage données vue
				 */
				return new ModelAndView("/pompier/showAllPompiers", "pompiers", listePompiers);
			} 
		
		/**************************************
		 * Gestion mission
		 * **Nouvelle mission : /mission/new
	     * **Liser Tous : /misison/listAll
		 ***************************************/	
		
		// show new Mission form
		@RequestMapping(value = "/mission/new", method = RequestMethod.GET)
		public String showNewMission(Model model) {

			logger.debug(":::showNewMission:::");

			Mission mission = new Mission();
			
			model.addAttribute("missionForm", mission);

	 
			 return "/mission/addUpdateMission";

		}
		

		
		 // show list of All Mission
			@RequestMapping({"/mission/listAll","missionList"})
			protected ModelAndView lisAllMissions(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				/*
				 * Lancement du Service et récupération données en base
				 */
				List<Mission> listeMissions = missionService.getAll();

				/*
				 * Envoi Vue + Modèle MVC pour Affichage données vue
				 */
				return new ModelAndView("/mission/showAllMissions", "missions", listeMissions);
			} 
	
}
