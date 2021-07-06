package home.jurufola.annuairepersonnes.repositories;

import home.jurufola.annuairepersonnes.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
