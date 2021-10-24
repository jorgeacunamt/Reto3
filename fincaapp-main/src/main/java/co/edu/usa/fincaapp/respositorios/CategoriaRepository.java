package co.edu.usa.fincaapp.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Categoria;

@Repository
public class CategoriaRepository { 
    @Autowired
    private CategoriaCrudRepository categoriaRespositorio;

    public List<Categoria> getTodosCategorias(){
        return (List<Categoria>) categoriaRespositorio.findAll();
    }
    public Optional<Categoria> getCategoriasPorId(Long id){
        return categoriaRespositorio.findById(id);
    }
    public Categoria guardar(Categoria categoria){
        return categoriaRespositorio.save(categoria);
    }
    public void borrar(Categoria categoria){
        categoriaRespositorio.delete(categoria);
    }
    public void borrarPorIdCategoria(Long id){
        categoriaRespositorio.deleteById(id);
    }


}
