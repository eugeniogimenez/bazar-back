package com.bazar.bazar.controller;

import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Venta getProducto(@PathVariable Long id) {
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
}
