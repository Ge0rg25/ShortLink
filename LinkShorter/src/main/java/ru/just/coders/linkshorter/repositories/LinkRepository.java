package ru.just.coders.linkshorter.repositories;

import jakarta.ws.rs.core.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.just.coders.linkshorter.models.LinkModel;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Long> {


    public LinkModel findByShorturl(String short_url);

    public List<LinkModel> findAllByOwnertoken(String ownertoken);

    public Boolean existsByShorturl(String shorturl);
}
