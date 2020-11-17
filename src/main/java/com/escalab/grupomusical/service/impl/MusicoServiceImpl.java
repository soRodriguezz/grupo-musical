package com.escalab.grupomusical.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.grupomusical.model.Musico;
import com.escalab.grupomusical.repo.MusicoRepoInterface;
import com.escalab.grupomusical.service.MusicoService;

@Service
public class MusicoServiceImpl implements MusicoService {
    @Autowired
    private MusicoRepoInterface musicoRepoInterface;


    @Override
    public List<Musico> getAll() {
        List<Musico> musico = musicoRepoInterface.findAll();
        musico.forEach((p) -> {
        	System.out.print(p.toString());
        });
    	return musico;
    }

    @Override
    public Musico save(Musico musico) {
        return musicoRepoInterface.save(musico);
    }

    @Override
    public Musico findById(Integer id) {
    	Optional<Musico> musico = musicoRepoInterface.findById(id);
    	if(musico.isPresent()) {
    		return musico.get();
    	} else {
    		return new Musico();
    	}
    }

    @Override
    public Musico update(Musico musico) {
        return musicoRepoInterface.save(musico);
    }

    @Override
    public Boolean delete(Integer id) {
        musicoRepoInterface.deleteById(id);
    	return true;
    }
}
