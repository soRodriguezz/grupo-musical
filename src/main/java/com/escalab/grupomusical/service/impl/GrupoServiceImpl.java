package com.escalab.grupomusical.service.impl;

import com.escalab.grupomusical.model.Grupo;
import com.escalab.grupomusical.repo.GrupoRepoInterface;
import com.escalab.grupomusical.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired
    private GrupoRepoInterface grupoRepoInterface;

    @Override
    public List<Grupo> getAll() {
    	List<Grupo> grupo = grupoRepoInterface.findAll();
    	
    	grupo.forEach((p) -> {
    		System.out.print(p.toString());
    	});
        return grupo;
    }

    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepoInterface.save(grupo);
    }

    @Override
    public Grupo findById(Integer id) {
    	Optional<Grupo> grupo = grupoRepoInterface.findById(id);
    	if(grupo.isPresent()) {
    		return grupo.get();
    	} else {
    		return new Grupo();
    	}
    }

    @Override
    public Grupo update(Grupo grupo) {
        return grupoRepoInterface.save(grupo);
    }

    @Override
    public Boolean delete(Integer id) {
        grupoRepoInterface.deleteById(id);
    	return true;
    }

}
