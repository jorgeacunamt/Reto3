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

import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.servicios.ReservaServicio;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")

public class ReservaController {
    @Autowired private ReservaServicio reservaServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Reserva> getTodasFincas(){
        return reservaServicio.obtenerTodoReservas();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva guardar(@RequestBody Reserva reserva){
        Reserva f = reservaServicio.guardar(reserva);
        return f;
    }
    
}
