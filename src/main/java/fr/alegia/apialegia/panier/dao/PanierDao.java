package fr.alegia.apialegia.panier.dao;

import fr.alegia.apialegia.panier.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierDao extends JpaRepository<Panier, Integer> {

    Panier findById(int id);
    Panier findByCompteId(int compteId);
}
