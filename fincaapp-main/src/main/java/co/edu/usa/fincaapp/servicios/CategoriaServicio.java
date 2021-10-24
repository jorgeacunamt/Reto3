package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Categoria;
import co.edu.usa.fincaapp.respositorios.CategoriaRepository;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepository categoriaRespositorio;

    public List<Categoria> obtenerTodoCategorias(){
        return categoriaRespositorio.getTodosCategorias();
    }
    public Optional<Categoria> getCategorias(Long id){
        return categoriaRespositorio.getCategoriasPorId(id);
    }
    public Categoria guardar(Categoria categoria) {
        if(categoria != null){
            if(categoria.getId() != null){
                Optional<Categoria> oAdmin = categoriaRespositorio.getCategoriasPorId(categoria.getId());
                if(oAdmin.isEmpty()){
                    return categoriaRespositorio.guardar(categoria);
                }else{
                    return categoria;
                }
            }else{
                return categoriaRespositorio.guardar(categoria);
            }
        }
        return null;
    }  
    public Categoria actualizar(Categoria categoria) {
        if(categoria.getId() != null){
            Optional<Categoria> oAdmin = categoriaRespositorio.getCategoriasPorId(categoria.getId());
            if(!oAdmin.isEmpty()){
                Categoria c = oAdmin.get();
                if(categoria.getName()!= null){
                    c.setName(categoria.getName());
                }
                if(categoria.getDescription()!= null){
                    c.setDescription(categoria.getDescription());
                }
                return categoriaRespositorio.guardar(c);
            }else{
                return categoria;
            }
        }else{
            return categoria;
        }
    }

    public boolean borrarAdmin(Long id){
        Boolean borrado =  getCategorias(id).map(c -> {
            categoriaRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}
