package com.psp.ejercicio5;

import java.util.Random;

class Hilo implements Runnable {
	
	private Thread hiloAlQueEspera = null;
	private final String nombre;
	
		Hilo(String nombre) {
		this.nombre = nombre;
		}
		
		public void setHilo(Thread h1) {
			this.hiloAlQueEspera = hiloAlQueEspera ;
		}
	
	@Override
	public void run() {
		System.out.printf("Hola, soy el hilo: %s.\n", this.nombre);
		
		if(hiloAlQueEspera != null)	{
			try	{
				hiloAlQueEspera.join();
			}	catch (InterruptedException e)	{
				System.out.println("El hilo " + nombre + " ha sido interrumpido");
			}
		}
		
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			int pausa = 10 + r.nextInt(500 - 10);
				System.out.printf("Hilo: %s hace pausa de %d ms.\n",this.nombre, pausa);
				try {
					Thread.sleep(pausa);
				} catch (InterruptedException e) {
					System.out.printf("Hilo %s interrumpido.\n",this.nombre);
				}
			}
		System.out.printf("Hilo %s terminado.\n", this.nombre);
		}


	
	}
public class JoinThreads {
	public static void main(String[] args) {
	Hilo hilo1 = new Hilo("H1");
	Thread h1 = new Thread(hilo1);
	Hilo hilo2 = new Hilo("H2");
	hilo2.setHilo(h1);
	Thread h2 = new Thread(hilo2);
	
	h1.start();
	h2.start();
	
	System.out.println("Hilo principal no espera.");
		/*try {
			h1.join();
			h2.join();
		} catch (InterruptedException ex) {
		System.out.println("Hilo principal interrumpido.");
	}
		System.out.println("Hilo principal terminado después de esperar a los hilos");*/
	}
}


//https://www.youtube.com/watch?v=geNFRei5mec