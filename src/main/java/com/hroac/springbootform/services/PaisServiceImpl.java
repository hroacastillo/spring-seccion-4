package com.hroac.springbootform.services;

import com.hroac.springbootform.model.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService{

    private List<Pais> lista;

    public PaisServiceImpl() {
        this.lista = Arrays.asList(
                new Pais(1,"ES","España"),
                new Pais(2,"MX","Mexico"),
                new Pais(3,"PE","Perú"),
                new Pais(4,"CO","Colombia"),
                new Pais(5,"AR","Argentina")
        );
    }

    @Override
    public List<Pais> list() {
        return lista;
    }

    @Override
    public Pais getById(Integer id) {

        Pais result = null;

        for (Pais pais:this.lista) {
            if (id.equals(pais.getId())) {
                result = pais;
                break;
            }
        }

        return result;
    }
}
