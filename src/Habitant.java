import java.util.Date;
import java.util.HashMap;

public class Habitant {

    private int NNIG;
    private Date dateNais;
    private String adresse;
    public float poids;
    private HashMap<Potion, Integer> potionsPrises = new HashMap<>(); // int : date de prise de la potion

    public Habitant(int NNIG, Date dateNais, String adresse) {
        this.NNIG = NNIG;
        this.dateNais = dateNais;
        this.adresse = adresse;
    }

    public data renseigne() { // ???
        return null;
    }

    public boolean donneAvis() {
        return true;
    }

    public HashMap<Potion, Integer> getPotionsPrises() {
        return potionsPrises;
    }

    public int getDureeReelle(Potion potionPrise) {
        return (int) System.currentTimeMillis() -  potionsPrises.get(potionPrise);
    }

    public int getAge() {
        return 0;
    }

    public float getPoids() {
        return poids;
    }
}
