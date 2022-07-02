package com.hroac.springbootform.services;

import com.hroac.springbootform.model.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> list();

    public Pais getById(Integer id);

}
