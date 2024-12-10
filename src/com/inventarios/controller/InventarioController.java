
package com.inventarios.controller;

import com.inventarios.model.Producto;
import com.inventarios.model.Proveedor;


import java.util.ArrayList;
import java.util.List;


public class InventarioController {
     private List<Producto> productos;
         private List<Proveedor> proveedores;

       public InventarioController() {
        productos = new ArrayList<>();
                proveedores = new ArrayList<>();

    }

    public void agregarProducto(Producto producto) throws Exception {
    if (buscarProducto(producto.getCodigo()) != null) {
        throw new Exception("El producto con código " + producto.getCodigo() + " ya existe.");
    }
    productos.add(producto);
    System.out.println("Producto agregado al controlador: " + producto.getNombre());
}

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
   
    
    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public List<Producto> getProductos() {
        return productos;
    }
     
 // Gestión de Proveedores
    public void agregarProveedor(Proveedor proveedor) throws Exception {
        if (buscarProveedor(proveedor.getId()) != null) {
            throw new Exception("El proveedor con ID " + proveedor.getId() + " ya existe.");
        }
        proveedores.add(proveedor);
    }

public Proveedor buscarProveedor(String id) {
    for (Proveedor proveedor : proveedores) {
        if (proveedor.getId().equals(id)) {
            return proveedor;
        }
    }
    return null; // No se encontró el proveedor
}

    public List<Proveedor> getProveedores() {
        return proveedores;
    }


}
