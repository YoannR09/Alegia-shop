package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Categorie;
import fr.yr.site.alegia.dao.CategorieDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceCategorie {


    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private CategorieDao dao;

    /**
     * Méthode pour rechercher une catégorie via un id
     * @param id
     * @return
     */
    public Categorie findById(int id){
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
    public Categorie findByNom(String nom){
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
    public List<Categorie> findAll(){
        try {
            return getDao().findByDisponible(true);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour trouver toutes les catégories disponibles ou indisponibles
     * @return
     */
    public List<Categorie> findByDispo(Boolean dispo){
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
    public void add(Categorie categorie){
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
    public void update(Categorie categorie){
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
    public void delete(int id){
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

