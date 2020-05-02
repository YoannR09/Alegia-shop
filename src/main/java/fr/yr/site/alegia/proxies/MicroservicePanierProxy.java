package fr.yr.site.alegia.proxies;


import fr.yr.site.alegia.beans.Panier;
import fr.yr.site.alegia.dao.PanierDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MicroservicePanierProxy {


    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private PanierDao dao;

    public Panier getPanier(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public Panier getPanierByCompteId(int compteId){
        try {
            return getDao().findByCompteId(compteId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }


    public void add(Panier panier){
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
