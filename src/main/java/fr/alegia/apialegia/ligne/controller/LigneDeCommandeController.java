package fr.alegia.apialegia.ligne.controller;

import fr.alegia.apialegia.ligne.dao.LigneDeCommandeDao;
import fr.alegia.apialegia.ligne.model.LigneDeCommande;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneDeCommandeController {

    @Autowired
    private LigneDeCommandeDao dao;

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/ligneDeCommande/{id}")
    public LigneDeCommande findById(@PathVariable int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/ligneDeCommande")
    public List<LigneDeCommande> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/ligneDeCommande/commande/{commandeId}")
    public List<LigneDeCommande> findByCommandeId(@PathVariable int commandeId){
        try {
            return getDao().findByCommandeId(commandeId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/ligneDeCommande")
    public void add(@RequestBody LigneDeCommande ldc){
        try {
            getDao().save(ldc);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected LigneDeCommandeDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
