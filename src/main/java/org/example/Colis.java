package org.example;

public class Colis extends Courrier{
    public double getVolume() {
        return volume;
    }

    public Colis(double poids, boolean mode_expedition, String s, double volume){
        super(poids, mode_expedition, s);
        this.volume=volume;
    }


    public void setVolume(double volume) {
        this.volume = volume;
    }

    private double volume;

    @Override
    public double affranchirnormal() {
        double montant_base = 0;
        double montant = 0;
        double montant_colis = 0;
        montant_colis=0.25*getVolume()+1.0*(getPoids()/1000);
        montant=montant_base+montant_colis;
        return montant;
    }

    @Override
    public boolean valide() {
        super.valide();
        if (getAdresse().equals("")||volume>50){
            cpt_invalide++;
            return false;
        }
        return true;
    }

    public void afficher(){
        super.afficher();
        System.out.println("| volume : "+volume);
    }
}

