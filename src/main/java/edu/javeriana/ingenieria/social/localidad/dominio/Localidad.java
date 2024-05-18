package edu.javeriana.ingenieria.social.localidad.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Localidad {
    @Id
    private Integer id;
    private Integer codigo, ciudad;
    private String descripcion;
}
