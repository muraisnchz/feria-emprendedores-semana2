package com.feria;

import com.feria.modelos.*;
import com.feria.servicios.*;
import com.feria.estrategias.*;

public class Main {

    public static void main(String[] args) {
        GestorFeria gestor = new GestorFeria();
        Reportes reportes = new Reportes();

        Emprendedor ana = new Emprendedor("Ana", "E001", "3423456789", "ana@gmail.com", Categoria.COMIDA);
        Producto pEmpanadas = new Producto("Empanadas", 500.0, 50);
        ana.agregarProducto(pEmpanadas);
        gestor.registrarEmprendedor(ana);

        // Se inyecta la estrategia específica requerida al momento de construir la venta
        Venta v1 = new Venta("V001", pEmpanadas, 12, new DescuentoFeriaEstandar());
        gestor.registrarVenta(v1);

        // Procesar pagos y cálculos usando polimorfismo
        for (Venta v : gestor.getVentas()) {
            if (!v.isPagoRealizado()) {
                double monto = v.calcularTotal();
                v.registrarPago();
                System.out.println("Cobrada venta con estrategia aplicada por $" + monto);
            }
        }
    }
}