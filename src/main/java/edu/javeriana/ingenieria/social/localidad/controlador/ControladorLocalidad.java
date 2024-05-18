package edu.javeriana.ingenieria.social.localidad.controlador;

import edu.javeriana.ingenieria.social.localidad.dominio.Localidad;
import edu.javeriana.ingenieria.social.localidad.servicio.ServicioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidades")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorLocalidad {
    @Autowired
    private ServicioLocalidad servicio;

    @GetMapping("listar")
    public List<Localidad> obtenerLocalidades() {
        return servicio.obtenerLocalidades();
    }

    @GetMapping("obtener")
    public ResponseEntity<Localidad> obtenerLocalidad(@RequestParam Integer codigo){
        if(codigo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.localidadExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerLocalidad(codigo), HttpStatus.OK);
    }

    @GetMapping("obtenerCiudad")
    public ResponseEntity<List<Localidad>> obtenerLocalidades(@RequestParam Integer ciudad){
        if(ciudad == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerLocalidades(ciudad).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerLocalidades(ciudad), HttpStatus.OK);
    }
}
