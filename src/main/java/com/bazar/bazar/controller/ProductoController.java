package com.bazar.bazar.controller;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    //EL CONTROLLER LLAMA AL SERVICE(Logica)
    @Autowired
    private IProductoService productServ;

    //ENDPOINTS
    //GET TODOS
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productServ.getProductos();
    }

    //GET UNO
    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productServ.findProducto(id);
    }

    //POST
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto product) {
        productServ.saveProducto(product);

        return "El producto '" + product.getNombre() + "' fue creado correctamente";
    }

    //DELETE
    @DeleteMapping("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productServ.deleteProducto(id);
        return "El producto con código '" + id + "' fue eliminada correctamente";
    }

    //PUT
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto product) {

        productServ.editProducto(product);

        return productServ.findProducto(product.getCodigo_producto());

    }

    //ENDPOINTS ESPECIFICOS
    //GET STOCK MENOR A 5
    @GetMapping("/productos/stock_menor_5")
    public List<Producto> getProductosStockMenorACinco() {
        return productServ.getProductosStockMenorACinco();
    }

}
