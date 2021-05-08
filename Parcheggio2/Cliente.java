public  class Cliente implements Runnable{
    private final String Targa;
    private final String Marca;
    private final Parcheggio2 Parcheggio;
    private final static int NRO_RUN = 3;

    public Cliente(String targa, String marca, Parcheggio2 parcheggio){
        Targa = targa;
        Marca = marca;
        Parcheggio = parcheggio;
    }

    public void run(){

        for (int i = 0; i<NRO_RUN; i++){
            System.out.println(" \t### entrata nel parcheggio " + Targa + " | " + Marca +" ### ");
            Parcheggio.Entrata(Targa, Marca);
            try { // simuliamo un delay
                System.out.println(" \t\t### sono nel parcheggio... " + Targa + " | " + Marca +" ### ");
                Thread.sleep ( 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" \t### sono uscito dal parcheggio... " + Targa + " | " + Marca +" ### ");
            Parcheggio.Uscita(Targa);
        }

    }

}


/*
   int counter = 0;
            while(!parcheggio.isItClosed() && counter < NUM_REP) {
                parcheggio.entrata(name);
                    if(parcheggio.isItClosed())  //Questo controllo interno mi permette di non proseguire nel caso in cui il parcheggio abbia chiuso al momento dell'entrata
                        break;
                try { // simuliamo un delay
                    System.out.println(" \t\t### sono nel parcheggio... " + name + " ### ");
                    Thread.sleep ((int) Math.random() * 20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parcheggio.uscita(name);
                counter++;
            }
        System.out.println( name + " ha finito correttamente");
*/
