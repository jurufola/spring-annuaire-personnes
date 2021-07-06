package home.jurufola.annuairepersonnes;

import home.jurufola.annuairepersonnes.entities.Adresse;
import home.jurufola.annuairepersonnes.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdresseController {
    @Autowired
    AdresseService adresseService;

    @GetMapping("adresses")
    public List<Adresse> getAdresses(){

        return adresseService.getAdresses();
    }
}
