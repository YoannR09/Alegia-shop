package fr.alegia.apialegia.list.controller;

import fr.alegia.apialegia.list.dao.ListTailleDao;
import fr.alegia.apialegia.list.model.ListTaille;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListTailleController {

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    @Autowired
    private ListTailleDao dao;

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/listTaille/{id}")
    public ListTaille findById(@PathVariable int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/listTaille/article/{articleId}")
    public List<ListTaille> findByCategorieId(@PathVariable int articleId){
        try {
            return getDao().findByArticleId(articleId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter une listTaille
     * @param listTaille
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/listTaille")
    public void add(@RequestBody ListTaille listTaille){
        try {
            getDao().save(listTaille);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour supprimer une liste de taille en focntion de l'article id
     * @param articleId
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "/listTaille/Article/{articleId}")
    public void deleteByArticleId(@PathVariable Integer articleId){
        try {
            getDao().deleteByArticleId(articleId);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected ListTailleDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
