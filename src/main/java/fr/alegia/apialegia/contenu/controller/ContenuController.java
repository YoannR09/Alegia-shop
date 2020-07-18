package fr.alegia.apialegia.contenu.controller;

import fr.alegia.apialegia.contenu.dao.ContenuDao;
import fr.alegia.apialegia.contenu.model.Contenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContenuController {

    @Autowired
    private ContenuDao dao;

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    /**
     * Méthode pour récupérer un
     * @param id
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/contenu/{id}")
    public Contenu findById(@PathVariable int id){
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
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/contenu/panier/{panierId}")
    public List<Contenu> findByPanierId(@PathVariable int panierId){
        try {
            return getDao().findByPanierIdOrderById(panierId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un contenu à la bdd
     * @param contenu
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/contenu")
    public void add(@RequestBody Contenu contenu){
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
    @CrossOrigin(origins = URL_ORIGIN)
    @PutMapping(value = "/contenu")
    public void update(@RequestBody Contenu contenu){
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
    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "/contenu/{id}")
    public void delete(@PathVariable int id){
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
