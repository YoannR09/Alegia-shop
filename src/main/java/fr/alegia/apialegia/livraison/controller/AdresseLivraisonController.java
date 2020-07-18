package fr.alegia.apialegia.livraison.controller;

import fr.alegia.apialegia.livraison.dao.AdresseLivraisonDao;
import fr.alegia.apialegia.livraison.model.AdresseLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdresseLivraisonController {

    @Autowired
    private AdresseLivraisonDao dao;

    private static final String URL_ORIGIN = "*";

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/livraison")
    public List<AdresseLivraison> findAll(){
        try {
            return dao.findAll();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/livraison/{id}")
    public AdresseLivraison findById(@PathVariable int id){
        try {
            return dao.findById(id);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/livraison/compte/{compteId}")
    public List<AdresseLivraison> findByCompteId(@PathVariable int compteId){
        try {
            return dao.findByCompteId(compteId);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/livraison")
    public void add(@RequestBody AdresseLivraison adresseLivraison){
        try {
            dao.save(adresseLivraison);
        }catch (Exception e){

        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @PutMapping(value = "/livraison")
    public void update(@RequestBody AdresseLivraison adresseLivraison){
        try {
            dao.save(adresseLivraison);
        }catch (Exception e){

        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "livraison/{id}")
    public void delete(@PathVariable int id){
        try {
            dao.deleteById(id);
        }catch (Exception e){

        }
    }

    @Transactional
    @CrossOrigin(origins = URL_ORIGIN)
    @DeleteMapping(value = "livraison/adresse/{adresseId}")
    public void deleteByAdresseId(@PathVariable int adresseId){
        try {
            dao.deleteByAdresseId(adresseId);
            System.out.println(adresseId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
