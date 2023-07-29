package com.bazar.bazar.service;

import com.bazar.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //CRUD
    //READ
    public List<Venta> getVentas();

    //CREATE
    public void saveVenta(Venta vent);

    //DELETE
    public void deleteVenta(Long idVenta);

    //READ DE UN SOLO OBJETO
    public Venta findVenta(Long idVenta);

    //UPDATE
    public void editVenta(Venta vent);

    //ESPECIFICOS
    //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    public List<Venta> getMontosCantVentas(LocalDate fechaVenta);

    /*DTO: Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente
    y el apellido del cliente de la venta con el monto más alto de todas.*/
    public Venta ventaMayor();

}
