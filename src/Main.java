import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Parcheggio2 parcheggioV2 = new Parcheggio2(5);
        Cliente c1 = new Cliente("a1","Volvo", parcheggioV2);
        Cliente c2 = new Cliente("a2","Volvo", parcheggioV2);
        Cliente c3 = new Cliente("a3","Volvo", parcheggioV2);
        Cliente c4 = new Cliente("a4","Volvo", parcheggioV2);
        Cliente c5 = new Cliente("a5","Volvo", parcheggioV2);


        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(c1);
        es.execute(c2);
        es.execute(c3);
        es.execute(c4);
        es.execute(c5);
        es.shutdown();

    }
}
