package fr.alegia.apialegia.panier.controller;

import fr.alegia.apialegia.panier.dao.PanierDao;
import fr.alegia.apialegia.panier.model.Panier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PanierController {

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    @Autowired
    private PanierDao dao;

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/panier/{id}")
    public Panier getPanier(@PathVariable int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/panier/compte/{compteId}")
    public Panier getPanierByCompteId(@PathVariable int compteId){
        try {
            return getDao().findByCompteId(compteId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour créer un panier
     * @param panier
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/panier")
    public void add(@RequestBody Panier panier){
        try {
            getDao().save(panier);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected PanierDao getDao() {
        return dao;
    }
}
