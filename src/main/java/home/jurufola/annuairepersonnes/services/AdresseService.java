package home.jurufola.annuairepersonnes.services;

import home.jurufola.annuairepersonnes.entities.Adresse;
import home.jurufola.annuairepersonnes.entities.Personne;
import home.jurufola.annuairepersonnes.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    @Autowired
    AdresseRepository adresseRepository;
    public List<Adresse> getAdresses() {

        return adresseRepository.findAll();
    }


    public String addAdresse(Adresse adresse){

        adresseRepository.save(adresse);

        return adresse + " a bien été ajouté à la base";
    }

    public String update(Long id, Adresse newAdresse) {
        // Recup adresse
        Adresse oldAdress = adresseRepository.getById(id);
       oldAdress.setNumero(newAdresse.getNumero());
       oldAdress.setRue(newAdresse.getRue());
       oldAdress.setCodePostal(newAdresse.getCodePostal());
       oldAdress.setVille(newAdresse.getVille());
       adresseRepository.save(oldAdress);

        return "Mise à jour Ok de l'adresse d'id " + id;
    }


    public void delete(Long id) {
        Adresse adresse = adresseRepository.getById(id);
        adresseRepository.delete(adresse);
    }

    public Adresse findByNumeroAndRueAndCodePostal(String numero, String rue, String codePostal) {
       return adresseRepository.findByNumeroAndRueAndCodePostal(numero, rue, codePostal);
    }

    public void save(Adresse adresse) {
        adresseRepository.save(adresse);
    }
}
