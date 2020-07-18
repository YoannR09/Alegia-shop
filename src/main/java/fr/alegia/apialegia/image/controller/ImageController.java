package fr.alegia.apialegia.image.controller;

import fr.alegia.apialegia.image.dao.ImageDao;
import fr.alegia.apialegia.image.model.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageDao dao;

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/image/article/{articleId}")
    public List<Image> findByArticleId(@PathVariable int articleId){
        try {
            return getDao().findByArticleId(articleId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter une image
     * @param image
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/image")
    public void add(@RequestBody Image image){
        try {
            getDao().save(image);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour supprimer une image
     * @param id
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "/image/{id}")
    public void delete(@PathVariable int id){
        try {
            getDao().deleteById(id);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected ImageDao getDao() {
        return dao;
    }
}
