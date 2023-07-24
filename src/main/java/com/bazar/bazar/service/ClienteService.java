package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    //Inyección de Dependencias de Repository
    @Autowired
    private IClienteRepository clientRepo;

    @Override
    public List<Cliente> getClientes() {

        List<Cliente> listaClientes = clientRepo.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente client) {
        clientRepo.save(client);
    }

    @Override
    public void deleteCliente(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente client = clientRepo.findById(id).orElse(null);
        return client;
    }

    @Override
    public void editCliente(Cliente client) {

        this.saveCliente(client);
    }
}
