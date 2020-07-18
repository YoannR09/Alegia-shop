package fr.alegia.apialegia.article.dao;

import fr.alegia.apialegia.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer> {

    Article findById(int id);

    Article findByNom(String nom);

    List<Article> findByCategorieId(int categorieId);

    List<Article> findByCategorieIdAndDisponible(int categorieId, Boolean dispo);

    List<Article> findAll();

    List<Article> findByDisponibleOrderById(Boolean dispo);
}
