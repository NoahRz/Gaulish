import java.util.ArrayList;
import java.util.HashMap;

public class App {

    private HashMap<Potion, Integer> registrePotions = new HashMap<>();
    private ArrayList<IntervallePotion> intervallesPotions; // Comme un tableau à 2 entrées (valeur : intervalle entre les 2 potions)

    public App() { }

    public boolean inscrirePotion(String nom, String effet, HashMap<Potion, Integer> intervalles, ArrayList<Dose> doses, ArrayList<String> caracteristiques){
        if (this.existePotion(nom)){
            return false;
        }
        else {
            Potion potion = new Potion(nom, effet, doses, caracteristiques);
            this.ajouteAuRegistrePotions(potion);
            return this.ajoutePotion(potion, intervalles);
        }
    }

    public boolean existePotion(String nom) {
        for (Potion position : registrePotions.keySet()) {
            if (position.getNom() == nom){
                return true;
            }
        }
        return false;
    };

    public boolean ajouteAuRegistrePotions(Potion potion){
        this.registrePotions.put(potion, 1);
        return true;
    }

    public boolean ajoutePotion(Potion potion1,  HashMap<Potion, Integer> intervalles) {
        for (Potion potion2 : intervalles.keySet()){
            IntervallePotion intervallePotion = new IntervallePotion(potion1, potion2, intervalles.get(potion2));
            this.intervallesPotions.add(intervallePotion);
        }
        return true;
    }

    public Potion prendrePotion(String nom, int quantite, Habitant habitant){
        Potion potion = this.cherchePotion(nom);
        if (potion == null) {
            return null;
        }else{
            if (this.verifIntervalle(potion, habitant) && this.verifDose(potion, habitant, quantite)) {
                this.enleveDuRegistrePotions(potion);
                return potion;
            }else{
                return null;
            }
        }
    }

    public Potion cherchePotion(String nom) {
        for (Potion position : registrePotions.keySet()) {
            if (position.getNom() == nom){
                return position;
            }
        }
        return null;
    }

    public boolean verifIntervalle(Potion potion, Habitant habitant){
        for (Potion potionPrise : habitant.getPotionsPrises().keySet()) {
            int dureeReelle = habitant.getDureeReelle(potionPrise);
            IntervallePotion intervallePotion = this.getIntervalle(potion, potionPrise);
            if (dureeReelle < intervallePotion.getDureeConseillee()){
                return false;
            }
        }
        return true;
    }

    public boolean verifDose(Potion potion, Habitant habitant, int quantite){
        float poids = habitant.getPoids();
        int age = habitant.getAge();
        return potion.verifDose(poids, age, quantite);
    }

    public IntervallePotion getIntervalle(Potion potion1, Potion potion2) {
        for (IntervallePotion intervallePotion : this.intervallesPotions) {
            if (intervallePotion.estCeluiDe(potion1, potion2)) {
                return intervallePotion;
            }
        }
        return null;
    }

    public boolean enleveDuRegistrePotions(Potion potion){
        int quantiteCourante = this.registrePotions.get(potion) -1;
        if (quantiteCourante == 0) {
            this.registrePotions.remove(potion);
        }else {
            this.registrePotions.replace(potion, quantiteCourante);
        }
        return true;
    }
}
