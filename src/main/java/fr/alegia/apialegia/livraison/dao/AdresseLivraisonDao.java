package fr.alegia.apialegia.livraison.dao;

import fr.alegia.apialegia.livraison.model.AdresseLivraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresseLivraisonDao extends JpaRepository<AdresseLivraison, Integer> {

    AdresseLivraison findById(int id);
    List<AdresseLivraison> findByCompteId(int compteId);
    void deleteByAdresseId(int adresseId);
}
