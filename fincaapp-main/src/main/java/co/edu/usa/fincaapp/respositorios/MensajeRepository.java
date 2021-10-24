package co.edu.usa.fincaapp.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Mensaje;


@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository mensajeRespositorio;

    public List<Mensaje> getTodosMensaje(){
        return (List<Mensaje>) mensajeRespositorio.findAll();
    }
    public Optional<Mensaje> getMensajePorId(Long id){
        return mensajeRespositorio.findById(id);
    }
    public Mensaje guardar(Mensaje mensaje){
        return mensajeRespositorio.save(mensaje);
    }
    public void borrar(Mensaje mensaje){
        mensajeRespositorio.delete(mensaje);
    }
    public void borrarPorIdReserva(Long id){
        mensajeRespositorio.deleteById(id);
    }
}
