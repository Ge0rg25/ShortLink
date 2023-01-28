package ru.just.coders.linkshorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.just.coders.linkshorter.models.LinkModel;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Long> {

    public LinkModel findAllByOwner_token();

}
