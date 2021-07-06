package home.jurufola.annuairepersonnes.repositories;

import home.jurufola.annuairepersonnes.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    Adresse findByNumeroAndRueAndCodePostal(String numero, String rue, String codePostal);
}
