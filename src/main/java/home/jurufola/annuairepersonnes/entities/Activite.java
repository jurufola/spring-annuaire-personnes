package home.jurufola.annuairepersonnes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;

    @ManyToMany
    @JoinTable(name = "personne_activite", joinColumns = @JoinColumn(name="activite_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "personne_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Personne> personnes = new HashSet<>();

    public Activite(String libelle, String description, Set<Personne> personnes) {
        this.libelle = libelle;
        this.description = description;
        this.personnes = personnes;
    }

    public Activite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", personnes=" + personnes +
                '}';
    }
}
