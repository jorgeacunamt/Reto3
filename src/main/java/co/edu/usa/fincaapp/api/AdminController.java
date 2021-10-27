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

import co.edu.usa.fincaapp.entidades.Administrativo;
import co.edu.usa.fincaapp.servicios.AdminServicio;


@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")

public class AdminController {
    @Autowired private AdminServicio adminServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Administrativo> getTodasaAdministrativos(){
        return adminServicio.obtenerTodoAdministrativos();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrativo guardar(@RequestBody Administrativo admin){
        Administrativo f = adminServicio.guardar(admin);
        return f;
    }
    
}
