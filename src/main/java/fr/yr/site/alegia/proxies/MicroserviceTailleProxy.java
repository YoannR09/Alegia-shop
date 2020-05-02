package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Taille;
import fr.yr.site.alegia.dao.TailleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public class MicroserviceTailleProxy {

    @Autowired
    private TailleDao dao;

    private static final Logger logger = LogManager.getLogger();


    public Taille findById(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public Taille findByTaille(String taille){
        try {
            return getDao().findByTaille(taille);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer la liste des tailles exitantes
     * @return
     */
    public List<Taille> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    protected TailleDao getDao() {
        return dao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
