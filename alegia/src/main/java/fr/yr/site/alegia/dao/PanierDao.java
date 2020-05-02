package fr.yr.site.alegia.dao;

import fr.yr.site.alegia.beans.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierDao extends JpaRepository<Panier, Integer> {

    Panier findById(int id);
    Panier findByCompteId(int compteId);
}
