package co.edu.usa.fincaapp.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Administrativo;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminRespositorio;

    public List<Administrativo> getTodosAdmin(){
        return (List<Administrativo>) adminRespositorio.findAll();
    }
    public Optional<Administrativo> getAdminPorId(Long id){
        return adminRespositorio.findById(id);
    }
    public Administrativo guardar(Administrativo admin){
        return adminRespositorio.save(admin);
    }
    public void borrar(Administrativo admin){
        adminRespositorio.delete(admin);
    }
    public void borrarPorIdAdmin(Long id){
        adminRespositorio.deleteById(id);
    }
}
