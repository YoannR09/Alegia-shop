package fr.yr.site.alegia.configuration;

import fr.yr.site.alegia.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Factory {


    private MicroserviceAdresseLivraisonProxy microserviceAdresseLivraisonProxy = new MicroserviceAdresseLivraisonProxy();

    private MicroserviceLigneDeCommandeProxy microserviceLigneDeCommandeProxy = new MicroserviceLigneDeCommandeProxy();

    private MicroserviceCommandeProxy microserviceCommandeProxy = new MicroserviceCommandeProxy();

    private MicroserviceArticleProxy microserviceArticleProxy = new MicroserviceArticleProxy();

    private MicroserviceCompteProxy microserviceCompteProxy = new MicroserviceCompteProxy();

    private MicroservicePanierProxy microservicePanierProxy= new MicroservicePanierProxy();

    private MicroserviceContenuPanierProxy microserviceContenuPanierProxy= new MicroserviceContenuPanierProxy();

    private MicroserviceCategorie microserviceCategorie= new MicroserviceCategorie();

    private MicroserviceImageProxy microserviceImageProxy= new MicroserviceImageProxy();

    private MicroserviceAdresseProxy microserviceAdresseProxy= new MicroserviceAdresseProxy();

    private MicroserviceTailleProxy microserviceTailleProxy= new MicroserviceTailleProxy();

    private MicroserviceListTaille microserviceListTaille= new MicroserviceListTaille();


    public MicroserviceLigneDeCommandeProxy getLigneProxy() {
        return microserviceLigneDeCommandeProxy;
    }

    public MicroserviceCommandeProxy getCommandeProxy() {
        return microserviceCommandeProxy;
    }

    public MicroserviceArticleProxy getArticleProxy() {
        return microserviceArticleProxy;
    }

    public MicroserviceCompteProxy getCompteProxy() {
        return microserviceCompteProxy;
    }

    public MicroservicePanierProxy getPanierProxy() {
        return microservicePanierProxy;
    }

    public MicroserviceContenuPanierProxy getContenuProxy() {
        return microserviceContenuPanierProxy;
    }

    public MicroserviceCategorie getCategorieProxy() {
        return microserviceCategorie;
    }

    public MicroserviceImageProxy getImageProxy() {
        return microserviceImageProxy;
    }

    public MicroserviceAdresseProxy getAdresseProxy() {
        return microserviceAdresseProxy;
    }

    public MicroserviceTailleProxy getTailleProxy() {
        return microserviceTailleProxy;
    }

    public MicroserviceListTaille getListTailleProxy() {
        return microserviceListTaille;
    }

    public MicroserviceAdresseLivraisonProxy getLivraisonProxy() {
        return microserviceAdresseLivraisonProxy;
    }
}
