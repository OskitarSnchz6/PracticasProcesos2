package com.psp.ejercicio2;

public class  CenaFilosofos {

	 public static void main(String[] args) throws Exception {

	        Filosofo[] philosophers = new Filosofo[5];				//Se crean 5 filósofos
	        Object[] forks = new Object[philosophers.length];		//Se crean los palillos con la misma cantidad de filósofos

	        for (int i = 0; i < forks.length; i++) {
	            forks[i] = new Object();						//Creacion de palillos
	        }

	        for (int i = 0; i < philosophers.length; i++) {

	            Object leftFork = forks[i];									//Palillo izquierdo
	            Object rightFork = forks[(i + 1) % forks.length];			//Palillo derecho

	            if (i == philosophers.length - 1) {
	                philosophers[i] = new Filosofo(rightFork, leftFork); 	//filósofo creado con palillo derecho
	            } else {
	                philosophers[i] = new Filosofo(leftFork, rightFork);	//filósofo creado con palillo izquierdo
	            }

	            Thread t = new Thread(philosophers[i], "Filósofo " + (i + 1));		//Un hilo para cada filósofo
	            t.start();															//Inicia 
	        }	
	    }
	}
