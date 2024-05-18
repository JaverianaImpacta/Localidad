package edu.javeriana.ingenieria.social.localidad.repositorio;

import edu.javeriana.ingenieria.social.localidad.dominio.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioLocalidad extends JpaRepository<Localidad, Integer> {
    List<Localidad> findAllByCiudad(Integer ciudad);

    Localidad findOneByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);
}
