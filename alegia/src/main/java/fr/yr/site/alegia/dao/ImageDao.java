package fr.yr.site.alegia.dao;

import fr.yr.site.alegia.beans.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {

    List<Image> findByArticleId(int articleId);
}
