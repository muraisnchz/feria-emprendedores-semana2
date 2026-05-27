package com.feria.estrategias;

public class DescuentoFeriaEstandar implements EstrategiaDescuento {
	
	public double aplicarDescuento(double precioUnitario, int cantidad) {
        double total = precioUnitario * cantidad;

        if (cantidad > 10) {
            total *= 0.90; // 10% de descuento por cantidad
        }
        if (total > 5000) {
            total *= 0.95; // 5% de descuento por monto alto
        }
        return total;

}
}
