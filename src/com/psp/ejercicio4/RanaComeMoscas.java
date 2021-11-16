package com.psp.ejercicio4;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RanaComeMoscas {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
    	
    	 DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
    	
    	 System.out.println("Rana empieza a cazar moscas " + dt.format(LocalDateTime.now()));
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);		//ScheduledExecutorService programa tareas para su ejecucion. Pueden retrasarse/ejecutarse en un tiempo fijado

        Runnable cazar = () -> {
            count++;
            System.out.println("Rana come mosca " + dt.format(LocalDateTime.now()));
        };

        // Empieza la rana a cazar moscas a los 5 segundos, y por cada mosca que coma se acumulara cada 3 segundos hasta cumplir los 30 segundos
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(cazar, 5, 3, TimeUnit.SECONDS);

        while (true) {
            Thread.sleep(1000);
            if (count == 9) {
                scheduledFuture.cancel(true);
                ses.shutdown();
                break;
            }
        }

    }
}
