package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Cliente;
import co.edu.usa.fincaapp.respositorios.ClienteRepository;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRespositorio;

    public List<Cliente> obtenerTodoClientes(){
        return clienteRespositorio.getTodosClientes();
    }
    public Optional<Cliente> getCliente(Long id){
        return clienteRespositorio.getClientePorId(id);
    }
    public Cliente guardar(Cliente cliente) {
        if(cliente != null){
            if(cliente.getId() != null){
                Optional<Cliente> oCliente = clienteRespositorio.getClientePorId(cliente.getId());
                if(oCliente.isEmpty()){
                    return clienteRespositorio.guardar(cliente);
                }else{
                    return cliente;
                }
            }else{
                return clienteRespositorio.guardar(cliente);
            }
        }
        return null;
    }  
    public Cliente actualizar(Cliente cliente) {
        if(cliente.getId() != null){
            Optional<Cliente> oCliente = clienteRespositorio.getClientePorId(cliente.getId());
            if(!oCliente.isEmpty()){
                Cliente c = oCliente.get();
                if(cliente.getName()!= null){
                    c.setName(cliente.getName());
                }
                if(cliente.getEmail()!= null){
                    c.setEmail(cliente.getEmail());
                }
                if(cliente.getAge() != null){
                    c.setAge(cliente.getAge());
                }
                if(cliente.getPassword()!= null){
                    c.setPassword(cliente.getPassword());
                }

                return clienteRespositorio.guardar(c);
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean borrarCliente(Long id){
        Boolean borrado =  getCliente(id).map(c -> {
            clienteRespositorio.borrar(c);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}
