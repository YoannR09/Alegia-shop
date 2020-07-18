package fr.alegia.apialegia.categorie.controller;

import fr.alegia.apialegia.categorie.dao.CategorieDao;
import fr.alegia.apialegia.categorie.model.Categorie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    @Autowired
    private CategorieDao dao;

    /**
     * Méthode pour rechercher une catégorie via un id
     * @param id
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/categorie/{id}")
    public Categorie findById(@PathVariable int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une catégorie via un nom
     * @param nom
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/categorie/Nom/{nom}")
    public Categorie findByNom(@PathVariable String nom){
        try {
            return getDao().findByNom(nom);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour trouver toutes les catégories
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/categorie")
    public List<Categorie> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour trouver toutes les catégories disponibles ou indisponibles
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/categorie/Dispo/{dispo}")
    public List<Categorie> findByDispo(@PathVariable Boolean dispo){
        try {
            return getDao().findByDisponible(dispo);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter une catégorie
     * Passe par une vérification du nom pour voir si une
     * catégorie existe déjà avec ce nom
     * @param categorie
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/categorie")
    public void add(@RequestBody Categorie categorie){
        try {
            Categorie cat = getDao().findByNom(categorie.getNom());
            if(cat == null){
                getDao().save(categorie);
            }
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour mettre à jour une catégorie
     * @param categorie
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PutMapping(value = "/categorie")
    public void update(@RequestBody Categorie categorie){
        try {
            getDao().save(categorie);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour supprimer une catégorie via un id
     * @param id
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "/categorie/{id}")
    public void delete(@PathVariable int id){
        try {
            getDao().deleteById(id);
        }catch (Exception e){
            logger.error(e);
        }
    }

    protected CategorieDao getDao() {
        return dao;
    }


    protected Logger getLogger() {
        return logger;
    }
}
