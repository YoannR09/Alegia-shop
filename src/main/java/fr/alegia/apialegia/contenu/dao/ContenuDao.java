package fr.alegia.apialegia.contenu.dao;

import fr.alegia.apialegia.contenu.model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenuDao extends JpaRepository<Contenu,Integer> {

    Contenu findById(int id);

    List<Contenu> findByPanierIdOrderById(int panierId);
}
