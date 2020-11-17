package com.escalab.grupomusical.service;

import com.escalab.grupomusical.model.Grupo;

import java.util.List;

public interface GrupoService {

    List<Grupo> getAll();

    Grupo save(Grupo grupo);

    Grupo findById(Integer grupo);

    Grupo update(Grupo grupo);

    Boolean delete(Integer id);

}
