package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    //Inyección de Dependencias de Repository
    @Autowired
    private IProductoRepository productRepo;

    @Override
    public List<Producto> getProductos() {

        List<Producto> listaProductos = productRepo.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProducto(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto product = productRepo.findById(id).orElse(null);
        return product;
    }

    @Override
    public void editProducto(Producto product) {

        this.saveProducto(product);
    }

    //ENDPOINTS ESPECIFICOS
    //STOCK MENOR A 5
    @Override
    public List<Producto> getProductosStockMenorACinco() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaProductosStockMenorACinco = new ArrayList<>();

        for (Producto product : listaProductos) {
            if (product.getCantidad_disponible() < 5) {
                listaProductosStockMenorACinco.add(product);
            }
        }
        return listaProductosStockMenorACinco;
    }
}
