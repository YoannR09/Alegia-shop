package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Adresse;
import fr.yr.site.alegia.beans.AdresseLivraison;
import fr.yr.site.alegia.dao.AdresseDao;
import fr.yr.site.alegia.dao.AdresseLivraisonDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public class MicroserviceAdresseLivraisonProxy {

    @Autowired
    private AdresseLivraisonDao dao;

    public List<AdresseLivraison> findAll(){
        try {
            return dao.findAll();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }


    public AdresseLivraison findById( int id){
        try {
            return dao.findById(id);
        }catch (Exception e){
            return null;
        }
    }


    public List<AdresseLivraison> findByCompteId( int compteId){
        try {
            return dao.findByCompteId(compteId);
        }catch (Exception e){
            return null;
        }
    }

    public void add(AdresseLivraison adresseLivraison){
        try {
            dao.save(adresseLivraison);
        }catch (Exception e){

        }
    }

    public void update( AdresseLivraison adresseLivraison){
        try {
            dao.save(adresseLivraison);
        }catch (Exception e){

        }
    }


    public void delete( int id){
        try {
            dao.deleteById(id);
        }catch (Exception e){

        }
    }
}
