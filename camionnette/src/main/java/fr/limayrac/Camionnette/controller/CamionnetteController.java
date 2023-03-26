package fr.limayrac.Camionnette.controller;

import fr.limayrac.Camionnette.model.Camionnette;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import fr.limayrac.Camionnette.repository.CamionnetteRepository;
import fr.limayrac.Camionnette.service.CamionnetteService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import org.apache.logging.log4j.Logger;
@RestController
public class CamionnetteController {
    @Autowired
    private CamionnetteService camionnetteService;

    @Autowired
    private CamionnetteRepository camionnetteRepository;

    @GetMapping("/camionnette/liste")
    public ModelAndView listeCamionnettes() {
        logger.info("Liste des camionnettes appelée le " + new Date());
        return new ModelAndView("listeCamionnette", "camionnettes", camionnetteService.getCamionnettes());
    }

    @GetMapping("/camionnette/creer")
    public ModelAndView creerCamionnette() {
        logger.info("Création d'une camionnette appelée le " + new Date());
        Camionnette o = new Camionnette();
        return new ModelAndView("creerCamionnette", "camionnette", o);
    }
    private static final Logger logger = LogManager.getLogger(CamionnetteController.class);
    @PostMapping("/camionnette/creer")
    public ModelAndView submit(@ModelAttribute("camionnette") Camionnette camionnette, ModelMap model) {
        logger.info("Enregistrement d'une camionnette appelée le " + new Date());
        model.addAttribute("marque", camionnette.getMarque());
        model.addAttribute("modele", camionnette.getModele());
        model.addAttribute("carburant", camionnette.getCarburant());
        model.addAttribute("hauteur", camionnette.getHauteur());

        camionnetteService.saveCamionnette(camionnette);
        ModelAndView modelAndView = new ModelAndView("listeCamionnette");
        modelAndView.addObject("camionnettes", camionnetteService.getCamionnettes());
        modelAndView.addObject("message", "La camionnette a été créée avec succès.");
        modelAndView.setViewName("redirect:/camionnette/liste");
        return modelAndView;
    }

    @GetMapping("/camionnette/modifier/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id, ModelMap model) {
        logger.info("Modification d'une camionnette appelée le " + new Date());
        Camionnette camionnette = camionnetteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid location Id:" + id));
        model.addAttribute("camionnette", camionnette);

        ModelAndView modelAndView = new ModelAndView("modifierCamionnette");
        modelAndView.addObject("camionnette", camionnette);
        return modelAndView;
    }

    @PostMapping("/camionnette/modifier/{id}")
    public ModelAndView modifierCamionnette(@ModelAttribute("camionnette") Camionnette camionnette) {
        logger.info("Enregistrement de la modification d'une camionnette appelée le " + new Date());
        camionnetteRepository.save(camionnette);
        ModelAndView modelAndView = new ModelAndView("listeCamionnette");
        modelAndView.addObject("camionnettes", camionnetteService.getCamionnettes());
        modelAndView.addObject("message", "la camionnette a été modifié avec succès.");
        modelAndView.setViewName("redirect:/camionnette/liste");
        return modelAndView;
    }

    @GetMapping("/camionnette/supprimer/{id}")
    public ModelAndView deleteLocation(@PathVariable("id") Integer id) {
        logger.info("Suppression d'une camionnette appelée le " + new Date());
        camionnetteRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("listeCamionnette");
        modelAndView.addObject("message_error", "Camionnette supprimé avec succès");
        modelAndView.setViewName("redirect:/camionnette/liste");
        return modelAndView;
    }


}
