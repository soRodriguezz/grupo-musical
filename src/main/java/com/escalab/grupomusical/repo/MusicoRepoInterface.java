package com.escalab.grupomusical.repo;

import com.escalab.grupomusical.model.Musico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicoRepoInterface extends JpaRepository<Musico, Integer> {
}
