package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

    //EL CONTROLLER LLAMA AL SERVICE(Logica)
    @Autowired
    private IClienteService clientServ;

    //ENDPOINTS
    //GET TODOS
    @GetMapping("/clientes")
    public List<Cliente> getCliente() {
        return clientServ.getClientes();
    }

    //GET UNO
    @GetMapping("/clientes/{id}")
    public Cliente getProducto(@PathVariable Long id) {
        return clientServ.findCliente(id);
    }

    //POST
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente client) {
        clientServ.saveCliente(client);
        return "El cliente " + client.getNombre() + " " + client.getApellido() + " fue creado correctamente";

    }

    //DELETE
    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clientServ.deleteCliente(id);
        return "El cliente con id: " + id + " fue eliminado correctamente";
    }

    //PUT
    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente client) {

        clientServ.editCliente(client);

        return clientServ.findCliente(client.getId_cliente());

    }
}
