package org.example;

public class Courrier {
    private double poids;
    private boolean mode_expedition;
    public int cpt_invalide;

    public Courrier(double poids, boolean mode_expedition, String adresse){
        this.poids=poids;
        this.mode_expedition=mode_expedition;
        this.adresse=adresse;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean getMode_expedition() {
        return mode_expedition;
    }

    public void setMode_expedition(boolean mode_expedition) {
        this.mode_expedition = mode_expedition;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    private String adresse;

    public double affranchir() {
        if (mode_expedition == false) {
            return affranchirnormal();
        } else return 2*affranchirnormal();
    }

    public double affranchirnormal(){
        return 0;
    }


    public boolean valide(){
        if (adresse.isEmpty()){
            cpt_invalide++;
            return false;
        }
        return true;
    }

    public int getCpt_invalide() {
        return cpt_invalide;
    }

    public void setCpt_invalide(int cpt_invalide) {
        this.cpt_invalide = cpt_invalide;
    }

    public void afficher(){
        System.out.println("\n| poids : "+poids+"\n| mode_exp : "+mode_expedition+"\n| adresse : "+adresse);
    }
}
