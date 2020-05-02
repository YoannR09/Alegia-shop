package fr.yr.site.alegia.proxies;


import fr.yr.site.alegia.beans.ListTaille;
import fr.yr.site.alegia.beans.Taille;
import fr.yr.site.alegia.dao.ListTailleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceListTaille {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private ListTailleDao dao;

    public ListTaille findById(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }


    public List<ListTaille> findByArticleId(int articleId){
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
    public void add(ListTaille listTaille){
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
    public void deleteByArticleId(Integer articleId){
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
