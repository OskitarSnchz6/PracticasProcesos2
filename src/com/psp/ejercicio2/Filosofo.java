package com.psp.ejercicio2;


public class Filosofo implements Runnable {

    private final Object leftFork;			//Palillo izquierdo
    private final Object rightFork;			//Palillo derecho

    Filosofo(Object left, Object right) {
        this.leftFork = left;				
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 3000)));			//cada filosofo espera un tiempo random entre 0 y 3000
    }

    @Override
    public void run() {
        try {
          
          doAction("Pensando"); 					//doAction es la acción que realiza el filósofo

		  while (true) {
               
                synchronized (leftFork) {
                	doAction("Coge el palillo izquierdo");
                	synchronized (rightFork) {
                		doAction("Deja el palillo derecho");
                    }
                	doAction("Deja el palillo izquierdo. Se pone a pensar");
                	//doAction("Pensando");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}