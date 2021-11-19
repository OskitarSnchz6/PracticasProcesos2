package com.psp.ejercicio6;

public class BancoCuentaCompartida implements Runnable{

	cuentaBanco miCuenta = new cuentaBanco();

	@Override
	public void run() {
		for(int i = 0; i < 1; i++)	{
			
			try	{
				ingresarDinero(1000);
				retirarDinero(2000);
				if (miCuenta.getSaldoActual()<0)	{
					System.out.println("Su cuenta tiene un saldo negativo");
				}
				System.out.println();
				Thread.sleep(500);
			}	catch (InterruptedException e)	{
				e.printStackTrace();
			}
		}
		
	}
	
	private synchronized void ingresarDinero(int valorIngreso)	{
			
			if (miCuenta.getSaldoActual()<=valorIngreso)	{
				System.out.println("Su saldo actual es de  " + miCuenta.getSaldoActual());
				System.out.println("El usuario " + Thread.currentThread().getName() + " esta realizando un ingreso de " + valorIngreso + " euros");
				miCuenta.retiroCuenta(valorIngreso);
				System.out.println("El ingreso se ha realizado");
				System.out.println("El nuevo saldo actual es de " + (miCuenta.getSaldoActual()+valorIngreso) + " euros");
			}	else	{
				System.out.println("Usuario " + Thread.currentThread().getName() + ". No se ha podido ingresar dicha cantidad");
			}
			
		}
	
	private synchronized void retirarDinero(int valorRetiro)	{
		
		if (miCuenta.getSaldoActual()>=valorRetiro)	{
			System.out.println("Su saldo actual es de " + miCuenta.getSaldoActual());
			System.out.println("El usuario " + Thread.currentThread().getName() + " esta realizando una retirada de " + valorRetiro + " euros");
			miCuenta.retiroCuenta(valorRetiro);
			System.out.println("La retirada se ha realizado");
			System.out.println("El nuevo saldo actual es " + miCuenta.getSaldoActual());
		}	else	{
			System.out.println("Usuario " + Thread.currentThread().getName() + ". No hay saldo suficiente para retirar");
		}
		
	}
	
}
