package home.jurufola.annuairepersonnes.repositories;

import home.jurufola.annuairepersonnes.entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
    Activite findByLibelleAndDescription(String libelle, String description);
}
