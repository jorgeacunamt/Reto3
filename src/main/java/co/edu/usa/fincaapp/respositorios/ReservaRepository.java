package co.edu.usa.fincaapp.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Reserva;


@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository reservaRespositorio;

    public List<Reserva> getTodosReserva(){
        return (List<Reserva>) reservaRespositorio.findAll();
    }
    public Optional<Reserva> getReservaPorId(Long id){
        return reservaRespositorio.findById(id);
    }
    public Reserva guardar(Reserva reserva){
        return reservaRespositorio.save(reserva);
    }
    public void borrar(Reserva reserva){
        reservaRespositorio.delete(reserva);
    }
    public void borrarPorIdReserva(Long id){
        reservaRespositorio.deleteById(id);
    }

    /*
    public List<Reserva> ReservacionStatusRepositorio (String status){
        return reservaRespositorio.findAllByStatus(status);
    }
    
    public List<Reserva> ReservacionTiempoRepositorio (Date a, Date b){
        return reservaRespositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = reservaRespositorio.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }
*/


}
