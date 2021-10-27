package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Administrativo;
import co.edu.usa.fincaapp.respositorios.AdminRepository;

@Service
public class AdminServicio {
    @Autowired
    private AdminRepository adminRespositorio;

    public List<Administrativo> obtenerTodoAdministrativos(){
        return adminRespositorio.getTodosAdmin();
    }
    public Optional<Administrativo> getAdmin(Long id){
        return adminRespositorio.getAdminPorId(id);
    }
    public Administrativo guardar(Administrativo admin) {
        if(admin != null){
            if(admin.getId() != null){
                Optional<Administrativo> oAdmin = adminRespositorio.getAdminPorId(admin.getId());
                if(oAdmin.isEmpty()){
                    return adminRespositorio.guardar(admin);
                }else{
                    return admin;
                }
            }else{
                return adminRespositorio.guardar(admin);
            }
        }
        return null;
    }  
    public Administrativo actualizar(Administrativo admin) {
        if(admin.getId() != null){
            Optional<Administrativo> oAdmin = adminRespositorio.getAdminPorId(admin.getId());
            if(!oAdmin.isEmpty()){
                Administrativo c = oAdmin.get();
                if(admin.getNombre()!= null){
                    c.setNombre(admin.getNombre());
                }
                if(admin.getCorreo()!= null){
                    c.setCorreo(admin.getCorreo());
                }
                if(admin.getContrasena()!= null){
                    c.setContrasena(admin.getContrasena());
                }

                return adminRespositorio.guardar(c);
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean borrarAdmin(Long id){
        Boolean borrado =  getAdmin(id).map(c -> {
            adminRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}
