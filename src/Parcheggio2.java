import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Parcheggio2 {


    private int nroPostiTotale;
    private int nroPostiLiberi;
    ConcurrentMap Parcheggio = new ConcurrentHashMap<String, String>(); //struttura dati per tenere traccia delle targhe e modelli


 // costruttore per inizializzare le istanze (es. con il numero di posti totale)
    public Parcheggio2(int _nroPostiTotale){
        nroPostiTotale = _nroPostiTotale;
    }

    /*un metodo “ENTRATA(MARCA,TARGA)” per richiedere l’ingresso dall’unica via di accesso
    e memorizzare i dati dell’auto quando viene posteggiata. Il metodo deve essere
    bloccante quando i posti sono tuZ occupati.*/

    public void Entrata(String Marca, String Targa){
        while(getNroPostiLiberi() >= getNroPostiTotale()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Parcheggio.put(Targa, Marca);
    }



    //un metodo “USCITA(TARGA)” per notificare l’uscita dal parcheggio. Il metodo non è
    //bloccante.
    public void uscita(String targa){
        while(getNroPostiLiberi() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Parcheggio.remove(targa);
        notifyAll();
    }

    /*Un metodo “SALVA_LOG(FILENAME)” che salva sul file FILENAME la lista di auto
    attualmente parcheggiate. */
    public void salvaLog(String filename){

        try {
            FileWriter myWriter = new FileWriter(filename);
            Set<Map.Entry<String, String>> entry =  Parcheggio.entrySet();

            for (Map.Entry<String, String> theEntry : entry) {
                String key = theEntry.getKey();
                String value = theEntry.getValue();

                myWriter.write("Targa: " + key + "\tModello: " + value);
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public int getNroPostiTotale() {
        return nroPostiTotale;
    }

    public int getNroPostiLiberi() {
        return nroPostiLiberi;
    }









}
