package com.bazar.bazar.service;

import com.bazar.bazar.model.Venta;

import com.bazar.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    //Inyección de Dependencias de Repository
    @Autowired
    private IVentaRepository ventRepo;

    @Override
    public List<Venta> getVentas() {

        List<Venta> listaVentas = ventRepo.findAll();
        return listaVentas;
    }

    /*
    @Override
    public void saveVenta(Venta vent) {
        System.out.println("Método saveVenta() activado con venta: " + vent.getCodigo_venta());
        // Validar que haya suficiente stock para los productos vendidos en la nueva venta
        //itera lost productos de esta venta
        for (Producto producto : vent.getListaProductos()) {
            System.out.println("producto cantidad: " + producto.getCantidad_disponible());

            //busca el producto en la db a ver si está guardado. Compara codigo con codigo
            Producto productoEnBD = productRepo.findById(producto.getCodigo_producto()).orElse(null);
            System.out.println("Producto encontrado en la base de datos: " + productoEnBD);

            //Si está en la db
            if (productoEnBD != null) {
                //compara cantidad entre la db y cantidad que pide en esta venta.
                if (productoEnBD.getCantidad_disponible() >= producto.getCantidad_disponible()) {

                    // Actualizar el stock del producto restando la cantidad vendida
                    //Resto lo que tengo menos lo que vendo y lo actualizao
                    Double cantidadActualizada = productoEnBD.getCantidad_disponible() - producto.getCantidad_disponible();
                    productoEnBD.setCantidad_disponible(cantidadActualizada);
                    productRepo.save(productoEnBD);
                } else {
                    throw new RuntimeException("No hay suficiente cantidad disponible del producto: " + producto.getNombre());
                }
            } else {
                throw new RuntimeException("Producto no encontrado en la base de datos: " + producto.getCodigo_producto());
            }
        }

        // Si hay suficiente stock para todos los productos vendidos, procedemos a guardar la nueva venta
        ventRepo.save(vent);
    }*/
    @Override
    public void saveVenta(Venta vent) {

        ventRepo.save(vent);
    }

    @Override
    public void deleteVenta(Long id) {
        ventRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta vent = ventRepo.findById(id).orElse(null);
        return vent;
    }

    @Override
    public void editVenta(Venta vent) {

        this.saveVenta(vent);
    }

    // ESPECIFICOS
    //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @Override
    public List<Venta> getMontosCantVentas(LocalDate fechaVenta) {

        List<Venta> listaVentas = this.getVentas();
        List<Venta> listaVentasFecha = new ArrayList<>();

        for (Venta ven : listaVentas) {

            LocalDate fecha = ven.getFecha_venta();

            if (fecha.equals(fechaVenta)) {
                listaVentasFecha.add(ven);
            }
        }

        return listaVentasFecha;
    }

    /*DTO: Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente
    y el apellido del cliente de la venta con el monto más alto de todas.*/
    @Override
    public Venta ventaMayor() {

        Double ventaMayor = 0.0;

        List<Venta> listaVentas = this.getVentas();
        Venta vent = new Venta();

        for (Venta ven : listaVentas) {

            Double totalVenta = ven.getTotal();

            if (totalVenta > ventaMayor) {
                ventaMayor = totalVenta;
                ven.getCodigo_venta();
                vent = ven;
            }
        }

        return vent;
    }

}
