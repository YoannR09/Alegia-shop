package fr.alegia.apialegia.compte.dao;

import fr.alegia.apialegia.compte.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteDao extends JpaRepository<Compte,Integer> {

    Compte findById(int id);
    Compte findByEmail(String email);
    Compte findByNiveauAccesId(int niveau);
}
