package org.example;


import java.util.ArrayList;

public class Boite {
    public ArrayList<Courrier> contenu;
    int taille_max;

    public Boite(int taille_max){
        this.contenu=new ArrayList<Courrier>();
        this.taille_max=taille_max;
    }

    public void ajouterCourrier(Courrier courrier){
        contenu.add(courrier);
    }

    public int getTaille_max() {
        return taille_max;
    }

    public void setTaille_max(int taille_max) {
        this.taille_max = taille_max;
    }

    public ArrayList<Courrier> getContenu() {
        return contenu;
    }

    public void setContenu(ArrayList<Courrier> contenu) {
        this.contenu = contenu;
    }

    public double affranchir(){
        double montant =0;
        for (int i =0 ; i<contenu.size();i++){

            Courrier cour = contenu.get(i);
            if (cour.valide()){
                montant += cour.affranchir();
            }
        }

        return montant;
    }

    public int courrierInvalides(){
        int cpt = 0;
        for (int i = 0; i<contenu.size();i++){
            Courrier cour = contenu.get(i);
            if (cour.valide()==false){
                cpt = cpt+1;
            }
        }
        return cpt;
    }

    public void afficher(){
        for (int i = 0; i<contenu.size();i++){
            Courrier cour = contenu.get(i);
            cour.afficher();
        }
    }

}
