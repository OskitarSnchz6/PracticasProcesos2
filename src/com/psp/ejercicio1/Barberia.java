package com.psp.ejercicio1;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barberia {

    public static void main(String[] args) {
        Barbero barbero = new Barbero(false);
        for (int i = 0; i < 10; i++) {
            Cliente c = new Cliente(i + 1, barbero);
            c.start();
        }
    }
}

class Barbero {
    public boolean ocupado;
    public boolean[] sillas = new boolean[5];
  
    public Barbero(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public synchronized void ocuparSilla(int nCliente) {
        System.out.println("Silla ocupada por el cliente: " + nCliente);
    }

    public synchronized void dejarSilla(int nCliente) {
        while (estaOcupado()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("El cliente " + nCliente + " deja libre una silla");
    }

    public synchronized void inicioCorte(int nCliente) {
        while (estaOcupado()) {
            System.out.println("Barbero ocupado, " + nCliente + " espera en una silla sentado");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero llama al cliente " + + nCliente + " para cortarle el pelo");
    }

    public synchronized void finCorte(int nCliente) {
        this.setOcupado(false);
        System.out.println("El barbero termina de cortar el pelo al cliente " + nCliente + " y llama al siguiente");
        notify();
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}


class Cliente extends Thread {
    private Barbero bar;
    private int numCliente;
    
    public Cliente(int nCli, Barbero b) {
        this.numCliente = nCli;
        this.bar = b;
    }

    @Override
    public void run() {
        try {
            bar.inicioCorte(numCliente);
            sleep(800);
            bar.finCorte(numCliente);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            //System.out.println("El barbero cierra y se va a casa");
        }
    }
}