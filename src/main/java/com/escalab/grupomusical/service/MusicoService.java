package com.escalab.grupomusical.service;

import com.escalab.grupomusical.model.Musico;

import java.util.List;

public interface MusicoService {

    List<Musico> getAll();

    Musico save(Musico musico);

    Musico findById(Integer musico);

    Musico update(Musico musico);

    Boolean delete(Integer id);

}
