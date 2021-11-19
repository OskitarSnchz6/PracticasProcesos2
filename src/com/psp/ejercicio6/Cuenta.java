package com.psp.ejercicio6;

public class Cuenta {
	public static void main(String[] args)	 {
		
		BancoCuentaCompartida cuenta = new BancoCuentaCompartida();
		
		Thread Elena = new Thread(cuenta, "Elena");
		Thread Jhon = new Thread(cuenta, "Jhon");
		Thread Juan = new Thread(cuenta, "Juan");
		
		Jhon.start();
		Elena.start();
		Juan.start();
	}
}
