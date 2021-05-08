public  class Cliente implements Runnable{
    private final String Targa;
    private final String Marca;
    private final Parcheggio2 Parcheggio;

    public Cliente(String targa, String marca, Parcheggio2 parcheggio){
        Targa = targa;
        Marca = marca;
        Parcheggio = parcheggio;
    }

    public void run(){
        Parcheggio.Entrata(Targa, Marca);
        try { // simuliamo un delay
            System.out.println(" \t\t### sono nel parcheggio... " + Targa + " ### ");
            Thread.sleep ((int) Math.random() * 20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Parcheggio.Uscita(Targa);
    }

}
