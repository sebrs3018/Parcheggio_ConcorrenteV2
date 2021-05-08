import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

     public static void main(String[] args) {

        Parcheggio2 parcheggioV2 = new Parcheggio2(5);
        Cliente c1 = new Cliente("a1","Volvo1", parcheggioV2);
        Cliente c2 = new Cliente("a2","Volvo2", parcheggioV2);
        Cliente c3 = new Cliente("a3","Volvo3", parcheggioV2);

        /* La dimensione del threadPool corrisponde con la dimensione del Parcheggio */
        ExecutorService es = Executors.newFixedThreadPool(100);

         for (int i = 0; i<100; i++){
            es.execute(c1);
            es.execute(c2);
            es.execute(c3);
        }

         CompletableFuture.runAsync(() -> {
             try {
                 while(!es.isTerminated()){
                     TimeUnit.MILLISECONDS.sleep(1000);
                     parcheggioV2.salvaLog("Log.txt");
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });
         es.shutdown();

    }
}
