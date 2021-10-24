package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Mensaje;
import co.edu.usa.fincaapp.respositorios.MensajeRepository;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepository mensajeRespositorio;

    public List<Mensaje> obtenerTodoMensajes(){
        return mensajeRespositorio.getTodosMensaje();
    }
    public Optional<Mensaje> getMensaje(Long id){
        return mensajeRespositorio.getMensajePorId(id);
    }
    public Mensaje guardar(Mensaje mensaje) {
        if(mensaje != null){
            if(mensaje.getId() != null){
                Optional<Mensaje> oMensaje = mensajeRespositorio.getMensajePorId(mensaje.getId());
                if(oMensaje.isEmpty()){
                    return mensajeRespositorio.guardar(mensaje);
                }else{
                    return mensaje;
                }
            }else{
                return mensajeRespositorio.guardar(mensaje);
            }
        }
        return null;
    }  
    public Mensaje actualizar(Mensaje mensaje) {
        if(mensaje.getId() != null){
            Optional<Mensaje> oMensaje = mensajeRespositorio.getMensajePorId(mensaje.getId());
            if(!oMensaje.isEmpty()){
                Mensaje c = oMensaje.get();
                if(mensaje.getMessagetext()!= null){
                    c.setMessagetext(mensaje.getMessagetext());
                }
                if(mensaje.getCliente()!= null){
                    c.setCliente(mensaje.getCliente());
                }
                if(mensaje.getFinca()!= null){
                    c.setFinca(mensaje.getFinca());
                }
                return mensajeRespositorio.guardar(c);
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }
    }

    public boolean borrarMensaje(Long id){
        Boolean borrado =  getMensaje(id).map(c -> {
            mensajeRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    }
}
