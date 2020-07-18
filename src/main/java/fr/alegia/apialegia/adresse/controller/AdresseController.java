package fr.alegia.apialegia.adresse.controller;

import fr.alegia.apialegia.adresse.dao.AdresseDao;
import fr.alegia.apialegia.adresse.model.Adresse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdresseController {

    @Autowired
    private AdresseDao dao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour rechercher ka liste des adresses
     * @return
     */
    @GetMapping(value = "/adresse")
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
    @GetMapping(value = "/adresse/{id}")
    public Adresse getAdresse(@PathVariable int id){
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
    @PostMapping(value = "/adresse")
    public void add(@RequestBody Adresse adresse){
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
    @GetMapping(value = "/adresse/all/{ville}/{codePostal}/{numero}/{rue}/{info}")
    public Adresse findByVilleAndCodePostalAndNumeroAndRueAndInfo(
            @PathVariable String ville,
            @PathVariable String codePostal,
            @PathVariable String numero,
            @PathVariable String rue,@PathVariable String info){
        try {
            return getDao().findByVilleAndCodePostalAndNumeroAndRueAndInfo(ville,codePostal,numero,rue,info);
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = "/adresse/OldCommande/{compteId}")
    public List<Adresse> findOldByCompteId(@PathVariable int compteId){
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
    @PutMapping(value = "/adresse")
    public void update(@RequestBody Adresse adresse){
        try {
            getDao().save(adresse);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    @DeleteMapping(value = "/adresse/{id}")
    public void delete(@PathVariable int id){
        try {
            dao.deleteById(id);
        }catch (Exception e){

        }
    }

    protected AdresseDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
