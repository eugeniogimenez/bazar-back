package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import java.util.List;

public interface IProductoService {

    //1-CRUD
    //READ
    public List<Producto> getProductos();

    //CREATE
    public void saveProducto(Producto product);

    //DELETE
    public void deleteProducto(Long id_producto);

    //READ DE UN SOLO OBJETO
    public Producto findProducto(Long id_producto);

    //UPDATE
    public void editProducto(Producto product);

    //2-SERVICIOS ESPECIFICOS
    //Obtener todos los productos cuya cantidad_disponible sea menor a 5
    public List<Producto> getProductosStockMenorACinco();

}
