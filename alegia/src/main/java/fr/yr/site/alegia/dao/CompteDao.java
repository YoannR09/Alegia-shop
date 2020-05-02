package fr.yr.site.alegia.dao;

import fr.yr.site.alegia.beans.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteDao extends JpaRepository<Compte,Integer> {

    Compte findById(int id);
    Compte findByEmail(String email);
    Compte findByNiveauAccesId(int niveau);
}
