package fr.yr.site.alegia.proxies;

import fr.yr.site.alegia.beans.Commande;
import fr.yr.site.alegia.dao.CommandeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Classe pour récupérer les données du MicroserviceCommande
 */
public class MicroserviceCommandeProxy {

    @Autowired
    private CommandeDao commandeDao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupérer une commande via un id.
     * @param id
     * @return
     */
    public Commande getCommande(int id){
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
    public Commande getCommandeByNumero(String numero){
        try {
            return getCommandeDao().findByNumero(numero);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }


    public List<Commande> findByNomPrenomEmail(String nom,
                                               String prenom,
                                               String email){
        try {
            return getCommandeDao().findByNomPrenomEmail(nom, prenom, email);
        }catch (Exception e){
            return null;
        }
    }


    public List<Commande> findByNomPrenom(String nom,
                                          String prenom){
        try {
            return getCommandeDao().findByNomPrenom(nom,prenom);
        }catch (Exception e){
            return null;
        }
    }


    public List<Commande> findByNom(String nom){
        try {
            return getCommandeDao().findByNom(nom);
        }catch (Exception e){
            return null;
        }
    }


    public List<Commande> findByNomEmail(String nom,String email){
        try {
            return getCommandeDao().findByNomEmail(nom,email);
        }catch (Exception e){
            return null;
        }
    }


    public List<Commande> findByPrenomEmail(String prenom,
                                            String email){
        try {
            return getCommandeDao().findByPrenomEmail(prenom, email);
        }catch (Exception e){
            return null;
        }
    }


    public List<Commande> findByPrenom(String prenom){
        try {
            return getCommandeDao().findByPrenom(prenom);
        }catch (Exception e){
            return null;
        }
    }

    public List<Commande> findByEmail(String email){
        try {
            return getCommandeDao().findByEmail(email);
        }catch (Exception e){
            return null;
        }
    }

    public List<Commande> findCommandeByNumeroContaining(String numero){
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
    public List<Commande> getCommandeByCompteId(int compteId){
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
    public List<Commande> getCOmmandeByStatutId(int statutId){
        try {
            return getCommandeDao().findByStatutIdOrderByIdDesc(statutId);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public List<Commande> getListCommande(){
        try {
            return getCommandeDao().findAll();
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    public void add(Commande commande){
        try {
            getCommandeDao().save(commande);
        }catch (Exception e){
            getLogger().error(e);
        }
    }

    public void update(Commande commande){
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
