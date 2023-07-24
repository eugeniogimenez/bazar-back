package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    //CRUD
    //READ
    public List<Cliente> getClientes();

    //CREATE
    public void saveCliente(Cliente client);

    //DELETE
    public void deleteCliente(Long id_cliente);

    //READ DE UN SOLO OBJETO
    public Cliente findCliente(Long id_cliente);

    //UPDATE
    public void editCliente(Cliente client);
}
