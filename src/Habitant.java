import java.util.HashMap;

public class Habitant {

    private int NNIG;
    private String nom;
    private String prenoms;
    private String statusCivique;
    private String adresse;
    // private Quartier quartiers;
    public float poids;
    private String specialite;
    private HashMap<Potion, Integer> potionsPrises = new HashMap<>(); // integer : date de prise de la potion


    public Habitant(int NNIG, String nom, String prenoms, String statusCivique, String adresse, float poids, String specialite, HashMap<Potion, Integer> potionsPrises) {
        this.NNIG = NNIG;
        this.nom = nom;
        this.prenoms = prenoms;
        this.statusCivique = statusCivique;
        this.adresse = adresse;
        this.poids = poids;
        this.specialite = specialite;
        this.potionsPrises = potionsPrises;
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
