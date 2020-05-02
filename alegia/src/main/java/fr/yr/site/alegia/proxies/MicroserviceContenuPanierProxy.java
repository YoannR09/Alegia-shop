package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Contenu;
import fr.yr.site.alegia.dao.ContenuDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceContenuPanierProxy {

    @Autowired
    private ContenuDao dao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupérer un
     * @param id
     * @return
     */
    public Contenu findById(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de contenus via l'id d'un panier
     * @param panierId
     * @return
     */
    public List<Contenu> findByPanierId(int panierId){
        try {
            return getDao().findByPanierId(panierId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un contenu à la bdd
     * @param contenu
     */
    public void add(Contenu contenu){
        try {
            getDao().save(contenu);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour mettre à jour un coutennu existant
     * @param contenu
     */
    public void update(Contenu contenu){
        try {
            getDao().save(contenu);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour supprimer un contenu
     * @param id
     */
    public void delete(int id){
        try {
            getDao().deleteById(id);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected ContenuDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
