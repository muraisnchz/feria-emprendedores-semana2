package com.feria.modelos;

import com.feria.estrategias.EstrategiaDescuento;
import java.time.LocalDate;

public class Venta {
    private String idVenta;
    private Producto producto;
    private int cantidad;
    private LocalDate fecha;
    private boolean pagoRealizado;
    private EstrategiaDescuento estrategiaDescuento; // Composición del patrón

    public Venta(String idVenta, Producto producto, int cantidad, EstrategiaDescuento estrategiaDescuento) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = LocalDate.now();
        this.pagoRealizado = false;
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public double calcularTotal() {
        // Delega la responsabilidad del cálculo algorítmico a la estrategia inyectada
        return estrategiaDescuento.aplicarDescuento(producto.getPrecio(), cantidad);
    }

    public void registrarPago() {
        this.producto.reducirStock(this.cantidad);
        this.pagoRealizado = true;
    }

    public boolean isPagoRealizado() { return pagoRealizado; }
}