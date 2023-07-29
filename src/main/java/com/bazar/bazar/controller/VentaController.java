package com.bazar.bazar.controller;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {

    //EL CONTROLLER LLAMA AL SERVICE(Logica)
    @Autowired
    private IVentaService ventServ;

    //ENDPOINTS
    //GET TODOS
    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return ventServ.getVentas();
    }

    //GET UNO
    @GetMapping("/ventas/{id}")
    public Venta getVenta(@PathVariable Long id) {
        return ventServ.findVenta(id);
    }

    //POST
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);

        return "La venta con codigo: " + vent.getCodigo_venta() + " fue realizada correctamente";

    }

    //DELETE
    @DeleteMapping("/ventas/eliminar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        ventServ.deleteVenta(id);
        return "La venta con código: " + id + " fue eliminada correctamente";
    }

    //PUT
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta vent) {

        ventServ.editVenta(vent);

        return ventServ.findVenta(vent.getCodigo_venta());

    }

    //ENDPOINTS ESPECIFICOS
    //Traer productos de una venta especifica
    @GetMapping("/ventas/productos/{ventaId}")
    public List<Producto> getProductosDeUnaVenta(@PathVariable Long ventaId) {
        Venta vent = ventServ.findVenta(ventaId);

        return vent.getListaProductos();
    }

    //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping("/ventas/dia/{fechaVenta}")
    public String getMontosCantVentas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate fechaVenta) {

        Double monto = 0.0;

        List<Venta> listaVentasFecha = ventServ.getMontosCantVentas(fechaVenta);

        int cantVen = listaVentasFecha.size();

        for (Venta ven : listaVentasFecha) {
            monto += ven.getTotal();
        }

        return "La cantidad de ventas del dia es " + cantVen + " y el monto total de ventas es: " + monto;
    }

    /*DTO: Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente
    y el apellido del cliente de la venta con el monto más alto de todas.*/
    @GetMapping("/ventas/ventaMayor")
    public Venta ventaMayor() {
        Venta ven = ventServ.ventaMayor();
        return ven;
    }

}
