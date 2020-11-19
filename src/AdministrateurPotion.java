import java.util.ArrayList;
import java.util.HashMap;

public class AdministrateurPotion extends Habitant{
    private ArrayList<Habitant> registre;
    public AdministrateurPotion(int NNIG, String nom, String prenoms, String statusCivique, String adresse, float poids, String specialite, HashMap<Potion, Integer> potionsPrises) {
        super(NNIG, nom, prenoms, statusCivique, adresse, poids, specialite, potionsPrises);
    }
}