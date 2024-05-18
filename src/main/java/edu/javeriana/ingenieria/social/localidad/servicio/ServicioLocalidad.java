package edu.javeriana.ingenieria.social.localidad.servicio;

import edu.javeriana.ingenieria.social.localidad.dominio.Localidad;
import edu.javeriana.ingenieria.social.localidad.repositorio.RepositorioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLocalidad {
    @Autowired
    private RepositorioLocalidad repositorio;

    public List<Localidad> obtenerLocalidades(){
        return repositorio.findAll();
    }

    public List<Localidad> obtenerLocalidades(Integer ciudad){
        return repositorio.findAllByCiudad(ciudad);
    }

    public Localidad obtenerLocalidad(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public boolean localidadExiste(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }
}
