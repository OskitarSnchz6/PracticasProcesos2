package com.psp.ejercicio6;

public class cuentaBanco {
	private int saldoActual = 2000;
	public int getSaldoActual()	{
		return saldoActual;
	}
	
	public void ingresarDinero(int valorRetiro)	{
		saldoActual += valorRetiro;
	}
	
	public void retiroCuenta(int valorRetiro)	{
		saldoActual -= valorRetiro;
	}
}
