package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Image;
import fr.yr.site.alegia.dao.ImageDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceImageProxy {

    @Autowired
    private ImageDao dao;

    private static final Logger logger = LogManager.getLogger();

    public List<Image> findByArticleId(int articleId){
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
    public void add(Image image){
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
    public void delete(int id){
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
