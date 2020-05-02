package fr.yr.site.alegia.beans;


import javax.persistence.*;

@Entity
public class ListTaille {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer articleId;
    private Integer tailleId;
    @Transient
    private Taille  taille;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTailleId() {
        return tailleId;
    }

    public void setTailleId(Integer tailleId) {
        this.tailleId = tailleId;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }
}
