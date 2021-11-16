package com.psp.ejercicio2;

public class  CenaFilosofos {

	 public static void main(String[] args) throws Exception {

	        Filosofo[] philosophers = new Filosofo[5];				//Se crean 5 fil�sofos
	        Object[] forks = new Object[philosophers.length];		//Se crean los palillos con la misma cantidad de fil�sofos

	        for (int i = 0; i < forks.length; i++) {
	            forks[i] = new Object();						//Creacion de palillos
	        }

	        for (int i = 0; i < philosophers.length; i++) {

	            Object leftFork = forks[i];									//Palillo izquierdo
	            Object rightFork = forks[(i + 1) % forks.length];			//Palillo derecho

	            if (i == philosophers.length - 1) {
	                philosophers[i] = new Filosofo(rightFork, leftFork); 	//fil�sofo creado con palillo derecho
	            } else {
	                philosophers[i] = new Filosofo(leftFork, rightFork);	//fil�sofo creado con palillo izquierdo
	            }

	            Thread t = new Thread(philosophers[i], "Fil�sofo " + (i + 1));		//Un hilo para cada fil�sofo
	            t.start();															//Inicia 
	        }	
	    }
	}
