package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Categoria;
import co.edu.usa.fincaapp.servicios.CategoriaServicio;


@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")

public class CategoriaController {
    @Autowired private CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> getTodasCategorias(){
        return categoriaServicio.obtenerTodoCategorias();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardar(@RequestBody Categoria categoria){
        Categoria f = categoriaServicio.guardar(categoria);
        return f;
    }
    
}
