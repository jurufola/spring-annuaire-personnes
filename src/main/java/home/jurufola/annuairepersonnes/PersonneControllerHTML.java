package home.jurufola.annuairepersonnes;

import home.jurufola.annuairepersonnes.entities.Personne;
import home.jurufola.annuairepersonnes.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonneControllerHTML {
    @Autowired
    PersonneService personneService;

    @GetMapping("/")
    public String acceuil(){

        return "index";
    }


    /**
     * Retourne la liste des personnes
     * @return La liste des personnes
     */
    @GetMapping("listpersonnes")
    public String getPersonnes(Model model){
        List<Personne> personnes = personneService.getPersonnes();
        model.addAttribute("personnes", personnes);

        return "personnes";
    }

    /*@GetMapping("/personneForm")
    public ModelAndView getPersonneForm(ModelAndView modelAndView) {
        Personne personne = new Personne();
        modelAndView.addObject("personne", personne);
        modelAndView.setViewName("personneForm");
        return modelAndView;
    }*/

    @GetMapping("ajoutpersonne")
    public String personneForm(Model model) {
        model.addAttribute("personne", new Personne());
        return "ajoutpersonne";
    }

    @PostMapping("ajoutpersonne")
    public String addPersonne(@ModelAttribute Personne personne) {
        personneService.addPersonne(personne);
        return "personnes";
    }
}
