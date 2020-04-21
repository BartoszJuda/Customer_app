package com.project.repositories;

import com.project.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query("select l from Link l where l.id=?1")
    Link getLinkById(long id);

    @Query("select l from Link l where l.linkName=?1")
    Link getLinkByLinkName(String linkName);
}
