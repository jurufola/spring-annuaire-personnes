package home.jurufola.annuairepersonnes.services;

import home.jurufola.annuairepersonnes.entities.Activite;
import home.jurufola.annuairepersonnes.entities.Adresse;
import home.jurufola.annuairepersonnes.entities.Personne;
import home.jurufola.annuairepersonnes.repositories.ActiviteRepository;
import home.jurufola.annuairepersonnes.repositories.AdresseRepository;
import home.jurufola.annuairepersonnes.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Service
public class PersonneService {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    AdresseService adresseService;

    @Autowired
    ActiviteRepository activiteRepository;

    public List<Personne> getPersonnes() {

        return personneRepository.findAll();
    }


    public String addPersonne(Personne p){

        Adresse adresse = p.getAdresse();
        System.out.println(adresse);
        //Verifier que l'adresse existe en base";
        Adresse adresseBase = adresseService.findByNumeroAndRueAndCodePostal(adresse.getNumero(),
                adresse.getRue(), adresse.getCodePostal());
        System.out.println("Adresse extraite de la base " + adresseBase);
        if (adresseBase == null){ // Adresse n esxiste pas encore dans la base
            adresseService.save(adresse);
            p.setAdresse(adresse);
        }else {
            p.setAdresse(adresseBase);
        }
        personneRepository.save(p);
        return p + " a bien été ajouté à la base";
    }

    public String update(Long id, Personne newPersonne) {
        // Recup personne
        Personne p = personneRepository.findById(id).get();
        p.setPrenom(newPersonne.getPrenom());
        p.setNom(newPersonne.getNom());
        p.setAge(newPersonne.getAge());
        p.setSexe(newPersonne.getSexe());
        personneRepository.save(p);
        return "Mise à jour Ok de la persone d'id " + id;
    }


    public void delete(Long id) {
        Personne p = personneRepository.findById(id).get();
        personneRepository.delete(p);
    }

    public Personne getPersonne(Long id) {
        return personneRepository.findById(id).get();
    }

    public void inscrirePersonneActivite(Long idPersonne, Long idActivite) {
        Personne personne = personneRepository.findById(idPersonne).get();
        Activite activite = activiteRepository.findById(idActivite).get();
        Set<Activite> personneActivites = personne.getActivites();
        personneActivites.add(activite);
        personneRepository.save(personne);
    }
}
