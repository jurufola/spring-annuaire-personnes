package home.jurufola.annuairepersonnes;

import home.jurufola.annuairepersonnes.entities.Personne;
import home.jurufola.annuairepersonnes.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlleur gerant la personne
 * @author juruf_000
 */

@RestController
public class PersonneController {

    @Autowired
    PersonneService personneService;

    /**
     * Retourne la liste des personnes
     * @return La liste des personnes
     */
    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        return personneService.getPersonnes();
    }

    @GetMapping("annuraire/personne/{id}")
    public Personne getPersonne(@PathVariable("id") Long id){
        System.out.println("Je suis dans getPersonne");
        return personneService.getPersonne(id);
    }

    @PostMapping("personne")
    public String addPersonne(@RequestBody Personne p) {
        return personneService.addPersonne(p);
    }

    @PutMapping("personne/{id}")
    public String updatePersonne(@PathVariable("id") Long id, @RequestBody Personne newPersonne){
        return personneService.update(id, newPersonne);
    }

    @DeleteMapping("delete/{id}")
    public String deletePersonne(@PathVariable("id") Long id) {
        personneService.delete(id);
        return "Supression OK";
    }

    @PutMapping("personne/{idPersonne}/activite/{idActivite}")
    public void inscrirePersonneActivite(@PathVariable("idPersonne") Long idPersonne,
                                         @PathVariable("idActivite") Long idActivite) {
        personneService.inscrirePersonneActivite(idPersonne, idActivite);
    }
}
