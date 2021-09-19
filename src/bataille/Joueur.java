package bataille;

import java.util.ArrayList;

public class Joueur {
    private final ArrayList<Carte> paquetCartes;

    public Joueur() {
        this.paquetCartes = new ArrayList<>();
    }

    public ArrayList<Carte> getPaquetCartes() {
        return paquetCartes;
    }

    public Carte tirerCarte() {
        return this.paquetCartes.remove(0);
    }

    public void ajouterCarte(Carte carteGagnee) {
        this.paquetCartes.add(carteGagnee);
    }

    public void ajouterCarte(ArrayList<Carte> cartesGagnees) {
        this.paquetCartes.addAll(cartesGagnees);
    }

    public String toString() {
        return "Joueur{" +
                "paquetCartes=" + paquetCartes +
                '}';
    }
}
