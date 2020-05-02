package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Article;
import fr.yr.site.alegia.dao.ArticleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MicroserviceArticleProxy {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private ArticleDao articleDao;

    /**
     * Méthode pou récupérer un article via un id
     * @param id
     * @return
     */
    public Article getArticle(int id){
        try {
            return getArticleDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }


    public List<Article> getArticleByCategorieId(int categorieId){
        try {
            return getArticleDao().findByCategorieId(categorieId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer la liste des articles
     * @return
     */
    public List<Article> findAll(){
        try {
            return getArticleDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste d'articles
     * en fonction de la disponibilité et l'id d'une categorie
     * @param categorieId
     * @param dispo
     * @return
     */
    public List<Article> findByCategorieIdAndDisponible(int categorieId,@PathVariable Boolean dispo){
        try {
            return getArticleDao().findByCategorieIdAndDisponible(categorieId,dispo);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer tous les articles disponibles
     * @param dispo
     * @return
     */
    public List<Article> findByDisponibleOrderById(Boolean dispo){
        try {
            return getArticleDao().findByDisponibleOrderById(dispo);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer un article via son nom
     * @param nom
     * @return
     */
    public Article findByNom(String nom){
        try {
            return getArticleDao().findByNom(nom);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un article
     * @param article
     */
    public void add( Article article){
        try {
            getArticleDao().save(article);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * Méthode pour mettre à jour un article
     * @param article
     */
    public void update(Article article){
        try {
            getArticleDao().save(article);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    /**
     * %éthode pour supprimer un article
     * @param id
     */
    public void delete(Integer id){
        try {
            getArticleDao().deleteById(id);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected ArticleDao getArticleDao() {
        return articleDao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
