package com.odk.errornotesapi.Repository;

import com.odk.errornotesapi.modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCommentaire extends JpaRepository<Commentaire, Long> {


}
