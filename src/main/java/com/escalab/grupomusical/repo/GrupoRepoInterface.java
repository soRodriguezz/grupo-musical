package com.escalab.grupomusical.repo;

import com.escalab.grupomusical.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepoInterface extends JpaRepository<Grupo, Integer> {

}
