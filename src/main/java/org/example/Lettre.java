package org.example;

public class Lettre extends Courrier{
    public Lettre(double poids, boolean mode_expedition, String adresse, String format) {
        super(poids, mode_expedition, adresse);
        this.format=format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    private String format;

    @Override
    public double affranchirnormal() {
        double montant_base = 0;
        double montant = 0;
        double montant_lettre = 0;
        if (this.format=="A3"){
            montant_lettre = 3.5+1.0*(getPoids()/1000);
        } else montant_lettre = 2.5+1.0*(getPoids()/1000);

        montant=montant_base+montant_lettre;
        return montant;
    }

    public void afficher(){
        super.afficher();
        System.out.println("| format : "+format);
    }
}
