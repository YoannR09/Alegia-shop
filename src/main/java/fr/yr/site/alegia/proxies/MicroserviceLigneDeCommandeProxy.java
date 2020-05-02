package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.LigneDeCommande;
import fr.yr.site.alegia.dao.LigneDeCommandeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public class MicroserviceLigneDeCommandeProxy {

    @Autowired
    private LigneDeCommandeDao dao;

    private static final Logger logger = LogManager.getLogger();

    public LigneDeCommande findById(int id){
        try {
            return getDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public List<LigneDeCommande> findAll(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public List<LigneDeCommande> findByCommandeId(int commandeId){
        try {
            return getDao().findByCommandeId(commandeId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public void add(LigneDeCommande ldc){
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
