package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.respositorios.FincaRepository;


@Service
public class FincaServicio {
    @Autowired
    private FincaRepository fincaRespositorio;

    public List<Finca> obtenerTodoAdministrativos(){
        return fincaRespositorio.getTodasFinca();
    }
    public Optional<Finca> getFincas(Long id){
        return fincaRespositorio.getFincaPorId(id);
    }
    public Finca guardar(Finca categoria) {
        if(categoria != null){
            if(categoria.getId() != null){
                Optional<Finca> oAdmin = fincaRespositorio.getFincaPorId(categoria.getId());
                if(oAdmin.isEmpty()){
                    return fincaRespositorio.guardar(categoria);
                }else{
                    return categoria;
                }
            }else{
                return fincaRespositorio.guardar(categoria);
            }
        }
        return null;
    }  
    public Finca actualizar(Finca categoria) {
        if(categoria.getId() != null){
            Optional<Finca> oAdmin = fincaRespositorio.getFincaPorId(categoria.getId());
            if(!oAdmin.isEmpty()){
                Finca c = oAdmin.get();
                if(categoria.getName()!= null){
                    c.setName(categoria.getName());
                }
                if(categoria.getAddress()!= null){
                    c.setAddress(categoria.getAddress());
                }
                if(categoria.getExension()!= null){
                    c.setExension(categoria.getExension());
                }
                if(categoria.getDescripcion()!= null){
                    c.setDescripcion(categoria.getDescripcion());
                }
                if(categoria.getCategoria()!= null){
                    c.setCategoria(categoria.getCategoria());
                }
                return fincaRespositorio.guardar(c);
            }else{
                return categoria;
            }
        }else{
            return categoria;
        }
    }

    public boolean borrarAdmin(Long id){
        Boolean borrado =  getFincas(id).map(c -> {
            fincaRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}
