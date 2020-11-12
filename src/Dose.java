public class Dose {
    private int quantite;
    private int poids;
    private int age;

    public Dose(int quantite, int poids, int age){
        this.quantite = quantite;
        this.age = age;
        this.poids = poids;
    }

    public int getAge() {
        return age;
    }

    public int getPoids() {
        return poids;
    }

    public int getQuantite() {
        return quantite;
    }
}
