package fr.alegia.apialegia.list.dao;

import fr.alegia.apialegia.list.model.ListTaille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListTailleDao extends JpaRepository<ListTaille,Integer> {

    ListTaille findById(int id);

    List<ListTaille> findByArticleId(int articleId);

    @Query(value = "DELETE FROM list_taille WHERE article_id = :articleId",
            nativeQuery = true)
    void deleteByArticleId(int articleId);
}
