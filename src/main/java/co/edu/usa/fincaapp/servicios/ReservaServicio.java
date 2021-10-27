package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.respositorios.ReservaRepository;


@Service
public class ReservaServicio {
    @Autowired
    private ReservaRepository reservaRespositorio;

    public List<Reserva> obtenerTodoReservas(){
        return reservaRespositorio.getTodosReserva();
    }
    public Optional<Reserva> getReserva(Long id){
        return reservaRespositorio.getReservaPorId(id);
    }
    public Reserva guardar(Reserva reserva) {
        if(reserva != null){
            if(reserva.getId() != null){
                Optional<Reserva> oReserva = reservaRespositorio.getReservaPorId(reserva.getId());
                if(oReserva.isEmpty()){
                    return reservaRespositorio.guardar(reserva);
                }else{
                    return reserva;
                }
            }else{
                return reservaRespositorio.guardar(reserva);
            }
        }
        return null;
    }  
    public Reserva actualizar(Reserva reserva) {
        if(reserva.getId() != null){
            Optional<Reserva> oReserva = reservaRespositorio.getReservaPorId(reserva.getId());
            if(!oReserva.isEmpty()){
                Reserva c = oReserva.get();
                if(reserva.getStartDate()!= null){
                    c.setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!= null){
                    c.setDevolutionDate(reserva.getDevolutionDate());
                }
                return reservaRespositorio.guardar(c);
            }else{
                return reserva;
            }
        }else{
            return reserva;
        }
    }

    public boolean borrarReserva(Long id){
        Boolean borrado =  getReserva(id).map(c -> {
            reservaRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    }
}
