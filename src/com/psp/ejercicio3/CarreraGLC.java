package com.psp.ejercicio3;


/*public class CarreraGLC{
	public static void main(String[] args) {
		
		// Crea hilos de galgo, liebre y conejo
		Galgo  galgo = new Galgo("Galgo");
		Liebre liebre = new Liebre("Liebre");
		Conejo conejo = new Conejo("Conejo");
		
		// Comienza la carrera
		galgo.start();
		liebre.start();
		conejo.start();
	}
}
								//Galgo
class Galgo extends Thread{
	public Galgo(String name) {
		super(name);// El método de construcción de la clase padre, establece el nombre
	}
	@Override
	public void run() {
		for(int i = 1;i <= 1000; i ++){ // i representa metros
			try {
				Thread.sleep(100);// Descanso 1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Imprime cada vez que corras un metro
			System.out.println(Thread.currentThread().getName()+" -> "+i+"mt");
			
			if (i % 100 == 0) {
				// Después de correr 10 metros
				try {
					Thread.sleep(1000); // La tortuga termina diez metros y descansa un segundo
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
								//Liebre
class Liebre extends Thread{
	public Liebre(String name) {
		super(name);// El método de construcción de la clase padre, establece el nombre
	}
	@Override
	public void run() {
		for(int i = 1;i <= 1000; i ++){ // i representa metros
			// Conejo 10 metros, 1 metro por segundo es 0.1 segundo
			try {
				Thread.sleep(100);// Descanso 0.1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Imprime cada vez que corras un metro
			System.out.println(Thread.currentThread().getName()+" -> "+i+"mt");
			if (i % 100 == 0) {
				// Después de correr 10 metros
				try {
					Thread.sleep(1000); // El conejo duerme 10 segundos después de correr 10 metros.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
								//Conejo
class Conejo extends Thread{
	public Conejo(String name) {
		super(name);// El método de construcción de la clase padre, establece el nombre
	}
	@Override
	public void run() {
		for(int i = 1;i <= 1000; i ++){ // i representa metros
			// Conejo 10 metros, 1 metro por segundo es 0.1 segundo
			try {
				Thread.sleep(100);// Descanso 0.1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Imprime cada vez que corras un metro
			System.out.println(Thread.currentThread().getName()+" -> "+i+"mt");
			if (i % 100 == 0) {
				// Después de correr 10 metros
				try {
					Thread.sleep(1000); // El conejo duerme 10 segundos después de correr 10 metros.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

*/


public class CarreraGLC extends Thread{
		 String nombre;
		 public CarreraGLC (String nombre){
		 this.nombre=nombre;
		}
		 public void run(){
		 for(int c=100;c<=1000;c = c+100){
		 System.out.print(c+"mt ");
		 }
		 System.out.println("\n # Llego a la meta el " + nombre+"#");
		}
		 static CarreraGLC Galgo;
		 static CarreraGLC Conejo;
		 static CarreraGLC Liebre;
		 public static void main(String []args) throws InterruptedException {
		 Galgo = new CarreraGLC(" Galgo ");
		 Conejo = new CarreraGLC(" Conejo ");
		 Liebre = new CarreraGLC(" Liebre ");
		 Galgo.start();
		 Conejo.start();
		 Liebre.start();  
		 Galgo.join();
		 Conejo.join();
		 Liebre.join();
		 }
}
