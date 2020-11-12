import java.util.ArrayList;

public class Potion {

    private String nom;
    private String effet;
    private ArrayList<Dose> dosesAgesPoids;
    private ArrayList<String> caracteristiquesModifiees;

    public Potion(String nom, String effet, ArrayList<Dose> dosesAgesPoids, ArrayList<String> caracteristiquesModifiees) {
        this.nom = nom;
        this.effet = effet;
        this.dosesAgesPoids = dosesAgesPoids;
        this.caracteristiquesModifiees = caracteristiquesModifiees;
    }

    public String getNom() {
        return nom;
    }

    public boolean verifDose(float poids, int age, int quantite) {
        Dose dose = this.getDose(poids, age);
        if (dose.getQuantite() == quantite) {
            return true;
        }else {
            return false;
        }
    }

    private Dose getDose(float poids, int age) {
        for (Dose dose: dosesAgesPoids){
            if (dose.getPoids() == poids && dose.getAge()== age){
                return dose;
            }
        }
        return null;
    }
}
