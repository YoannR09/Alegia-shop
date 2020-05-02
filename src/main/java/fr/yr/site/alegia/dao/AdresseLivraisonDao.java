package fr.yr.site.alegia.dao;

import fr.yr.site.alegia.beans.AdresseLivraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresseLivraisonDao extends JpaRepository<AdresseLivraison, Integer> {

    AdresseLivraison findById(int id);
    List<AdresseLivraison> findByCompteId(int compteId);
}
