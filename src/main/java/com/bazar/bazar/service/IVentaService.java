package com.bazar.bazar.service;

import com.bazar.bazar.model.Venta;
import java.util.List;

public interface IVentaService {

    //CRUD
    //READ
    public List<Venta> getVentas();

    //CREATE
    public void saveVenta(Venta vent);

    //DELETE
    public void deleteVenta(Long id_vento);

    //READ DE UN SOLO OBJETO
    public Venta findVenta(Long id_vento);

    //UPDATE
    public void editVenta(Venta vent);
}
