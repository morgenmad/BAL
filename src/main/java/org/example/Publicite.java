package org.example;

public class Publicite extends Courrier {

public Publicite(double poids, boolean mode_expedition, String s){
    super(poids, mode_expedition, s);
}

    @Override
    public double affranchirnormal() {
        double montant_base = 0;
        double montant = 0;
        double montant_pub = 0;
        montant_pub = 5.0*(getPoids()/1000);
        montant=montant_pub+montant_base;
        return montant;
    }
}
