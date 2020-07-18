package fr.alegia.apialegia.commande.controller;

import fr.alegia.apialegia.commande.dao.CommandeDao;
import fr.alegia.apialegia.commande.model.Commande;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {

    @Autowired
    private CommandeDao commandeDao;

    private static final Logger logger = LogManager.getLogger();
    private static final String URL_ORIGIN = "*";

    /**
     * Méthode pour récupérer une commande via un id.
     * @param id
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/{id}")
    public Commande getCommande(@PathVariable int id){
        try {
            return getCommandeDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une commande via un numéro.
     * @param numero
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/Numero/{numero}")
    public Commande getCommandeByNumero(@PathVariable String numero){
        try {
            return getCommandeDao().findByNumero(numero);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/NomPrenomEmail/{nom},{prenom},{email}")
    public List<Commande> findByNomPrenomEmail(@PathVariable String nom,
                                        @PathVariable String prenom,
                                        @PathVariable String email){
        try {
            return getCommandeDao().findByNomPrenomEmail(nom, prenom, email);
        }catch (Exception e){
            return null;
        }
    }


    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/NomPrenom/{nom},{prenom}")
    public List<Commande> findByNomPrenom(@PathVariable String nom,
                                   @PathVariable String prenom){
        try {
            return getCommandeDao().findByNomPrenom(nom,prenom);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/Nom/{nom}")
    public List<Commande> findByNom(@PathVariable String nom){
        try {
            return getCommandeDao().findByNom(nom);
        }catch (Exception e){
            return null;
        }
    }


    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/NomEmail/{nom},{email}")
    public List<Commande> findByNomEmail(@PathVariable String nom,@PathVariable String email){
     try {
         return getCommandeDao().findByNomEmail(nom,email);
     }catch (Exception e){
         return null;
     }
    }


    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/PrenomEmail/{prenom},{email}")
    public List<Commande> findByPrenomEmail(@PathVariable String prenom,
                                     @PathVariable String email){
        try {
            return getCommandeDao().findByPrenomEmail(prenom, email);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/Prenom/{prenom}")
    public List<Commande> findByPrenom(@PathVariable("prenom") String prenom){
        try {
            return getCommandeDao().findByPrenom(prenom);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/Email/{email}")
    public List<Commande> findByEmail(@PathVariable("email") String email){
        try {
            return getCommandeDao().findByEmail(email);
        }catch (Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/NumeroContaining/{numero}")
    public List<Commande> findCommandeByNumeroContaining(@PathVariable String numero){
        try {
            return getCommandeDao().findByNumeroContainingOrderByIdDesc(numero);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Méthode pour récupérer une commande via l'id d'un compte.
     * @param compteId
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/compte/{compteId}")
    public List<Commande> getCommandeByCompteId(@PathVariable int compteId){
        try {
            return getCommandeDao().findByCompteIdOrderByIdDesc(compteId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de commandes via l'id d'un statut
     * @param statutId
     * @return
     */
    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande/Statut/{statutId}")
    public List<Commande> getCOmmandeByStatutId(@PathVariable int statutId){
        try {
            return getCommandeDao().findByStatutIdOrderByIdDesc(statutId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @GetMapping(value = "/commande")
    public List<Commande> getListCommande(){
        try {
            return getCommandeDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @PostMapping(value = "/commande")
    public void add(@RequestBody Commande commande){
        try {
            getCommandeDao().save(commande);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    @CrossOrigin(origins = URL_ORIGIN)
    @PutMapping(value = "/commande")
    public void update(@RequestBody Commande commande){
        try {
            getCommandeDao().save(commande);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected CommandeDao getCommandeDao() {
        return commandeDao;
    }
}
