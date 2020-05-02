package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Compte;
import fr.yr.site.alegia.dao.CompteDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MicroserviceCompteProxy {

    @Autowired
    private CompteDao dao;

    private static final Logger logger = LogManager.getLogger();


    public Compte findById(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public Compte findByEmail(String email){
        try {
            return getDao().findByEmail(email);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public List<Compte> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un compte
     * L'adresse éléctronique est mise en minuscule
     * Le nom et prénom sont mis en majuscule
     * Si c'est le premier compte créé dans la bdd
     * ce compte sera alors un compte administrateur
     * @param compte
     */
    public void add(Compte compte){
        try {
            compte.setEmail(compte.getEmail().toLowerCase());
            compte.setNom(compte.getNom().toUpperCase());
            compte.setPrenom(compte.getPrenom().toUpperCase());
            if (findAll().size() == 0 && getDao().findByNiveauAccesId(2) == null){
                compte.setNiveauAccesId(2);
            }
            getDao().save(compte);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour mettre à jour un compte
     * @param compte
     */
    public void update(Compte compte){
        try {
            getDao().save(compte);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected CompteDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
