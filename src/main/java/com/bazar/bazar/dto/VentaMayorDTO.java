package com.bazar.bazar.dto;

import com.bazar.bazar.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/*Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente
y el apellido del cliente de la venta con el monto más alto de todas.*/
@Getter
@Setter
public class VentaMayorDTO {

    private Long codigoVenta;
    private Double total;
    private List<Producto> listaProductos;

    private String nombre;
    private String apellido;

    public VentaMayorDTO() {
    }

    public VentaMayorDTO(Long codigoVenta, Double total, List<Producto> listaProductos, String nombre, String apellido) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
