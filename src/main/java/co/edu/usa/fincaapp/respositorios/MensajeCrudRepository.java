package co.edu.usa.fincaapp.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Mensaje;


public interface MensajeCrudRepository extends CrudRepository<Mensaje, Long>{
    
}
