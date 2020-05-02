package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Adresse;
import fr.yr.site.alegia.dao.AdresseDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceAdresseProxy {

    @Autowired
    private AdresseDao dao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour rechercher ka liste des adresses
     * @return
     */
    public List<Adresse> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une adresse via un id
     * @param id
     * @return
     */
    public Adresse getAdresse(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }


    /**
     * Méthode pour ajouter une adresse
     * @param adresse
     */
    public void add(Adresse adresse){
        try {
            getDao().save(adresse);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour récupérer une adresse en fonction de toutes les valeurs de l'objet Adresse
     * @param ville
     * @param codePostal
     * @param numero
     * @param rue
     * @return
     */
    public Adresse findByVilleAndCodePostalAndNumeroAndRueAndInfo(
            String ville,
            String codePostal,
            String numero,
            String rue,String info){
        try {
            return getDao().findByVilleAndCodePostalAndNumeroAndRueAndInfo(ville,codePostal,numero,rue,info);
        }catch (Exception e){
            return null;
        }
    }


    public List<Adresse> findOldByCompteId(int compteId){
        try {
            return getDao().findOldAdresseByCompteIdAnd(compteId);
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }


    /**
     * Méthode pour mettre à jour une adresse existante
     * @param adresse
     */
    public void update(Adresse adresse){
        try {
            getDao().save(adresse);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected AdresseDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
