package fr.alegia.apialegia.compte.controller;

import fr.alegia.apialegia.compte.dao.CompteDao;
import fr.alegia.apialegia.compte.model.Compte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteController {

    @Autowired
    private CompteDao dao;

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";


    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/compte/{id}")
    public Compte findById(@PathVariable int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/compte/email/{email}")
    public Compte findByEmail(@PathVariable String email){
        try {
            return getDao().findByEmail(email);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/compte")
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
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/compte")
    public void add(@RequestBody Compte compte){
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
    @CrossOrigin(origins = URL_ORIGIN)
    @PutMapping(value = "/compte")
    public void update(@RequestBody Compte compte){
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
