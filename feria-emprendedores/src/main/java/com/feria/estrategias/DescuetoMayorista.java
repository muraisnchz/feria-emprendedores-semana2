package com.feria.estrategias;

public class DescuetoMayorista implements EstrategiaDescuento {

	@Override
	public double aplicarDescuento(double precioUnitario, int cantidad) {
        double total = precioUnitario * cantidad;
        // Aplica un 20% directo sin importar el monto final si se vende en esta modalidad
        return total * 0.80; 
    }

}
