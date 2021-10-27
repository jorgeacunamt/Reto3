package co.edu.usa.fincaapp.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Administrativo;

public interface AdminCrudRepository extends CrudRepository<Administrativo, Long>{
    
}
