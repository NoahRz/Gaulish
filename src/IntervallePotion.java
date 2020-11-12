public class IntervallePotion {
    private Potion potion1;
    private Potion potion2;
    private int dureeConseillee;

    public IntervallePotion(Potion potion1,  Potion potion2, int dureeConseillee){
        this.potion1 = potion1;
        this.potion2 = potion2;
        this.dureeConseillee = dureeConseillee; // en minute
    }

    public Potion getPotion1() {
        return potion1;
    }

    public Potion getPotion2() {
        return potion2;
    }

    public int getDureeConseillee() {
        return dureeConseillee;
    }

    public boolean estCeluiDe(Potion potion1, Potion potion2) {
        return (this.potion1 == potion1 && this.potion2 == potion2) || (this.potion1 == potion1 && this.potion2 == potion2);
    }
}
