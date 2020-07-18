package fr.alegia.apialegia.image.dao;

import fr.alegia.apialegia.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {

    List<Image> findByArticleId(int articleId);
}
