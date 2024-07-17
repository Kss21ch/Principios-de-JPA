package com.ug.hotels.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.hotels.model.Producto;
import com.ug.hotels.services.ProductoService;

@RestController
@RequestMapping
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/productos")
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id).orElse(null);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public List<Producto> findByNombre(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

    @GetMapping("/buscarPorPrecio")
    public List<Producto> findByPrecioRange(
            @RequestParam(name = "preciomin") double preciomin,
            @RequestParam(name = "preciomax") double preciomax) {
    
        return productoService.findByPrecioRange(preciomin, preciomax);
    }
}
