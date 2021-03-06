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

import co.edu.usa.fincaapp.entidades.Mensaje;
import co.edu.usa.fincaapp.servicios.MensajeServicio;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")

public class MensajeController {
    @Autowired private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Mensaje> getTodasFincas(){
        return mensajeServicio.obtenerTodoMensajes();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje guardar(@RequestBody Mensaje mensaje){
        Mensaje f = mensajeServicio.guardar(mensaje);
        return f;
    }
    
}
